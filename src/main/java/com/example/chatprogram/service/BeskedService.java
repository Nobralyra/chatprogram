package com.example.chatprogram.service;

import com.example.chatprogram.model.Beskeder;
import com.example.chatprogram.repository.BeskedRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeskedService {

    @Autowired
    BeskedRepo beskedRepo;

    public void tilfoejBesked(Beskeder besked)
    {

    }

    public List<Beskeder> hentAlleBeskeder()
    {
        return beskedRepo.hentAlleBeskeder();
    }
}
