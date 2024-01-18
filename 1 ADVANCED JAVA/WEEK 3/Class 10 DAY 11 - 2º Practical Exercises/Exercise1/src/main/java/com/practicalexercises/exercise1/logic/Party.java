package com.practicalexercises.exercise1.logic;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Party implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int partyId;
    private String partyName;
    
    @OneToMany(mappedBy = "party")
    private List<VoteStudent> votes;

    public Party() {
    }

    public Party(int partyId, String partyName, List<VoteStudent> votes) {
        this.partyId = partyId;
        this.partyName = partyName;
        this.votes = votes;
    }

    public Party(String partyName, List<VoteStudent> votes) {
        this.partyName = partyName;
        this.votes = votes;
    }

    public int getPartyId() {
        return partyId;
    }

    public void setPartyId(int partyId) {
        this.partyId = partyId;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public List<VoteStudent> getVotes() {
        return votes;
    }

    public void setVotes(List<VoteStudent> votes) {
        this.votes = votes;
    }

    @Override
    public String toString() {
        return "Party{" + "partyId=" + partyId + ", partyName=" + partyName + ", votes=" + votes + '}';
    }

    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
