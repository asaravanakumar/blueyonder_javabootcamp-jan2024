package com.labs.sboot.rest.dao;

import com.labs.sboot.rest.exception.GreetingsDataException;
import com.labs.sboot.rest.exception.NoGreetingsFoundException;
import com.labs.sboot.rest.model.Greeting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;

import java.sql.PreparedStatement;
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
        String query = "UPDATE GREETINGS SET TYPE = ?, MESSAGE = ? WHERE ID = ?";
        return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                ps.setString(1, greeting.getType());
                ps.setString(2, greeting.getMessage());
                ps.setInt(3, id);
                return ps.executeUpdate() > 0 ? true : false;
            }
        });
    }

    @Override
    public boolean deleteGreeting(int id) {
        String query = "DELETE FROM GREETINGS WHERE ID = ?";
        return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                ps.setInt(1, id);
                return ps.executeUpdate() > 0 ? true : false;
            }
        });    }

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
