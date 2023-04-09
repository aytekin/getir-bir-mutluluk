package com.getir.project.order;

import com.getir.project.statistic.dto.CustomerMonthlyStatisticResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {

    List<Order> findAllByIdAndCreatedDateBetween(String id, Date startDate, Date endDate);

    @Query(value = "SELECT to_char(o.created_date, 'month') as month, " +
            "       SUM(oi.amount)                   as totalBookCount, " +
            "       COUNT(o.customer_id)             as totalOrderCount, " +
            "       SUM(o.total_cost)                as totalCost " +
            "FROM t_order as o " +
            "         INNER JOIN t_order_item oi " +
            "                    ON o.id = oi.order_id " +
            "WHERE o.customer_id = :id " +
            "group by month " +
            "order by month ASC", nativeQuery = true)
    List<CustomerMonthlyStatisticResponse> customerMonthlyStatistics(String id);
}
