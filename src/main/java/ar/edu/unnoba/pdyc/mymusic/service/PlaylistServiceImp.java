package ar.edu.unnoba.pdyc.mymusic.service;

import ar.edu.unnoba.pdyc.mymusic.model.Playlist;
import ar.edu.unnoba.pdyc.mymusic.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistServiceImp implements PlaylistService{
    @Autowired
    private PlaylistRepository playlistRepository;

    @Override
    public List<Playlist> getPlaylists() {
        return playlistRepository.findAll();
    }

    @Override
    public Playlist create(Playlist playlist) {

        return playlistRepository.save(playlist);
    }

    @Override
    public Playlist find(Long id) {
        return playlistRepository.findById(id).get();
    }

    @Override
    public Playlist update(Long id, Playlist playlist) {
        Playlist p = playlistRepository.findById(id).get();
        p.setName(playlist.getName());
        return playlistRepository.save(p);
    }

    @Override
    public void delete(Long id) {
        playlistRepository.deleteById(id);
    }

}
