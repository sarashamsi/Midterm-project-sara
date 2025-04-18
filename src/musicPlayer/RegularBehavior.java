package musicPlayer;

public class RegularBehavior implements UserBehavior {

    private int playingLimit = 5 ;



    @Override
    public void createPlaylist(String Title, User owner) throws InvalidOperationException {
        throw new InvalidOperationException("'Regular' user cannot create PLAYLIST !");
    }

    @Override
    public void playMusic(Music music) throws InvalidOperationException {
        if (playingLimit <= 0){
            throw new InvalidOperationException("Your music playback limit has expired !\n*Please try again !*") ;
        } else {
            music.play();
            playingLimit-- ;
        }

    }

    @Override
    public void buyPremium(User owner, int month) {
        owner.setBehavior(new PremiumBehavior(month));
        System.out.println("User status changed from regular to premium !");
    }
}
