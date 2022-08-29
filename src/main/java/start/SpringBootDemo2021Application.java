package start;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@MapperScan("start.mapper")
@SpringBootApplication
public class SpringBootDemo2021Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemo2021Application.class, args);
    }

}
