package com.labs.sboot.rest.dao;

import com.labs.sboot.rest.exception.GreetingsDataException;
import com.labs.sboot.rest.exception.NoGreetingsFoundException;
import com.labs.sboot.rest.model.Greeting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Collection;
import java.util.Optional;

public class GreetingsDaoJdbcImpl implements GreetingsDao {

    private Logger log = LoggerFactory.getLogger(GreetingsDaoJdbcImpl.class);

    @Autowired
    private DataSource dataSource;
    private Connection conn = null;
    private Statement stmt = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    public GreetingsDaoJdbcImpl() {

    }

    private Connection getConnection() throws SQLException {
        if(conn == null) {
            return dataSource.getConnection();
        }
        return  conn;
    }

    @Override
    public int addGreeting(Greeting greeting) throws GreetingsDataException {
        String query = "INSERT INTO GREETINGS(type, message) VALUES(?,?)";
        int count = 0;
        try {
            pstmt = getConnection().prepareStatement(query);
            pstmt.setString(1, greeting.getType());
            pstmt.setString(2, greeting.getMessage());
            count = pstmt.executeUpdate();

        } catch (SQLException e) {
            String msg = "Error while inserting the greetings. " + e.getMessage();
            log.error(msg, e);
            throw new GreetingsDataException(msg, e);
        }
        return count;
    }

    @Override
    public Optional<Greeting> getGreeting(int id) throws GreetingsDataException, NoGreetingsFoundException {

        String query = "SELECT * FROM GREETINGS WHERE ID = ?";
        int count = 0;
        try {
            pstmt = getConnection().prepareStatement(query);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            Greeting greeting = null;
            while (rs.next()) {
                greeting = new Greeting();
                greeting.setId(rs.getInt("id"));
                greeting.setType(rs.getString("type"));
                greeting.setMessage(rs.getString("message"));
            }

            if(greeting == null) {
                String msg = "No matching greetings found for given id - " + id;
                log.error(msg);
                throw new NoGreetingsFoundException(msg);
            }

            return Optional.of(greeting);

        } catch (SQLException e) {
            String msg = "Error while fetching the greetings. " + e.getMessage();
            log.error(msg, e);
            throw new GreetingsDataException(msg, e);
        }
    }

    @Override
    public Collection<Greeting> getAllGreetings() {
        return null;
    }

    @Override
    public boolean updateGreeting(int id, Greeting greeting) {
        return false;
    }

    @Override
    public boolean deleteGreeting(int id) {
        return false;
    }
}
