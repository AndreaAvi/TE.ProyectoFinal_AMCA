package mx.unam.aragon.ico.te.animalesmvc.controladores;

import mx.unam.aragon.ico.te.animalesmvc.modelos.Anfibio;
import mx.unam.aragon.ico.te.animalesmvc.servicios.AnfibioService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Autora: Andrea Marcela Cáceres Avitia (Temas especiales de computación I 2025-II)
 * Proyecto: CRUD Spring MVC. Animales del mundo   Fecha: 05/06/2025
 * Clase: AnfibioController.java
 * Descripción: Clase controladora responsable de gestionar las solicitudes relacionadas con "Anfibios".
 * Proporciona endpoints para operaciones CRUD y funcionalidades como renderizar páginas de menú y listar.
 */

@Controller
@RequestMapping("/anfibios")
public class AnfibioController {

    @Autowired
    private AnfibioService anfibioService;

    @GetMapping("/menu")
    public String menuAnfibios() {
        return "anfibios/menu";
    }

    @GetMapping("/detalle")
    public String anfibio(Model model){
        Anfibio anfibio = new Anfibio(
                1,
                "Rana venenosa dorada (Phyllobates aurotaenia)",
                0.05,
                "Bosques tropicales húmedos",
                "Insectívoro",
                "Colombia",
                7,
                "En peligro",
                "Ovíparo",
                true,
                true,
                "https://es.wikipedia.org/wiki/Phyllobates_aurotaenia",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/0/09/Pbaurotaenia2.jpg/500px-Pbaurotaenia2.jpg"
        );

        model.addAttribute("anfibio", anfibio);
        return "anfibios/detalle";
    }

    // READ del CRUD
    @GetMapping("/lista")
    public String listaAnfibios(Model model) {
        // Ejemplos para agregar/borrar:
        /*
        List<Anfibio> anfibios = List.of(
                new Anfibio(1, "Rana venenosa dorada (Phyllobates aurotaenia)", 0.05, "Bosques tropicales húmedos", "Insectívoro", "Colombia", 7, "En peligro", "Ovíparo", true, true, "https://es.wikipedia.org/wiki/Phyllobates_aurotaenia", "https://upload.wikimedia.org/wikipedia/commons/thumb/0/09/Pbaurotaenia2.jpg/500px-Pbaurotaenia2.jpg"),
                new Anfibio(2, "Salamandra común (Salamandra salamandra)", 0.2, "Bosques húmedos", "Carnívoro", "Europa", 20, "Preocupación menor", "Ovovivíparo", true, true, "https://es.wikipedia.org/wiki/Salamandra_salamandra", "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2f/Salamandrasauceda.jpg/1200px-Salamandrasauceda.jpg"),
                new Anfibio(3, "Sapo común (Bufo bufo)", 0.15, "Diversos hábitats", "Insectívoro", "Europa y Asia", 12, "Preocupación menor", "Ovíparo", true, false, "https://sierradebaza.org/Fichas_fauna/00_Anfibios/05-09_sapo-comun/1a500hembralanavacabraabril.jpg"),
                new Anfibio(4, "Ajolote (Ambystoma mexicanum)", 0.25, "Lagos y canales de Xochimilco", "Carnívoro", "México", 15, "En peligro crítico", "Ovíparo", false, true, "https://es.wikipedia.org/wiki/Ambystoma_mexicanum", "https://static.nationalgeographic.es/files/styles/image_3200/public/NationalGeographic_2697714.jpg?w=1900&h=1599")
        );*/

        try {
            List<Anfibio> anfibios = anfibioService.obtenerTodos();
            model.addAttribute("anfibios", anfibios);
            return "anfibios/lista";
        } catch (Exception ex) {
            LoggerFactory.getLogger(getClass()).error("Error al obtener anfibios", ex);
            model.addAttribute("mensaje", "No se pudo cargar la lista de anfibios.");
            return "error/general";
        }
    }

    @GetMapping("/modificar-lista")
    public String listaAnfibios2(Model model) {
        try {
            List<Anfibio> anfibios = anfibioService.obtenerTodos();
            model.addAttribute("anfibios", anfibios);
            return "anfibios/modificar-lista";
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
            Anfibio anfibio = anfibioService.buscarPorId(id);
            model.addAttribute("anfibio", anfibio);
            return "anfibios/modificar-form";
        } catch (Exception ex) {
            LoggerFactory.getLogger(getClass()).error("Error al cargar el formulario de modificación", ex);
            model.addAttribute("mensaje", "No se pudo cargar el formulario de modificación.");
            return "error/general";
        }
    }

    @PostMapping("/modificar")
    public String modificar(@ModelAttribute Anfibio anfibio, Model model) {
        try {
            LoggerFactory.getLogger(getClass()).info("Se ha modificado un anfibio: " + anfibio);
            anfibioService.guardarAnfibio(anfibio);
            return "redirect:/anfibios/modificar-lista?exito";
        } catch (Exception ex) {
            LoggerFactory.getLogger(getClass()).error("Error al modificar anfibio", ex);
            model.addAttribute("mensaje", "No se pudo modificar el anfibio.");
            return "error/general";
        }
    }

    // CREATE del CRUD
    @GetMapping("/nuevo")
    public String nuevo(Model model){
        Anfibio anfibio = new Anfibio();
        model.addAttribute("anfibio", anfibio);
        return "anfibios/nuevo-form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Anfibio anfibio, Model model) {
        try {
            LoggerFactory.getLogger(getClass()).info("Se ha guardado un anfibio: " + anfibio);
            anfibioService.guardarAnfibio(anfibio);
            return "redirect:/anfibios/lista?exito";
        } catch (Exception ex) {
            LoggerFactory.getLogger(getClass()).error("Error al guardar anfibio", ex);
            model.addAttribute("mensaje", "No se pudo guardar el anfibio.");
            return "error/general";
        }
    }

    // DELETE del CRUD
    @GetMapping("/eliminar-lista")
    public String listaAnfibiosEliminar(Model model) {
        try {
            List<Anfibio> anfibios = anfibioService.obtenerTodos();
            model.addAttribute("anfibios", anfibios);
            return "anfibios/eliminar-lista";
        } catch (Exception ex) {
            LoggerFactory.getLogger(getClass()).error("Error al obtener lista para eliminar", ex);
            model.addAttribute("mensaje", "No se pudo cargar la lista para eliminar.");
            return "error/general";
        }
    }

    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id, Model model) {
        try {
            LoggerFactory.getLogger(getClass()).info("Se ha eliminado un anfibio con ID: " + id);
            anfibioService.eliminarPorId(id);
            return "redirect:/anfibios/eliminar-lista?exito";
        } catch (Exception ex) {
            LoggerFactory.getLogger(getClass()).error("Error al eliminar anfibio con ID: " + id, ex);
            model.addAttribute("mensaje", "No se pudo eliminar el anfibio.");
            return "error/general";
        }
    }
}