package com.study.sweetk.repository.mapper;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.sweetk.repository.vo.HwPoiVo;

@Repository("hwPoiMapper")
public class HwPoiMapper {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public List<HwPoiVo> selectPoiList(){
        return sqlSessionTemplate.selectList("hwPoiMapper.selectPoiList");
    }
    
}
