package test;

import datos.UsuarioDAO;
import domain.Usuario;

import java.util.List;

public class ManejoUsuarios {
    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario;
        //INSERT

        /*
        Usuario usuario = new Usuario("DZR", "17180916");
        usuarioDAO.insert(usuario);
        */

        //UPDATE

        /*
        usuario = new Usuario(2,"danielaZ", "daniela123");
        usuarioDAO.update(usuario);
        */

        //DELETE

        usuario = new Usuario(2);
        usuarioDAO.delete(usuario);

        //SELECT
            List<Usuario> usuarios = usuarioDAO.select();
            usuarios.forEach(us -> {
            System.out.println("Usuarios: " + us);
             });
    }
}
