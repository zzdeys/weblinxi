package com.linxi.service;

import com.linxi.po.User;

/**
 * @author linxi
 * @function
 * @project linxiblog
 * @package com.linxi.service
 * @date 2020/4/29-3:13 下午
 */
public interface UserService {

    User checkUser(String username, String password);
}
