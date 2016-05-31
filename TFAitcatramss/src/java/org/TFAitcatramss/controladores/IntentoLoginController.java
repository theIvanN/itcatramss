package org.TFAitcatramss.controladores;

import org.TFAitcatramss.entidades.IntentoLogin;
import org.TFAitcatramss.controladores.util.JsfUtil;
import org.TFAitcatramss.controladores.util.JsfUtil.PersistAction;
import org.TFAitcatramss.dao.IntentoLoginFacade;

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

@Named("intentoLoginController")
@SessionScoped
public class IntentoLoginController implements Serializable {

    @EJB
    private org.TFAitcatramss.dao.IntentoLoginFacade ejbFacade;
    private List<IntentoLogin> items = null;
    private IntentoLogin selected;

    public IntentoLoginController() {
    }

    public IntentoLogin getSelected() {
        return selected;
    }

    public void setSelected(IntentoLogin selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private IntentoLoginFacade getFacade() {
        return ejbFacade;
    }

    public IntentoLogin prepareCreate() {
        selected = new IntentoLogin();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("IntentoLoginCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("IntentoLoginUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("IntentoLoginDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<IntentoLogin> getItems() {
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

    public IntentoLogin getIntentoLogin(java.lang.String id) {
        return getFacade().find(id);
    }

    public List<IntentoLogin> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<IntentoLogin> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = IntentoLogin.class)
    public static class IntentoLoginControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            IntentoLoginController controller = (IntentoLoginController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "intentoLoginController");
            return controller.getIntentoLogin(getKey(value));
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
            if (object instanceof IntentoLogin) {
                IntentoLogin o = (IntentoLogin) object;
                return getStringKey(o.getIdintentoLogin());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), IntentoLogin.class.getName()});
                return null;
            }
        }

    }

}
