package musicPlayer;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Music {
    private String title ;
    private User singer ;
    private int numberOfStream = 0 ;
    private static ArrayList<Music> allMusics = new ArrayList<>() ;

    // constructor
    public Music(String title , User singer){
        this.title = title ;
        this.singer = singer ;
        this.numberOfStream = 0 ;
        allMusics.add(this);
    }

    //getters and setters
    public String getTitle(){
        return title ;
    }
    public User getSinger(){
        return singer ;
    }
    public int getNumberOfStream(){
        return numberOfStream ;
    }
    public static ArrayList<Music> getAllMusics(){
        return new ArrayList<>(allMusics);
    }

    public void play(){
        System.out.println("The song \""+ title +"__"+ singer.getUsername() +" is playing !");
        numberOfStream ++ ;

    }

    public ArrayList<Music> search (String nameOfMusic) {
        return (ArrayList<Music>) allMusics.stream().filter(music -> music.title.equals(title)).collect(Collectors.toList());
    }

    public Music search (String nameOfMusic ,String nameOfSinger){
        return allMusics.stream().filter(m -> m.title.equals(title) && m.singer.equals(singer)).findFirst().orElse(null);
    }
}
