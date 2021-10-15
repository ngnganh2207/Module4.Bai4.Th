package com.codegym.controller;

import com.codegym.model.Music;
import com.codegym.model.MusicForm;
import com.codegym.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;

@Controller
public class MusicController {
    @Autowired
    private MusicService musicService;

    @Value("${file-upload}")
    private String fileUpload;

    @RequestMapping("/home")
    public ModelAndView listMusicForm(){
        ModelAndView modelAndView= new ModelAndView("listmusic");
        modelAndView.addObject("list", musicService.list);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView listCreateForm(){
        ModelAndView modelAndView= new ModelAndView("create");
        modelAndView.addObject("listMusicForm", new MusicForm() );
        return modelAndView;
    }

    @PostMapping("/create")
    public String createNewMusic(@ModelAttribute MusicForm musicForm, RedirectAttributes redirectAttributes){
        MultipartFile multipartFile= musicForm.getFileMusic();
        String fileName=multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(multipartFile.getBytes(), new File(fileUpload+fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Music music=new Music(musicForm.getNameBaiHat(),musicForm.getNameNgheSy(),musicForm.getTheLoai(),fileName);
        musicService.save(music);
        redirectAttributes.addFlashAttribute("message","Create successfully");
        return "redirect:/home";
    }

    @GetMapping("/edit/{index}")
    public ModelAndView editFormMusic(@PathVariable("index") int index){
        ModelAndView modelAndView=new ModelAndView("edit","listMusicForm", musicService.list.get(index));
        return modelAndView;
    }

    @PostMapping("/edit/{index}")
    public ModelAndView editMusic(@PathVariable("index") int index,@ModelAttribute MusicForm musicForm){
        MultipartFile multipartFile= musicForm.getFileMusic();
        String fileName=multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(multipartFile.getBytes(), new File(fileUpload+fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Music musicEdit=new Music(musicForm.getNameBaiHat(),musicForm.getNameNgheSy(),musicForm.getTheLoai(),fileName);
        musicService.edit(index, musicEdit);

        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/delete/{index}")
    public ModelAndView deleteMusic(@PathVariable int index){
        musicService.delete(index);
        return new ModelAndView( "redirect:/home");
    }

}
