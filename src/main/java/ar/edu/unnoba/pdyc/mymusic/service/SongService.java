package ar.edu.unnoba.pdyc.mymusic.service;

import ar.edu.unnoba.pdyc.mymusic.model.Genre;
import ar.edu.unnoba.pdyc.mymusic.model.Song;

import java.util.List;

public interface SongService {
    public List < Song > getSongs(String author, Genre genre);
}
