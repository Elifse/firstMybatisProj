package cloud.elifse.service.impl;

import cloud.elifse.dao.UserDAO;
import cloud.elifse.pojo.User;
import cloud.elifse.service.UserService;
import cloud.elifse.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * @author Elifse
 * @Description
 * @Create 2022/5/30
 **/
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO = MyBatisUtil.getMapper(UserDAO.class);

    @Override
    public boolean addUser(User user) {
        boolean b = false;
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        try{
            int i = userDAO.insertUser(user);
            b = i > 0;
            sqlSession.commit();
        }catch (Exception e){
            sqlSession.rollback();
        }
        return b;
    }
}
