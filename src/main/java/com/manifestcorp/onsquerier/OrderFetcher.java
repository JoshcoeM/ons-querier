package com.manifestcorp.onsquerier;

import com.manifestcorp.onsdomain.Order;
import com.manifestcorp.onsquerier.dao.MainOrderMapper;
import com.manifestcorp.onsquerier.domain.CosmosOrder;
import com.manifestcorp.onsquerier.repository.OhioOrderRepository;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


@DgsComponent
public class OrderFetcher {
    Logger logger = LoggerFactory.getLogger(OrderFetcher.class);

    @Autowired
    MainOrderMapper mainOrderMapper;

    @Autowired
    OhioOrderRepository ohioOrderRepository;


    @DgsQuery(field="order")
    public CosmosOrder order(@InputArgument("orderId") Integer id ){
        CosmosOrder cOrder;
        var order = mainOrderMapper.getOrder(id);
        logger.info(order.toString());
        if(order != null){
            cOrder = new CosmosOrder(order);
        }else{
            cOrder = ohioOrderRepository.findById(id).block();
        }
        return cOrder;
    }

}
