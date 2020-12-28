import com.xiaofan.pojo.Hello;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        // 获取spring上下文
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Hello hello = (Hello) context.getBean("h2");
        hello.show();


    }
}
