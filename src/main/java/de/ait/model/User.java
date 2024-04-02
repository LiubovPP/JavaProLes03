package de.ait.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@Data // содержатся геттеры, сеттеры и toString
@Builder
@EqualsAndHashCode (onlyExplicitlyIncluded = true)

public class User {
    @EqualsAndHashCode.Include // относится к полю id, поэтому,чтобы указать, что методы hashCode() и equals() должны учитывать только это поле.
    private Long id;
    private String name;
    private String email;
}

