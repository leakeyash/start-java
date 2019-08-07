package com.leakeyash.bootmybatis.service;

import com.leakeyash.bootmybatis.mapper.UserMapper;
import com.leakeyash.bootmybatis.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public List<User> getUsers(){
        return userMapper.getAll();
    }

    public Integer createUser(User user){
        return userMapper.insert(user);
    }
}
