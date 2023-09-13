package com.dnb.devconnector.dto;

import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.dnb.devconnector.utils.CustomIdGenerator;
import com.dnb.devconnector.utils.ProfessionalStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class Profile {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "profile_seq")
	@GenericGenerator(name = "profile_seq",
	  strategy = "com.dnb.devconnector.utils.CustomIdGenerator",
	  parameters = {
			  @Parameter(name=CustomIdGenerator.INCREMENT_PARAM,value = "50"),
			  @Parameter(name=CustomIdGenerator.VALUE_PREFIX_PARAMETER,value = "PRO_"),
			  @Parameter(name=CustomIdGenerator.NUMBER_FORMAT_PARAMETER,value = "%05d")
			  }
)
     private UUID profileId;// uuid.toString();
	@NotNull(message = "You need to enter data in this field!!!")
	 @Column(nullable=false)
	@Enumerated(EnumType.ORDINAL)
     private ProfessionalStatus professionalStatus;
     private String company;
     private String website;
     private String location;
     @NotNull(message = "You need to enter data in this field!!!")
     @Column(nullable=false)
     private String skills;
     private String githubUsername;
     private String aboutYourself;
     private String twitterURL;
     private String facebookURL;
     private String youtubeURL;
     private String linkedlinURL;
     private String instagramURL;
}
