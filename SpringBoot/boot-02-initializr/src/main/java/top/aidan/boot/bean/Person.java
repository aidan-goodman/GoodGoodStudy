package top.aidan.boot.bean;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Aidan on 2021/9/18 16:57
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

@Component
@ConfigurationProperties(prefix = "person")
@Data
@ToString
public class Person {
   private String userName;
   private Boolean boss;
   private Date birth;
   private Integer age;
   private Pet pet;
   private String[] interests;
   private List<String> animal;
   private Map<String, Object> score;
   private Set<Double> salarys;
   private Map<String, List<Pet>> allPets;
}

