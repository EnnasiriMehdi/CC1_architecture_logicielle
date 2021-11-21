package myApplication.domain;

import java.util.Objects;

public class Tradesman {

    private UserId id;
    private String firstName;
    private String lastName;
    private String birthdate;
    private boolean validate;

    private Tradesman(String firstName, String lastName, String birthdate) {
        this.firstName = Objects.requireNonNull(firstName);
        this.lastName = Objects.requireNonNull(lastName);
        this.birthdate = Objects.requireNonNull(birthdate);
        this.validate = false;
    }

    public static Tradesman of(String firstName, String lastName, String birthdate) {
        return new Tradesman(firstName, lastName, birthdate);
    }

    public UserId getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setId(UserId id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public void setValidate(boolean validate) {
        this.validate = validate;
    }
}