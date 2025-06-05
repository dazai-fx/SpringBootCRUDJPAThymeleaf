package org.iesvdm.springbootcrudjpathymeleaf.user;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> { //extenedemos de crudRepository <Clase, tipo-de-dato-de-id>

    public Long countById(Integer id);// JPA entiende y genera el correspondiente sql statement por la convención del nombre del método

}
