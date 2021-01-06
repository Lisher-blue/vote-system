package com.sha.mapper;

import com.sha.entity.OptionsFull;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author Lisher
 */
@Repository
@Mapper
public interface OptionsFullMapper {
    /**
     * 通过id查找投票
     * @param id id
     * @return 生成的图片
     */
    OptionsFull selectById(int id);

    /**
     * 插入新投票
     * @param optionsFull 投票
     */
    void insertVote(OptionsFull optionsFull);

    /**
     * 通过id更新投票
     * @param optionsFull 投票
     */
    void updateVote(OptionsFull optionsFull);
}
