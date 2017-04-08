package top.zz.service;

import org.springframework.data.domain.Page;
import top.zz.model.Role;
import top.zz.util.Pageable;

import java.util.List;
import java.util.Set;

/**
 * Created by X-man on 2017/4/8.
 */
public interface RoleService {

    /**
     * 新增角色
     * @param role 角色
     * @param authorities 权限值数组
     * @return Long 保存实体的主键
     */
     Long saveRole(Role role, String authorities);

    /**
     * 新增角色
     * @param role 角色
     * @param authorities 权限值数组
     */
     void updateRole(Role role, String authorities);

    /**
     * 批量删除角色
     * @param roles
     */
     void batchDelete(List<Role> roles);

    /**
     * 分页查找所有的角色
     * @param pageable
     * @return Page<Role>
     */
    Page<Role> findPage(Pageable pageable);

    /**
     * 根据管理员ID查询管理员的角色ID
     * @param adminId
     * @return Set<Long>
     */
    Set<Long> getRoleIdsByAdminId(Long adminId);

     List<Role> findRoleByAdminId(Long id);
}
