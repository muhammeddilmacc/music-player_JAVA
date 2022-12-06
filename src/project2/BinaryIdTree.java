
package project2;

public class BinaryIdTree {
    static IdNode root;
    
    
   private IdNode addRecursive(IdNode current, Song song) {
    if (current == null) {
        return new IdNode(song);
    }

    if (song.id < current.id) {
        current.left = addRecursive(current.left, song);
    } else if (song.id > current.id) {
        current.right = addRecursive(current.right, song);
    } else {
        return current;
    }

    return current;
    }
    
    public void binaryTreeById(Song song){
        root = addRecursive(root, song);
    }
 
    void printInorder(IdNode node)
    {
        if (node == null)
            return;
 
        /* first recur on left child */
        printInorder(node.left);
 
        /* then print the data of node */
        System.out.println(node.id + " ");
 
        /* now recur on right child */
        printInorder(node.right);
    }
 
    
    public IdNode deleteNodeById(IdNode root, int id) {
 
        if(root == null) return root;
 
        if(id < root.id) {
            root.left = deleteNodeById(root.left, id);
        } else if(id > root.id) {
            root.right = (deleteNodeById(root.right, id));
        } else {
            if(root.left == null && root.right == null) {
                return null;
            } else if(root.left == null) {
                return root.right;
            } else if(root.right == null) {
                return root.left;
            } else {
                int minValue = minValue(root.right);
                root.id = (minValue);
                root.right = deleteNodeById(root.right, minValue);
            }
        }
        
        return root;
    }
 
    private int minValue(IdNode node) {
 
        if(node.left != null) {
            return minValue(node.left);
        }
        return node.id;
    }
 
    public int search(IdNode root, int id)
    {
    if (root==null || root.id==id)
        return root.id;
 
    if (root.id < id)
       return search(root.right, id);
 
    return search(root.left, id);
    }
    
}

