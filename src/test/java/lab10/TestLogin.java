package lab10;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.List;

@Test
public class TestLogin {
    @Test
    public void test_usuario_set1(){
        Usuario usuario1 = new Usuario("email0@gmail.com", "12345678", (long) 12345);
        Date date = new Date();
        usuario1.setPasswd("password");
        Assert.assertEquals(usuario1.passwd, "password");

        usuario1.setHash("hash1");
        Assert.assertEquals(usuario1.hash, "hash1");

        usuario1.setSexo(1);
        Assert.assertEquals(usuario1.sexo, (Integer) 1);

        usuario1.setPrimerNombre("Usuario1");
        Assert.assertEquals(usuario1.primerNombre, "Usuario1");

        usuario1.setSegundoNombre("Usuario2");
        Assert.assertEquals(usuario1.segundoNombre, "Usuario2");

        usuario1.setApellidoMaterno("Apellido1");
        Assert.assertEquals(usuario1.apellidoMaterno, "Apellido1");

        usuario1.setApellidoPaterno("Paterno1");
        Assert.assertEquals(usuario1.apellidoPaterno, "Paterno1");

        usuario1.setNombre("Nombre1");
        Assert.assertEquals(usuario1.nombre, "Nombre1");

        usuario1.setVigencia(12);
        Assert.assertEquals(usuario1.vigencia, (Integer) 12);

        usuario1.setFechaCese(date);
        Assert.assertEquals(usuario1.fechaCese, date);

        usuario1.setNombreCompleto("NombreCompleto");
        Assert.assertEquals(usuario1.nombreCompleto, "NombreCompleto");
    }

    @Test
    public void test_usuario_service_admin() {
        Usuario usuario1 = new Usuario("email0@gmail.com", "12345678", (long) 12345);
        Usuario usuario2 = new Usuario("email20@gmail.com", "14785236", (long) 15987);
        Usuario usuario3 = new Usuario("email6540@gmail.com", "85214796", (long) 96548);
        UsuarioService usuarioService = new UsuarioService();
        // Test de creacion de usuarios
        test_creation(usuario1, usuario2, usuario3, usuarioService);
        // Test de busqueda de usuarios creados
        test_findOne(usuario1, usuario2, usuario3, usuarioService);
        // Test de actualizacion con busqueda
        usuario1.setNombre("Usuario1");
        usuario1.setHash("hash_usuario1");
        usuario1.setPasswd("password_usuario1");
        test_update(usuario1, usuarioService, "Usuario1", "hash_usuario1", "password_usuario1");

        usuario2.setNombre("Usuario2");
        usuario2.setHash("hash_usuario2");
        usuario2.setPasswd("password_usuario2");
        test_update(usuario2, usuarioService, "Usuario2", "hash_usuario2", "password_usuario2");

        // Test eliminar
        usuarioService.delete(usuario3.codigo);
        Usuario usuarioE1 = usuarioService.findOne(usuario3.codigo);
        Assert.assertNull(usuarioE1);

        // Test findAll
        List<Usuario> usuarios = usuarioService.findAll();
        Assert.assertEquals(usuarios.size(), 2);

        // Test buscarUsuario

        // Test findOneByEmail


    }

    private void test_update(Usuario usuario1, UsuarioService usuarioService, String usuario12, String hash_usuario1, String password_usuario1) {
        Usuario usuarioA1 = usuarioService.update(usuario1);
        Assert.assertEquals(usuario1.nombre, usuarioA1.nombre);
        Assert.assertEquals(usuario1.hash, usuarioA1.hash);
        Assert.assertEquals(usuario1.passwd, usuarioA1.passwd);
        Usuario usuarioBA1 = usuarioService.findOne(usuario1.codigo);
        Assert.assertEquals(usuarioBA1.nombre, usuario12);
        Assert.assertEquals(usuarioBA1.hash, hash_usuario1);
        Assert.assertEquals(usuarioBA1.passwd, password_usuario1);
    }

    private void test_findOne(Usuario usuario1, Usuario usuario2, Usuario usuario3, UsuarioService usuarioService) {
        Usuario usuarioB1 = usuarioService.findOne(usuario1.codigo);
        Usuario usuarioB2 = usuarioService.findOne(usuario2.codigo);
        Usuario usuarioB3 = usuarioService.findOne(usuario3.codigo);
        Assert.assertEquals(usuario1.dni, usuarioB1.dni);
        Assert.assertEquals(usuario2.dni, usuarioB2.dni);
        Assert.assertEquals(usuario3.dni, usuarioB3.dni);
    }

    private void test_creation(Usuario usuario1, Usuario usuario2, Usuario usuario3, UsuarioService usuarioService) {
        Usuario usuarioC1 = usuarioService.create(usuario1);
        Usuario usuarioC2 = usuarioService.create(usuario2);
        Usuario usuarioC3 = usuarioService.create(usuario3);
        Assert.assertEquals(usuario1.codigo, usuarioC1.codigo);
        Assert.assertNotEquals(usuario2.codigo, usuarioC1.codigo);
        Assert.assertEquals(usuario2.codigo, usuarioC2.codigo);
        Assert.assertNotEquals(usuario3.codigo, usuarioC2.codigo);
        Assert.assertEquals(usuario3.codigo, usuarioC3.codigo);
        Assert.assertNotEquals(usuario1.codigo, usuarioC3.codigo);
    }
}
