package com.picpaybackend.picpaybackend.Entities;

import com.picpaybackend.picpaybackend.dtos.User.UserCreateDTO;
import com.picpaybackend.picpaybackend.enums.UserType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity(name= "users")
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String fistname;
    private String lastname;
    @Column(unique = true)
    private String document;
    @Column(unique = true)
    private String email;
    private String password;
    private BigDecimal balance;
    @Enumerated(EnumType.STRING)
    private UserType type;




    public User(UserCreateDTO dados){
        this.fistname = dados.firstName();
        this.lastname = dados.lastName();
        this.document = dados.document();
        this.balance = dados.balance();
        this.type = dados.userType();
        this.password = dados.password();
        this.email = dados.email();
    }

}
