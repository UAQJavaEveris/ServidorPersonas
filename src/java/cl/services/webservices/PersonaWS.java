/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.services.webservices;

import cl.model.dao.PersonaDAO;
import cl.model.pojos.Persona;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Brenda
 */
@WebService(serviceName = "PersonaWS")
public class PersonaWS {


    /**
     * Web service operation
     */
    @WebMethod(operationName = "InsertarNuevaPersona")
    public String InsertarNuevaPersona(@WebParam(name = "codigo") int codigo, @WebParam(name = "nombre") String nombre, @WebParam(name = "fechaNacimiento") String fechaNacimiento, @WebParam(name = "fechaDesceso") String fechaDesceso, @WebParam(name = "area") String area) {
        //TODO write your implementation code here:
        Persona p = new Persona(codigo,nombre,fechaNacimiento,fechaDesceso,area);
        PersonaDAO personaDAO = new PersonaDAO();
        personaDAO.ingresarPersona(p);
        return "<p>Nueva Persona Ingresada</p>";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "BuscarPersona")
    public String BuscarPersona(@WebParam(name = "codigo") int codigo) {
        //TODO write your implementation code here:
        PersonaDAO personaDAO = new PersonaDAO();
        return personaDAO.consultarPersona(codigo);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ConsultarTodo")
    public List<Persona> ConsultarTodo() {
        //TODO write your implementation code here:
        PersonaDAO personaDAO = new PersonaDAO();
        List<Persona> list = personaDAO.verPersonas();
        return list;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "DeletePersona")
    public String DeletePersona(@WebParam(name = "codigo") int codigo) {
        //TODO write your implementation code here:
        PersonaDAO personaDAO = new PersonaDAO();
        return personaDAO.detetePersona(codigo);
    }
    /**
     * Web service operation
     */
    @WebMethod(operationName = "UpdatePersona")
    public String UpdatePersona(@WebParam(name = "codigo") int codigo, @WebParam(name = "nombre") String nombre, @WebParam(name = "fechaNacimiento") String fechaNacimiento, @WebParam(name = "fechaDesceso") String fechaDesceso, @WebParam(name = "area") String area) {
        //TODO write your implementation code here:
        Persona p = new Persona(nombre,fechaNacimiento,fechaDesceso,area);
        PersonaDAO personaDAO = new PersonaDAO();
        return personaDAO.updatePersona(codigo, p);
    }
}
