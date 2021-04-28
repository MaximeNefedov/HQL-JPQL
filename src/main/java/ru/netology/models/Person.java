package ru.netology.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity(name = "persons")
public class Person implements Serializable {
    @EmbeddedId
    private ComposePersonId composePersonId;
    private String phoneNumber;
    private String cityOfLiving;
}
