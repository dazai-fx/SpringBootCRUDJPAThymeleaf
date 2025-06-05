package org.iesvdm.springbootcrudjpathymeleaf.user;

import jakarta.persistence.*;
import lombok.*;

@Entity //indica que esta clase es una entidad (tabla) en la base de datos
@Table(name = "users")//Especifica el nombre de la tabla en la base de datos que se mapeará con esta entidad
// --- ANOTACIONES DE LOMBOK ---
@Data // Genera automáticamente los métodos getters, setters, toString, equals y hashCode
@NoArgsConstructor // Genera Constructor vacío
@AllArgsConstructor // Genera Constructor con todos los parametros
public class User {
    @Id // Marca este campo como la clave primaria de la entidad
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Indica que el valor del campo 'id' se generará automáticamente (auto-incremental)
    private Integer id;
    @Column(nullable = false, unique = true, length = 45)
    // Define la columna 'email' con restricciones:
    // - No puede ser nulo
    // - Debe ser único
    // - Máximo 45 caracteres
    private String email;
    @Column(length = 15, nullable = false)
    private String password;
    @Column(length = 45, nullable = false, name="first_name")
    // Define la columna 'first_name':
    // - Se mapea con el nombre "first_name" en la base de datos
    // - No puede ser nulo
    // - Máximo 45 caracteres
    private String firstName;
    @Column(length = 45, nullable = false, name="last_name")
    private String lastName;

    private boolean enabled;

}
