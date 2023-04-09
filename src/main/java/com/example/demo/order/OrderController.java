package com.example.demo.order;

import com.example.demo.order.dto.OrderResponse;
import com.example.demo.order.dto.OrderSaveRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/order/")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("findAll")
    public String findAll() {
        return "";
    }

    @PostMapping("save")
    public OrderResponse save(@RequestBody @Valid OrderSaveRequest request) {
        return orderService.save(request);
    }

    @GetMapping("findById/{id}")
    public OrderResponse findById(@PathVariable String id) {
        return orderService.findById(id);
    }
}
