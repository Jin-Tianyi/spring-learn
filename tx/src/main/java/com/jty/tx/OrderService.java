package com.jty.tx;

import com.jty.tx.entity.Account;
import com.jty.tx.entity.Order;
import com.jty.tx.entity.Storage;
import com.jty.tx.mapper.AccountMapper;
import com.jty.tx.mapper.OrderMapper;
import com.jty.tx.mapper.StorageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

/**
 * @author :jty
 * @date :20-10-30
 */
@Service
public class OrderService {
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    StorageMapper storageMapper;
    @Autowired
    AccountMapper accountMapper;

    @Transactional(rollbackFor = Exception.class)
    public void doOrder(){
        //bz0001库存减20
        storageMapper.update(new Storage(null,"bz0001",100-20,100));
        //增加20份订单
        orderMapper.add(
                new Order(null,0001,"bz0001",20,20*100));
        accountMapper.update(new Account(null,0001,1500-20*100));
    }
}
