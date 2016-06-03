package org.TFAitcatramss.controladores;

import org.TFAitcatramss.entidades.Rol;
import org.TFAitcatramss.controladores.util.JsfUtil;
import org.TFAitcatramss.controladores.util.JsfUtil.PersistAction;
import org.TFAitcatramss.dao.RolFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
//import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.primefaces.context.RequestContext;


@Named("rolController")
@SessionScoped
public class RolController implements Serializable {

    @EJB
    private org.TFAitcatramss.dao.RolFacade ejbFacade;
    private List<Rol> items = null;
    private Rol selected;
    private Rol rol;
    
    private String idRol;
    private String rolNombre;
 
    // LEL
    @PostConstruct
    public void init() {
        rol = new Rol();
    }
    
    public Rol getRol() {
        return rol;
    }
    
    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getIdrol() {
        return idRol;
    }

    public void setIdrol(String idrol) {
        this.idRol = idrol;
    }

    public String getRolNombre() {
        return rolNombre;
    }

    public void setRolNombre(String rol) {
        this.rolNombre = rol;
    }
    
    public void rolGuardar() {
        //TipoDiagnostico tipoDiagnsticoSeleccionado = new TipoDiagnostico(idTipoDiagnostico);
     // TipoDiagnostico tipoDiagnsticoSeleccionado = new TipoDiagnostico(diagnosticoRegistro.getCodigoTipoDiagnostico().getCodigoTipoDiagnostico());
        rol.setIdrol(idRol); 
        rol.setRolNombre(rolNombre); 
        //ejbFacade.create(rol);
        FacesMessage msg = new FacesMessage(idRol.concat(rolNombre));
//        rol = new Rol();
//        diagnosticoTodos();
//        idRol = "";
//        FacesMessage msg = new FacesMessage("Registro Guardado");
       FacesContext.getCurrentInstance().addMessage(null, msg);
//        RequestContext context = RequestContext.getCurrentInstance();
//        context.update("f2:tblDiagnostico");
//        context.execute("PF('dlgGuardarDiagnostico').hide();");
    }

    
    // LEL

    public RolController() {
    }

    public Rol getSelected() {
        return selected;
    }

    public void setSelected(Rol selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private RolFacade getFacade() {
        return ejbFacade;
    }

    public Rol prepareCreate() {
        selected = new Rol();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("RolCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("RolUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("RolDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Rol> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Rol getRol(java.lang.String id) {
        return getFacade().find(id);
    }

    public List<Rol> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Rol> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Rol.class)
    public static class RolControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            RolController controller = (RolController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "rolController");
            return controller.getRol(getKey(value));
        }

        java.lang.String getKey(String value) {
            java.lang.String key;
            key = value;
            return key;
        }

        String getStringKey(java.lang.String value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Rol) {
                Rol o = (Rol) object;
                return getStringKey(o.getIdrol());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Rol.class.getName()});
                return null;
            }
        }

    }

}
