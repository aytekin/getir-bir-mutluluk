package com.getir.project.unit;

import com.getir.project.customer.Customer;
import com.getir.project.customer.CustomerRepository;
import com.getir.project.customer.CustomerServiceImpl;
import com.getir.project.customer.dto.CustomerResponse;
import com.getir.project.customer.dto.CustomerSaveRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class CustomerUnitTest {

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private Customer customer;
    private CustomerResponse customerResponse;

    @BeforeEach
    void setUp() {
        customer = new Customer();
        customer.setName("Test customer service");
        customer.setEmail("test@test.com");

        customerResponse = CustomerResponse.builder()
                .name("Test customer service")
                .email("test@test.com")
                .build();
    }


    @Test
    void createCustomer_successfullyCreatedCustomer_Test() {

        CustomerSaveRequest customerSaveRequest = prepareCreateCustomerRequest();

        given(customerRepository.save(any(Customer.class))).willReturn(customer);
        given(bCryptPasswordEncoder.encode(any(String.class))).willReturn("testpassword00");


        CustomerResponse createdCustomer = customerService.save(customerSaveRequest);
        assertEquals(customerResponse.getEmail(), createdCustomer.getEmail());

    }

    @Test
    void findAll_Success_Test() {

        given(customerRepository.findAll(any(Pageable.class))).willReturn(Page.empty(Pageable.ofSize(10)));

        Page<CustomerResponse> request = customerService.findAll(PageRequest.of(0, 10));
        assertEquals(0, request.getTotalPages());
    }


    private CustomerSaveRequest prepareCreateCustomerRequest() {
        return CustomerSaveRequest.builder()
                .name("Test customer service")
                .email("test@test.com")
                .username("test")
                .password("testpassword00")
                .build();
    }
}
