package com.example.shiroDemo;

import com.example.annotation.simple.configuration.MyBean;
import com.example.annotation.simple.configuration.SpringConfigurationApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
	public void contextLoads() {

        MyBean myBean = (MyBean)     SpringConfigurationApplication.context.getBean("myBean");
        System.out.println(myBean);
	}

}
