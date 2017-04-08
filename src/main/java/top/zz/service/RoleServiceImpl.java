package top.zz.service;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import top.zz.model.Authority;
import top.zz.model.Role;
import top.zz.repository.AuthorityRepository;
import top.zz.repository.RoleRepository;
import top.zz.util.Pageable;
import top.zz.util.StringUtil;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by X-man on 2017/4/8.
 */
@Service
public class RoleServiceImpl implements RoleService{

    @Resource
    private RoleRepository roleRepository;

    @Resource
    private AuthorityRepository authorityRepository;

    @Override
    @Transactional
    public Long saveRole(Role role, String authorities) {
        role.setCreateDate(new Date());
        role.setModifyDate(new Date());
        List<Authority> authorityList = new ArrayList<Authority>();
        String[] arrayAuthority = authorities.split(",");
        for(String authority:arrayAuthority){
            if(!StringUtil.isEmpty(authority)){
                Authority a = new Authority();
                a.setName(authority);
                authorityRepository.save(a);
                authorityList.add(a);
            }
        }
        if(CollectionUtils.isNotEmpty(authorityList)){
            role.setAuthorities(authorityList);
        }
        Role save = roleRepository.save(role);
        return save.getId();
    }

    @Override
    @Transactional
    public void updateRole(Role role, String authorities) {
        role.setModifyDate(new Date());
        Role save = roleRepository.save(role);
        List<Authority> authorities1 = save.getAuthorities();
        authorityRepository.delete(authorities1);
        List<Authority> authorityList = new ArrayList<Authority>();
        String[] arrayAuthority = authorities.split(",");
        for (String authority : arrayAuthority) {
            if (!StringUtil.isEmpty(authority)) {
                Authority a = authorityRepository.findByName(authority);
                if( null != a){
                    authorityList.add(a);
                } else {
                    Authority b = new Authority();
                    b.setName(authority);
                    authorityRepository.save(b);
                    authorityList.add(b);
                }
            }
        }

        if(CollectionUtils.isNotEmpty(authorityList)){
            role.setAuthorities(authorityList);
        }
        roleRepository.save(role);
    }

    @Override
    public void batchDelete(List<Role> roles) {

    }

    @Override
    public Page<Role> findPage(Pageable pageable) {
        return null;
    }

    @Override
    public Set<Long> getRoleIdsByAdminId(Long adminId) {
        return null;
    }

    @Override
    public List<Role> findRoleByAdminId(Long id) {
        return null;
    }
}
