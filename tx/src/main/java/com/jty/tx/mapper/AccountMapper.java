package com.jty.tx.mapper;

import com.jty.tx.entity.Account;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author :jty
 * @date :20-10-30
 */
@Mapper
public interface AccountMapper {
    /**
     * s
     * @param account
     */
    void update(Account account);
}
