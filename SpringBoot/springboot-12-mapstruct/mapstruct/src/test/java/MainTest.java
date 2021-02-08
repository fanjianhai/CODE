import com.xiaofan.domain.Role;
import com.xiaofan.domain.User;
import com.xiaofan.UserRoleDto;
import com.xiaofan.UserRoleMapper;
import org.junit.Before;
import org.junit.Test;

public class MainTest {
    User user = null;

    /**
     * 模拟从数据库中查出user对象
     */
    @Before
    public void before() {
        Role role  = new Role(2L, "administrator", "超级管理员");
        user  = new User(1L, "zhangsan", "12345", "17677778888", "123@qq.com", role);
    }

    /**
     * 模拟通过MapStruct把user对象转换成UserRoleDto对象
     */
    @Test
    public void test2() {
        UserRoleDto userRoleDto = UserRoleMapper.INSTANCES.toUserRoleDto(user);
        System.out.println(userRoleDto);
    }
}

