/**
 * Autora: Andrea Marcela Cáceres Avitia (Temas especiales de computación I 2025-II)
 * Proyecto: CRUD Spring MVC. Animales del mundo   Fecha: 05/06/2025
 * Clase: PezController.java
 * Descripción: Clase controladora responsable de gestionar las solicitudes relacionadas con "Peces".
 * Proporciona endpoints para operaciones CRUD y funcionalidades como renderizar páginas de menú y listar.
 * Proporciona un manejo de errores simple.
 *
 */
package mx.unam.aragon.ico.te.animalesmvc.controladores;

import mx.unam.aragon.ico.te.animalesmvc.modelos.Pez;
import mx.unam.aragon.ico.te.animalesmvc.servicios.PezService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/peces")
public class PezController {

    @Autowired
    private PezService pezService;

    @GetMapping("/menu")
    public String menuPeces() {
        return "peces/menu";
    }

    @GetMapping("/detalle")
    public String pez(Model model){
        Pez pez = new Pez(
                1,
                "Tiburón blanco (Carcharodon carcharias)",
                6.0,
                "Océanos templados y tropicales",
                "Carnívoro",
                "Océanos de todo el mundo",
                30,
                "Vulnerable",
                "https://es.wikipedia.org/wiki/Tiburón_blanco",
                "https://mymodernmet.com/wp/wp-content/uploads/2020/11/great-white-shark-photo-1.jpg",
                "Salada",
                1200,
                "Fusiforme",
                false
        );

        model.addAttribute("pez", pez);
        return "peces/detalle";
    }

    // READ del CRUD
    @GetMapping("/lista")
    public String listaPeces(Model model) {
        try {
            List<Pez> peces = pezService.obtenerTodos();
            model.addAttribute("peces", peces);
            return "peces/lista";
        } catch (Exception ex) {
            LoggerFactory.getLogger(getClass()).error("Error al obtener peces", ex);
            model.addAttribute("mensaje", "No se pudo cargar la lista de peces.");
            return "error/general";
        }
    }

    @GetMapping("/modificar-lista")
    public String listaPeces2(Model model) {
        try {
            List<Pez> peces = pezService.obtenerTodos();
            model.addAttribute("peces", peces);
            return "peces/modificar-lista";
        } catch (Exception ex) {
            LoggerFactory.getLogger(getClass()).error("Error al obtener lista para modificar", ex);
            model.addAttribute("mensaje", "No se pudo cargar la lista para modificar.");
            return "error/general";
        }
    }

    // UPDATE del CRUD
    @GetMapping("/modificar/{id}")
    public String mostrarFormularioModificacion(@PathVariable int id, Model model) {
        try {
            Pez pez = pezService.buscarPorId(id);
            model.addAttribute("pez", pez);
            return "peces/modificar-form";
        } catch (Exception ex) {
            LoggerFactory.getLogger(getClass()).error("Error al cargar el formulario de modificación", ex);
            model.addAttribute("mensaje", "No se pudo cargar el formulario de modificación.");
            return "error/general";
        }
    }

    @PostMapping("/modificar")
    public String modificar(@ModelAttribute Pez pez, Model model) {
        try {
            LoggerFactory.getLogger(getClass()).info("Se ha modificado un pez: " + pez);
            pezService.guardarPez(pez);
            return "redirect:/peces/modificar-lista?exito";
        } catch (Exception ex) {
            LoggerFactory.getLogger(getClass()).error("Error al modificar pez", ex);
            model.addAttribute("mensaje", "No se pudo modificar el pez.");
            return "error/general";
        }
    }

    // CREATE del CRUD
    @GetMapping("/nuevo")
    public String nuevo(Model model){
        Pez pez = new Pez();
        model.addAttribute("pez", pez);
        return "peces/nuevo-form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Pez pez, Model model) {
        try {
            LoggerFactory.getLogger(getClass()).info("Se ha guardado un pez: " + pez);
            pezService.guardarPez(pez);
            return "redirect:/peces/lista?exito";
        } catch (Exception ex) {
            LoggerFactory.getLogger(getClass()).error("Error al guardar pez", ex);
            model.addAttribute("mensaje", "No se pudo guardar el pez.");
            return "error/general";
        }
    }

    // DELETE del CRUD
    @GetMapping("/eliminar-lista")
    public String listaPecesEliminar(Model model) {
        try {
            List<Pez> peces = pezService.obtenerTodos();
            model.addAttribute("peces", peces);
            return "peces/eliminar-lista";
        } catch (Exception ex) {
            LoggerFactory.getLogger(getClass()).error("Error al obtener lista para eliminar", ex);
            model.addAttribute("mensaje", "No se pudo cargar la lista para eliminar.");
            return "error/general";
        }
    }

    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id, Model model) {
        try {
            LoggerFactory.getLogger(getClass()).info("Se ha eliminado un pez con ID: " + id);
            pezService.eliminarPorId(id);
            return "redirect:/peces/eliminar-lista?exito";
        } catch (Exception ex) {
            LoggerFactory.getLogger(getClass()).error("Error al eliminar pez con ID: " + id, ex);
            model.addAttribute("mensaje", "No se pudo eliminar el pez.");
            return "error/general";
        }
    }
}