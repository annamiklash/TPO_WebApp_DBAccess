package repository;

import model.Resource;
import model.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    private final DataSource dataSource;

    public UserRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Resource> findResourcesForUser(User user) {
        final String query = "Select r.name, r.content\n" +
                " from users_resources ur\n" +
                " JOIN users u on ur.users_id = u.id\n" +
                " JOIN resources r on ur.resources_id = r.id\n" +
                " where u.username = ? and u.password = ?";
        final List<Resource> resources = new ArrayList<>();

        try (Connection connection = dataSource.getConnection()) {

            final PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());

            final ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                resources.add(new Resource(
                        resultSet.getString("name"),
                        resultSet.getString("content")));
            }

            user.setResourceList(resources);
            return resources;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resources;
    }

    @Override
    public User getUser(String username, String password) {
        final String query = "select  u.username, u.password\n" +
                "from users u\n" +
                " JOIN users_resources ur ON u.id = ur.users_id\n" +
                " where u.username = ? and u.password = ? LIMIT 1";

        try (Connection connection = dataSource.getConnection()) {

            final PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            final ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new User(
                        resultSet.getString("username"),
                        resultSet.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
