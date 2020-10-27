package lab10;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    public UsuarioService () throws ConstructorUsuarioServiceException {
        throw new ConstructorUsuarioServiceException("ERROR CONSTRUCTOR BY DEFAULT IN USUARIO SERVICE");
    }

    public List<Usuario> findAll (){
        return (List<Usuario>) repository.findAll();
    }

    public Usuario findOne (Long codigo) {
        return this.repository.findById(codigo).orElse(new Usuario());
    }

    public Usuario create (Usuario usuario) {
        return repository.save(usuario);
    }

    public Usuario update (Usuario usuario) {
        return repository.save(usuario);
    }

    public void delete (Long codigo) {
        repository.deleteById(codigo);
    }

    public Usuario buscarUsuario (String email, String password) {
        return repository.findUsuarioByEmailAndPasswd(email, password);
    }

    public Usuario findOneByEmail (String email) {

        return repository.findUsuarioByEmail(email);
    }
}
