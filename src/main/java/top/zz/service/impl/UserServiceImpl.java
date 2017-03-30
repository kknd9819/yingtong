package top.zz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import top.zz.model.User;
import top.zz.repository.UserRepository;
import top.zz.service.UserService;

/**
 * Created by X-man on 2017/3/30.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void update(User user) {
        Assert.notNull(user,"user不能为null");
        userRepository.saveAndFlush(user);
    }
}
