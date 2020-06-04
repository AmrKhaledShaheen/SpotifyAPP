package com.example.signup;

/**
 * a class with variables needed to check on in signup and signin process
 * @verison 1.0

 */
public class Post {
    /**
     * Variables for object created all are string as shown
     */
    private String email;
    private String username;
    private String password;
    private String birthdate;
    private String gender;

    public Post(String email, String username, String password, String birthdate, String gender) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.birthdate = birthdate;
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getGender() {
        return gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
