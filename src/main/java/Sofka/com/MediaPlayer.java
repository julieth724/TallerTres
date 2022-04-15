package Sofka.com;

import java.util.ArrayList;
import java.util.*;

import static Sofka.com.Menus.filterMenu;

/**
 * Clase para definir comportamientos del reproductor
 *
 * @author Angela Julieth Ossa Cuellar
 * @author Carlos A. Valencia
 */

public class MediaPlayer {
    public static UUID id = UUID.randomUUID();
    public static PlayList currentPlaylist;
    public static ArrayList<PlayList> playLists = new ArrayList<>();
    // public AvailableSong filter;

    /**
     * métodos getter and setter de la clase
     *
     * @return
     */

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        MediaPlayer.id = id;
    }

    public ArrayList<PlayList> getPlayLists() {
        return playLists;
    }

    public void setPlayLists(ArrayList<PlayList> playLists) {
        MediaPlayer.playLists = playLists;
    }

    public void createPlaylist(String name) {
        currentPlaylist = new PlayList(name);
    }

    /**
     * método para dar un alto y continuar a los menus
     */
    public static void next() {
        try {
            System.out.println("enter any key to continue");
            Scanner sc = new Scanner(System.in);
            String response = sc.next();
            run();
        } catch (Exception e) {
            System.out.println("se produjo error de conexion");
        }
    }

    public static void nextFilter() {
        try {
            System.out.println("-----------------------------------------------------");
            System.out.println("1. Filter your music library");
            System.out.println("2. Order your music library ");
            System.out.println("0. Go back");
            System.out.println("-----------------------------------------------------");
            Scanner sc = new Scanner(System.in);
            String option = sc.nextLine();
            switch (option) {
                case "1":
                    filterMenu();
                    break;
                case "2":
                    break;
                default:
                    System.out.println("Please select a correct answer");
                    MediaPlayer.next();
            }
        } catch (Exception e) {
            System.out.println("se produjo error de conexión");
        }
    }


    /**
     * método para construir el arreglo donde se incluye la playlist
     */
    public static void createPlayList() {
        try {
            System.out.println("we are under construction of your Playlist");
            System.out.println("please, enter the list name");
            Scanner listName = new Scanner(System.in);
            String listNameStr = listName.nextLine();
            PlayList newPlayList = new PlayList(listNameStr);
            playLists.add(newPlayList);
            next();
        } catch (Exception e) {
            System.out.println("se produjo error de conexión");
        }
    }

    /**
     * método para ver la playlist creadas
     */
    public static void seePlayLists() {
        try {
            System.out.println("these are your lists");
            System.out.println("-----------------------------------------------------");
            if (playLists.size() > 0) {
                playLists.forEach(item -> System.out.println(item.getName()));
            } else {
                System.out.println("You don't have any List, please go to create one");
            }
            System.out.println("-----------------------------------------------------");
            next();
        } catch (Exception e) {
            System.out.println("se produjo error de conexion");
        }
    }

    /**
     * método que muestra las listas de caniones en la playlist
     */
    public static void seeSongPlayLists() {
        try {
            System.out.println("these are your Song");
            System.out.println("-----------------------------------------------------");
            if (currentPlaylist.songList.size() > 0) {
                currentPlaylist.songList.forEach(item -> System.out.println(item.getNameSong() + " created in " + item.getCreationDate() + " Genre " + item.getGenre()));
            } else {
                System.out.println("You don't have any Song, please go to insert one");
            }
            System.out.println("-----------------------------------------------------");
            next();
        } catch (Exception e) {
            System.out.println("se produjo error de conexion");
        }
    }

    /**
     * método que escoge o selecciona la playlist
     */
    public static void pickAPlayList() {
        try {
            System.out.println("Please pick one list");
            for (int i = 0; i < playLists.size(); i++) {
                System.out.println(i + ") " + playLists.get(i).getName());
            }
            Scanner indexList = new Scanner(System.in);
            int indexListInt = Integer.parseInt(indexList.nextLine());
            currentPlaylist = playLists.get(indexListInt);
            next();
        } catch (Exception e) {
            System.out.println("se produjo error de conexion");
        }
    }

    /**
     * metodo que permite escoger las canciones pre existentes a una playlist
     */
    public static void chooseTheSong() {
        try {
            System.out.println("Choose the song that you want to add");
            System.out.println("-----------------------------------------------------");
            ArrayList<Song> availableSongs = AvailableSong.getAvailableSongs();
            for (int i = 0; i < availableSongs.size(); i++) {
                System.out.println(i + ". " + availableSongs.get(i).getNameSong() + " Created in " + availableSongs.get(i).getCreationDate() + " Genre " + availableSongs.get(i).getGenre());
            }
            System.out.println("-----------------------------------------------------");
            Scanner addSongScaner = new Scanner(System.in);
            int addSongIndex = Integer.parseInt(addSongScaner.nextLine());
            currentPlaylist.addSong(availableSongs.get(addSongIndex));
            System.out.println("the song is added");
            next();
        } catch (Exception e) {
            System.out.println("se produjo error de conexión");
        }
    }

    public static void seeTheSong() {
        try {
            System.out.println("Library ");
            System.out.println("-----------------------------------------------------");
            ArrayList<Song> availableSongs = AvailableSong.getAvailableSongs();
            for (int i = 0; i < availableSongs.size(); i++) {
                System.out.println(i + ". " + availableSongs.get(i).getNameSong() + " Created in " + availableSongs.get(i).getCreationDate() + " Genre " + availableSongs.get(i).getGenre());
            }
            System.out.println("-----------------------------------------------------");
            nextFilter();
        } catch (Exception e) {
            System.out.println("se produjo error de conexión");
        }
    }

    /**
     * metodo que da inicio a la aplicación
     */
    public static void run() {
        try {
            if (currentPlaylist == null) {
                Menus.mainMenu();
            } else {
                Menus.playListMenu();
            }
        } catch (Exception e) {
            System.out.println("se produjo error de conexion");
        }
    }

    /**
     * metodo para filtrar las canciones por año
     */
    public static void filterTheSongByYear() {
        try {
            System.out.println("_____________________________________________________");
            System.out.println("enter the year of your songs");
            System.out.println("_____________________________________________________");
            Scanner yr = new Scanner(System.in);
            String year = yr.nextLine();
            System.out.println("these are your Song");
            System.out.println("-----------------------------------------------------");
            currentPlaylist.getByCreationDate(year).forEach(song -> System.out.println("* " + song.getNameSong() + " Created in " + song.getCreationDate() + " Genre " + song.getGenre()));
            System.out.println("-----------------------------------------------------");
            next();
        } catch (Exception e) {
            System.out.println("se produjo error de conexión");
        }
    }

    public static void filterTheSongByYearL() {
        try {

            System.out.println("_____________________________________________________");
            System.out.println("enter the year of your songs");
            System.out.println("_____________________________________________________");
            Scanner yr = new Scanner(System.in);
            String year = yr.nextLine();
            System.out.println("these are your Song");
            System.out.println("-----------------------------------------------------");
            PlayList filtro = new PlayList(year);

            filtro.getByCreationDateL(year).forEach(song -> System.out.println("* " + song.getNameSong() + " Created in " + song.getCreationDate() + " Genre " + song.getGenre()));
            System.out.println("-----------------------------------------------------");
            next();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * metodo para filtrar las canciones por genero
     */

    public static void filterTheSongByGenre() {

        try {
            System.out.println("_____________________________________________________");
            System.out.println("enter the genre of your songs in capital letters");
            System.out.println("_____________________________________________________");
            Scanner gr = new Scanner(System.in);
            String genre = gr.nextLine();
            System.out.println("these are your Song");
            System.out.println("-----------------------------------------------------");
            PlayList filtro = new PlayList(genre);
            filtro.getByGenre(genre).forEach(song -> System.out.println("* " + song.getNameSong() + " Created in " + song.getCreationDate() + " Genre " + song.getGenre() + " Duration " + song.getDuration()));
            System.out.println("-----------------------------------------------------");
            next();
        } catch (Exception e) {
            System.out.println("se produjo error de conexion");
        }

    }

    /**
     * metodo para ordenar la lista por año
     */
    //public static void orderByYear(){
//
    //      System.out.println("these are your Song");
    //    System.out.println("-----------------------------------------------------");
    //  currentPlaylist.sortSongList("year").forEach(song -> System.out.println("* " + song.getNameSong() + " Created in " + song.getCreationDate() + " Genre " + song.getGenre() + " Duration " + song.getDuration()));
    //  next();
    //}
    public static void orderByYear() {
        ArrayList<Song> availableSongs = AvailableSong.getAvailableSongs();
        PlayList filtro = new PlayList("year");
        System.out.println("these are the Songs");
        System.out.println("-----------------------------------------------------");
        filtro.sortSongList("year").forEach(song -> System.out.println("* " + song.getNameSong() + " Created in " + song.getCreationDate() + " Genre " + song.getGenre() + " Duration " + song.getDuration()));
        next();
    }

    /**
     * metodo para ordenar la lista por Duration
     */
    public static void orderByDuration() {

        System.out.println("these are your Song");
        System.out.println("-----------------------------------------------------");
        currentPlaylist.sortSongList("duration").forEach(song -> System.out.println("* " + song.getNameSong() + " Created in " + song.getCreationDate() + " Genre " + song.getGenre() + " Duration " + song.getDuration()));
        next();
    }


}

