package model;

import lombok.Data;

import java.util.List;

@Data
public class User {

    private int id;
    private String username;
    private String password;
    private List<Resource> resourceList;

    public User( String username, String password) {
        this.username = username;
        this.password = password;
    }


    public List<Resource> resources() {
        return resourceList;
    }
}
