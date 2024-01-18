package com.practicalexercises.exercise1.persistence;

import com.practicalexercises.exercise1.logic.Party;
import com.practicalexercises.exercise1.logic.VoteStudent;
import com.practicalexercises.exercise1.persistence.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PersistenceController {
    VoteStudentJpaController voteJpa = new VoteStudentJpaController();
    PartyJpaController partyJpa = new PartyJpaController();
    
    
//  VOTE STUDENT -------------------------------------------------------------------------------
    public void createVote(VoteStudent vote) {
        voteJpa.create(vote);
    }
    
    public List<VoteStudent> bringVotes(){
        return voteJpa.findVoteStudentEntities();
    }
    
    public void deleteVote(int idVoteDelete) {
        try {
            voteJpa.destroy(idVoteDelete);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public VoteStudent searchVote(int idVote){
        return voteJpa.findVoteStudent(idVote);
    }
    
    public void modifyVote(VoteStudent vote) {
        try {
            voteJpa.edit(vote);
        } catch (Exception ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//  -------------------------------------------------------------------------------------------
    
//  PARTY -------------------------------------------------------------------------------
    public void createParty(Party party) {
        partyJpa.create(party);
    }
    
    public List<Party> bringParties(){
        return partyJpa.findPartyEntities();
    }
    
    public void deleteParty(int idPartyDelete) {
        try {
            partyJpa.destroy(idPartyDelete);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public Party searchParty(int idParty){
        return partyJpa.findParty(idParty);
    }
    
    public void modifyParty(Party party) {
        try {
            partyJpa.edit(party);
        } catch (Exception ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//  -------------------------------------------------------------------------------------------
}
