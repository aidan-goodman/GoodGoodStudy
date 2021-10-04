package top.aidan.boot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import top.aidan.boot.utils.RedisUtil;

import java.util.Objects;

@SpringBootTest
class Boot05DatabaseApplicationTests {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private RedisUtil redisUtil;

    @Test
    void Test1() {
        RedisConnection connection = Objects.requireNonNull(redisTemplate.getConnectionFactory()).getConnection();
        connection.flushDb();
        redisTemplate.opsForValue().set("name", "Aidan");

        System.out.println(redisTemplate.opsForValue().get("name"));

        redisTemplate.opsForSet().add("set", 123, 456, 345, 678);
        System.out.println(redisTemplate.opsForSet().randomMembers("set", 4));
        connection.close();
    }

    @Test
    void Test2() {
        System.out.println(redisUtil.get("name"));
    }

    @Test
    void contextLoads() {
    }

}
