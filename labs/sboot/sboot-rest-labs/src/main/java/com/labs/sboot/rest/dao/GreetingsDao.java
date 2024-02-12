package com.labs.sboot.rest.dao;

import com.labs.sboot.rest.exception.GreetingsDataException;
import com.labs.sboot.rest.exception.NoGreetingsFoundException;
import com.labs.sboot.rest.model.Greeting;

import java.util.Collection;
import java.util.Optional;

public interface GreetingsDao {
    public int addGreeting(Greeting greeting) throws GreetingsDataException;
    public Optional<Greeting> getGreeting(int id) throws GreetingsDataException, NoGreetingsFoundException;
    public Collection<Greeting> getAllGreetings();
    public boolean updateGreeting(int id, Greeting greeting);
    public boolean deleteGreeting(int id);
}
