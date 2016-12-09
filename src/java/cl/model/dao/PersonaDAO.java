/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.model.dao;
import cl.model.pojos.Persona;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;
/**
 *
 * @author Brenda
 */
public class PersonaDAO {
    public void ingresarPersona(Persona p){
        SessionFactory sf= null;
        Session sesion = null;
        Transaction tx = null;
        try{
            sf = HibernateUtil.getSessionFactory();
            sesion = sf.openSession();
            tx = sesion.beginTransaction();
            sesion.save(p);
            tx.commit();
            sesion.close();
        }catch(Exception e){
            tx.rollback();
            throw new RuntimeException("No se pudo ingresar la persona");
        }
    }
    public String consultarPersona(int codigo){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();
        Persona p = (Persona)sesion.get(Persona.class, codigo);
        sesion.close();
        if(p!=null){
            return "<p>Codigo:</p>"+p.getCodigo()+
                    "<br><p>Nombre:</p>"+p.getNombre()+
                    "<br><p>Fecha Nacimiento:</p>"+p.getFechaNacimiento()+
                    "<br><p>Fecha Desceso:</p>"+p.getFechaDesceso()+
                    "<br><p>Area:</p>"+p.getArea();
        }else{
            return "El persona no existe";
        }
    }
    public String detetePersona(int codigo){
        SessionFactory sf= null;
        Session sesion = null;
        Transaction tx = null;
        try{
            sf = HibernateUtil.getSessionFactory();
            sesion = sf.openSession();
            tx = sesion.beginTransaction();
            Persona p = (Persona)sesion.get(Persona.class, codigo);
            sesion.delete(p);
            tx.commit();
            sesion.close();
            return "<p>Se ha eliminado a "+p.getNombre()+"</p>";
        }catch(Exception e){
            tx.rollback();
            throw new RuntimeException("No se pudo eliminar");
        }
    }
    public String updatePersona(int codigo,Persona persona){
        SessionFactory sf= null;
        Session sesion = null;
        Transaction tx = null;
        try{
            sf = HibernateUtil.getSessionFactory();
            sesion = sf.openSession();
            tx = sesion.beginTransaction();
            Persona p = (Persona)sesion.get(Persona.class, codigo);
            p.setNombre(persona.getNombre());
            p.setFechaNacimiento(persona.getFechaNacimiento());
            p.setFechaDesceso(persona.getFechaDesceso());
            p.setArea(persona.getArea());
            sesion.update(p);
            tx.commit();
            sesion.close();
            return "<p>Se ha actualizado a "+p.getCodigo()+"</p>";
        }catch(Exception e){
            tx.rollback();
            throw new RuntimeException("No se pudo actualizar");
        }
    }
    public List<Persona> verPersonas(){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();
        Query query = sesion.createQuery("from Persona");
        List<Persona> lista = query.list();
        sesion.close();
        return lista;
    }
}
