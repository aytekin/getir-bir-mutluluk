package com.getir.project.statistic;

import com.getir.project.order.OrderService;
import com.getir.project.statistic.dto.CustomerMonthlyStatisticResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/statistic/")
@AllArgsConstructor
public class StatisticController {

    private final OrderService orderService;

    @GetMapping("customerMonthlyStatistic")
    public List<CustomerMonthlyStatisticResponse> customerMonthlyStatistics(@RequestParam String id) {
        return orderService.customerMonthlyStatistics(id);
    }
}
