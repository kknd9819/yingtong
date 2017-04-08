package top.zz.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import top.zz.model.Admin;
import top.zz.model.Authority;
import top.zz.repository.AdminRepository;
import top.zz.repository.AuthorityRepository;
import top.zz.service.AdminService;
import top.zz.util.Pageable;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by X-man on 2017/4/8.
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminRepository adminRepository;

    @Resource
    private AuthorityRepository authorityRepository;

    @Override
    public Admin findByUsername(String username) {
        return adminRepository.findByUsername(username);
    }

    @Override
    public List<String> findAuthorities(Long id) {
        adminRepository.findBy
    }

    @Override
    public boolean isAuthenticated() {
        return false;
    }

    @Override
    public Admin getCurrent() {
        return null;
    }

    @Override
    public String getCurrentUsername() {
        return null;
    }

    @Override
    public String getCurrentStoreCode() {
        return null;
    }

    @Override
    public List<Admin> findCustomServiceAdmins() {
        return null;
    }

    @Override
    public Long saveAdmin(Admin admin, Long[] roleIds) {
        return null;
    }

    @Override
    public void updateAdmin(Admin admin, Long[] roleIds) {

    }

    @Override
    public void batchDelete(List<Admin> admins) {

    }

    @Override
    public Page<Admin> findPage(Pageable pageable) {
        return null;
    }

    @Override
    public void update(Admin admin) {
        Assert.notNull(admin,"admin不能为null");
        adminRepository.saveAndFlush(admin);
    }

    @Override
    public boolean usernameExists(String username) {
        return false;
    }
}
