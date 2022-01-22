package top.aidan.ioc.model;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Aidan on 2021/8/15 11:12
 *
 * @GitHub github.com/huaxin0304
 * @Blog aidanblog.top
 */
public class User {
    private String username;
    private String address;
    private Integer id;
    private Cat cat;
    private Cat[] cats;
    private List<String> favorites;
    private Map<String,Object> details;
    private Properties info;


    public User() {
        System.out.println("------init------");
    }

    public User(String username, String address, Integer id) {
        this.username = username;
        this.address = address;
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public Cat[] getCats() {
        return cats;
    }

    public void setCats(Cat[] cats) {
        this.cats = cats;
    }

    public List<String> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<String> favorites) {
        this.favorites = favorites;
    }

    public Map<String, Object> getDetails() {
        return details;
    }

    public void setDetails(Map<String, Object> details) {
        this.details = details;
    }

    public Properties getInfo() {
        return info;
    }

    public void setInfo(Properties info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", address='" + address + '\'' +
                ", id=" + id +
                ", cat=" + cat +
                ", cats=" + Arrays.toString(cats) +
                ", favorites=" + favorites +
                ", details=" + details +
                ", info=" + info +
                '}';
    }
}
