package com.example.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.example.Enum.Gender;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto {

	
	@NotBlank(message = "User First name is required")
	@Size(max = 30 , message = "First name is required")
	private  String firstName;
	
	@Size(max=30 , message = "Middle name cannot exceed 50 characters")
	private String middleName;
	
	@NotBlank(message = "User Last name is required")
	@Size(max = 50 , message = "Last name must be between 2 and 50 characters" )
	private String lastName;
	
	@NotBlank(message ="Email are required" )
	@Email(message = "Please enter a valid email address")
	@Size(max  = 100 , message = "Email cannot exceed 100 characters")
	private String email;
	
	@NotBlank(message = "Mobile number is required")
	@Pattern(regexp = "^[6-9]\\d{9}" , 
	         message = "Mobile number must be a valid 10-digit Indian mobile number")
	private String mobileNummber;
	
	@NotBlank(message = "Password must be required")
	@Size(min = 8 ,max = 20 , message = "Password Must be 8 characters")
	@Pattern(
            regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!]).*$",
            message = "Password must contain uppercase, lowercase, number and special character")
	private String password;
	
	@NotBlank(message = "Confirm password is required")
    private String confirmPassword;
	
	@NotNull(message = "Date Of Birth is required")
	@Past(message = "Date of birth must be in th past")
	private LocalDateTime dateOfBirth;
	
	@NotBlank(message = "Please select your gender")
	private Gender gender;
	
	@NotBlank(message = "Adhar Number is Required")
	@Size(max=12 , message = "Adhar Number atleast 12 digiits")
    @Pattern(
            regexp = "^[2-9]{1}[0-9]{11}$",
            message = "Please enter a valid Aadhaar number")
	private String adharNumber;
	
	@NotBlank(message = "Profile photo is required")
	private String photo;
	
	@NotBlank(message = "Pan_Number is required")
	@Pattern(regexp = "^[A-Z] {5}[0-9]] {4}[A-Z]$",
			 message = "Invalid PAN  number format")
	@Size(max = 10 , message = "Pan_Number is atleast  10 digits")
	private String panNumber;
	
    @NotNull(message = "Branch is required")
    private Long branchId;

    @NotBlank(message = "Address Line 1 is required")
    @Size(max = 150)
    private String addressLine1;

    @Size(max = 150)
    private String addressLine2;

    @Size(max = 100)
    private String landmark;

    @NotBlank(message = "City is required")
    private String city;

    @NotBlank(message = "State is required")
    private String state;

    @NotBlank(message = "Country is required")
    private String country;

    @NotBlank(message = "PIN Code is required")
    @Pattern(
            regexp = "^[1-9][0-9]{5}$",
            message = "Invalid PIN Code")
    private String pinCode;
	
}
