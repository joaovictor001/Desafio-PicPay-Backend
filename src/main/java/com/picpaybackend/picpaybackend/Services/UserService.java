package com.picpaybackend.picpaybackend.Services;

import com.picpaybackend.picpaybackend.Entities.User;
import com.picpaybackend.picpaybackend.enums.UserType;
import com.picpaybackend.picpaybackend.repository.UserReposity;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

public class UserService {
    @Autowired
    private UserReposity reposity;

    public  void  validateTrasaction(User sender, BigDecimal amount) throws Exception {
        if(sender.getType() == UserType.MERCHANT){
            throw new Exception("Usuario do tipo lojista não pode realizar transção");
        }

        if (sender.getBalance().compareTo(amount)< 0 ){
            throw new Exception("Saldo insuficiente");
        }
    }
    public User findUserById(long Id ) throws Exception {
        return this.reposity.findUserById(Id).orElseThrow(()-> new Exception("usurio not found"));
    }
    public void saveUser(User user){
        this.reposity.save(user);
    }
}
