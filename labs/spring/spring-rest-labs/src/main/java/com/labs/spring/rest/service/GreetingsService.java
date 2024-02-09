package com.labs.spring.rest.service;

import java.util.HashMap;
import java.util.Map;

public interface GreetingsService {

    public int addGreeting(String message);
    public String getGreeting(int id);

    public boolean updateGreeting(int id, String message);

    public boolean deleteGreeting(int id);
}
