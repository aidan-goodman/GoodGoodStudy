package cn.itcast.order.service;

import cn.itcast.feign.clients.UserClient;
import cn.itcast.feign.pojo.User;
import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.pojo.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderMapper orderMapper;
    // private final RestTemplate restTemplate;
    private final UserClient userClient;

    public OrderService(OrderMapper orderMapper, UserClient userClient) {
        this.orderMapper = orderMapper;
        this.userClient = userClient;
    }

    /* RestTemplate 实现远程调用
    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);

        // 2.使用 RestTemplate 发起 HTTP 请求获取 user
        String url = "http://userservice/user/" + order.getUserId();
        User user = restTemplate.getForObject(url, User.class);

        // 3.封装 user 对象
        order.setUser(user);

        // 4.返回
        return order;
    }
    */

    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);

        // 2.使用 Feign 实现远程调用
        User user = userClient.findById(order.getUserId());

        // 3.封装 user 对象
        order.setUser(user);

        // 4.返回
        return order;
    }
}
