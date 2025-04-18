package musicPlayer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Music {
    private String title;
    private User singer;
    private int numberOfStream = 0;
    private static ArrayList<Music> allMusics = new ArrayList<>();

    // constructor
    public Music(String title, User singer) {
        this.title = title;
        this.singer = singer;
        this.numberOfStream = 0;
        allMusics.add(this);
    }

    //getters and setters
    public String getTitle() {
        return title;
    }

    public User getSinger() {
        return singer;
    }

    public int getNumberOfStream() {
        return numberOfStream;
    }

    public static ArrayList<Music> getAllMusics() {
        return new ArrayList<>(allMusics);
    }

    public void play() {
        System.out.println("The song \"" + title + "\"__ with user : " + singer.getUsername() + " is playing !");
        numberOfStream++;

    }


    public List<Music> search(String nameOfMusic) {
        List<Music> result = new ArrayList<>();
        for (Music music : allMusics) {
            if (music.getTitle().equals(nameOfMusic)) {
                result.add(music);
            }
        }
        return result;
    }

    public Music search(String nameOfMusic, String nameOfSinger) {
        for (Music music : allMusics) {
            if (music.getTitle().equals(nameOfMusic) && music.getSinger().getUsername().equals(nameOfSinger)) {
                return music;
            }
        }
        return null;
    }

}



