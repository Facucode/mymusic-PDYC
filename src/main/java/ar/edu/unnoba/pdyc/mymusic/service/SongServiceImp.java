package ar.edu.unnoba.pdyc.mymusic.service;


import ar.edu.unnoba.pdyc.mymusic.model.Genre;
import ar.edu.unnoba.pdyc.mymusic.model.Song;
import ar.edu.unnoba.pdyc.mymusic.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImp implements SongService{
    @Autowired
    private SongRepository songRepository;

    @Override
    public List<Song> getSongs(String author, Genre genre) {
        return songRepository.findByAuthorAndGenre(author, genre);
    }
}
