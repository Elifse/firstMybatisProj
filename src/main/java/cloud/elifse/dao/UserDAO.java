package cloud.elifse.dao;

import cloud.elifse.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Elifse
 * @Description
 * @Create 2022/5/29
 **/
public interface UserDAO {

    public int insertUser(User user);
    public int deleteUser(String userNum);
    public int updateUser(@Param("userName") String userName,@Param("userNum") String userNum);
    public List<User> selectUsers();
    public User queryUser(String userId);
    public List<User> queryUserByUserGender(String userGender);
    public List<User> queryUserByName(String userName);
    public List<User> queryUserByLoginTime(String userName);


//    public List<User> listUsersByPage(@Param("start") int start,@Param("pageSize") int pageSize);
//    public int getCount();

}
