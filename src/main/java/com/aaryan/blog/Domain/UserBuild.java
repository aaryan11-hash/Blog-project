package com.aaryan.blog.Domain;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserBuild {

	@NotBlank
	@Size(min=5,max = 15,message = "username should have atleast 5 and at max 15 characters")
	private String username;

	@NotBlank
	@Size(min=5,max = 15,message = "password should have atleast 5 and at max 15 characters")
	private String password;

	
	
	
	
	

	
	
}
