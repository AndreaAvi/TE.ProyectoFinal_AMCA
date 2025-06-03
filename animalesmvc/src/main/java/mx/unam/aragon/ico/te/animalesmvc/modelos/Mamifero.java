package mx.unam.aragon.ico.te.animalesmvc.modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "mamiferos")
public class Mamifero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100, nullable = false)
    private String especie;

    @Column(name = "tamanio_promedio", nullable = false)
    private double tamanioPromedio; // en metros

    @Column(length = 100)
    private String habitat; // tipo de hábitat (selva, sabana, etc.)

    @Column(name = "tipo_alimentacion", length = 50)
    private String tipoAlimentacion;

    @Column(name = "zona_geografica", length = 100)
    private String zonaGeografica;

    @Column(name = "esperanza_vida")
    private int esperanzaVida; // en años

    @Column(name = "estado_conservacion", length = 50)
    private String estadoConservacion;

    @Column(name = "url_informacion", length = 255)
    private String urlInformacion;

    @Column(length = 255)
    private String imagen; // ruta o URL a imagen

    public Mamifero() {
    }

    public Mamifero(Integer id, String especie, double tamanioPromedio, String habitat,
                    String tipoAlimentacion, String zonaGeografica,
                    int esperanzaVida, String estadoConservacion, String urlInformacion, String imagen) {
        this.id = id;
        this.especie = especie;
        this.tamanioPromedio = tamanioPromedio;
        this.habitat = habitat;
        this.tipoAlimentacion = tipoAlimentacion;
        this.zonaGeografica = zonaGeografica;
        this.esperanzaVida = esperanzaVida;
        this.estadoConservacion = estadoConservacion;
        this.urlInformacion = urlInformacion;
        this.imagen = imagen;
    }

    // Getters y Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public double getTamanioPromedio() {
        return tamanioPromedio;
    }

    public void setTamanioPromedio(double tamanioPromedio) {
        this.tamanioPromedio = tamanioPromedio;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getTipoAlimentacion() {
        return tipoAlimentacion;
    }

    public void setTipoAlimentacion(String tipoAlimentacion) {
        this.tipoAlimentacion = tipoAlimentacion;
    }

    public String getZonaGeografica() {
        return zonaGeografica;
    }

    public void setZonaGeografica(String zonaGeografica) {
        this.zonaGeografica = zonaGeografica;
    }

    public int getEsperanzaVida() {
        return esperanzaVida;
    }

    public void setEsperanzaVida(int esperanzaVida) {
        this.esperanzaVida = esperanzaVida;
    }

    public String getEstadoConservacion() {
        return estadoConservacion;
    }

    public void setEstadoConservacion(String estadoConservacion) {
        this.estadoConservacion = estadoConservacion;
    }

    public String getUrlInformacion() {
        return urlInformacion;
    }

    public void setUrlInformacion(String urlInformacion) {
        this.urlInformacion = urlInformacion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Mamifero{" +
                "id=" + id +
                ", especie='" + especie + '\'' +
                ", tamanioPromedio=" + tamanioPromedio +
                ", habitat='" + habitat + '\'' +
                ", tipoAlimentacion='" + tipoAlimentacion + '\'' +
                ", zonaGeografica='" + zonaGeografica + '\'' +
                ", esperanzaVida=" + esperanzaVida +
                ", estadoConservacion='" + estadoConservacion + '\'' +
                ", urlInformacion='" + urlInformacion + '\'' +
                ", imagen='" + imagen + '\'' +
                '}';
    }
}
