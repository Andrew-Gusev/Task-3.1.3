package ru.itmentor.spring.boot_security.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "t_role")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String roleName;

    @Column
    @ManyToMany(mappedBy = "t_role")
    @Transient
    private Collection<User> users = new HashSet<>();

    @Override
    public String getAuthority() {
        return null;
    }
}
