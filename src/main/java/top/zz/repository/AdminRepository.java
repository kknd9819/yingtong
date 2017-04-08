package top.zz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.zz.model.Admin;

/**
 * Created by X-man on 2017/4/8.
 */
public interface AdminRepository extends JpaRepository<Admin,Long> {

    Admin findByUsername(String username);
}
