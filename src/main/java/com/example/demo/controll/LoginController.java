package com.example.demo.controll;

import com.example.demo.base.Result;
import com.example.demo.domain.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.ConcurrentMap;

@Controller
public class LoginController {
    /** 日志记录器 */
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    UserRepository userRepository;

    @RequestMapping({"/","/login"})
    public String index(){
        return"/login";
    }

    @RequestMapping("/login.do_")
    @ResponseBody
    public Result doLogin(User user){
        UsernamePasswordToken token = new UsernamePasswordToken(user.getName(), user.getPassword());

        Subject subject = SecurityUtils.getSubject();

        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            LOGGER.error(e.getMessage(),e);
            return Result.fail(403,"用户名或密码错误");
        }

        return Result.succeed();
    }

    @RequestMapping("/checkUser")
    @ResponseBody
    public Result checkUser(String user){
        ConcurrentMap<String, String> map = userRepository.checkUser(user);
        if(map!=null){
            return Result.succeed();
        }else {
            return Result.fail();
        }
    }

    @RequestMapping("/logout.do_")
    @ResponseBody
    public Result doLogout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return Result.succeed();
    }

}