
package project2;

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class Project2 {
    public static BinaryIdTree bt = new BinaryIdTree();
    public static BinaryNameTree btN = new BinaryNameTree();
    public static BinaryArtistTree btA = new BinaryArtistTree();
    public static ArrayList<Song> songList = new ArrayList<Song>();
    
    public static void main(String[] args) throws Exception {
       Scanner input = new Scanner(System.in);
       getNamesFromTxt();
       
       
        
        while(true){
            System.out.println("\n--Menu--\n1-Adding song\n2-Deleting song\n3-Searchings\n4-Songs by genre\n5-Exit");
            int secondChoose = input.nextInt();
            if(secondChoose == 1){
                addingSong();
            }
            if(secondChoose == 2){
                deletingSong();
            }
            if(secondChoose == 3){
                System.out.println("\n1-Name search\n2-Id search\n3-Artist search\n4-Id Range search");
                int choose = input.nextInt();
                int id;
                int id2;
                String name;
                switch(choose){  
                    case 1: 
                            Scanner input2 = new Scanner(System.in);
                            System.out.println("Enter the song name like (Nereden bileceksiniz => Nereden)");
                            
                            System.out.println("\nEnter the word in the song name: ");
                            name = input2.nextLine();
                            searchingN(name);
                            break;  
                    case 2: System.out.println("Enter the id");   
                            id= input.nextInt();
                            searching(id);
                            break; 
                     case 3: 
                            System.out.println("Enter the artist name like (Ahmetkaya,Erkanoğul)");
                            Scanner input3 = new Scanner(System.in);
                            System.out.println("Enter the artist name");   
                            name = input3.nextLine();
                            searchingA(name);
                            break; 
                     case 4: System.out.println("Enter the first id");   
                            id= input.nextInt();
                            System.out.println("Enter the secod id");
                            id2 = input.nextInt();
                            searchingR(choose,id,id2);
                            break; 
                    default:System.out.println("İnvalid choose!");  

               }
            }
            if(secondChoose == 4){
                printByGenre();
                
            }
            if(secondChoose == 5){
               System.out.println("Quitted from the system");
                break;
            }
            if(secondChoose > 4 && secondChoose<1){
                System.out.println("Invalid choose!!");
            }
        }

    }
    
    public static void printByGenre(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the genre: ");
        
        String genre = input.nextLine();
        int count = 0; 
        for(int a = 0; a<songList.size(); a++){
            if(songList.get(a).genre.toLowerCase().replace(" ", "").equals(genre.toLowerCase().replace(" ", ""))){
                count++;
                System.out.println(songList.get(a));
            }
            
        }
        if(count == 0){
            System.out.println("There is no song with this genre!!");
        }
       
    }
    public static void addingSong(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the name of song:");
        String name = input.nextLine();
        System.out.print("\nEnter the artist of the song: ");
        String artist = input.nextLine();
        System.out.print("\nEnter the genre of the song: ");
        String genre = input.nextLine();
        System.out.print("\nEnter the year of the song: ");
        int year = input.nextInt();
        System.out.println(name+" "+artist+" "+genre+" "+year);
        Song song = new Song(name,artist,genre,year);
        
        songList.add(song);
        bt.binaryTreeById(song);
        btN.binaryTreeByName(song);
        btA.binaryTreeByArtist(song);
    }
    public static void deletingSong(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the id: ");
        int id = input.nextInt();
        int index = id % 1000 - 1;
        
        int count = 0;
        for(int a = 0; a<songList.size(); a++){
            if(songList.get(a).id == id){
                count++;
                songList.remove(songList.get(a));
            }
        }
        
        if(count == 0){
            System.out.println("\nCouldnt find!!\n");
        }
        else{
             bt.deleteNodeById(bt.root, id);
        
        
            System.out.println("\n-----The new song list-----\n");
            for(int a = 0; a<songList.size(); a++){
                  System.out.println(songList.get(a));
            }
        }       
    }
    
    public static void getNamesFromTxt() throws Exception{
        File file = new File("/Users/USER/Desktop/Songs.txt");
        Scanner input = new Scanner(file);
       
        
        for(int a = 0; a<4; a++){
            String line = input.nextLine();
            makeSongObjects(line);
        }
    }
    public static void makeSongObjects(String line){
        String name = "";
        String artist = "";
        String genre = "";
       
        String strYear="";
        int year = 0;
        
        String temp = "";
        int count = 0;
        for(int a = 0; a<line.length(); a++){
           
            if(String.valueOf(line.charAt(a)).equals(";")){
                count++;
            }
            if(count == 0){
                if(!String.valueOf(line.charAt(a)).equals(";")){
                    name+= line.charAt(a);
                }
            }
            if(count == 1){
                if(!String.valueOf(line.charAt(a)).equals(";")){
                    artist+= line.charAt(a);
                }
            }
             if(count == 3){
                if(!String.valueOf(line.charAt(a)).equals(";")){
                    genre+= line.charAt(a);
                }
            }
            if(count == 4){
               
                 if(!String.valueOf(line.charAt(a)).equals(";") && !String.valueOf(line.charAt(a)).equals(" ")){
                    strYear += String.valueOf(line.charAt(a));
                    year = Integer.parseInt(strYear);
                }
                
            }
           
            
        }
        Song song = new Song(name,artist,genre,year);
        songList.add(song);
        bt.binaryTreeById(song);
        btN.binaryTreeByName(song);
        btA.binaryTreeByArtist(song);
    }
    
    
    public static void searching(int id){
        int index = (bt.search(bt.root, id) % 1000) - 1;
        System.out.println(songList.get(index));
    }
    
    public static void searchingN(String name){
        
        if(btN.search(btN.root, name) != null){
            System.out.println(songList.get(btN.search(btN.root, name).index));
        }else{
            System.out.println("Couldnt found");
        }
    }
      public static void searchingA(String artist){
        
           if(btA.search(btA.root, artist) != null){
            System.out.println(songList.get(btA.search(btA.root, artist).index));
        }else{
            System.out.println("Couldnt found");
        }
        
    }
     public static void searchingR(int choose,int id,int id2){

        for(int a = 0; a<songList.size(); a++){
            if(songList.get(a).id >= id && songList.get(a).id <= id2){
                System.out.println(songList.get(a)+",");
            }
        }
    }
}
