package logic;

import model.Model;
import model.User;

public interface UserLogic {

    boolean userExists(String username, String password);

    Model getUserResources(User user);

    User getUser(String username, String password);
}
