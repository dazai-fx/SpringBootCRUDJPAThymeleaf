package org.iesvdm.springbootcrudjpathymeleaf;

import org.iesvdm.springbootcrudjpathymeleaf.user.User;
import org.iesvdm.springbootcrudjpathymeleaf.user.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest// Prueba solo de la capa JPA (entidades y repositorios)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // Usa la base de datos real definida en application.properties (no la H2 en memoria)
@Rollback(false) //  No revierte los cambios al finalizar el test (guarda en la base de datos)
public class UserRepositoryTest {

    @Autowired // Inyecta el repositorio para hacer pruebas con él
    private UserRepository repo;

    @Test
    void testAddUser() {

        User user = new User();
        user.setEmail("klopezfj@gmail.com");
        user.setPassword("123456");
        user.setFirstName("karl ");
        user.setLastName("López");

        User savedUser = repo.save(user);

        assertThat(savedUser).isNotNull();
        assertThat(savedUser.getId() > 0).isTrue();

    }

    @Test
    void testListAll(){

        Iterable<User> users = repo.findAll();

        Assertions.assertNotNull(users);
        assertThat(users).hasSizeGreaterThan(0);

        for(User user : users){
            System.out.println(user);
        }

    }

    @Test
    void testUpdate(){

        Integer userId = 1;

        Optional<User> optionalUser= repo.findById(userId);

        User user = optionalUser.get();

        user.setPassword("hellooooo");
        repo.save(user);

        User updatedUser = repo.findById(userId).get();

        Assertions.assertEquals("hellooooo", updatedUser.getPassword());

    }

    @Test
    void testGet(){
        Integer userId = 1;
        Optional<User> optionalUser= repo.findById(userId);
        assertThat(optionalUser.isPresent()).isTrue();
        System.out.println(optionalUser.get());

    }

    @Test
    void testDelete(){
        Integer userId = 2;
        repo.deleteById(userId);
        Optional<User> optionalUser= repo.findById(userId);
        assertThat(optionalUser.isPresent()).isFalse();
    }


}
