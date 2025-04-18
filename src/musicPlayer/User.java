package musicPlayer;

import java.util.ArrayList;

public class User {
    private String username ;
    private String password ;
    private ArrayList<User> followerList ;
    private ArrayList<User> followingList ;
    private UserBehavior behavior ;
    private ArrayList<Playlist> playlists ;
    private static ArrayList<User> allUsers ;

    // constructor
    public User(String username , String password) throws InvalidOperationException {
        if (password.length() < 8){
            throw new InvalidOperationException("The password must contain at least 8 character ! \nPlease enter the correct number!");
        }
        if (allUsers.stream().anyMatch(user -> user.username.equals(username))){
            throw new InvalidOperationException("The USERNAME is duplicate !");
        }

        this.username = username ;
        this.password = password ;
        this.behavior = new RegularBehavior();
        this.followerList = new ArrayList<>();
        this.followingList = new ArrayList<>();
        this.playlists = new ArrayList<>();
        allUsers.add(this);
    }

    public void follow (User user){
        this.followingList.add(user) ;
        user.followerList.add(this);
    }

    public void createPlaylist(String title , User owner) throws InvalidOperationException {
        behavior.createPlaylist(title , owner);
    }

    public void playMusic (Music music) throws InvalidOperationException {
        behavior.playMusic(music);
    }

    public void buyPremium ( int month){
        behavior.buyPremium(this ,month);
    }

    public void addPlaylist(Playlist playlist){
        playlists.add(playlist);
    }

    public static ArrayList<User> getAllUsers(){
        return new ArrayList<>(allUsers);
    }


    // getters and setters
    public String getUsername(){
        return username ;
    }
    public ArrayList<Playlist> getPlaylists(){
        return playlists ;
    }
    public void setBehavior(UserBehavior behavior) {
        this.behavior = behavior ;
    }
    public String getPassword(){
        return password ;
    }


}
