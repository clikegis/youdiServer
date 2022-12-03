package com.cy.youdi.service.impl;

import com.cy.youdi.dao.YoudiDao;
import com.cy.youdi.service.YoudiService;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YoudiServiceImpl implements YoudiService {
    @Autowired
    YoudiDao youdiDao;

    @Override
    public List getAllData(){
        return youdiDao.selectList(null);
    }
}
