import musicPlayer.InvalidOperationException;
import musicPlayer.Music;
import musicPlayer.Playlist;
import musicPlayer.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {

            System.out.println("* Create user :");
            User userR = new User("sara", "sara1234");
            User userP = new User("zahra", "zahra123");
            userP.buyPremium(3);

            System.out.println("Regular user created: " + userR.getUsername());
            System.out.println("Premium user created: " + userP.getUsername());

            System.out.println("\n*Add Music :");
            Music song1 = new Music("Happier Than Ever", userR);
            Music song2 = new Music("Alane Walker", userP);

            System.out.println("Created songs:");
            System.out.println("- " + song1.getTitle() + " by " + song1.getSinger().getUsername());
            System.out.println("- " + song2.getTitle() + " by " + song2.getSinger().getUsername());


            System.out.println("\n* Music Playback :");
            song1.play();
            song2.play();

            System.out.println("\n*♥\uFE0F♥ Playlist♥♥\uFE0F*");
            Playlist playlist = new Playlist("My Playlist", userP);
            playlist.addMusic(song1, "zahra123");
            playlist.addMusic(song2, "zahra123");

            System.out.println("Playlist created with : " + playlist.getPlaylist().size() + " songs");

            System.out.println("\n*Testing Search Functionality :");
            List<Music> searchResults = Music.getAllMusics().stream().filter(m -> m.getTitle().equals("Song 1")).toList();
            System.out.println("Search found " + searchResults.size() + " results");


            System.out.println("\n*Testing User Behavior :");
            System.out.println("Regular user trying to create playlist:");
            try {
                userR.createPlaylist("Regular Playlist", userR);
            } catch (InvalidOperationException e) {
                System.out.println("Expected error: " + e.getMessage());
            }

            System.out.println("\nPremium user creating playlist:");
            userP.createPlaylist("Premium Playlist", userP);
            System.out.println("Playlist created successfully");

        } catch (InvalidOperationException e) {
            System.err.println("Test failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}