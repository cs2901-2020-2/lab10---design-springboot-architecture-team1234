package lab10;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping ("/users")
public class AuthenticationController {
    private UsuarioService service;
    RestTemplate restTemplate = new RestTemplate();
    public AuthenticationController() {}

    @PostMapping
    public ResponseEntity<?> create(Usuario user) {
        ResponseEntity<String> entity = restTemplate.getForEntity ("/users", String.class);
        service.create(user);
        return entity;
    }

    public ResponseEntity<?> read(Long codigo){
        ResponseEntity<String> entity = restTemplate.getForEntity("/users", String.class);
        service.findOne(codigo);
        return entity;
    }

    public ResponseEntity<?> update(Long codigo, Usuario user){
        ResponseEntity<String> entity = restTemplate.getForEntity("/users", String.class);
        service.update(user);
        return entity;
    }

    public ResponseEntity<?> delete(Long codigo){
        ResponseEntity<String> entity = restTemplate.getForEntity("/users", String.class);
        service.delete(codigo);
        return entity;
    }
}
