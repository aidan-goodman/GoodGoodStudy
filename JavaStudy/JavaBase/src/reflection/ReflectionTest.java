package reflection;

import org.testng.annotations.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionTest {
    @Test
    public void test1() throws Exception {
        //1.通过反射创建类的对象
        Class<Person> clazz = Person.class;
        Constructor<Person> constructor = clazz.getConstructor(String.class, int.class);
        Person person = constructor.newInstance("Aidan", 21);
        System.out.println(person);
        //2.通过反射调用对象的属性和方法
        //调用属性
        Field age = clazz.getDeclaredField("age");
        age.set(person, 22);
        System.out.println(person);
        //调用方法
        Method getName = clazz.getDeclaredMethod("getName");
        System.out.println(getName.invoke(person));

        System.out.println("**********************");
        //3.反射可以调取类中私有的结构
        //调用私有构造器
        Constructor<Person> personConstructor = clazz.getDeclaredConstructor
                (String.class, int.class, String.class);
        personConstructor.setAccessible(true);
        Person personPrivate = personConstructor.newInstance
                ("Tom", 20, "American");
        System.out.println(personPrivate);
        //调用私有属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(personPrivate, "Jack");
        System.out.println(personPrivate);
        //调用私有方法
        Method show = clazz.getDeclaredMethod("show");
        show.setAccessible(true);
        System.out.println(show.invoke(personPrivate));

    }
}
