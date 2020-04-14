import repository.UserRepositoryImpl;

import java.sql.SQLException;

public class MainTest {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        final UserRepositoryImpl userRepository = new UserRepositoryImpl(null);
      //  final List<Resource> resourcesForUser = userRepository.findResourcesForUser("aaa", "aaapassword");
      //  resourcesForUser.forEach(resource -> System.out.println(resource.getContent()));
    }
}
