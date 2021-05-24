package ar.edu.unnoba.pdyc.mymusic.repository;
import ar.edu.unnoba.pdyc.mymusic.model.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    @Repository("userRepository")
    public interface UserRepository extends JpaRepository<User,Long>{
        List<User> findByEmail(String email);
    }
