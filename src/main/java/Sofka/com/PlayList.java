package Sofka.com;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * Clase para definir comportamientos de la play list
 *
 * @author Angela Julieth Ossa Cuellar
 * @author Carlos A. Valencia
 */

public class PlayList {
    /**
     * Definición de atributos de la clase
     */

    public UUID id;
    public String name;
    public ArrayList<Song> songList;

    public PlayList(String name, ArrayList<Song> songList) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.songList = songList;
    }

    public PlayList(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.songList = new ArrayList<>();
    }

    /**
     * Getter and Setter de la clase
     *
     * @return retorna parámetro
     */

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Song> getSongList() {
        return songList;
    }

    public void addSong(Song song) {
        this.songList.add(song);
    }

    /**
     * Metodo para ordenar canción por año y por duración
     *
     * @param type duration
     * @return la comparación
     */
    public ArrayList<Song> sortSongListPl(String type) {
        if (type.equals("duration")) {
            this.songList.sort((o1, o2) -> {
                String nDuration1 = String.valueOf(o1.getDuration());
                String nDuration2 = String.valueOf(o2.getDuration());
                return nDuration1.compareTo(nDuration2);
            });
        } else if (type.equals("year")) {
            this.songList.sort(Comparator.comparing(Song::getCreationDate));
        }
        return this.songList;
    }

    public ArrayList<Song> sortSongList(String type) {
        ArrayList<Song> availableSongs = AvailableSong.getAvailableSongs();
        if (type.equals("duration")) {
            availableSongs.sort((o1, o2) -> {
                String nDuration1 = String.valueOf(o1.getDuration());
                String nDuration2 = String.valueOf(o2.getDuration());
                return nDuration1.compareTo(nDuration2);
            });
        } else if (type.equals("year")) {
            availableSongs.sort(Comparator.comparing(Song::getCreationDate));
        }
        return availableSongs;
    }

    /**
     * Método para filtra por genero
     *
     * @param genre
     * @return arreglo con canciones filtradas
     */
    public ArrayList<Song> getByGenre(String genre) {
        List<Song> listSong = this.songList.stream().filter(song -> song.getGenre().equals(genre)).collect(toList());
        return new ArrayList<>(listSong);
    }

    /**
     * Metodo para filtra por Año
     *
     * @param creationDate
     * @return arreglo con canciones filtradas
     */
    public ArrayList<Song> getByCreationDate(String creationDate) {
        return this.songList.stream().filter(song -> song.getCreationDate().equals(creationDate)).collect(Collectors.toCollection(ArrayList::new));
    }

}
