package com.mobilepro.beeflover;

public class Users {

    String uid, nama, email, nomor;

    public Users() {

    }

    public Users(String uid, String nama, String email, String nomor) {
        this.uid = uid;
        this.nama = nama;
        this.email = email;
        this.nomor = nomor;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomor() {
        return nomor;
    }

    public void setNomor(String nomor) {
        this.nomor = nomor;
    }
}
