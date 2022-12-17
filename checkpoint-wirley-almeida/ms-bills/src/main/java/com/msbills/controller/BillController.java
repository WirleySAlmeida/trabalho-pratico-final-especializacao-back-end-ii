package com.msbills.controller;

import com.msbills.dto.BillDto;
import com.msbills.models.Bill;
import com.msbills.service.BillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bills")
@RequiredArgsConstructor
public class BillController {

    private final BillService service;

    @GetMapping("/all")
    @PreAuthorize("hasRole('PROVIDERS')")
    public ResponseEntity<List<Bill>> getAll() {
        return ResponseEntity.ok().body(service.getAllBill());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bill> findByUserId(@PathVariable String id) {
        return ResponseEntity.ok(service.findByUserId(id));
    }

    @PostMapping
    @PreAuthorize("hasRole('PROVIDERS')")
    public ResponseEntity<Bill> save(@RequestBody BillDto billDto) {
        return new ResponseEntity<>(service.save(billDto), HttpStatus.CREATED);
    }
}
