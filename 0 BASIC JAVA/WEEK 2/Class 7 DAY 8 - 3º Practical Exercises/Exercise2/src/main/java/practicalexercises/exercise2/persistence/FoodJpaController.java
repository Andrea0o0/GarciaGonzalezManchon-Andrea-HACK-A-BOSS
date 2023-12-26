package practicalexercises.exercise2.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import javax.persistence.Persistence;
import practicalexercises.exercise2.models.Food;
import practicalexercises.exercise2.persistence.exceptions.NonexistentEntityException;

public class FoodJpaController implements Serializable {

    public FoodJpaController() {
      emf = Persistence.createEntityManagerFactory("restaurantjpa");
    }

    public FoodJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Food food) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(food);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Food food) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            food = em.merge(food);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = food.getId();
                if (findFood(id) == null) {
                    throw new NonexistentEntityException("The food with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Food food;
            try {
                food = em.getReference(Food.class, id);
                food.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The food with id " + id + " no longer exists.", enfe);
            }
            em.remove(food);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Food> findFoodEntities() {
        return findFoodEntities(true, -1, -1);
    }

    public List<Food> findFoodEntities(int maxResults, int firstResult) {
        return findFoodEntities(false, maxResults, firstResult);
    }

    private List<Food> findFoodEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Food.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Food findFood(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Food.class, id);
        } finally {
            em.close();
        }
    }

    public int getFoodCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Food> rt = cq.from(Food.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
