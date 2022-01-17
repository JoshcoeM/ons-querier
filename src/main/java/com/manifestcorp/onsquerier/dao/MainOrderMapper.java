package com.manifestcorp.onsquerier.dao;


import com.manifestcorp.onsdomain.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MainOrderMapper {
    public Order getOrder(int orderId);
}
