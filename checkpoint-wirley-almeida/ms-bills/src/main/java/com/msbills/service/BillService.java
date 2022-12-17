package com.msbills.service;

import com.msbills.dto.BillDto;
import com.msbills.models.Bill;
import com.msbills.openfeign.model.UserResponse;
import com.msbills.openfeign.repository.UserRepository;
import com.msbills.repositories.BillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BillService {

    private final BillRepository repository;
    private final UserRepository userRepository;

    public List<Bill> getAllBill() {
        return repository.findAll();
    }

    public Bill findByUserId(String id) {
        var bill = repository.findById(id);
        ResponseEntity<UserResponse> userResponse = userRepository.get(id);
        if (userResponse.getStatusCode().value() == 200) {
            UserResponse body = userResponse.getBody();
            assert body != null;
            return bill.get();
        } else throw new RuntimeException("Um erro ocorreu");
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
