package com.softsystem.clinic.project.validator;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class LoginViewModel {
	
	
	@Pattern(regexp = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-+]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "{Email.invalidEmail}")
    @Size(max = 150, message = "{Size.email}")
	@NotEmpty(message = "{NotEmpty.message}")
    public String pat_Email;

	@Size(min = 8, message = "{Size.password}")
    @NotEmpty(message = "{NotEmpty.message}")
    public String pat_Passhash;

	public String getPat_Email() {
		return pat_Email;
	}

	public void setPat_Email(String pat_Email) {
		this.pat_Email = pat_Email;
	}

	public String getPat_Passhash() {
		return pat_Passhash;
	}

	public void setPat_Passhash(String pat_Passhash) {
		this.pat_Passhash = pat_Passhash;
	}
    
    

}
