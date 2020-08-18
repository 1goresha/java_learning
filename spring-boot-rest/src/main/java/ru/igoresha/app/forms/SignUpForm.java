package ru.igoresha.app.forms;

import lombok.Data;

@Data


public class SignUpForm {

    private String firstName;
    private String lastName;
    private Integer age;
    private String login;
    private String passwordHash;

}
