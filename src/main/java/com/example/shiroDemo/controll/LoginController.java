package com.example.shiroDemo.controll;

import com.example.shiroDemo.base.Result;
import com.example.shiroDemo.domain.security.vo.UserVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
    /** 日志记录器 */
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping({"/","/login"})
    public String index(){
        return"/login";
    }

    @RequestMapping("/auth")
    @ResponseBody
    public Result doLogin(UserVO user){
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPassword());

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
      /*  ConcurrentMap<String, String> map = userRepository.checkUser(user);
        if(map!=null){
            return Result.succeed();
        }else {
            return Result.fail();
        }*/
        return Result.succeed();
    }

    @RequestMapping("/logout.do_")
    @ResponseBody
    public Result doLogout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return Result.succeed();
    }

}