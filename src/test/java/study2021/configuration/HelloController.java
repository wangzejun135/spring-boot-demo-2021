package study2021.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Describe
 * @Author wangzejun
 * @Date 2021/3/25 14:38
 */
public class HelloController {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @GetMapping("/say")
    public String say() {
        return redisTemplate.opsForValue().get("name");
    }

}
