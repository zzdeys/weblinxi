package com.linxi.dao;

import com.linxi.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author linxi
 * @function
 * @project linxiblog
 * @package com.linxi.dao
 * @date 2020/4/29-3:16 下午
 */
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsernameAndPassword(String username, String password);
}
