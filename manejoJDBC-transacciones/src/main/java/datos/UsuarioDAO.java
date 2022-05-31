package datos;

import domain.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static datos.Conexion.*;

public class UsuarioDAO {
    private Connection conexionTransactional;
    public final static String SQL_CREATE = "INSERT INTO usuarios(usuario, password) VALUES (?, ?)";
public final static String SQL_DELETE = "DELETE FROM usuarios WHERE id_usuario = ?";
public final static String SQL_UPDATE = "UPDATE usuarios SET  usuario = ? , password = ? WHERE id_usuario= ?";
public final static String SQL_SELECT = "SELECT * FROM usuarios ";

    public UsuarioDAO() {
    }

    public UsuarioDAO(Connection conexionTransactional) {
        this.conexionTransactional = conexionTransactional;
    }

    public List<Usuario> select() {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    Usuario usuario = null;
    List<Usuario> usuarios = new ArrayList();

    try {
        conn = getConnection();
        stmt = conn.prepareStatement(SQL_SELECT);
        rs = stmt.executeQuery();

        while (rs.next()) {
            int idUsuario = rs.getInt("id_usuario");
            String usua = rs.getString("usuario");
            String password = rs.getString("password");

            usuario = new Usuario(idUsuario,usua,password);
            usuarios.add(usuario);
        }

    } catch (SQLException e) {
        e.printStackTrace(System.out);
    }finally {
        try {
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }
    return usuarios;
}
public int insert(Usuario usuario){
    Connection conn = null;
    PreparedStatement stmt = null;
    int isInsert = 0;

    try {
        conn = getConnection();
        stmt = conn.prepareStatement(SQL_CREATE);
        stmt.setString(1, usuario.getUsuario());
        stmt.setString(2, usuario.getPassword());

        isInsert = stmt.executeUpdate();


    } catch (SQLException e) {
        e.printStackTrace(System.out);
    }finally {
        try {
            close(stmt);
            close(conn);
        }catch (SQLException e){
            e.printStackTrace(System.out);
        }
    }
 return isInsert;
}

public int update(Usuario usuario){
   Connection conn = null;
   PreparedStatement stmt = null;
   int isUpdate = 0;

    try {
        conn = getConnection();
        stmt = conn.prepareStatement(SQL_UPDATE);
        stmt.setString(1,usuario.getUsuario());
        stmt.setString(2,usuario.getPassword());
        stmt.setInt(3,usuario.getId_usuario());

        isUpdate = stmt.executeUpdate();

    } catch (SQLException e) {
        e.printStackTrace(System.out);
    }finally {
        try {
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }
      return isUpdate;
    }

    public int delete(Usuario usuario){
    Connection conn = null;
    PreparedStatement stmt = null;
    int isDelete = 0;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1,usuario.getId_usuario());
            isDelete = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        return isDelete;
    }


}
