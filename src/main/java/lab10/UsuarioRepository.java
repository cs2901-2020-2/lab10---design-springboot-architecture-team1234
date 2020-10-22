package lab10;

import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    public Usuario findUsuarioByEmailAndPasswd (String email, String password);
    public Usuario findUsuarioByEmail (String email);
}
