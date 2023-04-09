package com.getir.project.order;

import com.getir.project.order.dto.OrderResponse;
import com.getir.project.order.dto.OrderSaveRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/order/")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("findAllByIdAndDateBetween")
    public List<OrderResponse> findAllByIdAndDateBetween(@RequestParam String id, @RequestParam Date startDate, @RequestParam Date endDate) {
        return orderService.findAllByIdAndDateBetween(id, startDate, endDate);
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
