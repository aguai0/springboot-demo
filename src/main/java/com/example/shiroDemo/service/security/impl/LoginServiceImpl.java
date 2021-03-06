package com.example.shiroDemo.service.security.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.shiroDemo.common.constants.SysConstant;
import com.example.shiroDemo.dao.security.LoginDao;
import com.example.shiroDemo.domain.security.po.UserPermissionPO;
import com.example.shiroDemo.domain.security.vo.UserVO;
import com.example.shiroDemo.service.security.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@MapperScan(basePackages = {"com.example.shiroDemo.dao.security"})
public class LoginServiceImpl implements LoginService {
    private Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    private LoginDao loginDao;

    /**
     * 登录表单提交
     *
     * @param userVO
     * @return
     */
    @Override
    public UserVO authLogin(UserVO userVO) {
        String username = userVO.getUserName();
        String password = userVO.getPassword();

        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            currentUser.login(token);
        } catch (AuthenticationException e) {
            return null;
        }
        return userVO;
    }

    /**
     * 根据用户名和密码查询对应的用户
     *
     * @param userName 用户名
     * @param password 密码
     * @return
     */
    @Override
    public UserVO getUser(String userName, String password) {
        logger.info("验证用户和密码");
        return loginDao.getUser(userName, password);
    }

    /**
     * 查询当前登录用户的权限等信息
     *
     * @return
     */
    @Override
    public UserPermissionPO getInfo() {
        //从session获取用户信息
        Session session = SecurityUtils.getSubject().getSession();
        JSONObject userInfo = (JSONObject) session.getAttribute(SysConstant.SESSION_USER_INFO);
        String username = userInfo.getString("username");
        JSONObject returnData = new JSONObject();
        UserPermissionPO userPermission = null/*permissionService.getUserPermission(username)*/;
        session.setAttribute(SysConstant.SESSION_USER_PERMISSION, userPermission);
        returnData.put("userPermission", userPermission);
        return userPermission;
    }

    /**
     * 退出登录
     *
     * @return
     */
    @Override
    public Boolean logout() {
        try {
            Subject currentUser = SecurityUtils.getSubject();
            currentUser.logout();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
