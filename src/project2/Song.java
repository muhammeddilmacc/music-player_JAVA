
package project2;


public class Song {
    
    String name;
    String artist;
    private static int count = 1000;
    int id;
    String genre;
    int year;
    
    
    public Song(String name, String artist,String genre,int year){
        this.id = ++count;
        this.name = name;
        this.artist = artist;
        this.genre = genre;
        this.year = year;
    }
    
     @Override
    public String toString() {
       return ("Song name: "+name+ " > Song artist: "+artist+ " > İd: "+id + " > Genre: "+genre + " > Year: "+year);
    }
    
}
