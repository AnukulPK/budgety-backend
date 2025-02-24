package com.budgetingapp.backend.controller;

import com.budgetingapp.backend.dto.CreditDTO;
import com.budgetingapp.backend.model.Credit;
import com.budgetingapp.backend.service.CreditService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/credits")
public class CreditController {
    private final CreditService creditService;

    public CreditController(CreditService creditService)
    {
        this.creditService=creditService;
    }

    @GetMapping
    public List<Credit> getAllCredits() {
        return creditService.getAllCredits();
    }

    @PostMapping
    public ResponseEntity<Credit> addCredit(@RequestBody CreditDTO creditDTO) {
        Credit credit = new Credit(
                creditDTO.getSource(),
                creditDTO.getDescription(),
                creditDTO.getAmount(),
                creditDTO.getDate(),
                creditDTO.getCategory(),
                creditDTO.getCurrency(),
                creditDTO.getNotes()
        );


        Credit savedCredit =  creditService.addCredit(credit);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCredit);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Credit> updateCredit(@PathVariable Long id, @RequestBody CreditDTO creditDTO){
        Credit updatedCredit = creditService.updateCredit(id, creditDTO);
        return ResponseEntity.ok(updatedCredit);
    }

}
