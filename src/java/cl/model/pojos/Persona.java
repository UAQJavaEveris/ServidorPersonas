package cl.model.pojos;
// Generated 8/12/2016 06:15:31 PM by Hibernate Tools 4.3.1



/**
 * Persona generated by hbm2java
 */
public class Persona  implements java.io.Serializable {


     private Integer codigo;
     private String nombre;
     private String fechaNacimiento;
     private String fechaDesceso;
     private String area;

    public Persona() {
    }

    public Persona(String nombre, String fechaNacimiento, String fechaDesceso, String area) {
       this.nombre = nombre;
       this.fechaNacimiento = fechaNacimiento;
       this.fechaDesceso = fechaDesceso;
       this.area = area;
    }

    public Persona(Integer codigo, String nombre, String fechaNacimiento, String fechaDesceso, String area) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaDesceso = fechaDesceso;
        this.area = area;
    }
   
    public Integer getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getFechaNacimiento() {
        return this.fechaNacimiento;
    }
    
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public String getFechaDesceso() {
        return this.fechaDesceso;
    }
    
    public void setFechaDesceso(String fechaDesceso) {
        this.fechaDesceso = fechaDesceso;
    }
    public String getArea() {
        return this.area;
    }
    
    public void setArea(String area) {
        this.area = area;
    }




}

