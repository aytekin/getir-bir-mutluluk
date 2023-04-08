package com.example.demo.customer;

import com.example.demo.customer.dto.CustomerSaveRequest;
import com.example.demo.customer.dto.CustomerResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/customer/")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("save")
    public CustomerResponse save(@RequestBody @Valid CustomerSaveRequest request) {
        return customerService.save(request);
    }

    @GetMapping("findAll")
    public Page<CustomerResponse> findAll(@RequestParam(required = false, defaultValue = "10") int size,
                                          @RequestParam(required = false, defaultValue = "0") int page) {
        return customerService.findAll(PageRequest.of(page, size));
    }
}
