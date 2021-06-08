package ar.edu.unnoba.pdyc.mymusic.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="playlists")
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User owner;

    @ManyToMany
    @JoinTable(name = "playlists_songs",inverseJoinColumns = @JoinColumn(name = "song_id"))
    private List<Song> songs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

}
