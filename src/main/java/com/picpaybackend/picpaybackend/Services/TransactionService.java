package com.picpaybackend.picpaybackend.Services;

import com.picpaybackend.picpaybackend.Entities.Trasaction;
import com.picpaybackend.picpaybackend.Entities.User;
import com.picpaybackend.picpaybackend.dtos.Trasaction.TrasactionCreateDTO;
import com.picpaybackend.picpaybackend.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

@Service

public class TransactionService {
    @Autowired
    private UserService userService;
    @Autowired
    private TransactionRepository repository;

    //Para fazer chamadas Http externas.
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private  NotificationService notificationService;

    @Value("service-endpoint")
    private String picpayService;



    public Trasaction createTransaction(TrasactionCreateDTO dados) throws Exception {
        User sender = this.userService.findUserById(dados.senderId());
        User receiver = this.userService.findUserById(dados.receiverId());

        userService.validateTrasaction(sender,dados.value());

        boolean isAuthorized = this.authorizeTransaction();
        System.out.println(isAuthorized);
        if(isAuthorized){
            throw new Exception("Transação não autorizada");
        }

        Trasaction trasaction = new Trasaction();
        trasaction.setAmount(dados.value());
        trasaction.setSender(sender);
        trasaction.setReceiver(receiver);
        trasaction.setTimestamp(LocalDateTime.now());


        sender.setBalance(sender.getBalance().subtract(dados.value()));
        receiver.setBalance(receiver.getBalance().add(dados.value()));


        this.repository.save(trasaction);
        this.userService.saveUser(sender);
        this.userService.saveUser(receiver);

        this.notificationService.sendNotification(sender,"Trasação realizada com sucesso");
        this.notificationService.sendNotification(receiver,"Trasação recebida com sucesso");

        return trasaction;

    }
    public boolean authorizeTransaction(){
        ResponseEntity<Map> AuthorizationResponse = restTemplate.getForEntity("https://util.devi.tools/api/v2/authorize", Map.class);

        if(AuthorizationResponse.getStatusCode() == HttpStatus.OK){
            String mensage =(String) AuthorizationResponse.getBody().get("message");
            return "Autorizado".equalsIgnoreCase(mensage);
        }else {
            return false;
        }
    }

}
