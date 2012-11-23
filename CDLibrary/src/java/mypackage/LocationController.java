/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mypackage;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.faces.FacesException;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.model.SelectItem;
import mypackage.util.JsfUtil;
import mypackage.exceptions.NonexistentEntityException;
import mypackage.util.PagingInfo;

/**
 *
 * @author willy
 */
public class LocationController {

    public LocationController() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        jpaController = (LocationJpaController) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "locationJpa");
        pagingInfo = new PagingInfo();
        converter = new LocationConverter();
    }
    private Location location = null;
    private List<Location> locationItems = null;
    private LocationJpaController jpaController = null;
    private LocationConverter converter = null;
    private PagingInfo pagingInfo = null;

    public PagingInfo getPagingInfo() {
        if (pagingInfo.getItemCount() == -1) {
            pagingInfo.setItemCount(jpaController.getLocationCount());
        }
        return pagingInfo;
    }

    public SelectItem[] getLocationItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(jpaController.findLocationEntities(), false);
    }

    public SelectItem[] getLocationItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(jpaController.findLocationEntities(), true);
    }

    public Location getLocation() {
        if (location == null) {
            location = (Location) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentLocation", converter, null);
        }
        if (location == null) {
            location = new Location();
        }
        return location;
    }

    public String listSetup() {
        reset(true);
        return "location_list";
    }

    public String createSetup() {
        reset(false);
        location = new Location();
        return "location_create";
    }

    public String create() {
        try {
            jpaController.create(location);
            JsfUtil.addSuccessMessage("Location was successfully created.");
        } catch (Exception e) {
            JsfUtil.ensureAddErrorMessage(e, "A persistence error occurred.");
            return null;
        }
        return listSetup();
    }

    public String detailSetup() {
        return scalarSetup("location_detail");
    }

    public String editSetup() {
        return scalarSetup("location_edit");
    }

    private String scalarSetup(String destination) {
        reset(false);
        location = (Location) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentLocation", converter, null);
        if (location == null) {
            String requestLocationString = JsfUtil.getRequestParameter("jsfcrud.currentLocation");
            JsfUtil.addErrorMessage("The location with id " + requestLocationString + " no longer exists.");
            return relatedOrListOutcome();
        }
        return destination;
    }

    public String edit() {
        String locationString = converter.getAsString(FacesContext.getCurrentInstance(), null, location);
        String currentLocationString = JsfUtil.getRequestParameter("jsfcrud.currentLocation");
        if (locationString == null || locationString.length() == 0 || !locationString.equals(currentLocationString)) {
            String outcome = editSetup();
            if ("location_edit".equals(outcome)) {
                JsfUtil.addErrorMessage("Could not edit location. Try again.");
            }
            return outcome;
        }
        try {
            jpaController.edit(location);
            JsfUtil.addSuccessMessage("Location was successfully updated.");
        } catch (NonexistentEntityException ne) {
            JsfUtil.addErrorMessage(ne.getLocalizedMessage());
            return listSetup();
        } catch (Exception e) {
            JsfUtil.ensureAddErrorMessage(e, "A persistence error occurred.");
            return null;
        }
        return detailSetup();
    }

    public String destroy() {
        String idAsString = JsfUtil.getRequestParameter("jsfcrud.currentLocation");
        Integer id = new Integer(idAsString);
        try {
            jpaController.destroy(id);
            JsfUtil.addSuccessMessage("Location was successfully deleted.");
        } catch (NonexistentEntityException ne) {
            JsfUtil.addErrorMessage(ne.getLocalizedMessage());
            return relatedOrListOutcome();
        } catch (Exception e) {
            JsfUtil.ensureAddErrorMessage(e, "A persistence error occurred.");
            return null;
        }
        return relatedOrListOutcome();
    }

    private String relatedOrListOutcome() {
        String relatedControllerOutcome = relatedControllerOutcome();
        if (relatedControllerOutcome != null) {
            return relatedControllerOutcome;
        }
        return listSetup();
    }

    public List<Location> getLocationItems() {
        if (locationItems == null) {
            getPagingInfo();
            locationItems = jpaController.findLocationEntities(pagingInfo.getBatchSize(), pagingInfo.getFirstItem());
        }
        return locationItems;
    }

    public String next() {
        reset(false);
        getPagingInfo().nextPage();
        return "location_list";
    }

    public String prev() {
        reset(false);
        getPagingInfo().previousPage();
        return "location_list";
    }

    private String relatedControllerOutcome() {
        String relatedControllerString = JsfUtil.getRequestParameter("jsfcrud.relatedController");
        String relatedControllerTypeString = JsfUtil.getRequestParameter("jsfcrud.relatedControllerType");
        if (relatedControllerString != null && relatedControllerTypeString != null) {
            FacesContext context = FacesContext.getCurrentInstance();
            Object relatedController = context.getApplication().getELResolver().getValue(context.getELContext(), null, relatedControllerString);
            try {
                Class<?> relatedControllerType = Class.forName(relatedControllerTypeString);
                Method detailSetupMethod = relatedControllerType.getMethod("detailSetup");
                return (String) detailSetupMethod.invoke(relatedController);
            } catch (ClassNotFoundException e) {
                throw new FacesException(e);
            } catch (NoSuchMethodException e) {
                throw new FacesException(e);
            } catch (IllegalAccessException e) {
                throw new FacesException(e);
            } catch (InvocationTargetException e) {
                throw new FacesException(e);
            }
        }
        return null;
    }

    private void reset(boolean resetFirstItem) {
        location = null;
        locationItems = null;
        pagingInfo.setItemCount(-1);
        if (resetFirstItem) {
            pagingInfo.setFirstItem(0);
        }
    }

    public void validateCreate(FacesContext facesContext, UIComponent component, Object value) {
        Location newLocation = new Location();
        String newLocationString = converter.getAsString(FacesContext.getCurrentInstance(), null, newLocation);
        String locationString = converter.getAsString(FacesContext.getCurrentInstance(), null, location);
        if (!newLocationString.equals(locationString)) {
            createSetup();
        }
    }

    public Converter getConverter() {
        return converter;
    }

}
