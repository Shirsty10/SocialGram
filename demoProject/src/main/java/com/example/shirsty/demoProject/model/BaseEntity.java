package com.example.shirsty.demoProject.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@MappedSuperclass
@Data
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity{
	@CreatedDate
	@Column(updatable = false)
    private LocalDateTime createdAt;
	
	@CreatedBy
	@Column(updatable = false)
    private String createdBy;
	
	@LastModifiedDate
	@Column(insertable = false)
    private LocalDateTime updatedAt;
	
	@LastModifiedBy
	@Column(insertable = false)
    private String updatedBy;
}