package daoimpl;

import Bean.Nationality;
import Bean.User;
import daointer.AbstractDAO;
import daointer.UserDaoInter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDaoImpl extends AbstractDAO implements UserDaoInter {
    private User getUser(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String surname = rs.getString("surname");
        String phone = rs.getString("phone");
        String email = rs.getString("email");
        int nationality_id = rs.getInt("nationality_id");
        int birthplace_id = rs.getInt("birthplace_id");
        String nationalitystr = rs.getString("nationality");
        String birthplacestr = rs.getString("brithplace");

        Date brithdate = rs.getDate("birthdate");
        Nationality nationality = new Nationality(nationality_id, null, nationalitystr);
        Nationality brithplace = new Nationality(birthplace_id, birthplacestr, null);
        return new User(id, name, surname, phone, email, brithdate, nationality, brithplace);
    }

    @Override
    public List<User> getall() {
        List<User> result = new ArrayList<>();
        try (Connection c = connection()) {
            Statement stmt = c.createStatement();
            stmt.execute("SELECT "
                    + " u.*, "
                    + " n.nationality AS nationality, "
                    + " c.name AS brithplace "
                    + " FROM USER u "
                    + " LEFT JOIN country n ON u.nationality_id = n.id "
                    + " LEFT JOIN country c ON u.birthplace_id = c.id  ");
            ResultSet rs = stmt.getResultSet();
//            System.out.println(rs);
            while (rs.next()) {
                User u = getUser(rs);
                result.add(u);

            }
        } catch (Exception x) {

            x.printStackTrace();
        }
        return result;
    }

    @Override
    public User getById(int uid) {
        User result = null;
        try (Connection c = connection()) {
            Statement stmt = c.createStatement();
            stmt.execute("SELECT "
                    + " u.*, "
                    + " n.nationality AS nationality, "
                    + " c.name AS brithplace "
                    + " FROM USER u "
                    + " LEFT JOIN country n ON u.nationality_id = n.id "
                    + " LEFT JOIN country c ON u.birthplace_id = c.id where id=" + uid);
            ResultSet rs = stmt.getResultSet();
            System.out.println(rs);
            while (rs.next()) {

                result = getUser(rs);
            }
        } catch (Exception x) {
            System.out.println("problem oldi");
            x.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean addUser(User u) {
        try (Connection c = connection()) {
            PreparedStatement stmt = c.prepareStatement("insert into user(name,surname,phone,email) values (?,?,?,?)");
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getSurname());
            stmt.setString(3, u.getPhone());
            stmt.setString(4, u.getEmail());
            stmt.execute();
        } catch (Exception x) {
            x.printStackTrace();
            return false;
        }
        return true;
    }


    @Override
    public boolean UpdateUser(User u) {
        try (Connection c = connection()) {
            PreparedStatement stmt = c.prepareStatement("update user set name =?,surname=?,phone=?,email=?where  id=?");
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getSurname());
            stmt.setString(3, u.getPhone());
            stmt.setString(4, u.getEmail());
            stmt.setInt(5, u.getId());

            stmt.execute();
        } catch (Exception x) {
            x.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean RemoveUser(int id) {
        try (Connection c = connection()) {
            Statement stmt = c.createStatement();
            stmt.execute("delete from user   where  id=" + id);
        } catch (Exception x) {
            x.printStackTrace();
            return false;
        }
        return true;
    }


}


