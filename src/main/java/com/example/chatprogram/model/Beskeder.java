package com.example.chatprogram.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Beskeder {

    /**
     * Hvilke atributer/fields som bruges
     * Skal vidst nok hedde præcis det samme som hvad kolonnerne i tabellen hedder.
     *
     */
    @Id
    private int id;
    @NotBlank (message ="Indtast venligst en besked") //overruler den fejlbesked der er skrevet i html (hvis kun der er validering på databasesiden??)
    private String tekst;
    @NotBlank
    private String persons_navn;

    /**
     * Default constructer
     */
    public Beskeder() {
    }

    /**
     * Overloadet constructer med parameter
     * @param id
     * @param tekst
     * @param persons_navn
     */
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

    public String getPersons_navn() {
        return persons_navn;
    }

    public void setPersons_navn(String persons_navn) {
        this.persons_navn = persons_navn;
    }
}
