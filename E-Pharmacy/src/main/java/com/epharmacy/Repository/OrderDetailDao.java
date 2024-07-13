package com.epharmacy.Repository;

import org.springframework.data.repository.CrudRepository;

import com.epharmacy.Entity.OrderDetail;

public interface OrderDetailDao extends CrudRepository<OrderDetail, Integer> {

}
