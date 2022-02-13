package Sofka.com;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class PlayList {
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
        this.songList = new ArrayList<Song>();
    }

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
    public void addSong (Song song){
     this.songList.add(song);
    }

    public void removeSong (Song song){
        this.songList.remove(song);
    }

    public ArrayList<Song> sortSongList (String type) {
        if (type == "duration") {
            this.songList.sort(new Comparator<Song>() {
                @Override
                public int compare(Song o1, Song o2) {
                    String nDuration1 = String.valueOf(o1.getDuration());
                    String nDuration2 = String.valueOf(o2.getDuration());
                    return nDuration1.compareTo(nDuration2);
                }
            });
        } else if (type == "year") {
            this.songList.sort(new Comparator<Song>() {
                @Override
                public int compare(Song o1, Song o2) {
                    return o1.getCreationDate().compareTo(o2.getCreationDate());
                }
            });
        }
        return null;
    }
    public ArrayList<Song> getByGenre (String genre){
        List<Song> listSong = this.songList.stream().filter(song-> song.getGenre() == genre).collect(Collectors.toList());
       return new ArrayList<Song>(listSong);
    }
    public ArrayList<Song> getByCreationDate (String creationDate){
        List<Song> listSong = this.songList.stream().filter(song-> song.getCreationDate() == creationDate).collect(Collectors.toList());
        return new ArrayList<Song>(listSong);
    }
}
