package com.bsbiproject.demo.domain.service;

import com.bsbiproject.demo.domain.model.JDModel;
import com.bsbiproject.demo.infra.persistence.sql.JDMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : JDService.java
 * Time       : Create on 18-10-9
 * Location   : ../Home/BSBIProject/JDService.java
 */
@Service
public class JDService {

    @Resource
    private JDMapper mapper;

    public List<JDModel> selectJDModelAll() {
        return this.mapper.selectJDModelAll();
    }
}
