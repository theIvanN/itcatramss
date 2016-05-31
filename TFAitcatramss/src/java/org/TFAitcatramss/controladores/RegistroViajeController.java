package org.TFAitcatramss.controladores;

import org.TFAitcatramss.entidades.RegistroViaje;
import org.TFAitcatramss.controladores.util.JsfUtil;
import org.TFAitcatramss.controladores.util.JsfUtil.PersistAction;
import org.TFAitcatramss.dao.RegistroViajeFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("registroViajeController")
@SessionScoped
public class RegistroViajeController implements Serializable {

    @EJB
    private org.TFAitcatramss.dao.RegistroViajeFacade ejbFacade;
    private List<RegistroViaje> items = null;
    private RegistroViaje selected;

    public RegistroViajeController() {
    }

    public RegistroViaje getSelected() {
        return selected;
    }

    public void setSelected(RegistroViaje selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private RegistroViajeFacade getFacade() {
        return ejbFacade;
    }

    public RegistroViaje prepareCreate() {
        selected = new RegistroViaje();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("RegistroViajeCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("RegistroViajeUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("RegistroViajeDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<RegistroViaje> getItems() {
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

    public RegistroViaje getRegistroViaje(java.lang.String id) {
        return getFacade().find(id);
    }

    public List<RegistroViaje> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<RegistroViaje> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = RegistroViaje.class)
    public static class RegistroViajeControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            RegistroViajeController controller = (RegistroViajeController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "registroViajeController");
            return controller.getRegistroViaje(getKey(value));
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
            if (object instanceof RegistroViaje) {
                RegistroViaje o = (RegistroViaje) object;
                return getStringKey(o.getIdregistroViaje());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), RegistroViaje.class.getName()});
                return null;
            }
        }

    }

}
