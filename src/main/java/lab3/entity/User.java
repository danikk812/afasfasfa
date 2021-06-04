package lab3.entity;

import java.util.Objects;

public class User {
    private String email;
    private String password;
    private UserPreference preference;

    public User() {
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
        preference = new UserPreference();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserPreference getPreference() {
        return preference;
    }

    public void setPreference(UserPreference preference) {
        this.preference = preference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(preference, user.preference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password, preference);
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", preference=" + preference +
                '}';
    }
}
