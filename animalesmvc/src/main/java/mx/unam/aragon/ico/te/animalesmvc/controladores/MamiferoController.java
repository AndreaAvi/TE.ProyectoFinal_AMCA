package mx.unam.aragon.ico.te.animalesmvc.controladores;

import mx.unam.aragon.ico.te.animalesmvc.modelos.Mamifero;
import mx.unam.aragon.ico.te.animalesmvc.servicios.MamiferoService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Autora: Andrea Marcela Cáceres Avitia (Temas especiales de computación I 2025-II)
 * Proyecto: CRUD Spring MVC. Animales del mundo   Fecha: 05/06/2025
 * Clase: MamiferoController.java
 * Descripción: Clase controladora responsable de gestionar las solicitudes relacionadas con "Mamíferos".
 * Proporciona endpoints para operaciones CRUD y funcionalidades como renderizar páginas de menú y listar.
 */

@Controller
@RequestMapping("/mamiferos")
public class MamiferoController {

    @Autowired
    private MamiferoService mamiferoService;

    @GetMapping("/menu")
    public String menuMamiferos() {
        return "mamiferos/menu";
    }

    @GetMapping("/detalle")
    public String mamifero(Model model){
        Mamifero mamifero = new Mamifero(
                1,
                "Jaguar (Panthera onca)",
                1.8,
                "Selva tropical",
                "Carnívoro",
                "América Central y Sur",
                12,
                "Vulnerable",
                "https://es.wikipedia.org/wiki/Jaguar",
                "https://files.worldwildlife.org/wwfcmsprod/images/Jaguar_GPN7474/story_full_width/4q517ahb0m_Responsible_Forestry_8.10.2012_Biodiversiry_Loss_HI_7474.jpg"
        );

        model.addAttribute("mamifero", mamifero);
        return "mamiferos/detalle";
    }

    // READ del CRUD
    @GetMapping("/lista")
    public String listaMamiferos(Model model) {
        // Simulación previa:
        /*
        List<Mamifero> mamiferos = List.of(
                new Mamifero(1, "Jaguar (Panthera onca)", 1.8, "Selva tropical", "Carnívoro", "América Central y Sur", 12, "Vulnerable", "https://es.wikipedia.org/wiki/Jaguar", "https://files.worldwildlife.org/wwfcmsprod/images/Jaguar_GPN7474/story_full_width/4q517ahb0m_Responsible_Forestry_8.10.2012_Biodiversiry_Loss_HI_7474.jpg"),
                new Mamifero(2, "Lobo gris (Canis lupus)", 1.2, "Bosques y tundras", "Carnívoro", "América del Norte y Eurasia", 13, "Preocupación menor", "https://es.wikipedia.org/wiki/Lobo", "https://www.telemundo.com/sites/nbcutelemundo/files/images/promo/article/2017/05/02/lobo-gris-mexicano.jpg"),
                new Mamifero(3, "Elefante africano (Loxodonta)", 3.3, "Sabana", "Herbívoro", "África", 60, "Vulnerable", "https://es.wikipedia.org/wiki/Elefante_africano", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcST6BnN2Nvej56plqy27ajZnOSMeNEkUJgjNw&s"),
                new Mamifero(4, "Elefante africano (Loxodonta)", 3.3, "Sabana", "Herbívoro", "África", 60, "Vulnerable", "https://es.wikipedia.org/wiki/Elefante_africano", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcST6BnN2Nvej56plqy27ajZnOSMeNEkUJgjNw&s")
        );*/

        try {
            List<Mamifero> mamiferos = mamiferoService.obtenerTodos();
            model.addAttribute("mamiferos", mamiferos);
            return "mamiferos/lista";
        } catch (Exception ex) {
            LoggerFactory.getLogger(getClass()).error("Error al obtener mamíferos", ex);
            model.addAttribute("mensaje", "No se pudo cargar la lista de mamíferos.");
            return "error/general";
        }
    }

    @GetMapping("/modificar-lista")
    public String listaMamiferos2(Model model) {
        try {
            List<Mamifero> mamiferos = mamiferoService.obtenerTodos();
            model.addAttribute("mamiferos", mamiferos);
            return "mamiferos/modificar-lista";
        } catch (Exception ex) {
            LoggerFactory.getLogger(getClass()).error("Error al obtener lista para modificar", ex);
            model.addAttribute("mensaje", "No se pudo cargar la lista para modificar.");
            return "error/general";
        }
    }

    // UPDATE del CRUD
    @GetMapping("/modificar/{id}")
    public String mostrarFormularioModificacion(@PathVariable int id, Model model) {
        // Simulación previa
        /*
        Mamifero mamifero = new Mamifero(
                id,
                "Tigre de Bengala",
                3.1,
                "Selvas tropicales y manglares",
                "Carnívoro",
                "Asia (principalmente India y Bangladés)",
                15,
                "En peligro",
                "https://es.wikipedia.org/wiki/Tigre_de_Bengala",
                "https://upload.wikimedia.org/wikipedia/commons/5/56/Tigre_de_Bengala.jpg"
        );*/
        try {
            Mamifero mamifero = mamiferoService.buscarPorId(id);
            model.addAttribute("mamifero", mamifero);
            return "mamiferos/modificar-form";
        } catch (Exception ex) {
            LoggerFactory.getLogger(getClass()).error("Error al cargar el formulario de modificación", ex);
            model.addAttribute("mensaje", "No se pudo cargar el formulario de modificación.");
            return "error/general";
        }
    }

    @PostMapping("/modificar")
    public String modificar(@ModelAttribute Mamifero mamifero, Model model) {
        try {
            LoggerFactory.getLogger(getClass()).info("Se ha modificado un mamífero: " + mamifero);
            mamiferoService.guardarMamifero(mamifero);
            return "redirect:/mamiferos/modificar-lista?exito";
        } catch (Exception ex) {
            LoggerFactory.getLogger(getClass()).error("Error al modificar mamífero", ex);
            model.addAttribute("mensaje", "No se pudo modificar el mamífero.");
            return "error/general";
        }
    }

    // CREATE del CRUD
    @GetMapping("/nuevo")
    public String nuevo(Model model){
        Mamifero mamifero = new Mamifero();
        model.addAttribute("mamifero", mamifero);
        return "mamiferos/nuevo-form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Mamifero mamifero, Model model) {
        try {
            LoggerFactory.getLogger(getClass()).info("Se ha guardado un mamífero: " + mamifero);
            mamiferoService.guardarMamifero(mamifero);
            return "redirect:/mamiferos/lista?exito";
        } catch (Exception ex) {
            LoggerFactory.getLogger(getClass()).error("Error al guardar mamífero", ex);
            model.addAttribute("mensaje", "No se pudo guardar el mamífero.");
            return "error/general";
        }
    }

    // DELETE del CRUD
    @GetMapping("/eliminar-lista")
    public String listaMamiferosEliminar(Model model) {
        try {
            List<Mamifero> mamiferos = mamiferoService.obtenerTodos();
            model.addAttribute("mamiferos", mamiferos);
            return "mamiferos/eliminar-lista";
        } catch (Exception ex) {
            LoggerFactory.getLogger(getClass()).error("Error al obtener lista para eliminar", ex);
            model.addAttribute("mensaje", "No se pudo cargar la lista para eliminar.");
            return "error/general";
        }
    }

    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id, Model model) {
        try {
            LoggerFactory.getLogger(getClass()).info("Se ha eliminado un mamífero con ID: " + id);
            mamiferoService.eliminarPorId(id);
            return "redirect:/mamiferos/eliminar-lista?exito";
        } catch (Exception ex) {
            LoggerFactory.getLogger(getClass()).error("Error al eliminar mamífero con ID: " + id, ex);
            model.addAttribute("mensaje", "No se pudo eliminar el mamífero.");
            return "error/general";
        }
    }
}
