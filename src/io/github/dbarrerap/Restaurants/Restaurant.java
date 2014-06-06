package io.github.dbarrerap.Restaurants;

/**
 * Created by david on 6/5/14.
 */
public class Restaurant {
    /**
     * Objeto Restaurant para manejo de sus datos
     *
     */
    private String nombre, direccion, telefono, categoria;
    private double latitude, longitude;

    public Restaurant() {
    }

    public Restaurant(String nombre, String direccion, String telefono, String categoria, double latitude, double longitude) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.categoria = categoria;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
