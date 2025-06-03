package mx.unam.aragon.ico.te.animalesmvc.controladores;

import mx.unam.aragon.ico.te.animalesmvc.modelos.Mamifero;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/mamiferos")
public class MamiferoController {

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

    //READ del CRUD
    @GetMapping("/lista")
    public String listaMamiferos(Model model) {
        List<Mamifero> mamiferos = List.of(
                new Mamifero(1, "Jaguar (Panthera onca)", 1.8, "Selva tropical", "Carnívoro", "América Central y Sur", 12, "Vulnerable", "https://es.wikipedia.org/wiki/Jaguar", "https://files.worldwildlife.org/wwfcmsprod/images/Jaguar_GPN7474/story_full_width/4q517ahb0m_Responsible_Forestry_8.10.2012_Biodiversiry_Loss_HI_7474.jpg"),
                new Mamifero(2, "Lobo gris (Canis lupus)", 1.2, "Bosques y tundras", "Carnívoro", "América del Norte y Eurasia", 13, "Preocupación menor", "https://es.wikipedia.org/wiki/Lobo", "https://www.telemundo.com/sites/nbcutelemundo/files/images/promo/article/2017/05/02/lobo-gris-mexicano.jpg"),
                new Mamifero(3, "Elefante africano (Loxodonta)", 3.3, "Sabana", "Herbívoro", "África", 60, "Vulnerable", "https://es.wikipedia.org/wiki/Elefante_africano", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcST6BnN2Nvej56plqy27ajZnOSMeNEkUJgjNw&s"),
                new Mamifero(4, "Elefante africano (Loxodonta)", 3.3, "Sabana", "Herbívoro", "África", 60, "Vulnerable", "https://es.wikipedia.org/wiki/Elefante_africano", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcST6BnN2Nvej56plqy27ajZnOSMeNEkUJgjNw&s")
        );
        model.addAttribute("mamiferos", mamiferos);
        return "mamiferos/lista";
    }

    @GetMapping("/modificar-lista")
    public String listaMamiferos2(Model model) {
        List<Mamifero> mamiferos = List.of(
                new Mamifero(1, "Jaguar (Panthera onca)", 1.8, "Selva tropical", "Carnívoro", "América Central y Sur", 12, "Vulnerable", "https://es.wikipedia.org/wiki/Jaguar", "https://files.worldwildlife.org/wwfcmsprod/images/Jaguar_GPN7474/story_full_width/4q517ahb0m_Responsible_Forestry_8.10.2012_Biodiversiry_Loss_HI_7474.jpg"),
                new Mamifero(2, "Lobo gris (Canis lupus)", 1.2, "Bosques y tundras", "Carnívoro", "América del Norte y Eurasia", 13, "Preocupación menor", "https://es.wikipedia.org/wiki/Lobo", "https://www.telemundo.com/sites/nbcutelemundo/files/images/promo/article/2017/05/02/lobo-gris-mexicano.jpg"),
                new Mamifero(3, "Elefante africano (Loxodonta)", 3.3, "Sabana", "Herbívoro", "África", 60, "Vulnerable", "https://es.wikipedia.org/wiki/Elefante_africano", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcST6BnN2Nvej56plqy27ajZnOSMeNEkUJgjNw&s"),
                new Mamifero(4, "Elefante africano (Loxodonta)", 3.3, "Sabana", "Herbívoro", "África", 60, "Vulnerable", "https://es.wikipedia.org/wiki/Elefante_africano", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcST6BnN2Nvej56plqy27ajZnOSMeNEkUJgjNw&s")
        );
        model.addAttribute("mamiferos", mamiferos);
        return "mamiferos/modificar-lista";
    }

    //UPDATE del CRUD
    @GetMapping("/modificar/{id}")
    public String mostrarFormularioModificacion(@PathVariable int id, Model model) {
        // Objeto de prueba simulado, por ahora estoy sólo con las vistas
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
        );

        model.addAttribute("mamifero", mamifero);
        //Mamifero mamifero = mamiferoService.buscarPorId(id); // Lógica de back
        //model.addAttribute("mamifero", mamifero);
        return "mamiferos/modificar-form";
    }

    @PostMapping("/modificar")
    public String modificar(@ModelAttribute Mamifero mamifero) {
        LoggerFactory.getLogger(getClass()).info("Se ha modificado un mamífero: " + mamifero);
        //mamiferoService.guardarMamifero(mamifero); // mismo método que para guardar
        return "redirect:/mamiferos/modificar-lista?exito";
    }

    //CREATE del CRUD
    @GetMapping("/nuevo")
    public String nuevo(Model model){
        // Objeto de prueba simulado, por ahora estoy sólo con las vistas
        Mamifero mamifero = new Mamifero(
                0,
                "Tigre de Bengala",
                3.1,
                "Selvas tropicales y manglares",
                "Carnívoro",
                "Asia (principalmente India y Bangladés)",
                15,
                "En peligro",
                "https://es.wikipedia.org/wiki/Tigre_de_Bengala",
                "https://upload.wikimedia.org/wikipedia/commons/5/56/Tigre_de_Bengala.jpg"
        );

        model.addAttribute("mamifero", mamifero);
        return "mamiferos/nuevo-form";
    }

    @PostMapping("/guardar")
    public String guardar(
            @ModelAttribute Mamifero mamifero
    ) {
        LoggerFactory.getLogger(getClass()).info("Se ha guardado un mamífero: " + mamifero);
        //mamiferoService.guardarMamifero(mamifero); // Algo así sería
        return "redirect:/mamiferos/lista?exito";
    }

    //DELETE del CRUD
    @GetMapping("/eliminar-lista")
    public String listaMamiferosEliminar(Model model) {
        List<Mamifero> mamiferos = List.of(
                new Mamifero(1, "Jaguar (Panthera onca)", 1.8, "Selva tropical", "Carnívoro", "América Central y Sur", 12, "Vulnerable", "https://es.wikipedia.org/wiki/Jaguar", "https://files.worldwildlife.org/wwfcmsprod/images/Jaguar_GPN7474/story_full_width/4q517ahb0m_Responsible_Forestry_8.10.2012_Biodiversiry_Loss_HI_7474.jpg"),
                new Mamifero(2, "Lobo gris (Canis lupus)", 1.2, "Bosques y tundras", "Carnívoro", "América del Norte y Eurasia", 13, "Preocupación menor", "https://es.wikipedia.org/wiki/Lobo", "https://www.telemundo.com/sites/nbcutelemundo/files/images/promo/article/2017/05/02/lobo-gris-mexicano.jpg"),
                new Mamifero(3, "Elefante africano (Loxodonta)", 3.3, "Sabana", "Herbívoro", "África", 60, "Vulnerable", "https://es.wikipedia.org/wiki/Elefante_africano", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcST6BnN2Nvej56plqy27ajZnOSMeNEkUJgjNw&s")
        );
        model.addAttribute("mamiferos", mamiferos);
        return "mamiferos/eliminar-lista";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id) {
        LoggerFactory.getLogger(getClass()).info("Se ha eliminado un mamífero con ID: " + id);
        // mamiferoService.eliminarPorId(id); // Aquí irá la lógica real
        return "redirect:/mamiferos/eliminar-lista?exito";
    }

}
