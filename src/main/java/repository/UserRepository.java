package repository;

import model.Resource;
import model.User;

import java.util.List;

public interface UserRepository {

    List<Resource> findResourcesForUser(User user);

    User getUser(String username, String password);

}
