package com.example.week5relations.Service;

import com.example.week5relations.API.ApiException;
import com.example.week5relations.DTO.CustomerDetailsDTO;
import com.example.week5relations.Model.Customer;
import com.example.week5relations.Model.Details;
import com.example.week5relations.Repository.CustomerRepository;
import com.example.week5relations.Repository.DetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DetailsService {

    private final CustomerRepository customerRepository;
    private final DetailsRepository detailsRepository;

    public List<Details> getDetails(){
       return detailsRepository.findAll();
    }

    public void addDetails(CustomerDetailsDTO customerDetailsDTO){
        Customer customer = customerRepository.findCustomerById(customerDetailsDTO.getCustomer_id());

        if (customer == null){
            throw new ApiException("Customer not found");
        }

        Details details = new Details(null, customerDetailsDTO.getGender(), customerDetailsDTO.getEmail(), customerDetailsDTO.getAge() , customer);
        detailsRepository.save(details);
    }

    public void updateDetails(CustomerDetailsDTO customerDetailsDTO){
        Customer customer = customerRepository.findCustomerById(customerDetailsDTO.getCustomer_id());

        if (customer == null){
            throw new ApiException("Customer not found");
        }

        Details details = customer.getDetails();

        details.setGender(customerDetailsDTO.getGender());
        details.setEmail(customerDetailsDTO.getEmail());
        details.setAge(customerDetailsDTO.getAge());

        detailsRepository.save(details);
    }

    public void deleteDetails(Integer id) {
        Customer customer = customerRepository.findCustomerById(id);

        if (customer == null){
            throw new ApiException("Customer not found");
        }

        Details details = customer.getDetails();

        if (details == null){
            throw new ApiException("Customer has no details");
        }

        customer.setDetails(null);
        customerRepository.save(customer);
        detailsRepository.delete(details);

    }
}