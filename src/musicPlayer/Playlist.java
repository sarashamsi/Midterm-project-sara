package musicPlayer;

import java.util.ArrayList;
import java.util.Scanner;

public class Playlist {
    private ArrayList<Music> playlist = new ArrayList<>() ;
    private User owner ;
    private String title ;

    // constructor
    public Playlist(String title ,User owner){
        this.title = title ;
        this.owner = owner ;
        this.playlist = new ArrayList<>();
    }

    public void editTitle(String newTitle ,String password) throws InvalidOperationException{
        if (!owner.getPassword().equals(password)){
            throw new InvalidOperationException("The password is 'Incorrect' !");
        }
        this.title = newTitle ;
    }

    public void addMusic(Music music ,String password) throws InvalidOperationException{
        if (!owner.getPassword().equals(password)){
            throw new InvalidOperationException("The password is 'Incorrect' !");
        }
        if (playlist.contains(music)){
            throw new InvalidOperationException("The music is repetitive !");
        }
        playlist.add(music);
    }

    public void removeMusic(Music music ,String password) throws InvalidOperationException{
        if (!owner.getPassword().equals(password)){
            throw new InvalidOperationException("The password is incorrect !");
        }
        if (!playlist.remove(music)){
            throw new InvalidOperationException("Music not found in playlist !");
        }
    }

    public Music searchInPlaylist(String title ,User singer){
        for (Music music : playlist){
            if (music.getTitle().equals(title) && music.getSinger().equals(singer)){
                return music ;
            }
        }
        return null ;
    }

    public void playPlaylist() {

        for (Music music : playlist) {
            music.play();
        }
    }

    //getter and setters
    public String getTitle(){
        return title;
    }
    public ArrayList<Music> getPlaylist(){
        return new ArrayList<>(playlist);
    }
    public User getOwner(){
        return owner ;
    }

}
