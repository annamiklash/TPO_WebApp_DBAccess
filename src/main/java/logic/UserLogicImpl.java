package logic;

import model.Model;
import model.Resource;
import model.User;
import repository.UserRepository;
import repository.UserRepositoryImpl;

import javax.sql.DataSource;
import java.util.List;

public class UserLogicImpl implements UserLogic {

    private final UserRepository userRepository;

    public UserLogicImpl(DataSource dataSource) {
        userRepository = new UserRepositoryImpl(dataSource);

    }

    @Override
    public boolean userExists(String username, String password) {
        return userRepository.UserExists(username, password);
    }

    @Override
    public Model getUserResources(User user) {
        final List<Resource> resources = userRepository.findResourcesForUser(user);
        return new Model(resources);
    }

    @Override
    public User getUser(String username, String password) {
        return userRepository.getUser(username, password);
    }
}
