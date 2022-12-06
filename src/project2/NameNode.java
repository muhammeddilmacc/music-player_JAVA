
package project2;


public class NameNode {
    static int count = -1;
    String name;
    int index;
    NameNode left;
    NameNode right;
 
    public NameNode(Song song)
    {
        this.name = song.name;
        this.index = ++count;
        left = null;
        right = null;
    }
   

}
