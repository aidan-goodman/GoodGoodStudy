package top.aidan.mybatis.model;

/**
 * Created by Aidan on 2021/8/18 16:07
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

public class Role {

   private Integer id;
   private String name;

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   @Override
   public String toString() {
      return "Role{" +
              "id=" + id +
              ", name='" + name + '\'' +
              '}';
   }
}
