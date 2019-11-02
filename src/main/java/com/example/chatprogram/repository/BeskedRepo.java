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

    public List<Beskeder> hentAlleChats()
    {
        String sql = "SELECT * FROM chat";
        RowMapper<Beskeder> rowMapper = new BeanPropertyRowMapper<>(Beskeder.class);
        return jdbcTemplate.query(sql, rowMapper);
    }

    public void tilfoejBesked(Beskeder besked){
        String sql = "INSERT INTO chat (id, tekst, persons_navn) VALUES (?,?,?)";
        jdbcTemplate.update(sql, besked.getId(), besked.getTekst(), besked.getPersons_navn());
    }

    /*
    //skulle også returnere boolean for bekræftelse
    public void sletBesked(int id){
        String sql = "DELETE FROM beskeder WHERE id=?";
        jdbcTemplate.update(sql, id);
    }*/


}
