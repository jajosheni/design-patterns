package com.blur;

public class User {

    public String username;
    public String email;
    public String password;
    public String nickname;
    public String gender;
    public int id;

    private static com.blur.User instance = null;

    private User() {
    }

    public static com.blur.User getInstance() {
        if (instance == null) {
            instance = new com.blur.User();
        }
        return instance;
    }

    public void viewProfile() {
        System.out.println("Profile Viewed " + this.id);
    }

    public static void main(String[] args) {

        com.blur.User object = com.blur.User.getInstance();
        object.id = 123;

        com.blur.User object2 = com.blur.User.getInstance();
        com.blur.User object3 = com.blur.User.getInstance();

        object.viewProfile();
        object2.viewProfile();
        object3.viewProfile();

    }

}

