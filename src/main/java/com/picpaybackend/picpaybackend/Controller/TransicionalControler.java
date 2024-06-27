package com.picpaybackend.picpaybackend.Controller;

import com.picpaybackend.picpaybackend.Entities.Trasaction;
import com.picpaybackend.picpaybackend.Services.TransactionService;
import com.picpaybackend.picpaybackend.dtos.Trasaction.TrasactionCreateDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Trasaction")

public class TransicionalControler {
    @Autowired
    private TransactionService service;


    @PostMapping
    public ResponseEntity<Trasaction> createTransaction(@RequestBody @Valid TrasactionCreateDTO trasaction) throws  Exception{
        Trasaction newtTrasaction = this.service.createTransaction(trasaction);
        return new ResponseEntity<>(newtTrasaction, HttpStatus.OK);
    }

}
