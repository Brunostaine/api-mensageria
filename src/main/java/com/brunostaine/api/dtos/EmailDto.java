package com.brunostaine.api.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class EmailDto {
	

	@NotEmpty
	private String ownerRef;
	@NotEmpty
	@Email
	private String emailFrom; 
	@NotEmpty
	@Email
	private String emailTo;
	@NotEmpty
	private String subject;
	@NotEmpty
	private String text;

}
