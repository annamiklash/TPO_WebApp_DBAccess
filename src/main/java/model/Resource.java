package model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Resource {

    private String name;
    private String content;


    public Resource(String name, String content) {
        this.name = name;
        this.content = content;
    }


}
