package Sofka.com;

import java.util.ArrayList;
/**
 *Clase para definir el arreglo de canciones pre existentes
 * @author Angela Julieth Ossa Cuellar
 */
public class AvailableSong {

    public static ArrayList<Song> getAvailableSongs() {
        try {

            ArrayList<Song> availableSong = new ArrayList<>();

            availableSong.add(new Song(1, "Yendo a la casa de Damian", "1990", 3, "ROCK", "imag.png", "excelente banda"));
            availableSong.add(new Song(2, "No llora", "2020", 5, "ROCK", "imag.png", "excelente banda"));
            availableSong.add(new Song(3, "ya no se que hacer conmigo", "1990", 4, "ROCK", "imag.png", "excelente banda"));
            availableSong.add(new Song(4, "Cuando sea grande", "1991", 6, "ROCK", "imag.png", "excelente banda"));
            availableSong.add(new Song(5, "El incomprendido", "1980", 3, "SALSA", "imag.png", "excelente banda"));
            availableSong.add(new Song(6, "Mi otro yo", "1991", 5, "SALSA", "imag.png", "excelente banda"));
            availableSong.add(new Song(7, "Mi desengaño", "1999", 4, "SALSA", "imag.png", "excelente banda"));
            availableSong.add(new Song(8, "La agonia", "1998", 4, "SALSA", "imag.png", "excelente banda"));
            availableSong.add(new Song(9, "Vida de Rico", "1990", 3, "POP", "imag.png", "excelente banda"));
            availableSong.add(new Song(10, "Mientes", "1998", 3, "POP", "imag.png", "excelente banda"));
            availableSong.add(new Song(11, "Fuiste tu", "2015", 3, "POP", "imag.png", "excelente banda"));
            availableSong.add(new Song(12, "Happy", "2017", 4, "POP", "imag.png", "excelente banda"));
            return availableSong;


        } catch (Exception e) {
            System.out.println("se produjo error de conexion");
        }
        return null;
    }
}