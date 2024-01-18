package com.practicalexercises.exercise1.logic;

import com.practicalexercises.exercise1.persistence.PersistenceController;
import java.util.List;


public class Controller {
    PersistenceController persisController = new PersistenceController();
    
    
//  VOTE STUDENT -------------------------------------------------------------------------------
    public void createVote(Party party){
        persisController.createVote(new VoteStudent(party));
    }
    
    public List<VoteStudent> bringVotes(){
        return persisController.bringVotes();
    }
    
    public void deleteVotes(int idDelete){
        persisController.deleteVote(idDelete);
    }
    
    public VoteStudent searchVoteStudent(int idEdit){
        return persisController.searchVote(idEdit);
    }
    
    public void modifyVote(Party party, VoteStudent vote){
        vote.setParty(party);
        persisController.modifyVote(vote);
    }

//  -------------------------------------------------------------------------------------------
 
//  PARTY -------------------------------------------------------------------------------
    public void createParty(String partyName, List<VoteStudent> votes){
        persisController.createParty(new Party(partyName,votes));
    }
    
    public List<Party> bringParties(){
        return persisController.bringParties();
    }
    
    public void deleteParties(int idDelete){
        persisController.deleteParty(idDelete);
    }
    
    public Party searchParty(int idEdit){
        return persisController.searchParty(idEdit);
    }
    
    public Party searchByName(String name){
        List<Party> parties = persisController.bringParties();
        for (Party party : parties) {
            if(party.getPartyName().equalsIgnoreCase(name)){
                return party;
            }
        }
        return null;
    }
    
    public void modifyParty(String partyName, List<VoteStudent> votes,Party party){
        party.setPartyName(partyName);
        party.setVotes(votes);
        persisController.modifyParty(party);
    }

//  -------------------------------------------------------------------------------------------
 
    
}
