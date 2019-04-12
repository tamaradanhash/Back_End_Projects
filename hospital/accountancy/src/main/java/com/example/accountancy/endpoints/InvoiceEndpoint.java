package com.example.accountancy.endpoints;

import com.example.accountancy.logic.InvoiceManager;
import com.example.accountancy.persistence.Invoice;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoices")
@RequiredArgsConstructor
public class InvoiceEndpoint {
  private final InvoiceManager manager;

  @GetMapping
  public List<Invoice> getAll() {
    return manager.findAll();
  }

  @PutMapping("/{id}/paid")
  public void put(@PathVariable Long id) {
    manager.updateToPaid(id);
  }
}
