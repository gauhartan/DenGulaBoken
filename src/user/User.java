package user;

public class User {
    private final String username;
    private final String role;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.role = UserRole.ADMIN;
    }

    public User(String username) {
        this.username = username;
        this.role = UserRole.GUEST;
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }

    public User loginAsAdmin(String username, String password) {
        if (username.equals(this.username) && password.equals(this.password)) return this;
        else return null;
    }
}
