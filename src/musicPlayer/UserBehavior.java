package musicPlayer;

public interface UserBehavior {
    void createPlaylist (String Title, User owner) throws InvalidOperationException;
    void playMusic (Music music) throws InvalidOperationException;
    void buyPremium (User owner, int month);
}
