package com.picpaybackend.picpaybackend.repository;

import com.picpaybackend.picpaybackend.Entities.Trasaction;
import jakarta.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Trasaction, Long> {
}
