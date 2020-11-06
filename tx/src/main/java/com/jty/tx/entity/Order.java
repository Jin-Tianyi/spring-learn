package com.jty.tx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author :jty
 * @date :20-10-30
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Order {
    private Integer id;
    private Integer userId;
    private String commodityCode;
    private Integer count;
    private Integer money;
}
