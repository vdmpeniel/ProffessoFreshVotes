package com.inspirarte.freshvotes.domain;
import lombok.Data;
import javax.persistence.*;

//@Data // provides getters and setters
@Entity
@Table(name="users")
public class User {
   
    private Long id;
    private String username;
    private String password;
    private String name;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Annotations can be put on the getter method
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}  
    
}
