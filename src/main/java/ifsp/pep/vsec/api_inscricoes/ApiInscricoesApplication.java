package ifsp.pep.vsec.api_inscricoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ifsp.pep.vsec.api_inscricoes.model.Aluno;
import ifsp.pep.vsec.api_inscricoes.repository.AlunoRepository;

@SpringBootApplication
public class ApiInscricoesApplication {
	
	public static void main(String[] args) {
		
		
		SpringApplication.run(ApiInscricoesApplication.class, args);
	}

}
