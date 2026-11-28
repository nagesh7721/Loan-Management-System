package com.example.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BranchRequestDto {

	@NotBlank(message = "Branch code is required")
	@Size(max = 20, message = "Branch code cannot exceed 20 characters")
	private String branchCode;

	@NotBlank(message = "Branch name is required")
	@Size(max = 50, message = "Branch name cannot exceed 100 characters")
	private String branchName;

	@NotBlank(message = "IFSC code is required")
	@Pattern(regexp = "^[A-Z]{4}0[A-Z0-9]{6}$", message = "Invalid IFSC Code")
	private String ifscCode;

	@NotBlank(message = "Email is required")
	@Email(message = "Invalid Email address")
	@Size(max = 100 , message = "Email cannot exceed 100 characters")
	private String email;

	@Size(max = 10, message = "Phone Number Is Required")
    @Pattern(
            regexp = "^[6-9]\\d{9}$",
            message = "Invalid mobile number")
	private String mobileNumber;

	
	@NotBlank( message = "Manager name is required")
	@Size(max = 100, message = "Manager name cannot exceed 100 characters")
	private String managerName;

	@NotBlank(message = "Address Line 1 is required")
    @Size(max = 255, message = "Address Line 1 cannot exceed 255 characters")
    private String addressLine1;

    @Size(max = 255, message = "Address Line 2 cannot exceed 255 characters")
    private String addressLine2;

    @NotBlank(message = "City is required")
    @Size(max = 100, message = "City cannot exceed 100 characters")
    private String city;

    @NotBlank(message = "State is required")
    @Size(max = 100, message = "State cannot exceed 100 characters")
    private String state;

    @NotBlank(message = "Country is required")
    @Size(max = 100, message = "Country cannot exceed 100 characters")
    private String country;

    @NotBlank(message = "PIN Code is required")
    @Pattern(
            regexp = "^[1-9][0-9]{5}$",
            message = "Invalid PIN Code")
    private String pinCode;

}
