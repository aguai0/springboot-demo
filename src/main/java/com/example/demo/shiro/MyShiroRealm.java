package com.example.demo.shiro;


import com.example.demo.common.constants.SysConstant;
import com.example.demo.domain.security.UserVO;
import com.example.demo.service.security.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.Set;

public class MyShiroRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;

    /**
     * 权限认证
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        String username = (String)principals.getPrimaryPrincipal();
        Set<String> permissions = userService.findPermissions(username+ SysConstant.emailFix);

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setStringPermissions(permissions);
        return authorizationInfo;
    }

    /*主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
            throws AuthenticationException {

        // 从 token 中获取用户身份信息
        String username = (String)authenticationToken.getPrincipal();  //用户名
        //String password = new String((char[])authenticationToken.getCredentials()); //密码
        //通过username从数据库中查找 User对象，如果找到，没找到.
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        UserVO userInfo = userService.findByEmail(username);
        if(userInfo == null){
            throw new AuthenticationException();
        }
        // 获取盐值，即用户名
        ByteSource salt = ByteSource.Util.bytes(username);
        //注意，数据库中的user的密码必须是要经过md5加密，不然还是会抛出异常！！！！！
        return new SimpleAuthenticationInfo(userInfo.getName(), userInfo.getPassword(), getName());

    }

}