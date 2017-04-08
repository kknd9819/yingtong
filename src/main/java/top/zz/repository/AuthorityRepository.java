package top.zz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.zz.model.Authority;

/**
 * Created by X-man on 2017/4/8.
 */
public interface AuthorityRepository extends JpaRepository<Authority,Long> {

    Authority findByName(String name);
}
