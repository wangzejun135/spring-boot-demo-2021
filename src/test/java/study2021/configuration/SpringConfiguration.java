package study2021.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @Describe
 * @Author wangzejun
 * @Date 2021/3/25 14:16
 */
@Configuration
public class SpringConfiguration {

    @Conditional(GpCondition.class)
    @Bean
    public DemoService demoService() {
        return new DemoService();
    }

}
