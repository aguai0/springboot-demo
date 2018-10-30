package com.example.demo.repository.impl;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private static AtomicLong counter = new AtomicLong();

    private final ConcurrentMap<String, String> userMap = new ConcurrentHashMap<String, String>();

    public UserRepositoryImpl(){
        User user = new User();
        user.setAge(30);
        user.setName("test");
        user.setPassword("1");
        this.saveOrUpateUser(user);
    }

    @Override
    public User login(User user) {
        if(userMap.isEmpty()) {
            new UserRepositoryImpl();
        }
        String pwd = this.userMap.get(user.getName());
        if(StringUtils.isNotEmpty(pwd) && pwd.equals(user.getPassword())) return user;
        return null;
    }

    @Override
    public User register(User user) {
        this.userMap.put(user.getName(),user.getPassword());
        return user;
    }

    @Override
    public User saveOrUpateUser(User user) {
        Long id = user.getId();
        if (id <= 0) {
            id = counter.incrementAndGet();
            user.setId(id);
        }
        this.userMap.put(user.getName(), user.getPassword());
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        this.userMap.remove(id);
    }

    @Override
    public User getUserById(Long id) {
        return null/*this.userMap.get(id)*/;
    }

    @Override
    public List<User> listUser() {
        return null /*new ArrayList<User>(this.userMap.values())*/;
    }

    @Override
    public boolean checkUser(String userName) {
        String pwd = userMap.get(userName);
        if(pwd!=null)
            return false;
        return true;
    }
}