package lab10;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

public class UsuarioService {
    private UsuarioRepository repository;

    public UsuarioService () {};

    public List<Usuario> findAll (){
        List<Usuario> usuarios = new ArrayList<Usuario>();
        return usuarios;
    };

    public Usuario find (long codigo) {
        
    };

    public Usuario create (Usuario usuario) {

    }

    public Usuario update (Usuario usuario) {

    };

    public void delete (Usuario usuario) {

    };

    public Usuario buscarUsuario (String email, String password) {

    }

    public Usuario findOneByEmail (String email) {

    }
}
