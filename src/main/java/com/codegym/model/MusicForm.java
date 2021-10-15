package com.codegym.model;

import org.springframework.web.multipart.MultipartFile;

public class MusicForm {
    private String nameBaiHat;
    private String nameNgheSy;
    private String theLoai;
    private MultipartFile fileMusic;

    public MusicForm() {
    }

    public MusicForm(String nameBaiHat, String nameNgheSy, String theLoai, MultipartFile fileMusic) {
        this.nameBaiHat = nameBaiHat;
        this.nameNgheSy = nameNgheSy;
        this.theLoai = theLoai;
        this.fileMusic = fileMusic;
    }

    public String getNameBaiHat() {
        return nameBaiHat;
    }

    public void setNameBaiHat(String nameBaiHat) {
        this.nameBaiHat = nameBaiHat;
    }

    public String getNameNgheSy() {
        return nameNgheSy;
    }

    public void setNameNgheSy(String nameNgheSy) {
        this.nameNgheSy = nameNgheSy;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public MultipartFile getFileMusic() {
        return fileMusic;
    }

    public void setFileMusic(MultipartFile fileMusic) {
        this.fileMusic = fileMusic;
    }
}
