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
public class CdJpaController {
    @Resource
    private UserTransaction utx = null;
    @PersistenceUnit(unitName = "CDLibraryPU")
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cd cd) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(cd);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findCd(cd.getCdId()) != null) {
                throw new PreexistingEntityException("Cd " + cd + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cd cd) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            cd = em.merge(cd);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = cd.getCdId();
                if (findCd(id) == null) {
                    throw new NonexistentEntityException("The cd with id " + id + " no longer exists.");
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
            Cd cd;
            try {
                cd = em.getReference(Cd.class, id);
                cd.getCdId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cd with id " + id + " no longer exists.", enfe);
            }
            em.remove(cd);
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

    public List<Cd> findCdEntities() {
        return findCdEntities(true, -1, -1);
    }

    public List<Cd> findCdEntities(int maxResults, int firstResult) {
        return findCdEntities(false, maxResults, firstResult);
    }

    private List<Cd> findCdEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from Cd as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Cd findCd(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cd.class, id);
        } finally {
            em.close();
        }
    }

    public int getCdCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select count(o) from Cd as o");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
