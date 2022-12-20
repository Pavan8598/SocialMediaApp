package com.socialmedia.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.socialmedia.app.entities.multimedia;

import java.util.List;

@Repository
public interface multimediaRepository extends JpaRepository<multimedia, Long> {
    multimedia findByName(String name);

    boolean existsByName(String name);

    @Query(nativeQuery = true, value="SELECT name FROM multimedia")
    List<String> getAllEntryNames();
}