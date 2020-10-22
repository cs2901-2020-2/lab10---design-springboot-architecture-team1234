package lab10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    public UsuarioService () {};

    public List<Usuario> findAll (){
        List<Usuario> usuarios = (List<Usuario>) repository.findAll();
        return usuarios;
    };

    public Usuario findOne (Long codigo) {
        return (Usuario) repository.findById(codigo).get();
    };

    public Usuario create (Usuario usuario) {
        return repository.save(usuario);
    }

    public Usuario update (Usuario usuario) {
        return repository.save(usuario);
    };

    public void delete (Long codigo) {
        repository.deleteById(codigo);
    };

    public Usuario buscarUsuario (String email, String password) {
        return repository.findUsuarioByEmailAndPasswd(email, password);
    }

    public Usuario findOneByEmail (String email) {
        return repository.findUsuarioByEmail(email);
    }
}
