package com.jty.tx.mapper;

import com.jty.tx.entity.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author :jty
 * @date :20-10-30
 */
@Mapper
public interface OrderMapper {
    /**
     * s
     * @param order
     */
    void add(Order order);
}
