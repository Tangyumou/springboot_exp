package cn.tqw.twodatabase.controller;

import cn.tqw.twodatabase.mapper.FilePathMapper;
import cn.tqw.twodatabase.mappers.UserMapper;
import cn.tqw.twodatabase.pojo.FilePath;
import cn.tqw.twodatabase.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @Autowired
    private FilePathMapper filePathMapper;
    @Autowired
    private UserMapper userMapper;
    @RequestMapping("/getUser")
    @ResponseBody
    public User findUser(){
        User user = new User();
        user.setUserEmail("123");
        user.setUserPassword("123");
        return userMapper.findUser(user);
    }
    @ResponseBody
    @RequestMapping(value = "/getFilePath")

    public FilePath getFilepathByID(){
       return filePathMapper.findFilePathByID("104A794B");
    }
}
