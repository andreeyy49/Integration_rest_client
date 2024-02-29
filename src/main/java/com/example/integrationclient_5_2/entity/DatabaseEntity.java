package com.example.integrationclient_5_2.entity;

import com.example.integrationclient_5_2.model.EntityModel;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DatabaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private Instant date;

    public static DatabaseEntity from(EntityModel model){
        return new DatabaseEntity(model.getId(), model.getName(), model.getDate());
    }
}
