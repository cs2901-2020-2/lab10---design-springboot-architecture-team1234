package lab10;

import java.util.ArrayList;
import java.util.List;

public class UsuarioService {
    private UsuarioRepository repository;

    public UsuarioService () {};

    public List<Usuario> findAll (){
        List<Usuario> usuarios = (List<Usuario>) repository.findAll();
        return usuarios;
    };

    public Usuario findOne (long codigo) {
        return repository.findById(codigo);
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
