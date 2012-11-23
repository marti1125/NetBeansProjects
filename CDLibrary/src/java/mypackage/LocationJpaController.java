/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mypackage;

import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.transaction.UserTransaction;
import mypackage.exceptions.NonexistentEntityException;
import mypackage.exceptions.PreexistingEntityException;
import mypackage.exceptions.RollbackFailureException;

/**
 *
 * @author willy
 */
public class LocationJpaController {
    @Resource
    private UserTransaction utx = null;
    @PersistenceUnit(unitName = "CDLibraryPU")
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Location location) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(location);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findLocation(location.getLocationId()) != null) {
                throw new PreexistingEntityException("Location " + location + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Location location) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            location = em.merge(location);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = location.getLocationId();
                if (findLocation(id) == null) {
                    throw new NonexistentEntityException("The location with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Location location;
            try {
                location = em.getReference(Location.class, id);
                location.getLocationId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The location with id " + id + " no longer exists.", enfe);
            }
            em.remove(location);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Location> findLocationEntities() {
        return findLocationEntities(true, -1, -1);
    }

    public List<Location> findLocationEntities(int maxResults, int firstResult) {
        return findLocationEntities(false, maxResults, firstResult);
    }

    private List<Location> findLocationEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from Location as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Location findLocation(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Location.class, id);
        } finally {
            em.close();
        }
    }

    public int getLocationCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select count(o) from Location as o");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
