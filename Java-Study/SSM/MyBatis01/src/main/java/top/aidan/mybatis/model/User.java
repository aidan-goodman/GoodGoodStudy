package top.aidan.mybatis.model;

/**
 * Created by Aidan on 2021/8/23 9:31
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

public class User {
    private long id;
    private String username;
    private String address;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
