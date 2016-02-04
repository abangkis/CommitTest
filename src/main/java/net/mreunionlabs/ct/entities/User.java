package net.mreunionlabs.ct.entities;

import org.apache.tapestry5.beaneditor.NonVisual;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="user")
public class User {
	private Long id;	
	private String name;	
	private String password;	
	private Status status;
	private Date lastAccess;
	private Type type;

	public enum Status {
		ACTIVE, INACTIVE, SUSPENDED, LOGGED_IN
	}

	public enum Type {
		ADMIN, USER
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonVisual		
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(nullable = false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(nullable = false)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	@Column(name="last_access", columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)	
	public Date getLastAccess() {
		return lastAccess;
	}
	public void setLastAccess(Date lastAccess) {
		this.lastAccess = lastAccess;
	}
	
}
