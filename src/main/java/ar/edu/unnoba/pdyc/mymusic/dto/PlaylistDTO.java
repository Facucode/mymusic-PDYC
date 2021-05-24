package ar.edu.unnoba.pdyc.mymusic.dto;

public class PlaylistDTO {
    private Long id;
    private String name;
    private UserDTO owner;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserDTO getOwner() {
        return owner;
    }

    public void setOwner(UserDTO owner) {
        this.owner = owner;
    }
}
