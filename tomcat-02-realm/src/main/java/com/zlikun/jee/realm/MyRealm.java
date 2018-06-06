package com.zlikun.jee.realm;

import org.apache.catalina.realm.GenericPrincipal;
import org.apache.catalina.realm.RealmBase;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;

/**
 * 自定义Realm，并对Tomcat进行配置
 * https://tomcat.apache.org/tomcat-9.0-doc/realm-howto.html#Configuring_a_Realm
 * http://wiki.jikexueyuan.com/project/tomcat/realms-aaa.html#configRealm
 *
 * 参考标准实现：https://tomcat.apache.org/tomcat-9.0-doc/realm-howto.html#Standard_Realm_Implementations
 * JDBCRealm - Accesses authentication information stored in a relational database, accessed via a JDBC driver.
 * DataSourceRealm - Accesses authentication information stored in a relational database, accessed via a named JNDI JDBC DataSource.
 * JNDIRealm - Accesses authentication information stored in an LDAP based directory server, accessed via a JNDI provider.
 * UserDatabaseRealm - Accesses authentication information stored in an UserDatabase JNDI resource, which is typically backed by an XML document (conf/tomcat-users.xml).
 * MemoryRealm - Accesses authentication information stored in an in-memory object collection, which is initialized from an XML document (conf/tomcat-users.xml).
 * JAASRealm - Accesses authentication information through the Java Authentication & Authorization Service (JAAS) framework.
 */
public class MyRealm extends RealmBase {

    @Override
    protected String getPassword(String username) {
        // XXX 这里仅作演示，用户名与密码一致即通过认证
        return username;
    }

    @Override
    protected Principal getPrincipal(String username) {
        // XXX 这里仅作演示，用户名与密码一致即通过认证
        return new GenericPrincipal(username,
                getPassword(username),
                getRoles(username));
    }

    protected List<String> getRoles(String username) {
        // TODO 角色查询
        System.out.println(username);
        return null;
    }

}
