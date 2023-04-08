package com.example.demo.statistic;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/statistic/")
@AllArgsConstructor
public class StatisticController {

    private final StatisticService statisticService;
}
