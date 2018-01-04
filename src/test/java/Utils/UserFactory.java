package Utils;


public class UserFactory {



    public static User getValidUser(){
       return new User("daria.krynytsyna","8dawune4ka8");
    }

    public static User getInvalidUser(){
        return new User("daria.krynytsyna","dawune4ka");
    }
}
