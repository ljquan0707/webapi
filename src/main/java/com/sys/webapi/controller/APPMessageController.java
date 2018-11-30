package com.sys.webapi.controller;


import com.sys.webapi.bean.AppMessage;
import com.sys.webapi.service.AppMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/appmessage")
public class APPMessageController {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private AppMessageService service;

    @RequestMapping("/getThree")
    public List<AppMessage> getThreeForMessage(){

        List<AppMessage> list = service.getMessage();
        return list;
    }

    @RequestMapping(value="/getAll",produces = "application/json; charset=utf-8")
    public List<AppMessage> getAllMessage(){

        List<AppMessage> list = service.getAllMessage();
        int num = list.size();
        if(null!=list && num>3){
            for (int i = 0; i < num-3; i++) {
                list.remove(0);
            }
        }
        return list;
    }

    @RequestMapping( value = "/getByID",produces = "application/json; charset=utf-8")
    public List<AppMessage> getMessageById(@RequestParam("id") String id){
        List<AppMessage> list = service.getMessageById(id);
        int num = list.size();
        logger.info(num+"条数据。");
        if(null!=list && num>5){
            for (int i = 0; i < num-5; i++) {
                list.remove(0);
            }
        }
        return list;
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public int addMessage(@RequestBody AppMessage appMessage){
        return service.addMessage(appMessage);
    }

    @RequestMapping(value="/delMessageById",method=RequestMethod.POST)
    public int delMessageById(@RequestParam("id") String id){
        return service.delMessage(id);
    }
}
