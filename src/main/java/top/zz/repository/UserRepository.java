package top.zz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.zz.model.User;

/**
 * Created by X-man on 2017/3/30.
 */
public interface UserRepository extends JpaRepository<User,Long> {

     User findByUsername(String username);
}
