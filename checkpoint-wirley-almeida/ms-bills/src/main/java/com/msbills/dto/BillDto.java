package com.msbills.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BillDto {
    private String customerBill;

    private String productBill;

    private Double totalPrice;
}
