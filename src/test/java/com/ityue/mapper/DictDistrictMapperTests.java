package com.ityue.mapper;


import com.ityue.entity.DictDistrict;
import com.ityue.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DictDistrictMapperTests {

    @Autowired
    private DictDistrictMapper dictDistrictMapper;

    @Test
    public void select(){
        List<DictDistrict> byParent = dictDistrictMapper.findByParent("110100");
        byParent.forEach(System.err::println);
    }

}
