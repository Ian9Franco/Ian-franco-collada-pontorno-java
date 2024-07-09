package com.abmpf.abmpf.repository;

import com.abmpf.abmpf.entities.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceiptRepository extends JpaRepository<Receipt, Integer> {
}
