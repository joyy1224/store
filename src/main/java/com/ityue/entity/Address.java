package com.ityue.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 
 * @TableName t_address
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Address implements Serializable {
    /**
     * 收货地址id
     */
    private Integer aid;

    /**
     * 归属的用户id
     */
    private Integer uid;

    /**
     * 收货人姓名
     */
    private String name;

    /**
     * 省-名称
     */
    private String provinceName;

    /**
     * 省-行政代号
     */
    private String provinceCode;

    /**
     * 市-名称
     */
    private String cityName;

    /**
     * 市-行政代号
     */
    private String cityCode;

    /**
     * 区-名称
     */
    private String areaName;

    /**
     * 区-行政代号
     */
    private String areaCode;

    /**
     * 邮政编码
     */
    private String zip;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 手机
     */
    private String phone;

    /**
     * 固话
     */
    private String tel;

    /**
     * 标签
     */
    private String tag;

    /**
     * 是否默认：0-不默认，1-默认
     */
    private Integer isDefault;

    /**
     * 创建人
     */
    private String createdUser;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 修改人
     */
    private String modifiedUser;

    /**
     * 修改时间
     */
    private Date modifiedTime;

    private static final long serialVersionUID = 1L;

}