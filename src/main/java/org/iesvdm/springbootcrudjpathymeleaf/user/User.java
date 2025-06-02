package org.iesvdm.springbootcrudjpathymeleaf.user;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
//anotaciones de lombok
@Data // Incluye getters, setters, toString, equals y hashCode
@NoArgsConstructor // Constructor vacío
@AllArgsConstructor // Constructor con todos los campos
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true, length = 45)
    private String email;
    @Column(length = 15, nullable = false)
    private String password;
    @Column(length = 45, nullable = false, name="first_name")
    private String firstName;
    @Column(length = 45, nullable = false, name="last_name")
    private String lastName;

}
