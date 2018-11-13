package com.example.demo.shiro;


public class MyShiroRealm /*extends AuthorizingRealm */{

/*    @Resource
    UserService userService;

    *//**
     * 权限认证
     * @param principals
     * @return
     *//*
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        String username = (String)principals.getPrimaryPrincipal();
        Set<String> permissions = userService.findPermissions(username);

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setStringPermissions(permissions);
        return authorizationInfo;
    }

    *//*主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。*//*
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
            throws AuthenticationException {

        // 从 token 中获取用户身份信息
        String username = (String)authenticationToken.getPrincipal();  //用户名
        //String password = new String((char[])authenticationToken.getCredentials()); //密码
        //通过username从数据库中查找 User对象，如果找到，没找到.
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        UserVO user = userService.findByUserName(username);
        if(user == null){
            throw new AuthenticationException();
        }
        // 获取盐值，即用户名
        ByteSource salt = ByteSource.Util.bytes(username);
        //注意，数据库中的user的密码必须是要经过md5加密，不然还是会抛出异常！！！！！
        return new SimpleAuthenticationInfo(user.getUserName(), user.getPassword(), getName());

    }*/

}