package org.iesvdm.springbootcrudjpathymeleaf.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired private UserRepository userRepository;

    public List<User> listAll(){
        return (List<User>)userRepository.findAll(); // casteamos a lista porque findAll devuelve un Iterable
    }

    public void save(User user){
        userRepository.save(user);
    }

    public User get(Integer id) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }
        throw new UserNotFoundException("No se encontro usuario "+id);
    }

    public void delete(Integer id) throws UserNotFoundException {
        Long count = userRepository.countById(id);
        if(count == 0 || count == null){
            throw new UserNotFoundException("No se encontro usuario "+id);
        }
        userRepository.deleteById(id);


    }

}
