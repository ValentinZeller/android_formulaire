package com.example.form;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    private String nom;
    private String prenom;
    private String email;
    private String genre;
    private String prog;
    private int heure;

    public User(String nom, String prenom, String email, String genre, String prog, int heure) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.genre = genre;
        this.prog = prog;
        this.heure = heure;
    }

    public User(Parcel source) {
        this.nom = source.readString();
        this.prenom = source.readString();
        this.email = source.readString();
        this.genre = source.readString();
        this.prog = source.readString();
        this.heure = source.readInt();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getProg() {
        return prog;
    }

    public void setProg(String prog) {
        this.prog = prog;
    }

    public int getHeure() {
        return heure;
    }

    public void setHeure(int heure) {
        this.heure = heure;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nom);
        dest.writeString(prenom);
        dest.writeString(email);
        dest.writeString(genre);
        dest.writeString(prog);
        dest.writeInt(heure);
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {

        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
