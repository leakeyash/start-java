package com.leakeyash.bootmybatis.mapper;

import com.leakeyash.bootmybatis.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> getAll();
    int insert(User user);
}
