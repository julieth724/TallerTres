package Sofka.com;

import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class MediaPlayer {
    public static UUID id = UUID.randomUUID();
    public static PlayList currentPlaylist;
    public static ArrayList<PlayList> playLists = new ArrayList<PlayList>();



    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ArrayList<PlayList> getPlayLists() {
        return playLists;
    }

    public void setPlayLists(ArrayList<PlayList> playLists) {
        this.playLists = playLists;
    }

    public void createPlaylist(String name){
        this.currentPlaylist = new PlayList(name);
    }

    public static void next () {
        System.out.println("enter any key to continue");
        Scanner sc = new Scanner(System.in);
        String response = sc.next();
        run();
    }

    private  static void createPlayList() {
        System.out.println("we are under construction of your Playlist");
        System.out.println("please, enter the list name");
        Scanner listName = new Scanner(System.in);
        String listNameStr = listName.nextLine();
        PlayList newPlayList = new PlayList(listNameStr);
        playLists.add(newPlayList);
        next();
    }

    private  static void  seePlayLists() {
        System.out.println("these are your lists");
        System.out.println("-----------------------------------------------------");
        if(playLists.size() > 0){
            playLists.stream().forEach(item -> System.out.println(item.getName()));
        }
        else{
            System.out.println("You don't have any List, please go to create one");
        }
        System.out.println("-----------------------------------------------------");
        next();
    }

    private static void  pickAPlayList() {
        System.out.println("Please pick one list");
        for (int i = 0; i < playLists.size(); i++){
            System.out.println(i + ") " + playLists.get(i).getName());
        }
        Scanner indexList = new Scanner(System.in);
        int indexListInt = Integer.valueOf(indexList.nextLine());
        currentPlaylist = playLists.get(indexListInt);
        next();
    }

    private static void mainMenu(){
        System.out.println("Welcome to the Media Player");
        System.out.println("Select the desired option");

        System.out.println("1. Create your Playlist");
        System.out.println("2. view your Playlists");
        if(playLists.size() > 0){
            System.out.println("3. pick Playlists");
        }

        System.out.println("0. Exit");

        Scanner sc = new Scanner(System.in);
        String option = sc.nextLine();

        switch (option) {
            case "1":
                createPlayList();
                break;
            case "2":
                seePlayLists();
                break;
            case "3":
                pickAPlayList();
                break;
            case "0":
                System.out.println("Thank you for you visit");
                break;
            default:
                System.out.println("Please select a correct answer");
                next();
        }
    }

    private static  void playListMenu() {
        System.out.println("You are on " + currentPlaylist.getName() + " playList");
        System.out.println("Please choose an option");
        System.out.println("-----------------------------------------------------");
        System.out.println("1. Add song");
        System.out.println("2. Remove song");
        System.out.println("3. See songs");
        System.out.println("0. Go back");
        System.out.println("-----------------------------------------------------");
        Scanner sc = new Scanner(System.in);
        String option = sc.nextLine();
        switch (option) {
            case "1":
                System.out.println("Choose the song that you want to add");
                System.out.println("-----------------------------------------------------");
                ArrayList<Song> availableSongs = AvailableSong.getAvailableSongs();
                for (int i = 0; i < availableSongs.size();i++){
                    System.out.println(i + ". " + availableSongs.get(i).getNameSong());
                }
                System.out.println("-----------------------------------------------------");
                Scanner addSongScaner = new Scanner(System.in);
                int addSongIndex = Integer.valueOf(addSongScaner.nextLine());
                currentPlaylist.addSong(availableSongs.get(addSongIndex));
                System.out.println("the song is added");
                next();
                break;
            case "2":
                seePlayLists();
                break;
            case "3":
                pickAPlayList();
                break;
            case "0":
                System.out.println("Going back....");
                currentPlaylist = null;
                next();
                break;
            default:
                System.out.println("Please select a correct answer");
                next();
        }

    }

    public static void run() {
        if (currentPlaylist == null) {
            mainMenu();
        } else {
            playListMenu();
        }
    }
}

