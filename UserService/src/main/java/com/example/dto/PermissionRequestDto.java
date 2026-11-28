package com.example.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.Enum.ModuleType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PermissionRequestDto {

	@NotBlank(message = "Permission name is required")
	private String permissionName;

	@NotNull(message = "Module name is required")
	private ModuleType moduleName;

	@Size(max = 250, message = "Description cannot exceed 250 characters")
	private String description;
}
