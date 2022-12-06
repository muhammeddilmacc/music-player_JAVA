
package project2;


public class ArtistNode {
    static int count = -1;
    int index;
    String artist;
    ArtistNode left;
    ArtistNode right;
 
    public ArtistNode(Song song)
    {
        this.index = ++count;
        this.artist = song.artist;
        left = null;
        right = null;
    }
    

}
