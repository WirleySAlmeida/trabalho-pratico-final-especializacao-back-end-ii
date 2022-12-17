package com.msbills.service;

import com.msbills.dto.BillDto;
import com.msbills.models.Bill;
import com.msbills.repositories.BillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BillService {

    private final BillRepository repository;

    public List<Bill> getAllBill() {
        return repository.findAll();
    }

    public Bill findByUserId(String id) {
        return repository.findById(id).get();
    }

    public Bill save(BillDto billDto){
        Bill bill = new Bill();
        bill.setCustomerBill(billDto.getCustomerBill());
        bill.setProductBill(billDto.getProductBill());
        bill.setTotalPrice(billDto.getTotalPrice());
        repository.save(bill);
        return bill;
    }

}
