package repository;

import model.Resource;
import model.User;

import java.util.List;

public interface UserRepository {

    boolean UserExists(String username, String password);

    List<Resource> findResourcesForUser(User user);

    User getUser(String username, String password);

}
