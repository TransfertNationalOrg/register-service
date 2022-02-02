package ma.ensa;

import lombok.Data;
import ma.ensa.model.CurrentAgent;
import ma.ensa.model.CurrentClient;
import ma.ensa.repository.CurrentAgentRepository;
import ma.ensa.repository.CurrentClientRepository;
import ma.ensa.service.CurrentAgentService;
import ma.ensa.service.CurrentClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@Data
@EnableEurekaServer
@SpringBootApplication
public class RegisterServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RegisterServiceApplication.class, args);
	}

	private final CurrentClientService currentClientService;
	private final CurrentClientRepository clientRepository;
	private final CurrentAgentService currentAgentService;
	private final CurrentAgentRepository currentAgentRepository;

	@Override
	public void run(String... args) throws Exception {
		if (currentAgentRepository.findAll().size()==0){
			CurrentAgent currentAgent = new CurrentAgent();
			currentAgent.setId(1L);
			currentAgentService.save(currentAgent);
		}

		if(clientRepository.findAll().size()==0){
			CurrentClient currentClient = new CurrentClient();
			currentClient.setId(1L);
			currentClientService.save(currentClient);
		}
	}
}
