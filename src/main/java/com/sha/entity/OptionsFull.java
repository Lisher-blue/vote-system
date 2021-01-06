package com.sha.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Lisher
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "votefull")
public class OptionsFull {
    @Id
    @KeySql
    private Integer id;
    /**
     * 选票数
     */
    private Integer poll;
}
