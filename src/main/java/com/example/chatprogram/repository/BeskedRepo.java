package com.example.chatprogram.repository;

import com.example.chatprogram.model.Beskeder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BeskedRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * Ved hjælp af SQL statementet kan alle chats, der er på databasen, blive hentet ind i java programmet.
     * Det gøres ved hjælp af RowMapper og JdbcTemplate.
     *
     * RowMapper interface to fetch the records from the database using query() method of JdbcTemplate class
     *
     * https://www.javatpoint.com/RowMapper-example
     * https://dzone.com/articles/spring-jdbc-rowmapper-vs-resultsetextractor
     *
     * @return jdbcTemplate.query(sql, rowMapper)
     */
    public List<Beskeder> hentAlleChats()
    {
        String sql = "SELECT * FROM chat";
        RowMapper<Beskeder> rowMapper = new BeanPropertyRowMapper<>(Beskeder.class);
        return jdbcTemplate.query(sql, rowMapper);
    }

    /**
     * Ved hjælp af SQL statementet kan der blive tiljøjet en besked til databasen.
     * Der er brugt void, da der ikke ønskes et return.
     *
     * Det gøres ved hjælp af JdbcTemplate update, som bruger sql statementet og getmetoder.
     *
     * @param beskeder
     */
    public void tilfoejBesked(Beskeder beskeder){
        String sql = "INSERT INTO chat (id, tekst, persons_navn) VALUES (?,?,?)";
        jdbcTemplate.update(sql, beskeder.getId(), beskeder.getTekst(), beskeder.getPersons_navn());
    }

    /**
     * Ikke brugt metode
     */
    /*
    skulle også returnere boolean for bekræftelse
    public void sletBesked(int id){
        String sql = "DELETE FROM beskeder WHERE id=?";
        jdbcTemplate.update(sql, id);
    }*/


}
