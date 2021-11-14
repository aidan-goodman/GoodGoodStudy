package beiye;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aidan on 2021/10/26 14:36
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

public class LRUCache {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(5);
        cache.set(1, 101);
        cache.set(2, 102);
        cache.set(3, 103);
        int i = cache.get(1);
        System.out.println(i);
        // 可以使用 debug 查看内部的优先级变化
    }

    // 结点结构
    class DLinkedNode {
        int key;    // 此处的 key 方便在链表和 Map 同时移除
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }

    Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;   // 当前存储大小
    private final int k;   // 指定容量
    private DLinkedNode head, tail;     // 方便对真正的头尾操作

    // 默认构造器
    public LRUCache(int k) {
        this.size = 0;
        this.k = k;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public void set(int key, int value) {
        DLinkedNode node = cache.get(key);
        // 先判断是否存在，存在更改值，不存在放入
        if (node == null) {
            DLinkedNode newNode = new DLinkedNode(key, value);

            cache.put(key, newNode);
            // 放入后置于链表头
            addHead(newNode);
            ++size;
            // 超过最大容量直接拿掉链尾的值（最近最少被使用）
            if (size > k) {
                DLinkedNode reTail = removeTail();
                cache.remove(reTail.key);
                --size;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 先将被使用到的放入头节点
        moveToHead(node);
        return node.value;
    }

    private void addHead(DLinkedNode node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    private void removeNode(DLinkedNode node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addHead(node);
    }

    private DLinkedNode removeTail() {
        DLinkedNode result = tail.prev;
        removeNode(result);
        return result;
    }
}
