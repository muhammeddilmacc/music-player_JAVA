
package project2;


public class BinaryNameTree {
 public static NameNode root;
    
    
  private NameNode addRecursive(NameNode current, Song song) {
    if (current == null) {
        return new NameNode(song);
    }

    if (compareStrings(song.name,current.name) == -1) {
        current.left = addRecursive(current.left, song);
    } else if (compareStrings(song.name,current.name) == 1) {
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
   public NameNode search(NameNode root, String name)
    {
    if (root == null || root.name.toLowerCase().contains(name.toLowerCase()) || root.name.toLowerCase().equals(name.toLowerCase())) {
            return root;
        }

        /*
         We will keep moving to the left sub-tree recursively if the key is
         less than the node value.
         */
        else if (compareStrings(name,root.name) == -1) {
            return search(root.left, name);
        }

        /*
         We will moving to the right sub-tree if the key is greater than the node value.
         */
       return search(root.right, name);
    }
   
    public void binaryTreeByName(Song song){
        root = addRecursive(root, song);
    }
 
    void printInorder(NameNode node)
    {
        if (node == null)
            return;
 
        /* first recur on left child */
        printInorder(node.left);
 
        /* then print the data of node */
        System.out.println(node.name + " ");
 
        /* now recur on right child */
        printInorder(node.right);
    }
}
