package com.example.entity;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.HashSet;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.example.Enum.ModuleType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name= "permission")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Permission {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "permission_id")
	private long id;
	
	@Column(name= "permission_name" , unique = true , nullable = false)
	private String permissionName;
	
	@Column( length = 250  )
	private String description;
	
	@CreationTimestamp
	@Column(name = "created_at" , updatable = false)
	private LocalDateTime createdAt;
	
	@UpdateTimestamp
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;
	
	@Default
	@Column(name = "is_active")
	private boolean active = true;
	
	@Enumerated(EnumType.STRING)
	@Column(name  = "module_name" , nullable = false)
	private ModuleType moduleName;
	
	
	
	 @Default
	 
	  @ManyToMany(mappedBy = "permissions") private Set<Role> roles = new
	  HashSet<>();
	 
}
