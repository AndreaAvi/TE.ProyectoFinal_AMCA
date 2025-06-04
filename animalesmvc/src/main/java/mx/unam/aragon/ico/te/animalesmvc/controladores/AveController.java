package mx.unam.aragon.ico.te.animalesmvc.controladores;

import mx.unam.aragon.ico.te.animalesmvc.modelos.Ave;
import mx.unam.aragon.ico.te.animalesmvc.servicios.AveService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/aves")
public class AveController {

    @Autowired
    private AveService aveService;

    @GetMapping("/menu")
    public String menuAves() {
        return "aves/menu";
    }

    @GetMapping("/detalle")
    public String ave(Model model){
        Ave ave = new Ave(
                1,
                "Guacamaya roja (Ara macao)",
                0.9,
                "Selva tropical",
                "Frugívoro",
                "América Central y del Sur",
                50,
                "Preocupación menor",
                "planeador",
                true,
                "https://es.wikipedia.org/wiki/Ara_macao",
                "https://cdn0.bioenciclopedia.com/es/posts/9/3/1/guacamayo_rojo_139_orig.jpg"

        );

        model.addAttribute("ave", ave);
        return "aves/detalle";
    }

    @GetMapping("/lista")
    public String listaAves(Model model) {
        try {
            List<Ave> aves = aveService.obtenerTodas();
            model.addAttribute("aves", aves);
            return "aves/lista";
        } catch (Exception ex) {
            LoggerFactory.getLogger(getClass()).error("Error al obtener aves", ex);
            model.addAttribute("mensaje", "No se pudo cargar la lista de aves.");
            return "error/general";
        }
    }

    @GetMapping("/modificar-lista")
    public String listaAvesModificar(Model model) {
        try {
            List<Ave> aves = aveService.obtenerTodas();
            model.addAttribute("aves", aves);
            return "aves/modificar-lista";
        } catch (Exception ex) {
            LoggerFactory.getLogger(getClass()).error("Error al obtener lista para modificar", ex);
            model.addAttribute("mensaje", "No se pudo cargar la lista para modificar.");
            return "error/general";
        }
    }

    @GetMapping("/modificar/{id}")
    public String mostrarFormularioModificacion(@PathVariable int id, Model model) {
        try {
            Ave ave = aveService.buscarPorId(id);
            model.addAttribute("ave", ave);
            return "aves/modificar-form";
        } catch (Exception ex) {
            LoggerFactory.getLogger(getClass()).error("Error al cargar el formulario de modificación", ex);
            model.addAttribute("mensaje", "No se pudo cargar el formulario de modificación.");
            return "error/general";
        }
    }

    @PostMapping("/modificar")
    public String modificar(@ModelAttribute Ave ave, Model model) {
        try {
            LoggerFactory.getLogger(getClass()).info("Se ha modificado un ave: " + ave);
            aveService.guardarAve(ave);
            return "redirect:/aves/modificar-lista?exito";
        } catch (Exception ex) {
            LoggerFactory.getLogger(getClass()).error("Error al modificar ave", ex);
            model.addAttribute("mensaje", "No se pudo modificar el ave.");
            return "error/general";
        }
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model){
        Ave ave = new Ave();
        model.addAttribute("ave", ave);
        return "aves/nuevo-form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Ave ave, Model model) {
        try {
            LoggerFactory.getLogger(getClass()).info("Se ha guardado un ave: " + ave);
            aveService.guardarAve(ave);
            return "redirect:/aves/lista?exito";
        } catch (Exception ex) {
            LoggerFactory.getLogger(getClass()).error("Error al guardar ave", ex);
            model.addAttribute("mensaje", "No se pudo guardar el ave.");
            return "error/general";
        }
    }

    @GetMapping("/eliminar-lista")
    public String listaAvesEliminar(Model model) {
        try {
            List<Ave> aves = aveService.obtenerTodas();
            model.addAttribute("aves", aves);
            return "aves/eliminar-lista";
        } catch (Exception ex) {
            LoggerFactory.getLogger(getClass()).error("Error al obtener lista para eliminar", ex);
            model.addAttribute("mensaje", "No se pudo cargar la lista para eliminar.");
            return "error/general";
        }
    }

    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id, Model model) {
        try {
            LoggerFactory.getLogger(getClass()).info("Se ha eliminado un ave con ID: " + id);
            aveService.eliminarPorId(id);
            return "redirect:/aves/eliminar-lista?exito";
        } catch (Exception ex) {
            LoggerFactory.getLogger(getClass()).error("Error al eliminar ave con ID: " + id, ex);
            model.addAttribute("mensaje", "No se pudo eliminar el ave.");
            return "error/general";
        }
    }
}
