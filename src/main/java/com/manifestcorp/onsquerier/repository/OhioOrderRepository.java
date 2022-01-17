package com.manifestcorp.onsquerier.repository;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.repository.ReactiveCosmosRepository;
import com.manifestcorp.onsquerier.domain.CosmosOrder;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Repository;

@Repository
public interface OhioOrderRepository extends ReactiveCosmosRepository<CosmosOrder, Integer> {

}