package start.spring.aop.cglib;

/**
 * @Describe 接口
 * @Author wangzejun
 * @Date 2021/4/2 13:24
 */
public class UserDao {

    public void addUser() {
        System.out.println("添加用户");
    }

    public void deleteUser() {
        System.out.println("删除用户");
    }

}
