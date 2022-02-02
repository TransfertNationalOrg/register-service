package ma.ensa.controller;

import lombok.Data;
import ma.ensa.model.CurrentClient;
import ma.ensa.repository.CurrentClientRepository;
import ma.ensa.service.CurrentClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("currentClient")
@Data
public class CurrentClientController {

    private final CurrentClientService currentClientService;
    private final CurrentClientRepository clientRepository;

    @PutMapping("/")
    public ResponseEntity<?> update(@PathVariable("id") Long id) throws Exception {
        if (id == null)
            return ResponseEntity.badRequest().body("The provided id is not valid");
        List<CurrentClient> currentClients = clientRepository.findAll();
        CurrentClient currentClient = currentClients.get(1);
        currentClient.setId(id);
        return  ResponseEntity.ok().body(currentClientService.update(currentClient));
    }

    @GetMapping("/")
    public ResponseEntity<Long> getCurrentClientId(Long id){
        return ResponseEntity.ok().body(clientRepository.findById(1L).get().getId());
    }
}
