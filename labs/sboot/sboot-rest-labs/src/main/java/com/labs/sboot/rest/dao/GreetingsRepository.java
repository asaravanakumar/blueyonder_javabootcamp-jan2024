package com.labs.sboot.rest.dao;

import com.labs.sboot.rest.model.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GreetingsRepository extends JpaRepository<Greeting, Integer> {
    public List<Greeting> findByType(String type);

    public List<Greeting> findByTypeAndMessageContaining(String type, String message);

    // message LIKE '%Hello%'
    public List<Greeting> findByTypeAndMessageLike(String type, String message);

    @Query("select g from Greeting g where g.type = ?1 and g.message like %?2%")
    public List<Greeting> findByTypeAndMessageLikeQuery(String type, String message);

    @Query(value = "select * from Greeting g where g.type = ?1 and g.message like %?2%", nativeQuery = true)
    public List<Greeting> findByTypeAndMessageLikeNativeQuery(String type, String message);

}
