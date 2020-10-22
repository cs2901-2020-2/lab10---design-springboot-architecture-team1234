package lab10;

import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository {
    public Usuario findUsuariosByEmailAndPasswd (String email, String password);
    public Usuario findUsuarioByEmail (String email);
}
