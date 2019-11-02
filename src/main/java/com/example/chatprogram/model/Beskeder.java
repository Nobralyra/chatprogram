package com.example.chatprogram.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Beskeder {

    @Id
    private int id;
    @NotBlank (message ="Indtast venligst en besked")
    private String tekst;
    private String persons_navn;


    public String getPersons_navn() {
        return persons_navn;
    }

    public void setPersons_navn(String persons_navn) {
        this.persons_navn = persons_navn;
    }



    public Beskeder() {
    }

    public Beskeder(int id, String tekst, String persons_navn) {
        this.id = id;
        this.tekst = tekst;
        this.persons_navn = persons_navn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }
}
