package tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tx.entity.*;
import tx.mapper.*;
/**
 * @author :jty
 * @date :20-10-30
 */
public class OrderService {
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    StorageMapper storageMapper;
    @Autowired
    AccountMapper accountMapper;

    public void doOrder(){
        //bz0001库存减20
        storageMapper.update(new Storage(null,"bz0001",100-20,100));
        //增加20份订单
        orderMapper.add(
                new Order(null,0001,"bz0001",20,20*100));
        //手动制造一个异常，观察数据库变化
        int m=1/0;

        accountMapper.update(new Account(null,0001,1500-20*100));
    }
        //命名内部类


}
