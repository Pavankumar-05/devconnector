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

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Experience {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "experience_seq 	")
	@GenericGenerator(name = "experience_seq",
	  type = CustomIdGenerator.class,
	  parameters = {
			  @Parameter(name=CustomIdGenerator.INCREMENT_PARAM,value = "50"),
			  @Parameter(name=CustomIdGenerator.VALUE_PREFIX_PARAMETER,value = "EXP_"),
			  @Parameter(name=CustomIdGenerator.NUMBER_FORMAT_PARAMETER,value = "%05d"),
			  @Parameter(name="dateFormat",value="yyyyMM"),
			  //@Parameter(name="useDatePrefix",value="true")
			  }
)
	private String experienceId;
	@NotNull(message = "Company field shouldn't be empty!!!")
	private String jobTitle;
	@NotNull(message = "Company field shouldn't be empty!!!")
	private String company;
	private String location;
	private LocalDate fromDate;
	private boolean currentJob;
	private LocalDate toDate;
	private String description;
}
