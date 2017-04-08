package top.zz.service;

import org.springframework.data.domain.Page;
import top.zz.model.Admin;
import top.zz.util.Pageable;

import java.util.List;

/**
 * Created by X-man on 2017/4/8.
 */
public interface AdminService {



    void update(Admin admin);


    /**
     * 判断用户名是否存在
     * @param username 用户名(忽略大小写)
     * @return 用户名是否存在
     */
    boolean usernameExists(String username);

    /**
     * 根据用户名查找管理员
     * @param username 用户名(忽略大小写)
     * @return 管理员，若不存在则返回null
     */
     Admin findByUsername(String username);

    /**
     * 根据ID查找权限
     * @param id ID
     * @return 权限,若不存在则返回null
     */
     List<String> findAuthorities(Long id);

    /**
     * 判断管理员是否登录
     * @return 管理员是否登录
     */
     boolean isAuthenticated();

    /**
     * 获取当前登录管理员
     * @return 当前登录管理员,若不存在则返回null
     */
     Admin getCurrent();

    /**
     * 获取当前登录用户名
     * @return 当前登录用户名,若不存在则返回null
     */
     String getCurrentUsername();

    /**
     * 获取当前登录门店ID
     * @return 当前登录门店ID,若不存在则返回null
     */
     String getCurrentStoreCode() ;

    /**
     * 查找客服所有人员管理员
     * @return List<Admin>
     */
     List<Admin> findCustomServiceAdmins();

    /**
     * 新增后台管理员
     * @param admin 后台管理员实体
     * @param roleIds 角色主键数组
     * @return Long 保存实体的主键
     */
     Long saveAdmin(Admin admin, Long[] roleIds);

    /**
     * 新增后台管理员
     * @param admin 后台管理员实体
     * @param roleIds 角色主键数组
     */
     void updateAdmin(Admin admin, Long[] roleIds);

    /**
     * 批量删除管理员
     * @param admins
     */
     void batchDelete(List<Admin> admins);

    /**
     * 分页查找所有的后台管理员
     * @param pageable
     * @return Page<Admin>
     */
     Page<Admin> findPage(Pageable pageable);
}
