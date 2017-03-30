package top.zz.config.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import top.zz.model.Permission;
import top.zz.model.Role;
import top.zz.model.User;
import top.zz.service.UserService;

import javax.annotation.Resource;

/**
 * Created by X-man on 2017/3/30.
 */
public class MyShiroRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;

    /**
     * 认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        //获取用户的输入的账号.
        UsernamePasswordToken upt = (UsernamePasswordToken) token.getPrincipal();
        String username = upt.getUsername();
        String password = new String(upt.getPassword());
        System.out.println(token.getCredentials());
        User user = userService.findByUsername(username);
        if(user == null){
            throw new UnknownAccountException();
        }
        if(user.getLocked() == true){
            throw new LockedAccountException();
        }
//        if(StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)){
//            if(!DigestUtils.md5Hex(password).equals(user.getPassword())){
//                throw new IncorrectCredentialsException();
//            }
//        }

        SimpleAuthenticationInfo simpleAuthenticationInfo =
                new SimpleAuthenticationInfo(user,user.getPassword(), ByteSource.Util.bytes(user.getCredentialsSalt()),getName());
        return simpleAuthenticationInfo;
    }


    /**
     * 授权
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        User user = (User) principals.getPrimaryPrincipal();
        for(Role role:user.getRoleList()){
            authorizationInfo.addRole(role.getRole());
            for(Permission permission:role.getPermissions()){
                authorizationInfo.addStringPermission(permission.getPermission());
            }
        }
        return authorizationInfo;
    }


}
