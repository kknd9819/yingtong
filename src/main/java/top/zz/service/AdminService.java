package top.zz.service;

import top.zz.model.Admin;

/**
 * Created by X-man on 2017/4/8.
 */
public interface AdminService {

    Admin findByUsername(String username);;

    void update(Admin admin);

}
