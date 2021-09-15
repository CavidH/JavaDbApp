import Bean.User;
import daoimpl.UserDaoImpl;
import daointer.UserDaoInter;
import javafx.scene.effect.FloatMapBuilder;


public class Main {
    /* */

    //    /**
//     * public static Connection connection() throws Exception {
//     * Class.forName("com.mysql.cj.jdbc.Driver");
//     * //com.mysql.cj.jdbc.Driver s;
//     * <p>
//     * String url = "jdbc:mysql://localhost:3306/resume";
//     * String username = "root";
//     * String password = "123456";
//     * Connection c = DriverManager.getConnection(url, username, password);
//     * return c;
//     * }
//     * <p>
//     * public static void GetAllUser() throws Exception {
//     * Connection c = connection();
//     * Statement stmt = c.createStatement();
//     * stmt.execute("select * from user");
//     * ResultSet rs = stmt.getResultSet();
//     * System.out.println(rs);
//     * while (rs.next()) {
//     * int id = rs.getInt("id");
//     * String name = rs.getString("name");
//     * String surname = rs.getString("surname");
//     * String phone = rs.getString("phone");
//     * String email = rs.getString("email");
//     * System.out.println("id=" + id);
//     * System.out.println("name=" + name);
//     * System.out.println("surname=" + surname);
//     * System.out.println("phone=" + phone);
//     * System.out.println("email=" + email);
//     * <p>
//     * System.out.println("-----------------");
//     * <p>
//     * <p>
//     * }
//     * <p>
//     * <p>
//     * }
//     * <p>
//     * public static void UpdateUser() throws Exception {
//     * Connection c = connection();
//     * <p>
//     * Statement stmt = c.createStatement();
//     * stmt.execute("update user set name='**CAVID**' where  id=1");
//     * <p>
//     * <p>
//     * }
//     **/
    public static void main(String[] args) throws Exception {


        UserDaoInter userDaoInter = Context.instanceUserDao();
        userDaoInter
                .getall()
                .stream()
                .forEach(System.out::println);

        /*UserDaoImpl userDaoimpl = new UserDaoImpl();
        User u=new User(1,"Cavid","Haciyev","+994554531254","hcavid@gmail.com");
        userDaoimpl.addUser(u);
        userDaoimpl.getall()
                .stream().forEach(System.out::println);*/
    }
}