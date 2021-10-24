package com.nisum.technologies.users.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.nisum.technologies.users.domain.Constants.Field;

@MappedSuperclass
public class Audit {
	
	@Column(name = Field.AUDIT_ACTIVE, columnDefinition = "BOOLEAN DEFAULT TRUE")
	private boolean active = true;
	
	@Column(name = Field.AUDIT_CREATED, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@CreationTimestamp
	private Date created;

	@Column(name = Field.AUDIT_MODIFIED, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@UpdateTimestamp
	private Date modified;

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}
}