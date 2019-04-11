package com.example.accountancy.repositories;

import com.example.accountancy.persistence.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
