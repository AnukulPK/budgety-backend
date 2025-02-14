package com.budgetingapp.backend.service;

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


}
