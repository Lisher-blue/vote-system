package com.sha.mapper;

import com.sha.entity.Options;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Lisher
 */
@Repository
@Mapper
public interface OptionsMapper {
    /**
     * 列出所有的选择
     * @return 选择列表
     */
    List<Options> findAllOptions();
}
