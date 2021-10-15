package com.codegym.model;

public class Music {
    private String nameBaiHat;
    private String nameNgheSy;
    private String theLoai;
    private String fileMusic;

    public Music(String nameBaiHat, String nameNgheSy, String theLoai, String fileMusic) {
        this.nameBaiHat = nameBaiHat;
        this.nameNgheSy = nameNgheSy;
        this.theLoai = theLoai;
        this.fileMusic = fileMusic;
    }

    public Music() {
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

    public String getFileMusic() {
        return fileMusic;
    }

    public void setFileMusic(String fileMusic) {
        this.fileMusic = fileMusic;
    }
}
