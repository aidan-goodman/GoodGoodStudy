package exception;

public class ThrowTest {
    public static void main(String[] args) {
        try {
            Student student = new Student(1001);
            //如果构造器中不进行自定义异常，此处报错之后仍会运行下一语句，将id以默认值0输出
            System.out.println(student.toString());
        } catch (Exception e) {//捕获自定义的异常
            System.out.println(e.getMessage());
        }
    }
}

class Student {
    private final int id;

    public Student(int id) throws Exception {//常规抛出，在main方法解决
        if (id > 0) {
            this.id = id;
        } else {
            throw new Exception("输入数据非法");//自定义一个异常
        }

    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                '}';
    }
}