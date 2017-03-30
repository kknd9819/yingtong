package top.zz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.zz.model.Permission;

/**
 * Created by X-man on 2017/3/30.
 */
public interface PermissionRepository extends JpaRepository<Permission,Long> {


}
