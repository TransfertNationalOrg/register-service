package ma.ensa.controller;

import lombok.Data;
import ma.ensa.model.CurrentAgent;
import ma.ensa.repository.CurrentAgentRepository;
import ma.ensa.service.CurrentAgentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("currentAgent")
@Data
public class CurrentAgentController {

    private final CurrentAgentService currentAgentService;
    private final CurrentAgentRepository currentAgentRepository;

    @PutMapping("/")
    public ResponseEntity<?> update(@PathVariable("id") Long id) throws Exception {
        if (id == null)
            return ResponseEntity.badRequest().body("The provided id is not valid");
        List<CurrentAgent> currentAgents = currentAgentRepository.findAll();
        CurrentAgent currentAgent = currentAgents.get(1);
        currentAgent.setId(id);
        return ResponseEntity.ok().body(currentAgentService.update(currentAgentRepository.getById(id)));
    }

    @GetMapping("/")
    public ResponseEntity<Long> getCurrentAgentId(){
        return ResponseEntity.ok().body(currentAgentRepository.findById(1L).get().getId());
    }

}
