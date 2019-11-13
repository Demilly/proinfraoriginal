package com.ApiProInfra.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class Usuario implements Serializable {
  	private static final long serialVersionUID = 1L;
		
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private long id;
   
   private String nome;
   
   private String senha;
   
   @Column(nullable = false, updatable = false)
   @CreatedDate
   private Date dtCreation;
   
   @LastModifiedDate
   private Date dtUpdate;
   
}
