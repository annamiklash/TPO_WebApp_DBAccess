package logic;

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
    public List<Resource> getUserResources(User user) {
        return userRepository.findResourcesForUser(user);
    }

    @Override
    public User getUser(String username, String password) {
        return userRepository.getUser(username, password);
    }
}
