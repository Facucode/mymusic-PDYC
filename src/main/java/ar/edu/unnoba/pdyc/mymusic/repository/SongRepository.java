package ar.edu.unnoba.pdyc.mymusic.repository;

import ar.edu.unnoba.pdyc.mymusic.model.Genre;
import ar.edu.unnoba.pdyc.mymusic.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("SongRepository")
public interface SongRepository extends JpaRepository<Song,Long> {
    List<Song> findByAuthorAndGenre(String author, Genre genre);

}
