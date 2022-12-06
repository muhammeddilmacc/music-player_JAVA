
package project2;

import static project2.BinaryNameTree.root;


public class BinaryArtistTree {
    public static ArtistNode root;
    
    private ArtistNode addRecursive(ArtistNode current, Song song) {
    if (current == null) {
        return new ArtistNode(song);
    }

    if (compareStrings(song.artist,current.artist) == -1) {
        current.left = addRecursive(current.left, song);
    } else if (compareStrings(song.artist,current.artist) == 1) {
        current.right = addRecursive(current.right, song);
    } else {
        return current;
    }
    return current;
    }
    

    public static int compareStrings(String s1, String s2) {

        int comparedResult = s1.compareTo(s2);

        if (comparedResult > 0) {
            return 1;
        } else if (comparedResult < 0) {
            return -1;
        } else {
            return 0;
        }


    }
    
    
     public ArtistNode search(ArtistNode root, String artist)
    {
    if (root == null || root.artist.toLowerCase().contains(artist.toLowerCase()) || root.artist.toLowerCase().equals(artist.toLowerCase())) {
            return root;
        }

        /*
         We will keep moving to the left sub-tree recursively if the key is
         less than the node value.
         */
        else if (compareStrings(artist,root.artist) == -1) {
            return search(root.left, artist);
        }

        /*
         We will moving to the right sub-tree if the key is greater than the node value.
         */
       return search(root.right, artist);
    }
   
    
     public void binaryTreeByArtist(Song song){
        root = addRecursive(root, song);
    }
    
      void printInorder(ArtistNode node)
    {
        if (node == null)
            return;
 
        /* first recur on left child */
        printInorder(node.left);
 
        /* then print the data of node */
        System.out.println(node.artist + " ");
 
        /* now recur on right child */
        printInorder(node.right);
    }
    
  
}
