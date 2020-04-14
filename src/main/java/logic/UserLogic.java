package logic;

import model.Resource;
import model.User;

import java.util.List;

public interface UserLogic {

    List<Resource> getUserResources(User user);

    User getUser(String username, String password);
}
