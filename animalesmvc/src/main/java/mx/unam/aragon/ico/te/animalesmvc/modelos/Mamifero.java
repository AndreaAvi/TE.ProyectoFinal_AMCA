package mx.unam.aragon.ico.te.animalesmvc.modelos;

public class Mamifero {

    private int id;
    private String especie;
    private double tamanioPromedio; // en metros
    private String habitat; // tipo de hábitat (selva, sabana, etc.)
    private String tipoAlimentacion;
    private String zonaGeografica;
    private int esperanzaVida; // en años
    private String estadoConservacion;
    private String urlInformacion;
    private String imagen; // ruta o URL a imagen

    public Mamifero() {
    }

    public Mamifero(int id, String especie, double tamanioPromedio, String habitat,
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

    // Getters y setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
