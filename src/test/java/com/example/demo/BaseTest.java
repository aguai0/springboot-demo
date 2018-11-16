package com.example.demo;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class BaseTest {
    /** 日志记录器 */
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseTest.class);
    @Before
    public void init(){
        LOGGER.info("测试开始..........");
    }

    @After
    public void after(){
        LOGGER.info("测试结束.......");
    }
}