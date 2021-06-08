package ar.edu.unnoba.pdyc.mymusic.resource;

import ar.edu.unnoba.pdyc.mymusic.dto.AddSongResponse;
import ar.edu.unnoba.pdyc.mymusic.dto.PlaylistDTO;
import ar.edu.unnoba.pdyc.mymusic.dto.SongDTO;
import ar.edu.unnoba.pdyc.mymusic.model.Playlist;
import ar.edu.unnoba.pdyc.mymusic.model.Song;
import ar.edu.unnoba.pdyc.mymusic.service.PlaylistService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/playlists")
public class PlaylistResource {
    @Autowired
    private PlaylistService playlistService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Playlist> getPlaylists() {
        return playlistService.getPlaylists();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createPlaylist(PlaylistDTO playlistDTO){
        ModelMapper modelMapper = new ModelMapper();
        Playlist playlist = modelMapper.map(playlistDTO, Playlist.class);
        playlistService.create(playlist);
        return Response.ok().build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePlaylist(@PathParam("id") Long id,PlaylistDTO playlistDTO){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = (String) auth.getPrincipal();
        ModelMapper modelMapper = new ModelMapper();
        Playlist playlist = modelMapper.map(playlistDTO, Playlist.class);
        try{
            playlistService.update(id,playlist,userName);
            return Response.ok().build();
        }catch(Exception e){
            return Response.status(Response.Status.FORBIDDEN).build();
        }

    }

    @POST
    @Path("/{id}/songs")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addSong(@PathParam("id") Long id, SongDTO songDTO){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = (String) auth.getPrincipal();
        ModelMapper modelMapper = new ModelMapper();
        Song song = modelMapper.map(songDTO, Song.class);
        try{
            Playlist p = playlistService.addSong(id, song,userName);
            AddSongResponse pdto = modelMapper.map(p, AddSongResponse.class);
            return Response.ok(pdto).build();
        }catch(Exception e){
            return Response.status(Response.Status.FORBIDDEN).build();
        }
    }
}