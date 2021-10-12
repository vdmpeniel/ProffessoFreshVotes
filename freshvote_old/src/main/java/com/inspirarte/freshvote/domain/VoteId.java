package com.inspirarte.freshvote.domain;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.io.Serializable;


@Embeddable
public class VoteId implements Serializable {
    // serialization version to be able to communicate between app versions.
    private static final long serialVersionUID = 3231321433655L;

    @ManyToOne // there is a many to one relationship from vote to user
    private User user;

    @ManyToOne // there is a many to one relationship from vote to feature
    private Feature feature;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Feature getFeature() {
        return feature;
    }

    public void setFeature(Feature feature) {
        this.feature = feature;
    }
}
