package start.configuration;

import start.util.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Describe
 * @Author wangzejun
 * @Date 2021/3/25 14:38
 */
@RestController()
@RequestMapping("/api")
public class HelloController {

    // 自动装配
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @GetMapping("/say")
    public String say() {
        String str = redisTemplate.opsForValue().get("mykey");
        if (StrUtil.isEmpty(str)) {
            str = "我是空值";
            redisTemplate.opsForValue().set("mykey", "我是无效缓存");
        }
        return str;
    }
    
}
