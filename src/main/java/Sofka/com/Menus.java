package Sofka.com;

import java.util.Scanner;

/**
 * Clase para ejecutar metodos que funcionan como Menus
 *
 * @author Angela Julieth Ossa Cuellar
 * @author Carlos A. Valencia
 */
public class Menus {
    /**
     * Metodo del menu principal
     */
    public static void mainMenu() {
        try {
            System.out.println("Welcome to the Media Player");
            System.out.println("Select the desired option");

            System.out.println("1. view your music library");
            System.out.println("2. Create your Playlist");
            System.out.println("3. view your Playlists");

            if (MediaPlayer.playLists.size() > 0) {
                System.out.println("4. pick Playlists");
            }

            System.out.println("0. Exit");

            Scanner sc = new Scanner(System.in);
            String option = sc.nextLine();

            switch (option) {
                case "1":
                    MediaPlayer.seeTheSong();
                    break;
                case "2":
                    MediaPlayer.createPlayList();
                    break;
                case "3":
                    MediaPlayer.seePlayLists();
                    break;
                case "4":
                    MediaPlayer.pickAPlayList();
                    break;
                case "0":
                    System.out.println("Thank you for you visit");
                    break;
                default:
                    System.out.println("Please select a correct answer");
                    MediaPlayer.next();
            }
        } catch (Exception e) {
            System.out.println("se produjo error cargando el menú.");
        }
    }

    /**
     * Método para el menú de la play list adiere y muestra canciones
     */
    public static void playListMenu() {
        try {
            System.out.println("You are on " + MediaPlayer.currentPlaylist.getName() + " playList");
            System.out.println("Please choose an option");
            System.out.println("-----------------------------------------------------");
            System.out.println("1. Add song");
            System.out.println("2. See songs");
            if (MediaPlayer.currentPlaylist.getSongList().size() > 0) {
                System.out.println("3. Filter your Playlists");
            }
            System.out.println("0. Go back");
            System.out.println("-----------------------------------------------------");
            Scanner sc = new Scanner(System.in);
            String option = sc.nextLine();
            switch (option) {
                case "1":
                    MediaPlayer.chooseTheSong();
                    break;
                case "2":
                    MediaPlayer.seeSongPlayLists();
                    break;
                case "3":
                    filterMenuPlayList();
                    break;
                case "0":
                    System.out.println("Going back....");
                    MediaPlayer.currentPlaylist = null;
                    MediaPlayer.next();
                    break;
                default:
                    System.out.println("Please select a correct answer");
                    MediaPlayer.next();
            }
        } catch (Exception e) {
            System.out.println("se produjo un error al cargar el menú de playList");
        }

    }

    /**
     * Memú para ejecutar los filtro por año, y genero y ordenar por año y duración
     */
    public static void filterMenuPlayList() {
        try {

            System.out.println("Please choose an option");
            System.out.println("-----------------------------------------------------");
            System.out.println("1. filter by year");
            System.out.println("2. filter by genre");
            System.out.println("3. See order by Year");
            System.out.println("4. See order by Duration");
            System.out.println("5. see all");
            System.out.println("0. Go back");
            System.out.println("-----------------------------------------------------");
            Scanner sc = new Scanner(System.in);
            String option = sc.nextLine();
            switch (option) {
                case "1":
                    MediaPlayer.filterTheSongByYear();
                    MediaPlayer.next();
                    break;
                case "2":
                    MediaPlayer.filterTheSongByGenre();
                    break;
                case "3":
                    MediaPlayer.orderByYear();
                    break;
                case "4":
                    MediaPlayer.orderByDuration();
                    break;
                case "5":
                    MediaPlayer.seeSongPlayLists();
                    break;
                case "0":
                    System.out.println("Going back....");
                    MediaPlayer.currentPlaylist = null;
                    MediaPlayer.next();
                    break;
                default:
                    System.out.println("Please select a correct answer");
                    MediaPlayer.next();
            }
        } catch (Exception e) {
            System.out.println("Se produjo un error al cargar el menú de opciones.");
        }
    }

    public static void filterMenu() {
        try {

            System.out.println("Please choose an option");
            System.out.println("-----------------------------------------------------");
            System.out.println("1. filter by year");
            System.out.println("2. filter by genre");
            System.out.println("3. See order by Year");
            System.out.println("4. See order by Duration");
            System.out.println("0. Go back");
            System.out.println("-----------------------------------------------------");
            Scanner sc = new Scanner(System.in);
            String option = sc.nextLine();
            switch (option) {
                case "1":
                    MediaPlayer.filterTheSongByYearL();
                    MediaPlayer.next();
                    break;
                case "2":
                    MediaPlayer.filterTheSongByGenreL();
                    break;
                case "3":
                    MediaPlayer.orderByYearL();
                    break;
                case "4":
                    MediaPlayer.orderByDurationL();
                    break;
                case "0":
                    System.out.println("Going back....");
                    MediaPlayer.currentPlaylist = null;
                    MediaPlayer.next();
                    break;
                default:
                    System.out.println("Please select a correct answer");
                    MediaPlayer.next();
            }
        } catch (Exception e) {
            System.out.println("Se produjo un error al cargar el menú de opciones.");
        }
    }
}
