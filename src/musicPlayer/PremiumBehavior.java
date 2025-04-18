package musicPlayer;

public class PremiumBehavior implements UserBehavior{

    private int month ;

    // constructor
    public PremiumBehavior(int month) {
        this.month = month ;
    }

    @Override
    public void createPlaylist(String title, User owner) throws InvalidOperationException {
        Playlist playlist = new Playlist(title ,owner );
        owner.getPlaylists().add(playlist) ;

    }

    @Override
    public void playMusic(Music music) {
        music.play();
    }

    @Override
    public void buyPremium(User owner, int month) {
        this.month += month ;
    }
}
