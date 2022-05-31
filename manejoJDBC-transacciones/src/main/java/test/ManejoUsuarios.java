package test;


import datos.Conexion;
import datos.UsuarioDAO;
import domain.Usuario;

import java.sql.Connection;
import java.sql.SQLException;

public class ManejoUsuarios {
    public static void main(String[] args) {
        Connection conexion = null;

        try {
            conexion = Conexion.getConnection();
            if(conexion.getAutoCommit()){
                conexion.setAutoCommit(false);
            }

            UsuarioDAO usuarioDAO = new UsuarioDAO(conexion);
            Usuario usuario = new Usuario();
            usuario.setId_usuario(1);
            usuario.setUsuario("Riverse");
            usuario.setPassword("1234546");
            usuarioDAO.update(usuario);

             usuarioDAO = new UsuarioDAO();
            usuario = new Usuario();
            usuario.setUsuario("elver");
            usuario.setPassword("123245");
            usuarioDAO.insert(usuario);


        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("entramos al roll back");
            try {
                assert conexion != null;
                conexion.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
