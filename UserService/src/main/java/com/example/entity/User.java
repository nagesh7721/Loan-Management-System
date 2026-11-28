package com.example.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.example.Enum.Gender;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private long id;

	@Column(name = "coustomer_code", unique = true, length = 50)
	private String coustomerCode;

	@Column(name = "first_name", length = 30, nullable = false)
	private String firstName;

	@Column(name = "middle_name", length = 50)
	private String middleName;

	@Column(name = "last_name", nullable = false, length = 50)
	private String lastName;

	@Column(name = "user_email", unique = true, length = 100, nullable = false)
	private String email;

	@Column(name = " monile_number", length = 10, nullable = false, unique = true)
	private String mobileNumber;

	@Column(name = "user_password", unique = true, nullable = false, length = 50)
	private String password;

	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth;

	@Enumerated(EnumType.STRING)
	@Column(name = "gender")
	private Gender gender;

	@Default
	@Column(name = "account_locked")
	private boolean acounyLocked = false;

	@Column(name = " adhar_number", nullable = false, unique = true, length = 12)
	private String adharNumber;

	@Column(name = "profile_photo")
	private String profilePhoto;

	@Column(name = "pan_number", unique = true, nullable = false, length = 10)
	private String panNumber;

	@Column(name = "is_active")
	private boolean isActive = true;

	@Column(name = "last_login")
	private LocalDate lastLogin;

	@Column(name = "failed_login_attempts ")
	private Integer failedLoginAttempts;

	@CreationTimestamp
	@Column(name = "created_at", updatable = false)
	private LocalDateTime createdAt;

	@CreationTimestamp
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;

	@Column(name = "created_by", length = 100)
	private String createdBy;

	@Column(name = " updated_by", length = 100)
	private String updatedBy;

	@Default
	@ManyToMany
	@JoinTable(name = " user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "branch_id")
	private Branch branch;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "address_id" , unique = true)
	private Address address;

}
