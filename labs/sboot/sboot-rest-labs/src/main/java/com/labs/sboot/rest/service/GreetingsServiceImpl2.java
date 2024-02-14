package com.labs.sboot.rest.service;

import com.labs.sboot.rest.dao.GreetingsRepository;
import com.labs.sboot.rest.exception.GreetingsAppException;
import com.labs.sboot.rest.exception.NoGreetingsFoundException;
import com.labs.sboot.rest.model.Greeting;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class GreetingsServiceImpl2 implements GreetingsService1 {

    @Autowired
    GreetingsRepository greetingsRepo;

    @Override
    public int addGreeting(Greeting greeting) throws GreetingsAppException {
        Greeting savedGreeting = greetingsRepo.save(greeting);
        return savedGreeting.getId();
    }

    @Override
    public Optional<Greeting> getGreeting(int id) throws GreetingsAppException, NoGreetingsFoundException {
        return greetingsRepo.findById(id);
    }

    @Override
    public Collection<Greeting> getAllGreetings() {
        return greetingsRepo.findAll();
    }

    @Override
    public boolean updateGreeting(int id, Greeting greeting) throws NoGreetingsFoundException {
        Greeting greetingForUpdate = greetingsRepo.findById(id).orElseThrow(NoGreetingsFoundException::new);
        greetingForUpdate.setType(greeting.getType());
        greetingForUpdate.setMessage(greeting.getMessage());
        greetingsRepo.save(greetingForUpdate);
        return true;
    }

    @Override
    public boolean deleteGreeting(int id) throws NoGreetingsFoundException {
        Greeting greetingForUpdate = greetingsRepo.findById(id).orElseThrow(NoGreetingsFoundException::new);
        greetingsRepo.deleteById(id);
        return true;
    }

    @Override
    public List<Greeting> searchGreetings(String type) {
        return greetingsRepo.findByType(type);
    }

    @Override
    public List<Greeting> searchGreetings(String type, String message) {
//        return greetingsRepo.findByTypeAndMessageContaining(type, message);
        return greetingsRepo.findByTypeAndMessageLikeQuery(type, message);
    }
}
