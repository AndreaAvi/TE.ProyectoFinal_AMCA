/**
 * Autora: Andrea Marcela Cáceres Avitia (Temas especiales de computación I 2025-II)
 * Proyecto: CRUD Spring MVC. Animales del mundo   Fecha: 05/06/2025
 * Clase: ManejadorErroresGlobal.java
 * Descripción: Clase de manejo global de excepciones para el proyecto.
 * Utiliza la anotación @ControllerAdvice para capturar errores no controlados que se produzcan en los controladores.
 * Registra el error en los logs y muestra una vista amigable con un mensaje general al usuario.
 */

package mx.unam.aragon.ico.te.animalesmvc.excepciones;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ManejadorErroresGlobal {

    private final Logger logger = LoggerFactory.getLogger(ManejadorErroresGlobal.class);

    // Error general para todas las excepciones no controladas
    @ExceptionHandler(Exception.class)
    public String manejarExcepcionGeneral(Exception ex, Model model) {
        logger.error("Error general capturado: ", ex);
        model.addAttribute("mensaje", "Ocurrió un error inesperado. Intenta más tarde.");
        return "error/general";
    }

}
