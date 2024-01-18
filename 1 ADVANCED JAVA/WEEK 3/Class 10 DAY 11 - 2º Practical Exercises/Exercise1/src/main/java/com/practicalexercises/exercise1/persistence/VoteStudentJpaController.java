package com.practicalexercises.exercise1.persistence;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.practicalexercises.exercise1.logic.Party;
import com.practicalexercises.exercise1.logic.VoteStudent;
import com.practicalexercises.exercise1.persistence.exceptions.NonexistentEntityException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import javax.persistence.Persistence;


public class VoteStudentJpaController implements Serializable {

    public VoteStudentJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public VoteStudentJpaController() {
        emf = Persistence.createEntityManagerFactory("voteJpa");
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(VoteStudent voteStudent) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Party party = voteStudent.getParty();
            if (party != null) {
                party = em.getReference(party.getClass(), party.getPartyId());
                voteStudent.setParty(party);
            }
            em.persist(voteStudent);
            if (party != null) {
                party.getVotes().add(voteStudent);
                party = em.merge(party);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(VoteStudent voteStudent) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            VoteStudent persistentVoteStudent = em.find(VoteStudent.class, voteStudent.getVoteId());
            Party partyOld = persistentVoteStudent.getParty();
            Party partyNew = voteStudent.getParty();
            if (partyNew != null) {
                partyNew = em.getReference(partyNew.getClass(), partyNew.getPartyId());
                voteStudent.setParty(partyNew);
            }
            voteStudent = em.merge(voteStudent);
            if (partyOld != null && !partyOld.equals(partyNew)) {
                partyOld.getVotes().remove(voteStudent);
                partyOld = em.merge(partyOld);
            }
            if (partyNew != null && !partyNew.equals(partyOld)) {
                partyNew.getVotes().add(voteStudent);
                partyNew = em.merge(partyNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = voteStudent.getVoteId();
                if (findVoteStudent(id) == null) {
                    throw new NonexistentEntityException("The voteStudent with id " + id + " no longer exists.");
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
            VoteStudent voteStudent;
            try {
                voteStudent = em.getReference(VoteStudent.class, id);
                voteStudent.getVoteId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The voteStudent with id " + id + " no longer exists.", enfe);
            }
            Party party = voteStudent.getParty();
            if (party != null) {
                party.getVotes().remove(voteStudent);
                party = em.merge(party);
            }
            em.remove(voteStudent);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<VoteStudent> findVoteStudentEntities() {
        return findVoteStudentEntities(true, -1, -1);
    }

    public List<VoteStudent> findVoteStudentEntities(int maxResults, int firstResult) {
        return findVoteStudentEntities(false, maxResults, firstResult);
    }

    private List<VoteStudent> findVoteStudentEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(VoteStudent.class));
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

    public VoteStudent findVoteStudent(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(VoteStudent.class, id);
        } finally {
            em.close();
        }
    }

    public int getVoteStudentCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<VoteStudent> rt = cq.from(VoteStudent.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
