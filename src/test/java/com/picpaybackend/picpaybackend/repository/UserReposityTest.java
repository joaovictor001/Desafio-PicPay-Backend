package com.picpaybackend.picpaybackend.repository;

import com.picpaybackend.picpaybackend.Entities.User;
import com.picpaybackend.picpaybackend.dtos.User.UserCreateDTO;
import com.picpaybackend.picpaybackend.enums.UserType;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
        /*Informar o banco de tests, que vais ser utilizado
        Normalmente é usado o H2 Database para teste por é um banco mais rapido de realizar tests
         */
@ActiveProfiles("test")

class UserReposityTest {

    @Autowired
    UserReposity userReposity;
    @Autowired
    EntityManager entityManager;

    @Test
    @DisplayName("Shold get User successfully from DB")
    void findUserByDocumentSuccess() {
        String document = "11223344";
        UserCreateDTO data =  new UserCreateDTO("joao","victor",document, new BigDecimal(10), "joao@123","123", UserType.COMMON);

        this.createUser(data);

       Optional<User> founduser =this.userReposity.findUserByDocument(document);
       assertThat(founduser.isPresent()).isTrue();
    }

    private User createUser(UserCreateDTO data){
        User newUser = new User(data);
        this.entityManager.persist(newUser);
        return  newUser;

    }
}