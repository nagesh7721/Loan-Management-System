package com.example.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "address")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= " address_id")
	private Long id;
	
	
	@Column(name = " address_line_1" , length = 200 , nullable = false)
	private String addressLine1;
	
	@Column(name = "address_line_2" , length = 200)
	private String addressline2 ;
	
	
	@Column(name = "land_mark" , length =  200)
	private String landMark;
	
	@Column(name = "city" , nullable = false , length = 100)
	private String city;
	
	@Column(name = "district" , nullable = false , length = 100)
	private String district;
	
	@Column(name = "state " , nullable = false , length = 100)
	private String state;
	
	@Column(name = "country" , nullable = false , length = 100)
	private String country;
	
	@Column(name = "pin_code" , nullable = false , length = 100)
	private String pinCode;
	
	@Column(name = "is_active")
	private Boolean active  = true ;
	
	@CreationTimestamp
	@Column(name="created_at" , updatable = false)
	private LocalDateTime createdAt;
	
	@UpdateTimestamp
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;
	
	@OneToOne(mappedBy = "address")
	private User user;
}
