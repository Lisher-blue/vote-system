package com.sha.mapper;

import com.sha.entity.OptionsOrigin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author Lisher
 */
@Repository
@Mapper
public interface OptionsOriginMapper {
    /**
     * 通过id查找投票
     * @param id id
     * @return 生成的图片
     */
    OptionsOrigin selectById(int id);

    /**
     * 插入新投票
     * @param optionsOrigin 投票
     */
    void insertVote(OptionsOrigin optionsOrigin);

    /**
     * 通过id更新投票
     * @param optionsOrigin 投票
     */
    void updateVote(OptionsOrigin optionsOrigin);
}
