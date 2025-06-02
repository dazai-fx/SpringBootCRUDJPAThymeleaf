package org.iesvdm.springbootcrudjpathymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("")// debe de estar vacío o con "/"
    public String showHomePage() {
        System.out.println("main controller");
        return "index"; // debemos de crear el archivo html index
    }

}
