package com.linxi.service;

import com.linxi.dao.UserRepository;
import com.linxi.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author linxi
 * @function
 * @project linxiblog
 * @package com.linxi.service
 * @date 2020/4/29-3:14 下午
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User checkUser(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, password);
        return user;
    }
}
