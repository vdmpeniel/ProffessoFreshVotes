package com.inspirarte.freshvotes.domain;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

//@Data
@Entity

public class Vote {
    
    private VoteId pk;
    private Boolean upvote;
    
    @EmbeddedId
	public VoteId getVoteId() {
		return pk;
	}
	public void setVoteId(VoteId voteId) {
		this.pk = voteId;
	}
	public Boolean getUpvote() {
		return upvote;
	}
	public void setUpvote(Boolean upvote) {
		this.upvote = upvote;
	}    
    
    
}
