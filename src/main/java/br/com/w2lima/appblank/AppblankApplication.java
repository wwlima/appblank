package br.com.w2lima.appblank;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import br.com.w2lima.appblank.model.NotaModel;
import br.com.w2lima.appblank.model.ProdutoModel;
import br.com.w2lima.appblank.model.UserModel;
import br.com.w2lima.appblank.model.VendaModel;
import br.com.w2lima.appblank.model.enums.UserStatusEum;
import br.com.w2lima.appblank.repository.NotaRepository;
import br.com.w2lima.appblank.repository.ProdutoRepository;
import br.com.w2lima.appblank.repository.UserRepository;
import br.com.w2lima.appblank.repository.VendaRepository;

@EnableWebMvc
@SpringBootApplication
public class AppblankApplication implements CommandLineRunner{

	@Autowired
	private UserRepository repo;
	
	@Autowired
	private NotaRepository notaRepo;
	
	@Autowired
	private ProdutoRepository produtoRepo;
	
	@Autowired
	private VendaRepository vendaRepo;
	
    public static void main(String[] args) {
        SpringApplication.run(AppblankApplication.class, args);
    }

	@Override
	public void run(String... args) throws Exception {
		UserModel william = UserModel.builder().id(UUID.randomUUID()).name("William Lima").born(LocalDate.of(1977,  06,28)).status(UserStatusEum.BLOQUEADO).build();
		UserModel will = UserModel.builder().id(UUID.randomUUID()).name("William Carvalho").born(LocalDate.of(2016,  10,31)).status(UserStatusEum.INATIVO).build();
		UserModel ze = UserModel.builder().id(UUID.randomUUID()).name("Ze Carvalho").born(LocalDate.of(2016,  10,31)).status(UserStatusEum.ATIVO).build();
		
		//repo.findAll().stream().forEach(System.out::println);
		
		ProdutoModel p1 = ProdutoModel.builder().id(UUID.randomUUID()).name("Cadeira").valor(100.0).build();
		ProdutoModel p2 = ProdutoModel.builder().id(UUID.randomUUID()).name("Mesa   ").valor(300.0).build();
		ProdutoModel p3 = ProdutoModel.builder().id(UUID.randomUUID()).name("Caneta ").valor( 10.0).build();
		//produtoRepo.saveAll(List.of(p1,p2,p3));
		
		NotaModel n1 = new NotaModel(UUID.randomUUID(), LocalDate.now(), will);	
		n1.addProduto(p1,3);
		n1.addProduto(p2,5);
		n1.addProduto(p3,4);
		notaRepo.save(n1);
		
		
		
		NotaModel n2 = new NotaModel(UUID.randomUUID(), LocalDate.now(), william);	
		n2.addProduto(p1,2);
		n2.addProduto(p2,3);
		notaRepo.save(n2);
		
		//notaRepo.findAll().forEach(System.out::println);
				
		
		//System.out.println("Listando produtos da nota 1 - Fetch Eager - INEFICIENTE");
		//System.out.println(vendaRepo.findByNotaId(n1.getId()));
		
		System.out.println("Listando produtos da nota 1 - EFICIENTE");
		NotaModel notaResult = notaRepo.findNota(n1.getId());
		System.out.println(notaResult);
		System.out.println("----------------------------");
		
		
		
	}

}
