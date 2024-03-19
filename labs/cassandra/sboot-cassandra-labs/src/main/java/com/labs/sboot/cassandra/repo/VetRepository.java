package com.labs.sboot.cassandra.repo;

import java.util.UUID;

import com.labs.sboot.cassandra.model.Vet;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CassandraRepository<Vet, UUID> {
    Vet findByFirstName(String username);
}
