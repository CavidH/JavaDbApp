package daointer;
import Bean.*;

import java.util.List;


public interface UserDaoInter {
    public List<User> getall();
    public  User  getById(int uid);
    public boolean addUser(User u);
    public boolean UpdateUser(User u);
    public boolean RemoveUser(int id);


}
