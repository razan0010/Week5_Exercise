package com.example.week5relations.Controller;

import com.example.week5relations.DTO.CustomerDetailsDTO;
import com.example.week5relations.Service.DetailsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/details")
@RequiredArgsConstructor
public class CustomerDetailsController {

    private final DetailsService detailsService;

    @GetMapping("get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(detailsService.getDetails());
    }

    @PostMapping("add")
    public ResponseEntity addCustomer(@RequestBody @Valid CustomerDetailsDTO customerDetailsDTO){
        detailsService.addDetails(customerDetailsDTO);
        return ResponseEntity.status(200).body("Customer details added");
    }

    @PutMapping("update")
    public ResponseEntity updateCustomer(@RequestBody @Valid CustomerDetailsDTO customerDetailsDTO){
        detailsService.updateDetails(customerDetailsDTO);
        return ResponseEntity.status(200).body("Customer details updated");
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Integer id){
        detailsService.deleteDetails(id);
        return ResponseEntity.status(200).body("Customer details deleted");
    }
}
