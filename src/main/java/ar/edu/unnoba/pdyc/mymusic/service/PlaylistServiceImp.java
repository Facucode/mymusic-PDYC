package ar.edu.unnoba.pdyc.mymusic.service;

import ar.edu.unnoba.pdyc.mymusic.model.Playlist;
import ar.edu.unnoba.pdyc.mymusic.model.Song;
import ar.edu.unnoba.pdyc.mymusic.repository.PlaylistRepository;
import ar.edu.unnoba.pdyc.mymusic.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PlaylistServiceImp implements PlaylistService{

    @Autowired
    private PlaylistRepository playlistRepository;

    @Autowired
    private SongRepository songRepository;

    @Override
    public List<Playlist> getPlaylists() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {}
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
    @Transactional
    public Playlist update(Long id, Playlist playlist, String userEmail) throws Exception{
        Playlist p = playlistRepository.findById(id).get();
        if(!p.getOwner().getEmail().equals(userEmail)){
            throw new Exception();
        }
        p.setName(playlist.getName());
        return playlistRepository.save(p);
    }

    @Override
    @Transactional
    public Playlist addSong(Long id, Song song, String userEmail) throws Exception{
        Playlist p = playlistRepository.findById(id).get();
        if(!p.getOwner().getEmail().equals(userEmail)){
            throw new Exception();
        }
        song = songRepository.findById(song.getId()).get();
        p.getSongs().add(song);
        p = playlistRepository.save(p);
        return p;
    }

    @Override
    public void delete(Long id) {
        playlistRepository.deleteById(id);
    }
}