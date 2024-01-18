package com.practicalexercises.exercise1.logic;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
public class VoteStudent implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int voteId;
    
    @ManyToOne
    @JoinColumn(name = "party_id")
    private Party party;

    public VoteStudent() {
    }

    public VoteStudent(int voteId, Party party) {
        this.voteId = voteId;
        this.party = party;
    }

    public VoteStudent(Party party) {
        this.party = party;
    }

    public int getVoteId() {
        return voteId;
    }

    public void setVoteId(int voteId) {
        this.voteId = voteId;
    }

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    @Override
    public String toString() {
        return "VoteStudent{" + "voteId=" + voteId + ", party=" + party + '}';
    }

    
 
}
