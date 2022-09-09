package cloud.elifse.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

/**
 * @author Elifse
 * @Description
 * @Create 2022/5/29
 **/

@Data
@ToString
public class User {
    private int userId;
    private String userNum;
    private String userName;
    private String userGender;
    private String loginTime;

    public User() {
    }

    public User(int userId, String userNum, String userName, String userGender, String loginTime) {
        this.userId = userId;
        this.userNum = userNum;
        this.userName = userName;
        this.userGender = userGender;
        this.loginTime = loginTime;
    }

    public User(int userId, String userNum, String userName, String userGender, int loginTime) {
    }
}
