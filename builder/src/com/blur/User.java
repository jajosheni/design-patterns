
package com.blur;

public class User {

    private final String name;
    private final String email;
    private final String celNo;
    private final String nickname;
    private final String gender;
    private final int id;

    public User(UserBuilder userBuilder) {
        this.name = userBuilder.name;
        this.email = userBuilder.email;
        this.celNo = userBuilder.celNo;
        this.nickname = userBuilder.nickname;
        this.gender = userBuilder.gender;
        this.id= userBuilder.id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCelNo() {
        return celNo;
    }

    public String getNickname() {
        return nickname;
    }

    public String getGender() {
        return gender;
    }
    
    public int getİd() {
        return id;
    }
      
    @Override
    public String toString() {
        return "User: " + this.name + ", " + this.nickname + ", " + this.email + ", " + this.celNo + ", " + this.gender;
    }

    public static class UserBuilder {
        private String name;
        private String email;
        private String celNo;
        private String nickname;
        private String gender;
        private int id;

        public UserBuilder(String name, String nickname) {
            this.name = name;
            this.nickname = nickname;
        }

        public UserBuilder id(int id) {
            this.id = id;
            return this;
        }

        public UserBuilder celNo(String celNo) {
            this.celNo = celNo;
            return this;
        }

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }
        
           public UserBuilder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
  
    public static void main(String[] args) {
        User user1 = new UserBuilder("User One", "nickname one")
                .email("nick@name.one")
                .celNo("123456789")
                .gender("Female")
                .build();

        User user2 = new UserBuilder("User Two", "nickname two")
                .email("nick@name.two")
                .celNo("223456789")
                .build();

        User user3 = new UserBuilder("User Three", "nickname three")
                .celNo("323456789")
                .build();

        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);
    }
}

