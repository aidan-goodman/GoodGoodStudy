package top.aidan.boot.redis;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * Created by Aidan on 2021/10/3 16:28
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

public class JedisTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        /* 有效性测试
        System.out.println(jedis.ping());
        System.out.println(jedis.set("name", "Aidan"));
        jedis.close();
        */

        jedis.flushDB();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Aidan");
        jsonObject.put("age", 21);
        jsonObject.put("address", "aidanblog.top");

        Transaction multi = jedis.multi();
        String jsonString = jsonObject.toJSONString();

        try {
            multi.set("user1", jsonString);
            multi.set("user2", jsonString);
            multi.exec();
        } catch (Exception e) {
            e.printStackTrace();
            multi.discard();
        } finally {
            System.out.println(jedis.get("user1"));
            System.out.println(jedis.get("user2"));
            jedis.close();
        }


    }
}
