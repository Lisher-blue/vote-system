package com.sha.mapper;

import com.sha.entity.Vote;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author Lisher
 */
@Repository
@Mapper
public interface VoteMapper {
    /**
     * 通过编号查找投票结果
     * @param id 编号
     * @return 投票结果
     */
    Vote selectById(int id);

    /**
     * 插入新投票
     * @param vote 投票
     */
    void insertVote(Vote vote);

    /**
     * 通过id更新投票
     * @param vote 投票
     */
    void updateVote(Vote vote);

    /**
     * 通过pid查找投票
     * @param pId 选票id
     * @return 投票结果
     */
    Vote selectByPid(int pId);
}
