package org.itcatramss_6.controladores;

import org.itcatramss_6.entidades.ValeCombustible;
import org.itcatramss_6.controladores.util.JsfUtil;
import org.itcatramss_6.controladores.util.JsfUtil.PersistAction;
import org.itcatramss_6.dao.ValeCombustibleFacade;

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

@Named("valeCombustibleController")
@SessionScoped
public class ValeCombustibleController implements Serializable {

    @EJB
    private org.itcatramss_6.dao.ValeCombustibleFacade ejbFacade;
    private List<ValeCombustible> items = null;
    private ValeCombustible selected;

    public ValeCombustibleController() {
    }

    public ValeCombustible getSelected() {
        return selected;
    }

    public void setSelected(ValeCombustible selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ValeCombustibleFacade getFacade() {
        return ejbFacade;
    }

    public ValeCombustible prepareCreate() {
        selected = new ValeCombustible();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ValeCombustibleCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ValeCombustibleUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ValeCombustibleDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<ValeCombustible> getItems() {
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

    public ValeCombustible getValeCombustible(java.lang.String id) {
        return getFacade().find(id);
    }

    public List<ValeCombustible> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<ValeCombustible> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = ValeCombustible.class)
    public static class ValeCombustibleControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ValeCombustibleController controller = (ValeCombustibleController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "valeCombustibleController");
            return controller.getValeCombustible(getKey(value));
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
            if (object instanceof ValeCombustible) {
                ValeCombustible o = (ValeCombustible) object;
                return getStringKey(o.getIdvaleCombustible());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), ValeCombustible.class.getName()});
                return null;
            }
        }

    }

}
