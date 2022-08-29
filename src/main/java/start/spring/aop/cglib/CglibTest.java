package start.spring.aop.cglib;

/**
 * @Describe 测试类
 * @Author wangzejun
 * @Date 2021/4/2 15:05
 */
public class CglibTest {

    public static void main(String[] args) {
        // 创建代理对象
        CglibProxy cglibProxy = new CglibProxy();
        // 创建目标对象
        UserDao userDao = new UserDao();
        // 从代理对象中获取增强后的目标对象
        UserDao userDao2 = (UserDao) cglibProxy.createProxy(userDao);

        // 执行业务方法
        userDao2.addUser();
        userDao2.deleteUser();
    }
}
