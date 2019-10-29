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
    
    public List<Beskeder> hentAlleBeskeder()
    {
        String sql = "SELECT * FROM beskeder";
        RowMapper<Beskeder> rowMapper = new BeanPropertyRowMapper<>(Beskeder.class);
        return jdbcTemplate.query(sql, rowMapper);
    }

    public void tilfoejBesked(Beskeder besked){
        String sql = "INSERT INTO beskeder (id, besked) VALUES (?,?)";
        jdbcTemplate.update(sql, besked.getId(), besked.getBesked());
    }

    /*
    //skulle også returnere boolean for bekræftelse
    public void sletBesked(int id){
        String sql = "DELETE FROM beskeder WHERE id=?";
        jdbcTemplate.update(sql, id);
    }*/


}
