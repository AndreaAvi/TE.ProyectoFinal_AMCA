package mx.unam.aragon.ico.te.animalesmvc.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class MainController {

    // Página principal
    @GetMapping("/")
    public String obtenerInicial() {
        return "index";  // Thymeleaf buscará src/main/resources/templates/index.html
    }

    // Página de créditos (Portada)
    @GetMapping("/creditos")
    public String obtenerCreditos() {
        return "creditos"; // src/main/resources/templates/creditos.html
    }
}
