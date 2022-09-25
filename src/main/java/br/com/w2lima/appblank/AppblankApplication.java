package br.com.w2lima.appblank;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import br.com.w2lima.appblank.model.UserModel;
import br.com.w2lima.appblank.model.enums.UserStatusEum;
import br.com.w2lima.appblank.repository.UserRepository;

@EnableWebMvc
@SpringBootApplication
public class AppblankApplication implements CommandLineRunner{

	@Autowired
	private UserRepository repo;
	
    public static void main(String[] args) {
        SpringApplication.run(AppblankApplication.class, args);
    }

	@Override
	public void run(String... args) throws Exception {
		UserModel william = UserModel.builder().id(UUID.randomUUID()).name("William Lima").born(LocalDate.of(1977,  06,28)).status(UserStatusEum.BLOQUEADO).build();
		UserModel will = UserModel.builder().id(UUID.randomUUID()).name("William Carvalho").born(LocalDate.of(2016,  10,31)).status(UserStatusEum.INATIVO).build();
		repo.saveAll(List.of(william, will));
		
		
	}

}
