package top.zz.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import top.zz.model.Role;

import java.util.List;

/**
 * Created by X-man on 2017/3/30.
 */
public interface RoleRepository extends JpaRepository<Role,Long> {

    @Query("from Role where ?1 = ?2")
    Page<Role> findByMap(String key,Object value, Pageable pageable);

    @Query("from Role where admins.id = ?1")
    List<Role> findRoleByAdminId(Long adminId);
}
