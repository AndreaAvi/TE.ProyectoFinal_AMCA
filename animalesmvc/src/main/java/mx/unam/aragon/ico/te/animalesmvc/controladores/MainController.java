package mx.unam.aragon.ico.te.animalesmvc.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Autora: Andrea Marcela Cáceres Avitia (Temas especiales de computación I 2025-II)
 * Proyecto: CRUD Spring MVC. Animales del mundo   Fecha: 05/06/2025
 * Clase: MainController.java
 * Descripción: Clase controladora responsable de gestionar las solicitudes relacionadas con las
 * rutas principales.
 */

@Controller
@RequestMapping("/home")
public class MainController {

    // Página principal
    @GetMapping("/")
    public String obtenerInicial() {
        return "index";
    }

    // Página de créditos (Portada)
    @GetMapping("/creditos")
    public String obtenerCreditos() {
        return "creditos";
    }
}
