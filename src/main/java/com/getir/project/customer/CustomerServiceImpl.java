package com.getir.project.customer;

import com.getir.project.common.exception.GetirException;
import com.getir.project.common.utils.ObjectMappers;
import com.getir.project.customer.dto.CustomerResponse;
import com.getir.project.customer.dto.CustomerSaveRequest;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public CustomerResponse save(CustomerSaveRequest request) {
        checkUsernameAndEmailExist(request);
        Customer customer = ObjectMappers.map(request, Customer.class);
        customer.setPassword(bCryptPasswordEncoder.encode(customer.getPassword()));
        return ObjectMappers.map(repository.save(customer), CustomerResponse.class);
    }

    @Override
    public Page<CustomerResponse> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(customer -> ObjectMappers.map(customer, CustomerResponse.class));
    }


    private void checkUsernameAndEmailExist(CustomerSaveRequest request) {
        repository.findByEmail(request.getEmail()).ifPresent(s -> {
            throw new GetirException("customer already exist with email : " + request.getEmail()); //if exist throw ex
        });

        repository.findByUsername(request.getUsername()).ifPresent(s -> {
            throw new GetirException("customer already exist with username : " + request.getUsername()); //if exist throw ex
        });
    }
}
