package com.inspirarte.freshvotes.domain;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.io.Serializable;

//@Data
@Embeddable
public class VoteId implements Serializable {
    // serialization version to be able to communicate between app versions.
    private static final long serialVersionUID = 3231321433655L;
    private User user;    
    private Feature feature;

    @ManyToOne // there is a many to one relationship from vote to user
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne // there is a many to one relationship from vote to feature
	public Feature getFeature() {
		return feature;
	}

	public void setFeature(Feature feature) {
		this.feature = feature;
	}

	public static long getSerialversionUID() {
		return serialVersionUID;
	}  
}
