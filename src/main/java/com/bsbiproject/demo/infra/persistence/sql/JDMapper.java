package com.bsbiproject.demo.infra.persistence.sql;

import com.bsbiproject.demo.domain.model.JDModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Author     : WindAsMe
 * File       : JDMapper.java
 * Time       : Create on 18-10-9
 * Location   : ../Home/BSBIProject/JDMapper.java
 */
@Mapper
public interface JDMapper {

    List<JDModel> selectJDModelAll();
}
