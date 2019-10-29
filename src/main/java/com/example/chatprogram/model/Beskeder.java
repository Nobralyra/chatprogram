package com.example.chatprogram.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Beskeder {

    @Id
    private int id;
    @NotBlank (message ="Indtast venligst en besked")
    private String besked;

    public Beskeder() {
    }

    public Beskeder(int id, String besked) {
        this.id = id;
        this.besked = besked;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBesked() {
        return besked;
    }

    public void setBesked(String besked) {
        this.besked = besked;
    }
}
