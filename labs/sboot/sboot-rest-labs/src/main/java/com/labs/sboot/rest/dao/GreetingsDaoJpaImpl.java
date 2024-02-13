package com.labs.sboot.rest.dao;

import com.labs.sboot.rest.exception.GreetingsDataException;
import com.labs.sboot.rest.exception.NoGreetingsFoundException;
import com.labs.sboot.rest.model.Greeting;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Optional;

@Transactional
public class GreetingsDaoJpaImpl implements GreetingsDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public int addGreeting(Greeting greeting) throws GreetingsDataException {
        entityManager.persist(greeting);
        return greeting.getId();
    }

    @Override
    public Optional<Greeting> getGreeting(int id) throws GreetingsDataException, NoGreetingsFoundException {
        Greeting greeting = entityManager.find(Greeting.class, id);
        return Optional.of(greeting);
    }

    @Override
    public Collection<Greeting> getAllGreetings() {
        return entityManager.createQuery("FROM Greeting").getResultList();
    }

    @Override
    public boolean updateGreeting(int id, Greeting greeting) throws NoGreetingsFoundException {
        Greeting greetingForUpdate = entityManager.find(Greeting.class, id);
        if(greetingForUpdate == null) {
            throw new NoGreetingsFoundException("No greetings found for given id - " + id);
        }
        greetingForUpdate.setType(greeting.getType());
        greetingForUpdate.setMessage(greeting.getMessage());
        entityManager.persist(greetingForUpdate);
        return true;
    }

    @Override
    public boolean deleteGreeting(int id) throws NoGreetingsFoundException {
        Greeting greetingForDelete = entityManager.find(Greeting.class, id);
        if(greetingForDelete == null) {
            throw new NoGreetingsFoundException("No greetings found for given id - " + id);
        }
        entityManager.remove(greetingForDelete);
        return true;
    }
}
