package com.labs.sboot.rest.service;

public interface GreetingsService {

    public int addGreeting(String message);
    public String getGreeting(int id);

    public boolean updateGreeting(int id, String message);

    public boolean deleteGreeting(int id);
}
