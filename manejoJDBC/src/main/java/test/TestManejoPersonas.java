package test;

import datos.PersonaDAO;
import domain.Persona;

import java.util.List;

public class TestManejoPersonas {
    public static void main(String[] args){
        PersonaDAO personaDAO = new PersonaDAO();
        //insertando un nuevo objeto de tipo persona

           /* Persona persona = new Persona("Esneyder", "Rivera", "Erivera@gmail.com", "222222");
            personaDAO.insertar(persona);*/

        // Actualizando personas

        /*Persona persona = new Persona(1,"Elver", "Galarga" ,"ElverGalarga@gmail.com", "2233333");
        personaDAO.update(persona);*/

        //Eliminando una persona

        Persona persona = new Persona(4);
        personaDAO.delete(persona);

        // consultando los datos de la tabla personas
        List<Persona> personas =  personaDAO.seleccionar();
        personas.forEach(person -> {
            System.out.println("Persona: " + person);
        });
    }
}
