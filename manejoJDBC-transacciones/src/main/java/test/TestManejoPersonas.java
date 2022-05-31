package test;

import datos.Conexion;
import datos.PersonaDAO;
import domain.Persona;

import java.sql.*;

public class TestManejoPersonas {
    public static void main(String[] args){

        Connection conexion = null;
        try {
             conexion = Conexion.getConnection();
            if(conexion.getAutoCommit()) {
            conexion.setAutoCommit(false);
            }

            PersonaDAO personaDAO = new PersonaDAO(conexion);
            Persona persona = new Persona();
            persona.setIdPersona(1);
            persona.setNombre("Ernesto");
            persona.setApellido("Perez");
            persona.setEmail("frailejonHernestoPerez@gmail.com");
            persona.setTelefono("222222222");
            personaDAO.update(persona);


            persona = new Persona();
            persona.setNombre("Rosa");
            persona.setApellido("Mel ano");
            persona.setEmail("rosaMelAno@gmail.com");
            persona.setTelefono("222222222");
            personaDAO.insertar(persona);



            conexion.commit();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
            System.out.println("Entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }
}
