package lab10;

import java.util.Date;

public class Usuario {
    String hash;
    String primerNombre;
    String apellidoPaterno;
    String apellidoMaterno;
    String email;
    String nombre;
    String passwd;
    String segundoNombre;
    String dni;
    String nombreCompleto;
    Long codigo;
    Integer sexo;
    Integer vigencia;
    Date fechaCese;

    public Usuario(String email, String dni, Long codigo) {
        this.email = email;
        this.dni = dni;
        this.codigo = codigo;
    }

    public Usuario() {

    }

    public void setEmail(String email){this.email = email;}

    public void setDni(String dni){this.dni = dni;}

    public void setCodigo(Long codigo){this.codigo = codigo;}

    public void setHash(String hash) {
        this.hash = hash;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setSexo(Integer sexo) {
        this.sexo = sexo;
    }

    public void setVigencia(Integer vigencia) {
        this.vigencia = vigencia;
    }

    public void setFechaCese(Date fechaCese) {
        this.fechaCese = fechaCese;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
