package lab10;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
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
    public void test_usuario_service_admin() throws Exception {
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
        Usuario usuarioBSS1 = usuarioService.buscarUsuario("email0@gmail.com","password_usuario1");
        Assert.assertEquals(usuario1.nombre, usuarioBSS1.nombre);
        Assert.assertEquals(usuario1.hash, usuarioBSS1.hash);

        // Test findOneByEmail
        Usuario usuarioBE1 = usuarioService.findOneByEmail("email20@gmail.com");
        Assert.assertEquals(usuario2.nombre, usuarioBE1.nombre);
        Assert.assertEquals(usuario2.hash, usuarioBE1.hash);
        Assert.assertEquals(usuario2.email, usuarioBE1.email);

        usuarioService.delete(usuario1.codigo);
        usuarioService.delete(usuario2.codigo);

        List<Usuario> usuariosFinal = usuarioService.findAll();
        Assert.assertEquals(usuarios.size(), 0);
    }

    @Test(expectedExceptions = ConstructorUsuarioServiceException.class)
    public void test_create_delete_specialized() throws Exception {
        Usuario usuario1 = new Usuario("email0@gmail.com", "12345678", (long) 12345);
        Usuario usuario2 = new Usuario("email20@gmail.com", "14785236", (long) 15987);
        Usuario usuario3 = new Usuario("email30@gmail.com", "85214796", (long) 54555);
        Usuario usuario4 = new Usuario("email40@gmail.com", "78952312", (long) 98522);
        Usuario usuario5 = new Usuario("email50@gmail.com", "15947823", (long) 96998);
        Usuario usuario6 = new Usuario("email60@gmail.com", "84523632", (long) 88548);

        List<Usuario> usuariosComparer = new ArrayList<>();
        usuariosComparer.add(usuario1);
        usuariosComparer.add(usuario2);
        usuariosComparer.add(usuario3);
        usuariosComparer.add(usuario4);
        usuariosComparer.add(usuario5);
        usuariosComparer.add(usuario6);

        UsuarioService usuarioService = new UsuarioService();

        usuarioService.create(usuario1);
        usuarioService.create(usuario2);
        usuarioService.create(usuario1);
        usuarioService.create(usuario3);
        usuarioService.create(usuario4);
        usuarioService.create(usuario2);
        usuarioService.create(usuario5);
        usuarioService.create(usuario6);
        usuarioService.create(usuario6);
        usuarioService.create(usuario2);

        List<Usuario> usuarios = usuarioService.findAll();
        Assert.assertEquals(usuariosComparer.size(), usuarios.size());
        Assert.assertEquals(usuariosComparer, usuarios);

        usuarioService.delete(usuario1.codigo);
        usuariosComparer.remove(usuario1);
        usuarios = usuarioService.findAll();
        Assert.assertEquals(usuariosComparer.size(), usuarios.size());
        Assert.assertEquals(usuariosComparer, usuarios);

        usuarioService.delete(usuario2.codigo);
        usuarioService.delete(usuario3.codigo);
        usuariosComparer.remove(usuario2);
        usuariosComparer.remove(usuario3);
        usuarios = usuarioService.findAll();
        Assert.assertEquals(usuariosComparer.size(), usuarios.size());
        Assert.assertEquals(usuariosComparer, usuarios);

        usuarioService.delete(usuario2.codigo);
        usuarioService.delete(usuario4.codigo);
        usuariosComparer.remove(usuario4);
        usuarios = usuarioService.findAll();
        Assert.assertEquals(usuariosComparer.size(), usuarios.size());

        usuarioService.delete(usuario2.codigo);
        usuarioService.delete(usuario3.codigo);
        usuarios = usuarioService.findAll();
        Assert.assertEquals(usuariosComparer.size(), usuarios.size());
        Assert.assertEquals(usuariosComparer, usuarios);

        usuarioService.delete(usuario5.codigo);
        usuarioService.delete(usuario6.codigo);
        usuariosComparer.remove(usuario5);
        usuariosComparer.remove(usuario6);
        usuarios = usuarioService.findAll();
        Assert.assertEquals(usuariosComparer.size(), usuarios.size());
        Assert.assertEquals(usuariosComparer, usuarios);

        usuarioService.delete(usuario1.codigo);
        usuarioService.delete(usuario6.codigo);
        usuarios = usuarioService.findAll();
        Assert.assertEquals(usuariosComparer.size(), usuarios.size());
        Assert.assertEquals(usuariosComparer, usuarios);


        Usuario usuario7 = new Usuario("email80@gmail.com", "15947823", (long) 96778);

        usuarioService.delete(usuario2.codigo);
        usuarioService.delete(usuario7.codigo);
        usuarios = usuarioService.findAll();
        Assert.assertEquals(usuariosComparer.size(), usuarios.size());
        Assert.assertEquals(usuariosComparer, usuarios);
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

    @Test
    private void testUserByDefault(){
        Usuario usuarioByDafult = new Usuario();
        usuarioByDafult.setEmail("user1234@email");
        usuarioByDafult.setDni("72731229");
        Long codigoUsuarioByDafult = (long) 20184235;
        usuarioByDafult.setCodigo(codigoUsuarioByDafult);
        Assert.assertEquals(usuarioByDafult.codigo,codigoUsuarioByDafult);
        Assert.assertEquals(usuarioByDafult.dni,"72731229");
        Assert.assertEquals(usuarioByDafult.email,"user1234@email");
    }
}
