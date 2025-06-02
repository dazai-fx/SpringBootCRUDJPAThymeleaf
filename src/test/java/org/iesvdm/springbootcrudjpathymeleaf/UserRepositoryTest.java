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


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {
    @Autowired
    private UserRepository repo;

    @Test
    void testAddUser() {

        User user = new User();
        user.setEmail("jspro.com");
        user.setPassword("123456");
        user.setFirstName("pro");
        user.setLastName("js");

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





    }


}
