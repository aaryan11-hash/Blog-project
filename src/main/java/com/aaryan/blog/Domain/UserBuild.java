package com.aaryan.blog.Domain;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserBuild {

	@Pattern(regexp = "^[a-zA-Z0-9@_]{4,13}",message = "not valid")
	private String username;

	@Pattern(regexp = "^[a-zA-Z0-9@_]{4,13}",message = "not valid")
	private String password;

	
	
	
	
	

	
	
}
