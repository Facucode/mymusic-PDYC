package ar.edu.unnoba.pdyc.mymusic.service;

import ar.edu.unnoba.pdyc.mymusic.model.Playlist;

import java.util.List;

public interface PlaylistService {
    public List<Playlist> getPlaylists();

    public Playlist create(Playlist playlist);

    public Playlist find(Long id);

    public Playlist update(Long id,Playlist playlist);

    public void delete(Long id);
}
