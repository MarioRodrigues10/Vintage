package vintage.module.user;

public class UserHolder {
    private static User user;

    public static void setUser (User newUser) { user = newUser; }

    public static User getUser() { return  user;}
}
