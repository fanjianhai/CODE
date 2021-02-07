package com.xiaofan;

import com.xiaofan.domain.Users;
import com.xiaofan.repository.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class Springboot05DataJpaApplicationTests {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    UsersRepositoryByName usersRepositoryByName;

    @Autowired
    UsersRepositoryQueryAnnotation usersRepositoryQueryAnnotation;

    @Autowired
    UsersRepositoryCrudRepository usersRepositoryCrudRepository;

    @Autowired
    UsersRepositoryPagingAndSorting usersRepositoryPagingAndSorting;

    @Test
    void testSave() {
        Users users = new Users();
        users.setAddress("北京市");
        users.setAge(18);
        users.setName("小范");
        usersRepository.save(users);
    }
    //================================================================

    /**
     * Repository
     */
    @Test
    public void UsersRepositoryByName(){
        List<Users> list=usersRepositoryByName.findByName("小范");
        for (Users users:list){
            System.out.println(users);
        }
    }

    @Test
    public void findByNameAndAge(){
        List<Users> list=usersRepositoryByName.findByNameAndAge("小范",18);
        for (Users users:list){
            System.out.println(users);
        }
    }

    @Test
    public void findByNameLike() {
        List<Users> list = usersRepositoryByName.findByNameLike("小%");
        for (Users users : list) {
            System.out.println(users);
        }
    }
    //================================================================

    /**
     * Repository--@Query测试
     */
    @Test
    public void testQueryByNameUseSQL() {
        List<Users> list = usersRepositoryQueryAnnotation.queryByNameUseSQL("小范");
        for (Users users : list) {
            System.out.println(users);
        }
    }

    /**
     * Repository--@Query测试
     */
    @Test
    @Transactional //@Transactional与@Test 一起使用时 事务是自动回滚的。
    @Rollback(false) //取消自动回滚
    public void testUpdateUsersNameById() {
        usersRepositoryQueryAnnotation.updateUsersNameById("小范", 1);
    }
    //================================================================

    @Test
    public void testCrudRepositorySave() {
        Users users=new Users();
        users.setName("青衫");
        users.setAge(30);
        users.setAddress("湖南怀化");
        this.usersRepositoryCrudRepository.save(users);
    }

    @Test
    public void testCrudRepositoryUpdate() {
        Users users=new Users();
        users.setId(4);
        users.setName("青");
        users.setAge(18);
        users.setAddress("怀化");
        this.usersRepositoryCrudRepository.save(users);
    }

    @Test
    public void testCrudRepositoryFindOne() {
        Optional<Users> optional = usersRepositoryCrudRepository.findById(4);
        System.out.println(optional.get());
    }

    @Test
    public void testCrudRepositoryFindAll() {
        List<Users> list= (List<Users>) this.usersRepositoryCrudRepository.findAll();
        for (Users user:list){
            System.out.println(user);
        }
    }

    @Test
    public void testCrudRepositoryDeleteById() {
        this.usersRepositoryCrudRepository.deleteById(4);

    }
    //================================================================
    @Test
    public void testPagingAndSortingRepositorySort() {
        //Order	定义了排序规则
        Sort.Order order=new Sort.Order(Sort.Direction.DESC,"id");
        //Sort对象封装了排序规则
        Sort sort=Sort.by(order);
        List<Users> list= (List<Users>) this.usersRepositoryPagingAndSorting.findAll(sort);
        for (Users users:list){
            System.out.println(users);
        }
    }

    @Test
    public void testPagingAndSortingRepositoryPaging() {
        //Pageable:封装了分页的参数，当前页，煤业显示的条数。注意：它的当前页是从0开始
        //PageRequest(page,size):page表示当前页，size表示每页显示多少条
        Pageable pageable=PageRequest.of(1,2);
        Page<Users> page=this.usersRepositoryPagingAndSorting.findAll(pageable);
        System.out.println("数据的总条数："+page.getTotalElements());
        System.out.println("总页数："+page.getTotalPages());
        List<Users> list=page.getContent();
        for (Users users:list){
            System.out.println(users);
        }
    }

    @Test
    public void testPagingAndSortingRepositorySortAndPaging() {
        Sort sort=Sort.by(new Sort.Order(Sort.Direction.DESC,"id"));
        Pageable pageable=PageRequest.of(0,2,sort);
        Page<Users> page=this.usersRepositoryPagingAndSorting.findAll(pageable);
        System.out.println("数据的总条数："+page.getTotalElements());
        System.out.println("总页数："+page.getTotalPages());
        List<Users> list=page.getContent();
        for (Users users:list){
            System.out.println(users);
        }
    }
    //================================================================

}
