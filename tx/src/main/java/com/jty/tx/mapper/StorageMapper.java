package com.jty.tx.mapper;

import com.jty.tx.entity.Storage;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author :jty
 * @date :20-10-30
 */
@Mapper
public interface StorageMapper {
    /**
     * s
     * @param storage
     */
    void update(Storage storage);
}
