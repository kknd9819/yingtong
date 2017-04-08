package top.zz.config.shiro;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import top.zz.model.Admin;
import top.zz.model.Authority;
import top.zz.model.Role;
import top.zz.model.vo.Principal;
import top.zz.service.AdminService;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 权限认证
 * @Date 2014-12-31
 * @author 欧志辉
 * @version 1.0
 */
public class AuthenticationRealm extends AuthorizingRealm {

	
	@Resource(name = "adminServiceImpl")
	private AdminService adminService;

	/**
	 * 获取认证信息
	 * 
	 * @param token
	 *            令牌
	 * @return 认证信息
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken token) {
		
		/****************************
		 * 安全认证框架	Shiro1.2
		 * UsernamePasswordToken 支持最常见的 用户名/密码 的认证机制 org.apache.shiro.authc.UsernamePasswordToken
		 * 由于它实现了RememberMeAuthenticationToken接口，我们可以通过令牌设置“记住我”的功能 ，“已记住”和“已认证”是有区别的：
		 * 已记住的用户仅仅是非匿名用户，你可以通过subject.getPrincipals()获取用户信息。但是它并非是完全认证通过的用户，
		 * 当你访问需要认证用户的功能时，你仍然需要重新提交认证信息。 
		 * 
		 * AuthenticationToken : 重写加入 验证码 。
		 * **/
		AuthenticationToken authenticationToken = (AuthenticationToken) token;
		
		String username = authenticationToken.getUsername();
		String password = new String(authenticationToken.getPassword());
		String ip = authenticationToken.getHost();

		
		
		if (username != null && password != null) {
			Admin admin = adminService.findByUsername(username);
			if (admin == null) {
				throw new UnknownAccountException();
			}
			if (!admin.getEnabled()) {
				throw new DisabledAccountException();
			}
			if (admin.getLocked()) {
				int loginFailureLockTime = 10;
				if (loginFailureLockTime == 0) {
					throw new LockedAccountException();
				}
				Date lockedDate = admin.getLockedDate();
				Date unlockDate = DateUtils.addMinutes(lockedDate, loginFailureLockTime);
				if (new Date().after(unlockDate)) {
					admin.setLoginFailureCount(0);
					admin.setLocked(false);
					admin.setLockedDate(null);
					adminService.update(admin);
				} else {
					throw new LockedAccountException();
				}
			}
			if (!DigestUtils.md5Hex(password).equals(admin.getPassword())) {
				int loginFailureCount = admin.getLoginFailureCount() + 1;
				if (loginFailureCount >= 5) {
					admin.setLocked(true);
					admin.setLockedDate(new Date());
				}
				admin.setLoginFailureCount(loginFailureCount);
				adminService.update(admin);
				throw new IncorrectCredentialsException();
			}
			admin.setLoginIp(ip);
			admin.setLoginDate(new Date());
			admin.setLoginFailureCount(0);
			adminService.update(admin);
			return new SimpleAuthenticationInfo(new Principal(admin.getId(), username, admin.getName()), password, getName());
		}
		throw new UnknownAccountException();
	}

	/**
	 * 获取授权信息
	 * @param principals principals
	 * @return AuthorizationInfo 授权信息
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		Admin admin = (Admin) principals.getPrimaryPrincipal();
		for(Role role :admin.getRoles()){
			authorizationInfo.addRole(role.getName());
			for(Authority authority: role.getAuthorities()){
				authorizationInfo.addStringPermission(authority.getName());
			}
		}
		return authorizationInfo;
	}

}