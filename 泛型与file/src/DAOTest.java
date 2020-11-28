import java.util.List;

public class DAOTest {
    public static void main(String[] args) {
        DAO<User> dao = new DAO<>();
        dao.save("1001",new User(1001,21,"张三"));
        dao.save("1002",new User(1002,20,"李四"));
        dao.save("1003",new User(1003,23,"王五"));

        List<User> list = dao.list();
        System.out.println(list);
    }
}
