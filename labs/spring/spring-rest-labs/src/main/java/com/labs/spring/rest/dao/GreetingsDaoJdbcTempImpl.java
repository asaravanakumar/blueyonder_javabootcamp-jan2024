package com.labs.spring.rest.dao;

import com.labs.spring.rest.exception.GreetingsDataException;
import com.labs.spring.rest.exception.NoGreetingsFoundException;
import com.labs.spring.rest.model.Greeting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class GreetingsDaoJdbcTempImpl implements GreetingsDao{
    private Logger log = LoggerFactory.getLogger(GreetingsDaoJdbcTempImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int addGreeting(Greeting greeting) throws GreetingsDataException {
        String query = "INSERT INTO GREETINGS(TYPE,MESSAGE) VALUES('" + greeting.getType() + "','" + greeting.getMessage() + "')";
        jdbcTemplate.execute(query);
        return -1;
    }

    @Override
    public Optional<Greeting> getGreeting(int id) throws GreetingsDataException, NoGreetingsFoundException {
        String query = "SELECT * FROM GREETINGS WHERE ID = " + id;
        List<Greeting> greetings = jdbcTemplate.query(query, new GreetingsRowMapper());

        if(greetings.size() < 0) {
            String msg = "No matching greetings found for given id - " + id;
            log.error(msg);
            throw new NoGreetingsFoundException(msg);
        }
        return Optional.of(greetings.getFirst());
    }

    @Override
    public Collection<Greeting> getAllGreetings() {
        String query = "SELECT * FROM GREETINGS";
        List<Greeting> greetings = jdbcTemplate.query(query, new GreetingsRowMapper());
        return greetings;
    }

    @Override
    public boolean updateGreeting(int id, Greeting greeting) {
        return false;
    }

    @Override
    public boolean deleteGreeting(int id) {
        return false;
    }

    // Maps Greetings table record to Greetings object. Returns List of Greetings object.
    class GreetingsRowMapper implements RowMapper<Greeting> {

        @Override
        public Greeting mapRow(ResultSet rs, int rowNum) throws SQLException {
            Greeting greeting = new Greeting();
            greeting.setId(rs.getInt("id"));
            greeting.setType(rs.getString("type"));
            greeting.setMessage(rs.getString("message"));
            return greeting;
        }
    }
}
