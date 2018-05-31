package com.example.demo.controll;

import com.example.demo.base.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 * All Rights Reserved.
 *
 */
@RestController
@RequestMapping("/demoController")
public class DemoController {

    /*@Autowired
    private DemoConfig demoConfig;*/

    @RequestMapping("/test")
    public Result<Object> firstTest() {
        Result result = new Result<Object>();
        result.setData("demooooooooooo...");
        result.setMessage("测试成功");
        result.setCode(200);
        return result;
    }
}