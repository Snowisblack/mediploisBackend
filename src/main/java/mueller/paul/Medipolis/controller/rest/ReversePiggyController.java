package mueller.paul.Medipolis.controller.rest;

import mueller.paul.Medipolis.model.ReversePiggybank;
import mueller.paul.Medipolis.model.User;
import mueller.paul.Medipolis.repository.ReversePiggybankRepository;
import mueller.paul.Medipolis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/piggy")
public class ReversePiggyController {

    @Autowired
    ReversePiggybankRepository reversePiggybankRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/getBalance")
    @CrossOrigin(origins = "*")
    public float getBalance(@RequestParam(name = "username") String username){
        Optional<User> user = userRepository.findByUsername(username);
        if(user.isPresent()){
            ReversePiggybank reversePiggybank = user.get().getReversePiggybank();
        }
        return -1;
    }
}
