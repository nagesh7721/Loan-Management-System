package com.example.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.Enum.RoleType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleRequestDto {

	@NotNull(message = "Role name is requid")
	private RoleType roleName;

	@Size(max = 255, message = "Description cannot exceed 255 character")
	private String description;

}
