package Sofka.com;

import java.util.ArrayList;

public class AvailableSong {
    private int id;
    private String nameSong;
    private int creationDate;
    private float duration;
    private String genre;
    private String careName;
    private String description;
    public ArrayList song;


    public AvailableSong() {
        //  ArrayList<Song> songs = new ArrayList<Song>(id, duration, creationDate, genre, careName, description);

    }

    public void insertSong() {
    }

    public static ArrayList<Song> getAvailableSongs() {
        try {

            ArrayList<Song> availableSong = new ArrayList<Song>();

            availableSong.add(new Song(1, "Yendo a la casa de Damian", "1990", 5, "rock", "imag.png", "excelente banda"));
            availableSong.add(new Song(2, "No llora", "2020", 5, "rock", "imag.png", "excelente banda"));
            availableSong.add(new Song(3, "ya no se que hacer conmigo", "1990", 5, "rock", "imag.png", "excelente banda"));
            availableSong.add(new Song(4, "Cuando sea grande", "", 5, "rock", "imag.png", "excelente banda"));
            availableSong.add(new Song(5, "El incomprendido", "1980", 5, "Salsa", "imag.png", "excelente banda"));
            availableSong.add(new Song(6, "Mi otro yo", "1991", 5, "Salsa", "imag.png", "excelente banda"));
            availableSong.add(new Song(7, "Mi desengaño", "1999", 5, "salsa", "imag.png", "excelente banda"));
            availableSong.add(new Song(8, "La agonia", "1998", 5, "salsa", "imag.png", "excelente banda"));
            availableSong.add(new Song(9, "Vida de Rico", "1990", 5, "Pop", "imag.png", "excelente banda"));
            availableSong.add(new Song(10, "Mientes", "1998", 5, "Pop", "imag.png", "excelente banda"));
            availableSong.add(new Song(11, "Fuiste tu", "2015", 5, "Pop", "imag.png", "excelente banda"));
            availableSong.add(new Song(12, "Happy", "2017", 5, "pop", "imag.png", "excelente banda"));
            return availableSong;


            //System.out.println(library);


        } catch (Exception e) {
            System.out.println("se produjo error de conexion");
        }
        return null;
    }
}