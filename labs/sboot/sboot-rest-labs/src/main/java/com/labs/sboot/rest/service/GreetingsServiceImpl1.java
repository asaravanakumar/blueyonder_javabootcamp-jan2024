package com.labs.sboot.rest.service;

import com.labs.sboot.rest.dao.GreetingsDao;
import com.labs.sboot.rest.exception.GreetingsAppException;
import com.labs.sboot.rest.exception.GreetingsDataException;
import com.labs.sboot.rest.exception.NoGreetingsFoundException;
import com.labs.sboot.rest.model.Greeting;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Optional;

public class GreetingsServiceImpl1 implements GreetingsService1 {

//    private Map<Integer, Greeting> greetings = new HashMap<>();

    @Autowired
    private GreetingsDao greetingsDao;

    @Override
    public int addGreeting(Greeting greeting) throws GreetingsAppException {
//        int id = greetings.size() + 1;
//        greetings.put(id, greeting);
//        return id;
        int count = 0;
        try {
            count = greetingsDao.addGreeting(greeting);
        }catch (GreetingsDataException e) {
            throw new GreetingsAppException(e.getMessage(), e);
        }
        return count;
    }

    @Override
    public Optional<Greeting> getGreeting(int id) throws NoGreetingsFoundException, GreetingsAppException {
//        Greeting greeting = greetings.get(id);
//        return greeting != null ? Optional.of(greeting) : Optional.empty();
        Optional<Greeting> greetings = Optional.empty();
        try {
            greetings = greetingsDao.getGreeting(id);
        }catch (GreetingsDataException e) {
            throw new GreetingsAppException(e.getMessage(), e);
        }
        return greetings;
    }

    @Override
    public Collection<Greeting> getAllGreetings() {
//        return greetings.values();
        return greetingsDao.getAllGreetings();
    }

    @Override
    public boolean updateGreeting(int id, Greeting greeting) {
//        if(greetings.containsKey(id)) {
//            greetings.put(id, greeting);
//            return true;
//        }
//        return false;
        return greetingsDao.updateGreeting(id, greeting);
    }

    @Override
    public boolean deleteGreeting(int id) {
//        if(greetings.containsKey(id)) {
//            greetings.remove(id);
//            return true;
//        }
//        return false;
        return greetingsDao.deleteGreeting(id);
    }
}
