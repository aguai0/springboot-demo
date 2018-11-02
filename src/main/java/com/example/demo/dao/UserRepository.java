package com.example.demo.dao;

import com.example.demo.common.utils.MD5Util;
import com.example.demo.domain.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UserRepository{
    private static AtomicLong counter = new AtomicLong();

    private static final ConcurrentMap<String, String> userMap = new ConcurrentHashMap<String, String>();

    static {
        User user = new User();
        user.setAge(30);
        user.setName("test");
        user.setPassword(MD5Util.getMD5("1"));
        userMap.put(user.getName(), user.getPassword());
        System.out.println("password=======>"+userMap.get("test"));
    }
    public UserRepository(){

    }

    public User login(User user) {
       /* if(userMap.isEmpty()) {
            new UserRepositoryImpl();
        }*/
        String pwd = this.userMap.get(user.getName());
        System.out.println("pwd=======>"+pwd);
        if(StringUtils.isNotEmpty(pwd) && pwd.equals(user.getPassword())) return user;
        return null;
    }

    public User register(User user) {
        this.userMap.put(user.getName(),MD5Util.getMD5(user.getPassword()));
        return user;
    }

    public User saveOrUpateUser(User user) {
        Long id = user.getId();
        if (id <= 0) {
            id = counter.incrementAndGet();
            user.setId(id);
        }
        this.userMap.put(user.getName(), MD5Util.getMD5(user.getPassword()));
        return user;
    }

    public void deleteUser(Long id) {
        this.userMap.remove(id);
    }

    public User getUserById(Long id) {
        return null/*this.userMap.get(id)*/;
    }

    public List<User> listUser() {
        return null /*new ArrayList<User>(this.userMap.values())*/;
    }

    public ConcurrentMap<String, String> checkUser(String userName) {

        if(userMap.get(userName)!=null)
          return userMap;

        return null;
    }
}