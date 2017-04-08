package top.zz.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import top.zz.model.Admin;
import top.zz.repository.AdminRepository;
import top.zz.service.AdminService;

import javax.annotation.Resource;

/**
 * Created by X-man on 2017/4/8.
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminRepository adminRepository;

    @Override
    public Admin findByUsername(String username) {
        return adminRepository.findByUsername(username);
    }

    @Override
    public void update(Admin admin) {
        Assert.notNull(admin,"admin不能为null");
        adminRepository.saveAndFlush(admin);
    }
}
