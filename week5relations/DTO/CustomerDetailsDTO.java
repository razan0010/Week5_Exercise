package com.example.week5relations.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerDetailsDTO {

    private Integer customer_id;
    private String gender;
    private String email;
    private Integer age;
}
