package com.practicalexercises.exercise1.persistence;

import com.practicalexercises.exercise1.logic.Party;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.practicalexercises.exercise1.logic.VoteStudent;
import com.practicalexercises.exercise1.persistence.exceptions.NonexistentEntityException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Persistence;

/**
 *
 * @author andre
 */
public class PartyJpaController implements Serializable {

    public PartyJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public PartyJpaController() {
        emf = Persistence.createEntityManagerFactory("voteJpa");
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Party party) {
        if (party.getVotes() == null) {
            party.setVotes(new ArrayList<VoteStudent>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<VoteStudent> attachedVotes = new ArrayList<VoteStudent>();
            for (VoteStudent votesVoteStudentToAttach : party.getVotes()) {
                votesVoteStudentToAttach = em.getReference(votesVoteStudentToAttach.getClass(), votesVoteStudentToAttach.getVoteId());
                attachedVotes.add(votesVoteStudentToAttach);
            }
            party.setVotes(attachedVotes);
            em.persist(party);
            for (VoteStudent votesVoteStudent : party.getVotes()) {
                Party oldPartyOfVotesVoteStudent = votesVoteStudent.getParty();
                votesVoteStudent.setParty(party);
                votesVoteStudent = em.merge(votesVoteStudent);
                if (oldPartyOfVotesVoteStudent != null) {
                    oldPartyOfVotesVoteStudent.getVotes().remove(votesVoteStudent);
                    oldPartyOfVotesVoteStudent = em.merge(oldPartyOfVotesVoteStudent);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Party party) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Party persistentParty = em.find(Party.class, party.getPartyId());
            List<VoteStudent> votesOld = persistentParty.getVotes();
            List<VoteStudent> votesNew = party.getVotes();
            List<VoteStudent> attachedVotesNew = new ArrayList<VoteStudent>();
            for (VoteStudent votesNewVoteStudentToAttach : votesNew) {
                votesNewVoteStudentToAttach = em.getReference(votesNewVoteStudentToAttach.getClass(), votesNewVoteStudentToAttach.getVoteId());
                attachedVotesNew.add(votesNewVoteStudentToAttach);
            }
            votesNew = attachedVotesNew;
            party.setVotes(votesNew);
            party = em.merge(party);
            for (VoteStudent votesOldVoteStudent : votesOld) {
                if (!votesNew.contains(votesOldVoteStudent)) {
                    votesOldVoteStudent.setParty(null);
                    votesOldVoteStudent = em.merge(votesOldVoteStudent);
                }
            }
            for (VoteStudent votesNewVoteStudent : votesNew) {
                if (!votesOld.contains(votesNewVoteStudent)) {
                    Party oldPartyOfVotesNewVoteStudent = votesNewVoteStudent.getParty();
                    votesNewVoteStudent.setParty(party);
                    votesNewVoteStudent = em.merge(votesNewVoteStudent);
                    if (oldPartyOfVotesNewVoteStudent != null && !oldPartyOfVotesNewVoteStudent.equals(party)) {
                        oldPartyOfVotesNewVoteStudent.getVotes().remove(votesNewVoteStudent);
                        oldPartyOfVotesNewVoteStudent = em.merge(oldPartyOfVotesNewVoteStudent);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = party.getPartyId();
                if (findParty(id) == null) {
                    throw new NonexistentEntityException("The party with id " + id + " no longer exists.");
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
            Party party;
            try {
                party = em.getReference(Party.class, id);
                party.getPartyId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The party with id " + id + " no longer exists.", enfe);
            }
            List<VoteStudent> votes = party.getVotes();
            for (VoteStudent votesVoteStudent : votes) {
                votesVoteStudent.setParty(null);
                votesVoteStudent = em.merge(votesVoteStudent);
            }
            em.remove(party);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Party> findPartyEntities() {
        return findPartyEntities(true, -1, -1);
    }

    public List<Party> findPartyEntities(int maxResults, int firstResult) {
        return findPartyEntities(false, maxResults, firstResult);
    }

    private List<Party> findPartyEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Party.class));
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

    public Party findParty(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Party.class, id);
        } finally {
            em.close();
        }
    }

    public int getPartyCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Party> rt = cq.from(Party.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
