package com.ityue.entity;

import lombok.*;

import java.io.Serializable;

/**
 * 
 * @TableName t_dict_district
 */
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DictDistrict extends BeseEntity implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String parent;

    /**
     * 
     */
    private String code;

    /**
     * 
     */
    private String name;

    private static final long serialVersionUID = 1L;
}