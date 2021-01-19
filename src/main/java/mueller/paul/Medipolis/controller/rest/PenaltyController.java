package mueller.paul.Medipolis.controller.rest;

import mueller.paul.Medipolis.dto.PenaltyRequest;
import mueller.paul.Medipolis.model.Penalty;
import mueller.paul.Medipolis.model.ReversePiggybank;
import mueller.paul.Medipolis.model.User;
import mueller.paul.Medipolis.repository.PenaltyRepository;
import mueller.paul.Medipolis.repository.ReversePiggybankRepository;
import mueller.paul.Medipolis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest/penalty")
public class PenaltyController {
    @Autowired
    private PenaltyRepository penaltyRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ReversePiggybankRepository piggybankRepository;

    @GetMapping(value = "/getAll")
    @CrossOrigin(origins = "*")
    public List<Penalty> getAll(){
        return penaltyRepository.findAll();
    }

    @PostMapping(value = "/create")
    @CrossOrigin(origins = "*")
    public void makeOne(@RequestBody PenaltyRequest penaltyRequest){
        Penalty penalty = new Penalty(penaltyRequest.getName(), penaltyRequest.getValue());
        penaltyRepository.save(penalty);
    }

    @PutMapping(value = "/addPenalty/{username}/{penaltyId}")
    @CrossOrigin(origins = "*")
    public boolean addPenalty(@PathVariable("username") String username,
                           @PathVariable("penaltyId") Long id){
        System.out.println(username);
        Optional<User> u = userRepository.findByUsername(username);
        id += 1;
        User user = null;
        if(u.isPresent()){
            user = u.get();
        }else{
            return false;
        }
        Penalty penalty = penaltyRepository.getOne(id);
        ReversePiggybank reversePiggybank = piggybankRepository.findByUser(user);
        reversePiggybank.addPenalty(penalty);
        reversePiggybank.setBalance();
        piggybankRepository.save(reversePiggybank);
        userRepository.save(user);
        return true;
    }

    @PutMapping(value = "/clearPens/{username}")
    @CrossOrigin(origins = "*")
    public boolean clearPens(@PathVariable("username") String username){
        User user = userRepository.findByUsername(username).get();
        ReversePiggybank reversePiggybank = user.getReversePiggybank();
        reversePiggybank.clearPenalties();
        reversePiggybank.setBalance();
        piggybankRepository.save(reversePiggybank);
        return true;
    }
}
