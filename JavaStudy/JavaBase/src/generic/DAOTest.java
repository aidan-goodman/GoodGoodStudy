package generic;

public class DAOTest {
    public static void main(String[] args) {
        DAO<User> userDAO = new DAO<>();
        userDAO.save("001", new User(1, 12, "周杰伦"));
        userDAO.save("002", new User(2, 15, "蔡依林"));
        userDAO.save("003", new User(3, 17, "陈冠希"));
        userDAO.save("004", new User(4, 21, "古天乐"));

        userDAO.update("002", new User(7, 35, "方文山"));
        User user = userDAO.get("002");
        System.out.println(user.toString());
    }
}
