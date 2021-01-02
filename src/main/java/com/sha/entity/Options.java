package com.sha.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;

/**
 * @author Lisher
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "options")
public class Options {
    private int id;
    private String optionValue;
    private String src;
}
