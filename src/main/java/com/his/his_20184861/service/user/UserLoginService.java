package com.his.his_20184861.service.user;

import com.his.his_20184861.mapper.UserMapper;
import com.his.his_20184861.pojo.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLoginService {

@Autowired
    private UserMapper userMapper;
@Autowired
    private User user;

public User VerifyLogin(String ID, String password){
    User user = userMapper.VerifyLogin(ID, password);
    return user;
}
}