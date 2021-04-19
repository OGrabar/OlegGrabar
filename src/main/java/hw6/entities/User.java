package hw6.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    public final static User ROMAN = new User("Roman", "Jdi1234", "ROMAN IOVLEV");

    private String name;
    private String password;
    private String username;
}