package com.ityue.mapper;

import com.ityue.entity.DictDistrict;

import java.util.List;

/**
* @author ASUS
* @description 针对表【t_dict_district】的数据库操作Mapper
* @createDate 2022-09-07 19:58:19
* @Entity generator.DictDistrict
*/
public interface DictDistrictMapper {
    List<DictDistrict> findByParent(String parent);
}




