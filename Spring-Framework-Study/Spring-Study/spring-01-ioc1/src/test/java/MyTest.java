import com.xiaofan.dao.UserDaoImpl;
import com.xiaofan.dao.UserMysqlImpl;
import com.xiaofan.service.UserServiceImpl;

public class MyTest {
    public static void main(String[] args) {

        UserServiceImpl service = new UserServiceImpl();
        // 通过set方法进行动态值的注入！
        service.setDao(new UserMysqlImpl());
        service.getUser();
    }
}
