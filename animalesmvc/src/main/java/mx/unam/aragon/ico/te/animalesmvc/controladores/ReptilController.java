package mx.unam.aragon.ico.te.animalesmvc.controladores;

import mx.unam.aragon.ico.te.animalesmvc.modelos.Reptil;
import mx.unam.aragon.ico.te.animalesmvc.servicios.ReptilService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/reptiles")
public class ReptilController {

    @Autowired
    private ReptilService reptilService;

    @GetMapping("/menu")
    public String menuReptiles() {
        return "reptiles/menu";
    }

    @GetMapping("/detalle")
    public String reptil(Model model){
        Reptil reptil = new Reptil(
                1,
                "Iguana verde (Iguana iguana)",
                "Selvas tropicales y bosques",
                "Herbívoro",
                "América Central y del Sur",
                20,
                "Preocupación menor",
                false,
                true,
                1.5,
                "https://es.wikipedia.org/wiki/Iguana_iguana",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQBkFwed2xvGNpv05SR-q6UKGLREtHCK7zVqQ&s"
        );

        model.addAttribute("reptil", reptil);
        return "reptiles/detalle";
    }

    // READ del CRUD
    @GetMapping("/lista")
    public String listaReptiles(Model model) {
        // Simulación previa:
        /*
        List<Reptil> reptiles = List.of(
                new Reptil(1, "Iguana verde (Iguana iguana)", "Selvas tropicales", "Herbívoro", "América Central y del Sur", 20, "Preocupación menor", false, true, 1.5, "https://es.wikipedia.org/wiki/Iguana_iguana", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQBkFwed2xvGNpv05SR-q6UKGLREtHCK7zVqQ&s"),
                new Reptil(2, "Cobra real (Ophiophagus hannah)", "Bosques tropicales", "Carnívoro", "Asia", 18, "Vulnerable", true, true, 3.7, "https://es.wikipedia.org/wiki/Ophiophagus_hannah", "https://upload.wikimedia.org/wikipedia/commons/6/66/Indiancobra.jpg"),
                new Reptil(3, "Tortuga galápagos (Chelonoidis nigra)", "Islas volcánicas", "Herbívoro", "Islas Galápagos", 100, "Vulnerable", false, true, 1.2, "https://es.wikipedia.org/wiki/Chelonoidis_nigra", "https://static.wikia.nocookie.net/wikia_tortuga/images/9/99/Tortuga-rusa.jpg/revision/latest?cb=20200526211233&path-prefix=es"),
                new Reptil(4, "Gecko tokay (Gekko gecko)", "Bosques tropicales", "Insectívoro", "Sudeste asiático", 10, "Preocupación menor", false, true, 0.35, "https://es.wikipedia.org/wiki/Gekko_gecko", "https://zooloexoticos.wordpress.com/wp-content/uploads/2018/07/8501263358_0cebba7ef2_o.jpg?w=1400")
        );*/

        try {
            List<Reptil> reptiles = reptilService.obtenerTodos();
            model.addAttribute("reptiles", reptiles);
            return "reptiles/lista";
        } catch (Exception ex) {
            LoggerFactory.getLogger(getClass()).error("Error al obtener reptiles", ex);
            model.addAttribute("mensaje", "No se pudo cargar la lista de reptiles.");
            return "error/general";
        }
    }

    @GetMapping("/modificar-lista")
    public String listaReptiles2(Model model) {
        try {
            List<Reptil> reptiles = reptilService.obtenerTodos();
            model.addAttribute("reptiles", reptiles);
            return "reptiles/modificar-lista";
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
        Reptil reptil = new Reptil(
                id,
                "Pitón birmana (Python bivittatus)",
                "Bosques tropicales y pantanos",
                "Carnívoro",
                "Sudeste asiático",
                20,
                "Vulnerable",
                false,
                true,
                5.74,
                "https://es.wikipedia.org/wiki/Python_bivittatus",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTk1HIbd9gpKbrziyy3f0jC1kbIvcP23CIPbQ&s"
        );*/
        try {
            Reptil reptil = reptilService.buscarPorId(id);
            model.addAttribute("reptil", reptil);
            return "reptiles/modificar-form";
        } catch (Exception ex) {
            LoggerFactory.getLogger(getClass()).error("Error al cargar el formulario de modificación", ex);
            model.addAttribute("mensaje", "No se pudo cargar el formulario de modificación.");
            return "error/general";
        }
    }

    @PostMapping("/modificar")
    public String modificar(@ModelAttribute Reptil reptil, Model model) {
        try {
            LoggerFactory.getLogger(getClass()).info("Se ha modificado un reptil: " + reptil);
            reptilService.guardarReptil(reptil);
            return "redirect:/reptiles/modificar-lista?exito";
        } catch (Exception ex) {
            LoggerFactory.getLogger(getClass()).error("Error al modificar reptil", ex);
            model.addAttribute("mensaje", "No se pudo modificar el reptil.");
            return "error/general";
        }
    }

    // CREATE del CRUD
    @GetMapping("/nuevo")
    public String nuevo(Model model){
        Reptil reptil = new Reptil();
        model.addAttribute("reptil", reptil);
        return "reptiles/nuevo-form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Reptil reptil, Model model) {
        try {
            LoggerFactory.getLogger(getClass()).info("Se ha guardado un reptil: " + reptil);
            reptilService.guardarReptil(reptil);
            return "redirect:/reptiles/lista?exito";
        } catch (Exception ex) {
            LoggerFactory.getLogger(getClass()).error("Error al guardar reptil", ex);
            model.addAttribute("mensaje", "No se pudo guardar el reptil.");
            return "error/general";
        }
    }

    // DELETE del CRUD
    @GetMapping("/eliminar-lista")
    public String listaReptilesEliminar(Model model) {
        try {
            List<Reptil> reptiles = reptilService.obtenerTodos();
            model.addAttribute("reptiles", reptiles);
            return "reptiles/eliminar-lista";
        } catch (Exception ex) {
            LoggerFactory.getLogger(getClass()).error("Error al obtener lista para eliminar", ex);
            model.addAttribute("mensaje", "No se pudo cargar la lista para eliminar.");
            return "error/general";
        }
    }

    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id, Model model) {
        try {
            LoggerFactory.getLogger(getClass()).info("Se ha eliminado un reptil con ID: " + id);
            reptilService.eliminarPorId(id);
            return "redirect:/reptiles/eliminar-lista?exito";
        } catch (Exception ex) {
            LoggerFactory.getLogger(getClass()).error("Error al eliminar reptil con ID: " + id, ex);
            model.addAttribute("mensaje", "No se pudo eliminar el reptil.");
            return "error/general";
        }
    }
}