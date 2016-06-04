/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.TFAitcatramss.controladores;

import static com.sun.xml.ws.spi.db.BindingContextFactory.LOGGER;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.TFAitcatramss.dao.RolFacade;
import org.TFAitcatramss.entidades.Rol;

/**
 *
 * @author pelipites
 */
@ManagedBean
@RequestScoped
public class ManejadorRol {

    /**
     * mage ve el codigo de mi chero y el del arquitecto ahi esta la magia
     * guiate por el codigo de ellos asi hice yo y hay que hacer las demas 
     * operaciones yo en la noche continuare trabajando 
     */
    @EJB // sin esto NO funciona el rol facade asi que ponerselo 
    public RolFacade facade; //esto hace la magia esto tiene los metodos crud
            
    // La entidad rol y sus respectivos atributos       
    public Rol rol;
    public String idRol;
    public String nombreRol;
    //hay que agregar los set y gets de todas las variables que eh creado
    //por que o sino no guardan 
    
    private List<Rol> items = null;
    
    //constructor
    public ManejadorRol() {
        clearForm();
        items = new ArrayList<Rol>();;
  
    }
    
    //esto se lo copie al arquitecto es para inicializar la variable rol
    public void clearForm() {
        setRol(new Rol()); //esto puede ser rol = new Rol();
    }                     //el ide lo a cambiado por los set y get que meti   

    public RolFacade getRolFacade() {
        return facade;
    }

    public void setRolFacade(RolFacade rolFacade) {
        this.facade = rolFacade;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
    //aca el metodo guardar que invoco al dar clic en el boton
    public String guardar() {
        try {
   
            facade.create(rol); //aca guardo en la base de datos
            LOGGER.log(Level.SEVERE, "datos guardados ");
            clearForm(); //aca igual al ingeniero limpio la variable rol
        } catch (Exception e) {
          LOGGER.log(Level.SEVERE, "Error al guardar datos:", e);
        }
        return null; //retorno null ya que debo de retornar String
    } //los LOGGERlog() estan de choto crei que ivan a imprimir mensajes
      //pero al final no hacen nada esas mierdas
    
    public String actualizar() {
        try {
   
            facade.edit(rol); //aca guardo en la base de datos
            LOGGER.log(Level.SEVERE, "datos actualizados ");
            clearForm(); //aca igual al ingeniero limpio la variable rol
        } catch (Exception e) {
          LOGGER.log(Level.SEVERE, "Error al actualizar datos:", e);
        }
        return null; //retorno null ya que debo de retornar String
    } 
    
    public String eliminar(Rol role) {
        try {
   
            facade.remove(role); //aca guardo en la base de datos
            LOGGER.log(Level.SEVERE, "datos eliminados ");
            clearForm(); //aca igual al ingeniero limpio la variable rol
        } catch (Exception e) {
          LOGGER.log(Level.SEVERE, "Error al elimanar datos:", e);
        }
        return null; //retorno null ya que debo de retornar String
    }
    
    public List<Rol> getListaRol() {
        items = facade.listarRol();
        return items;
    }

    public void setListaRol(List<Rol> rol) {
        this.items = items;
    }
    
    public List<Rol> ver() {
        items = facade.listarRol();
        return items;
//        try {
//   
//            items = facade.findAll();
//        } catch (Exception e) {
//          LOGGER.log(Level.SEVERE, "no hay datos", e);
//        }
//        return items;
        /* CODIGO DEL RolController
        if (items == null) {
            items = getFacade().findAll();
        } */
    }
    
    public void findItems() {
        items = facade.findAll();
    }
    
    public String getIdRol() {
        return idRol;
    }

    public void setIdRol(String idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public RolFacade getFacade() {
        return facade;
    }

    public List<Rol> getItems() {
        return items;
    }

    public void setFacade(RolFacade facade) {
        this.facade = facade;
    }

    public void setItems(List<Rol> items) {
        this.items = items;
    }
    
    public List<Rol> rolTodos() {
        items = facade.listarRol();
        return items;
    } 
    
}
