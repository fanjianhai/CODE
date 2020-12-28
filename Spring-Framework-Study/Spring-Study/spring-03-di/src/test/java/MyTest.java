import com.xiaofan.pojo.Student;
import com.xiaofan.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Student stu = (Student) context.getBean("student");
        System.out.println(stu);
    }

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("userbeans.xml");
        User user = context.getBean("u", User.class);
        User user1 = context.getBean("u", User.class);
        System.out.println(user == user1);
    }
}
