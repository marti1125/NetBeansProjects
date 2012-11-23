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
public class CdController {

    public CdController() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        jpaController = (CdJpaController) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "cdJpa");
        pagingInfo = new PagingInfo();
        converter = new CdConverter();
    }
    private Cd cd = null;
    private List<Cd> cdItems = null;
    private CdJpaController jpaController = null;
    private CdConverter converter = null;
    private PagingInfo pagingInfo = null;

    public PagingInfo getPagingInfo() {
        if (pagingInfo.getItemCount() == -1) {
            pagingInfo.setItemCount(jpaController.getCdCount());
        }
        return pagingInfo;
    }

    public SelectItem[] getCdItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(jpaController.findCdEntities(), false);
    }

    public SelectItem[] getCdItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(jpaController.findCdEntities(), true);
    }

    public Cd getCd() {
        if (cd == null) {
            cd = (Cd) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentCd", converter, null);
        }
        if (cd == null) {
            cd = new Cd();
        }
        return cd;
    }

    public String listSetup() {
        reset(true);
        return "cd_list";
    }

    public String createSetup() {
        reset(false);
        cd = new Cd();
        return "cd_create";
    }

    public String create() {
        try {
            jpaController.create(cd);
            JsfUtil.addSuccessMessage("Cd was successfully created.");
        } catch (Exception e) {
            JsfUtil.ensureAddErrorMessage(e, "A persistence error occurred.");
            return null;
        }
        return listSetup();
    }

    public String detailSetup() {
        return scalarSetup("cd_detail");
    }

    public String editSetup() {
        return scalarSetup("cd_edit");
    }

    private String scalarSetup(String destination) {
        reset(false);
        cd = (Cd) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentCd", converter, null);
        if (cd == null) {
            String requestCdString = JsfUtil.getRequestParameter("jsfcrud.currentCd");
            JsfUtil.addErrorMessage("The cd with id " + requestCdString + " no longer exists.");
            return relatedOrListOutcome();
        }
        return destination;
    }

    public String edit() {
        String cdString = converter.getAsString(FacesContext.getCurrentInstance(), null, cd);
        String currentCdString = JsfUtil.getRequestParameter("jsfcrud.currentCd");
        if (cdString == null || cdString.length() == 0 || !cdString.equals(currentCdString)) {
            String outcome = editSetup();
            if ("cd_edit".equals(outcome)) {
                JsfUtil.addErrorMessage("Could not edit cd. Try again.");
            }
            return outcome;
        }
        try {
            jpaController.edit(cd);
            JsfUtil.addSuccessMessage("Cd was successfully updated.");
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
        String idAsString = JsfUtil.getRequestParameter("jsfcrud.currentCd");
        Integer id = new Integer(idAsString);
        try {
            jpaController.destroy(id);
            JsfUtil.addSuccessMessage("Cd was successfully deleted.");
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

    public List<Cd> getCdItems() {
        if (cdItems == null) {
            getPagingInfo();
            cdItems = jpaController.findCdEntities(pagingInfo.getBatchSize(), pagingInfo.getFirstItem());
        }
        return cdItems;
    }

    public String next() {
        reset(false);
        getPagingInfo().nextPage();
        return "cd_list";
    }

    public String prev() {
        reset(false);
        getPagingInfo().previousPage();
        return "cd_list";
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
        cd = null;
        cdItems = null;
        pagingInfo.setItemCount(-1);
        if (resetFirstItem) {
            pagingInfo.setFirstItem(0);
        }
    }

    public void validateCreate(FacesContext facesContext, UIComponent component, Object value) {
        Cd newCd = new Cd();
        String newCdString = converter.getAsString(FacesContext.getCurrentInstance(), null, newCd);
        String cdString = converter.getAsString(FacesContext.getCurrentInstance(), null, cd);
        if (!newCdString.equals(cdString)) {
            createSetup();
        }
    }

    public Converter getConverter() {
        return converter;
    }

}
