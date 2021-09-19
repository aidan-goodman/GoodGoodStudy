package top.aidan.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by Aidan on 2021/9/18 16:58
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Pet {
   private String name;
   private Double weight;

}
