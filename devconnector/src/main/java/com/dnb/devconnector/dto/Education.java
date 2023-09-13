package com.dnb.devconnector.dto;

import java.time.LocalDate;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.dnb.devconnector.utils.CustomIdGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//EXP_DATE_NUMBER
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Education {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "education_seq")
	@GenericGenerator(name = "education_seq",
	  type = CustomIdGenerator.class,
	  parameters = {
			  @Parameter(name=CustomIdGenerator.INCREMENT_PARAM,value = "50"),
			  @Parameter(name=CustomIdGenerator.VALUE_PREFIX_PARAMETER,value = "EDU"),
			  @Parameter(name=CustomIdGenerator.NUMBER_FORMAT_PARAMETER,value = "%05d")
			  //@Parameter(name=CustomIdGenerator.DATE_FORMAT_PARAMETER,value="yyyy/MM/dd"),
			  //@Parameter(name="useDatePrefix",value="false")
			  }
)
	private String educationId;
	@NotNull(message = "School field shouldn't be empty!!")
	private String school;
	@NotNull(message = "Degree field shouldn't be empty!!")
	private String degree;
	private String fieldOfStudy;
	private LocalDate fromDate;
	private LocalDate toDate;
	private String description;
	

}
