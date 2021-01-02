package com.sha.mapper;

import com.sha.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author Lisher
 */
@Repository
@Mapper
public interface UserMapper {
    /**
     * 通过id查找用户
     * @param id id
     * @return 用户
     */
    User selectByUserId(int id);

    /**
     * 通过用户名查找用户
     * @param username 用户名
     * @return 用户
     */
    User selectByUserName(String username);
}
