package com.dnb.devconnector.dto;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.UniqueElements;

import com.dnb.devconnector.utils.CustomIdGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_seq")
	@GenericGenerator(name = "user_seq",
	  strategy = "com.dnb.devconnector.utils.CustomIdGenerator",
	  parameters = {
			  @Parameter(name=CustomIdGenerator.INCREMENT_PARAM,value = "50"),
			  @Parameter(name=CustomIdGenerator.VALUE_PREFIX_PARAMETER,value = "User_"),
			  @Parameter(name=CustomIdGenerator.NUMBER_FORMAT_PARAMETER,value = "%05d")
			  }
)
	private String userId;
	@Column(nullable = false)
	private String userName;
	@NotNull(message = "Email shouldn't be empty!")
	@UniqueElements(message = "Email should be Unique")
	private String emailId;
	@Length(min = 8, max = 16,message = "The Length of the password should be minimum 8 and maximum 16")
	private String password;
	

	
	
}
