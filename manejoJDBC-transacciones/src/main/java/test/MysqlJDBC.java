package test;

import java.sql.*;

public class MysqlJDBC{
            public static void main(String[] args) {
                String url = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezon=UTC&allowPublicKeyRetrieval=true";
                try {
                    //Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conexion = DriverManager.getConnection(url,"root","");
                    Statement instruccion = conexion.createStatement();
                    var sql = "SELECT * FROM personas";
                    ResultSet resultado = instruccion.executeQuery(sql);
                    while(resultado.next()) {
                        System.out.print("id persona: " + resultado.getInt("id_persona"));
                        System.out.print(" Nombre: " + resultado.getString("nombre"));
                        System.out.print(" Apellido: " + resultado.getString("apellido"));
                        System.out.print(" Email: " + resultado.getString("email"));
                        System.out.print(" Telefono: " + resultado.getString("telefono"));
                        System.out.println("");
                    }
                    resultado.close();
                    instruccion.close();
                    conexion.close();
                } catch (SQLException ex) {
                    ex.printStackTrace(System.out);
                }
            }

        }