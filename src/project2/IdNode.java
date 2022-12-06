
package project2;


public class IdNode {
    public int id;
    IdNode left;
    IdNode right;
 
    public IdNode(Song song)
    {
        this.id = song.id;
        left = null;
        right = null;
    }
    
    
}
