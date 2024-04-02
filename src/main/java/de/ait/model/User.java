package de.ait.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder

public class User {
    private Long id;
    private String name;
    private String email;
}

