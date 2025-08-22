package dev.java10x.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import java.util.UUID;

@Entity
public class Users extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;
    public String username;
    public String email;

}
