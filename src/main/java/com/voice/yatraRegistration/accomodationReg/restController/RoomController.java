package com.voice.yatraRegistration.accomodationReg.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.voice.yatraRegistration.accomodationReg.dao.RoomDao;
import com.voice.yatraRegistration.accomodationReg.model.RoomType;

@RestController
@RequestMapping("/v1/accomodation/rooms/")
@CrossOrigin("*")
public class RoomController {

    @Autowired
    RoomDao roomDao;

    @PostMapping("/fetchAll")
    public List<RoomType> fetchAllRoom(){
        return roomDao.findAll();
    }

    @PostMapping("/saveRoom")
    public RoomType saveRoom(@RequestBody RoomType room){
        System.out.println();
        return roomDao.save(room);
    }

    @DeleteMapping("/deleteAll")
    public void del(){
         roomDao.deleteAll();
    }
}
