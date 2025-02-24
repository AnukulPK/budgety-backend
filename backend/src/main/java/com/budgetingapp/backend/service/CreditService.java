package com.budgetingapp.backend.service;

import com.budgetingapp.backend.dto.CreditDTO;
import com.budgetingapp.backend.model.Credit;
import com.budgetingapp.backend.repository.CreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditService {

    @Autowired
    private CreditRepository creditRepository;

    public CreditService(CreditRepository creditRepository)
    {
        this.creditRepository=creditRepository;
    }

    public List<Credit> getAllCredits()
    {
        return creditRepository.findAll();
    }

    public Credit addCredit(Credit credit){
        return creditRepository.save(credit);
    }


    public Credit updateCredit(Long id, CreditDTO creditDTO) {
        return creditRepository.findById(id).map(credit->{
            credit.setDescription(creditDTO.getDescription());
            credit.setAmount(creditDTO.getAmount());
            credit.setDate(creditDTO.getDate());
            credit.setCategory(creditDTO.getCategory());
            credit.setCurrency(creditDTO.getCurrency());
            credit.setNotes(creditDTO.getNotes());
            return creditRepository.save(credit);
        }).orElseThrow(()->new RuntimeException("Credit not found with id: "+id));
    }
}
