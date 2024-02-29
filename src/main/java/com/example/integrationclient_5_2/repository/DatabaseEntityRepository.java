package com.example.integrationclient_5_2.repository;

import com.example.integrationclient_5_2.entity.DatabaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DatabaseEntityRepository extends JpaRepository<DatabaseEntity, UUID> {
}
