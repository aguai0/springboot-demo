package com.example.demo.service.security;

import com.alibaba.fastjson.JSON;
import com.example.demo.BaseTest;
import com.example.demo.domain.security.UserVO;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.List;

public class UserServiceTest extends BaseTest {

    /** 日志记录器 */
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceTest.class);

    @Resource
    private UserService userService;

    @Test
    public void count(){
        Integer count = userService.count(new UserVO());
        LOGGER.info("count:"+count);
    }

    @Test
    public void findList(){
        List<UserVO> list = userService.findList(new UserVO());
        LOGGER.info(JSON.toJSONString(list));
    }

    @Test
    public void insert(){
        UserVO userVO = new UserVO();
        userVO.setUserName("test");
        userVO.setPassword("1");
        userVO.setRoleId(1);
        userVO.setStatus(1);
        userVO.setMobile("13512211121");
        userVO.setEmail("test@121.com");
        userVO.setNickName("haha");
        userService.save(userVO);
    }

    @Test
    public void update(){
        UserVO userVO = new UserVO();
        userVO.setId(10008L);
        userVO.setPassword("123456");
        userService.update(userVO);
    }
}