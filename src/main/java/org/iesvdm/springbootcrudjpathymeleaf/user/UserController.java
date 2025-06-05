package org.iesvdm.springbootcrudjpathymeleaf.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {

    @Autowired private UserService userService;

    @GetMapping("/users")
    public String users(Model model) {
        List<User> listUsers =userService.listAll();
        model.addAttribute("listUsers", listUsers);

        return "users";
    }

    @GetMapping("/users/new")
    public String showNewUserForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("pageTitle", "Añadir usuario");
        return "user_form";
    }

    @PostMapping("/users/save")
    public String saveUser(User user, RedirectAttributes ra) {
        userService.save(user);

        ra.addFlashAttribute("message", "El usuario ha sido guardado correctamente");

        return "redirect:/users";

    }

    @GetMapping("/users/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model, RedirectAttributes ra) {
        try {
            User user = userService.get(id);
            model.addAttribute("user", user);
            model.addAttribute("pageTitle", "Editar usuario (ID: " + id + ")");
        } catch (UserNotFoundException e) {
            e.printStackTrace();
            ra.addFlashAttribute("message", "El usuario no existe");
            return "redirect:/users";
        }
        return "user_form";
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable Integer id, RedirectAttributes ra) {
        try {
            userService.delete(id);
            ra.addFlashAttribute("message", "El usuario con id: " + id + " ha sido eliminado correctamente");
        } catch (UserNotFoundException e) {
            e.printStackTrace();
            ra.addFlashAttribute("message", e.getMessage());

        }
        return "redirect:/users";
    }

}
