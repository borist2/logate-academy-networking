package com.example.networkingcourse.repository.implementation;

import com.example.networkingcourse.model.Order;
import com.example.networkingcourse.model.QOrder;
import com.example.networkingcourse.repository.CustomOrderRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class CustomOrderRepositoryImpl implements CustomOrderRepository
{
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Order findByIdQueryDSL(Integer id)
    {
        var qOrder = QOrder.order;
        return jpaQueryFactory.select(qOrder)
                .from(qOrder)
                .where(qOrder.id.eq(id))
                .fetchOne();
    }
}
