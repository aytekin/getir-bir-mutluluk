package com.getir.project.customer;

import com.getir.project.customer.dto.CustomerSaveRequest;
import com.getir.project.customer.dto.CustomerResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {
    CustomerResponse save(CustomerSaveRequest request);

    Page<CustomerResponse> findAll(Pageable pageable);
}
