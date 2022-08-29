package start.spring.factorybean;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @Describe 切面类，Spring环绕通知
 * @Author wangzejun
 * @Date 2021/4/2 13:28
 */
public class MyAspect implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        // 前置处理
        checkPermissions();

        // 执行目标方法
        Object object = methodInvocation.proceed();

        // 后置处理
        addLog();
        return object;
    }

    public void checkPermissions() {
        System.out.println("***权限校验***");
    }

    public void addLog() {
        System.out.println("***日志增强***");
    }

}
