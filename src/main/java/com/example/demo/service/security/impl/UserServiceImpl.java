package com.example.demo.service.security.impl;

import com.example.demo.common.enums.StatusEnum;
import com.example.demo.dao.security.UserDAO;
import com.example.demo.domain.security.UserVO;
import com.example.demo.service.security.UserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    public Integer count(UserVO collect) {
        int count = userDAO.count(collect);
        return count;
    }

    @Override
    public List<UserVO> findList(UserVO userVO) {
        List<UserVO> list = userDAO.findList(userVO);
        return list;
    }

    @Override
    public void update(UserVO userVO) {
        userDAO.update(userVO);
    }

    @Override
    public void save(UserVO userVO) {
        userVO.setStatus(StatusEnum.valid.getCode());
        userVO.setCreateName((String) SecurityUtils.getSubject().getPrincipal());
        userVO.setModifyName((String) SecurityUtils.getSubject().getPrincipal());
        userDAO.insert(userVO);
    }

    @Override
    public UserVO queryById(Long id) {
        UserVO userVO = new UserVO();
        userVO.setId(id);
        return userDAO.queryUser(userVO);
    }

    @Override
    public UserVO findByName(String userName) {
        UserVO userVO = new UserVO();
        userVO.setUserName(userName);
        return userDAO.queryUser(userVO);
    }

    @Override
    public void deleteById(Long id) {
        userDAO.deleteById(id);
    }
}