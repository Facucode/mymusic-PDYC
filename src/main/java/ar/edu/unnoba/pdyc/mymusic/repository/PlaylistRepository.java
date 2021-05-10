package ar.edu.unnoba.pdyc.mymusic.repository;

import ar.edu.unnoba.pdyc.mymusic.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("playListRepository")

public interface PlaylistRepository extends JpaRepository<Playlist,Long> {
    List<Playlist> findByName(String name);
}