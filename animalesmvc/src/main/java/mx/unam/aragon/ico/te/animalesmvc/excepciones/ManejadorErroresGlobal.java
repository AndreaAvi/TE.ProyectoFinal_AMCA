package mx.unam.aragon.ico.te.animalesmvc.excepciones;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ManejadorErroresGlobal {

    private final Logger logger = LoggerFactory.getLogger(ManejadorErroresGlobal.class);

    // Error general para todas las excepciones no controladas
    @ExceptionHandler(Exception.class)
    public String manejarExcepcionGeneral(Exception ex, Model model) {
        logger.error("Error general capturado: ", ex);
        model.addAttribute("mensaje", "Ocurrió un error inesperado. Intenta más tarde.");
        return "error/general"; // templates/error/general.html
    }

}
