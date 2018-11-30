package com.sys.webapi.service;

import com.sys.webapi.bean.AppMessage;
import com.sys.webapi.mapper.AppMessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


import com.sys.webapi.bean.AppMessage;
import com.sys.webapi.mapper.AppMessageMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
@Service
public class AppMessageService {
    @Autowired
    private AppMessageMapper mapper;

    public List<AppMessage> getMessage(){
        List<AppMessage> list = new ArrayList<AppMessage>();
        list.add(mapper.selectByPrimaryKey("2"));
        //list = mapper.selectAll();
        return list;
    }

    public List<AppMessage> getAllMessage(){
        List<AppMessage> list = new ArrayList<AppMessage>();
        list = mapper.selectAll();
        return list;
    }

    public int addMessage(AppMessage appMessage) {
        return mapper.insert(appMessage);
    }

    public List<AppMessage> getMessageById(String id) {
        return mapper.getMessById(id);
    }

    public int delMessage(String id) {
        return mapper.deleteByPrimaryKey(id);
    }
}
