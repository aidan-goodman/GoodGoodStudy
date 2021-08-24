package generic;

import java.util.*;

public class DAO<T> {
    private Map<String, T> map = new HashMap<>();//集合直接创建，防止空指针异常

    public void save(String id, T entity) {
        map.put(id, entity);
    }

    public T get(String id) {
        return map.get(id);
    }

    public void update(String id, T entity) {
        if (map.containsKey(id)) {//判断当前key是否存在
            map.put(id, entity);
        }
    }

    public List<T> list() {
        List<T> list = new ArrayList<>();
        Collection<T> collection = map.values();//不要直接强转成List
        for (T t :
                collection) {
            list.add(t);
        }
        return list;
    }

    public void delete(String id) {
        map.remove(id);
    }

}
