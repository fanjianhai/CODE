import com.xiaofan.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        UserService userServiceImpl = (UserService) applicationContext.getBean("userServiceImpl");
        userServiceImpl.getUser();
    }
}
