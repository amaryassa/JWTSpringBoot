package com.tokenjwt.task;

import java.util.stream.Stream;

import com.tokenjwt.task.dao.TaskRepository;
import com.tokenjwt.task.entities.AppRole;
import com.tokenjwt.task.entities.AppUser;
// import com.tokenjwt.task.entities.AppRole;
// import com.tokenjwt.task.entities.AppUser;
import com.tokenjwt.task.entities.Task;
import com.tokenjwt.task.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private TaskRepository taskRepository;

	@Autowired
	private AccountService accountService ;
	

	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder getBCPE() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void run(String... args) throws Exception {

		accountService.saveUser(new AppUser(null, "admin", "aze", null));
		accountService.saveUser(new AppUser(null, "user", "aze", null));
		accountService.saveRole(new AppRole(null, "ADMIN"));
		accountService.saveRole(new AppRole(null, "USER"));


		accountService.addRoleToUser("admin", "ADMIN");
		accountService.addRoleToUser("admin", "USER");
		accountService.addRoleToUser("user", "USER");

		Stream.of("T1","T2", "T3").forEach(t ->{
			taskRepository.save(new Task(null, t));
		});
		taskRepository.findAll().forEach(t -> {
			System.out.println(t.getTaskName());
		});

	}

}
