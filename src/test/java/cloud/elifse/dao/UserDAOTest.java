package cloud.elifse.dao;

import cloud.elifse.pojo.User;
import cloud.elifse.utils.MyBatisUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.junit.Test;

import java.sql.Time;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * @author Elifse
 * @Description Test
 * @Create 2022/9/6
 **/
public class UserDAOTest {

    @Test
    public void insertUser() {
//         涉及到数据库数据的改动（插入，更改，删除）需要得到SqlSession和提交事务
//         当获取SqlSession对象的时候，默认开启了事务。
            UserDAO userDAO = MyBatisUtil.getMapper(UserDAO.class);
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入用户编号：");
            String userNum = scanner.next();
            System.out.println("请输入用户姓名：");
            String userName = scanner.next();
            System.out.println("请输入用户性别：");
            String userGender = scanner.next();

            User user = new User(0, userNum, userName, userGender,0);
            int result = userDAO.insertUser(user);
            System.out.println(result);
    }

    @org.junit.Test
    public void deleteUser() {
        UserDAO userDAO = MyBatisUtil.getMapper(UserDAO.class);
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要删除的用户编号：");
        String userNum = scanner.nextLine();
        int result = userDAO.deleteUser(userNum);
        System.out.println(result);
    }

    @org.junit.Test
    public void updateUser() {
        UserDAO userDAO = MyBatisUtil.getMapper(UserDAO.class);
        int result = userDAO.updateUser("卢伟","0002");
        System.out.println(result);
    }

    @org.junit.Test
    public void selectUsers() {
        UserDAO userDAO = MyBatisUtil.getMapper(UserDAO.class);
        List<User> list = userDAO.selectUsers();
        assertNotNull(list);
        for (User user:list) {
            System.out.println(user);
        }
    }

    @org.junit.Test
    public void queryUser() {
        UserDAO userDAO = MyBatisUtil.getMapper(UserDAO.class);
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要查询的用户ID ：");
        String userId = scanner.nextLine();
        User user = userDAO.queryUser(userId);
        System.out.println(user);
    }


//    @org.junit.Test
//    public void listUsersByPage() {
//        UserDAO userDAO = MyBatisUtil.getMapper(UserDAO.class);
//        List<User> list = userDAO.listUsersByPage(0,2);
//        assertNotNull(list);
//        for (User user:list) {
//            System.out.println(user);
//        }
//    }
//
//    @org.junit.Test
//    public void getCount() {
//        UserDAO userDAO = MyBatisUtil.getMapper(UserDAO.class);
//        int count = userDAO.getCount();
//        System.out.println(count);
//    }
    @org.junit.Test
    public void listUsersByPage() {
        UserDAO userDAO = MyBatisUtil.getMapper(UserDAO.class);
        PageHelper.startPage(1,8);
//        List<User> users = userDAO.selectUsers();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入查询的性别：");
        String userGender = scanner.nextLine();
        List<User> users = userDAO.queryUserByUserGender(userGender);
        PageInfo<User> pageInfo = new PageInfo<>(users);
        // PageInfo中包含了分页信息，包括总页数，当前页码，总记录数等
        pageInfo.getList().forEach(System.out::println);
        if (users.size() == 0) {
            System.out.println("没有查询到相关信息");
        }
    }


    @org.junit.Test
    // 根据用户姓名查询用户信息
    public void queryUserByUserName() {
        UserDAO userDAO = MyBatisUtil.getMapper(UserDAO.class);
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入查询的用户姓名：");
        String userName = scanner.nextLine();
        List<User> user = userDAO.queryUserByName(userName);
        user.forEach(System.out::println);
        if (user.size() == 0) {
            System.out.println("没有查询到相关信息");
        }
    }
//    @org.junit.Test
//    // 根据用户编号查询用户信息
//    public void queryUserByUserNum() {
//        UserDAO userDAO = MyBatisUtil.getMapper(UserDAO.class);
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("请输入查询的用户编号：");
//        String userNum = scanner.nextLine();
//        User user = userDAO.queryUserByNum(userNum);
//        System.out.println(user);
//    }

    @org.junit.Test
    // 根据性别查询用户信息
    public void queryUserByUserGender() {
        UserDAO userDAO = MyBatisUtil.getMapper(UserDAO.class);
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入查询的性别：");
        String userGender = scanner.nextLine();
        List<User> user = userDAO.queryUserByUserGender(userGender);
        user.forEach(System.out::println);
        if (user.size() == 0) {
            System.out.println("没有查询到相关信息");
        }
    }

    // 根据用户的登陆时间查询
    @org.junit.Test
    public void queryUserByLoginTime() {
        UserDAO userDAO = MyBatisUtil.getMapper(UserDAO.class);
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入查询的登陆时间：");
        String loginTime = scanner.nextLine();
        List<User> user = userDAO.queryUserByLoginTime(loginTime);
        user.forEach(System.out::println);
        if (user.size() == 0) {
            System.out.println("没有查询到相关信息");
        }
    }
}
