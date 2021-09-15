import daoimpl.UserDaoImpl;
import daointer.UserDaoInter;

public class Context {
    public static UserDaoInter instanceUserDao(){
        return new UserDaoImpl();
    }
}
