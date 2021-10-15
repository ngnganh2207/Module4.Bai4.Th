package com.codegym.service;

import com.codegym.model.Music;

import java.util.ArrayList;

public class MusicService {
    public ArrayList<Music> list= new ArrayList<>();

    public MusicService() {
        list.add(new Music("Đợi chờ","Đan Trường","Nhạc Vàng","No"));
    }

    public void save(Music music){
        list.add(music);
    }

    public void edit(int index, Music music){
        list.set(index,music);
    }

    public void delete(int index){
        list.remove(index);
    }
}
