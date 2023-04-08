package com.example.demo.order;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders/")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("findAll")
    public String findAll(){
        return "";
    }
}
