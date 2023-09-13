package com.dnb.devconnector;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.dnb.devconnector.dto.Education;
import com.dnb.devconnector.dto.Experience;
import com.dnb.devconnector.dto.Profile;
import com.dnb.devconnector.dto.User;
import com.dnb.devconnector.exceptions.EmailNotFoundException;
import com.dnb.devconnector.service.EducationService;
import com.dnb.devconnector.service.ExperienceService;
import com.dnb.devconnector.service.ProfileService;
import com.dnb.devconnector.service.UserService;


@SpringBootApplication
public class DevconnectorApplication {

	static UserService userService;
	public static void main(String[] args) {
		// creates application context object
		ApplicationContext applicationContext = SpringApplication.run(DevconnectorApplication.class, args);
		userService = applicationContext.getBean(UserService.class); 
		ProfileService profileService = applicationContext.getBean(ProfileService.class);
		EducationService educationService = applicationContext.getBean(EducationService.class);

		Scanner scan = new Scanner(System.in);
		ExperienceService experienceService = applicationContext.getBean(ExperienceService.class);
		Experience experience = new Experience();
		experience.setJobTitle("dev");
		experience.setCompany("dnb");
		experienceService.createExperienceDetails(experience);
		System.exit(0);
		Education education = new Education();
		education.setSchool("ss");
		education.setDegree("ssss");
		educationService.createEducationDetails(education);
		System.exit(0);

		try {
			//profile.setProfileId();
			//profileService.createUserProfile(new Profile(generateAlphanumericUUID(),,"xyz","xyz","xyz","xyz","xyz","xyz","xyz","xyz","xyz","xyz","xyz"));
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		System.exit(0);
		while (true) {
			System.out.println("1.Create User\n2.Get User\n3.Get All User\n4.Delete User\n5.Exit");
			System.out.println("Enter option:");
			int option = scan.nextInt();
			switch (option) {
			case 1:
				createUser();
				break;
			case 2:
				getUser();
				break;
			case 3:
				getAllUsers();
				break;
			case 4:
				deleteUser();
				break;
			case 5:
				scan.close();
				System.exit(0);
			default:
				System.out.println("Wrong choice");
				System.out.println("Choose again..");
				break;
			}
		}
	}
	public static UUID generateAlphanumericUUID() {
		UUID uuid = UUID.randomUUID();
		return uuid;
	}
	public static void createUser() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter User Name:");
		String userName = scan.next();
		System.out.println("Enter your Email Id:");
		String emailId = scan.next();
		System.out.println("Enter your password:");
		String password = scan.next();
		
		User user = new User();
		user.setEmailId(emailId);
		user.setPassword(password);
		user.setUserName(userName);
		System.out.println(userService.createUser(user));
	}

	public static void getUser() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Email Id:");
		String emailId = scan.next();
		Optional<User> returnedAccount = userService.getUserById(emailId);
		if (returnedAccount.isPresent())
			System.out.println(returnedAccount.get());
		else
			System.out.println("Account not found..");
		//scan.close();
	}

	public static void getAllUsers() {
		Iterable<User> accounts = userService.getAllUsers();
		System.out.println(accounts);
	}

	public static void deleteUser() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter account Id to be deleted:");
		String id = scan.next();
		try {
			boolean result = userService.deleteUserById(id);
			if(result)
				System.out.println("Deleted Successfully!!!");
			else
				System.out.println("Couldn't Happen");
		} catch (EmailNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//scan.close();
	}


}
