/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sofka.com;

import java.util.Date;


/**
 * Clase que define la canción
 * @author Carlos A. Valencia
 * @author Angela Julieth Ossa Cuellar
 */
public class Song implements ILibraryForm {
    private int id;
    private String nameSong;
    public String creationDate;
    private int duration;
    private String genre;
    private String careName;
    private String description;

    /**
     * Definición de los parametros
     *
     * @param id           :  identificador de la canción
     * @param nameSong     nombre de la Canción
     * @param creationDate Años de ccreacion de la Canción
     * @param duration     Duracion en min de la canción
     * @param genre        genero musical de la canción
     * @param careName     Caratula de la Canción
     * @param description  descripcion corta
     */

    public Song(int id, String nameSong, String creationDate,
                int duration, String genre, String careName, String description) {
        this.id = id;
        this.nameSong = nameSong;
        this.creationDate = creationDate;
        this.duration = duration;
        this.genre = genre;
        this.careName = careName;
        this.description = description;
    }

    /**
     * Creacion de metodos Getter and Setter
     * @return retorno del parametro
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCareName() {
        return careName;
    }

    public void setCareName(String careName) {
        this.careName = careName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void CreateLibrary() {


    }

    /**
     * Reesccritura de metodos de la interface
     */
    @Override
    public void Id() {

    }

    @Override
    public String nameSong(String nameSong) {
        return null;
    }

    @Override
    public Date CreationDate(int creationDate) {
        return null;
    }

    @Override
    public int Duration(int duration) {
        return 0;
    }

    @Override
    public String Genre(String genre) {
        return null;
    }

    @Override
    public String CareName(String careName) {
        return null;
    }

    @Override
    public String Description(String description) {
        return null;
    }
}
