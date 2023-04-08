package com.example.demo.customer;

import com.example.demo.customer.dto.CustomerSaveRequest;
import com.example.demo.customer.dto.CustomerResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public interface CustomerService {
    CustomerResponse save(CustomerSaveRequest request);

    Page<CustomerResponse> findAll(Pageable pageable);
}
