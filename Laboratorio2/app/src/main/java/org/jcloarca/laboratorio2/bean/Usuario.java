package org.jcloarca.laboratorio2.bean;

/**
 * Created by JCLoarca on 5/21/2016.
 */
public class Usuario {
    private Integer idUsuario;
    private String nombreCompleto;
    private String telefono;
    private String correo;
    private String direccion;
    private String username;
    private String password;
    private String token;
    private String exp;

    public Usuario() {
    }

    public Usuario(Integer idUsuario, String nombreCompleto, String telefono, String correo,
                   String direccion, String username, String password, String token, String exp) {
        this.idUsuario = idUsuario;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.username = username;
        this.password = password;
        this.token = token;
        this.exp = exp;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }
}
