package top.zz.service;

import top.zz.model.User;

/**
 * Created by X-man on 2017/3/30.
 */
public interface UserService {

   User findByUsername(String username);
}
