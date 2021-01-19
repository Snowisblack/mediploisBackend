package mueller.paul.Medipolis.controller.rest;

import mueller.paul.Medipolis.dto.LoginRequest;
import mueller.paul.Medipolis.dto.RegisterRequest;
import mueller.paul.Medipolis.dto.UserResponse;
import mueller.paul.Medipolis.model.ReversePiggybank;
import mueller.paul.Medipolis.model.User;
import mueller.paul.Medipolis.repository.ReversePiggybankRepository;
import mueller.paul.Medipolis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest/user")
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ReversePiggybankRepository reversePiggybankRepository;

    @GetMapping(value = "/getByUsername")
    @CrossOrigin(origins = "*")
    public User getUser(@RequestParam(name = "username") String username) throws Exception {
        Optional<User> user = userRepository.findByUsername(username);
        if(user.isPresent()){
            return user.get();
        }
        throw new Exception("USER_NOT_FOUND");
    }

    @PostMapping(value = "/register")
    @CrossOrigin(origins = "*")
    public ResponseEntity<String> registerUser(@RequestBody RegisterRequest registerRequest) {
        Optional<User> user = userRepository.findByUsername(registerRequest.getUsername());
        if(user.isPresent()){
            return ResponseEntity.badRequest().body("USERNAME_ALREADY_TAKEN");
        }else if(!registerRequest.getPassword().equals(registerRequest.getPasswordConfirm())){
            return ResponseEntity.badRequest().body("PASSWORD_MISSMATCH");
        }else{
            User newUser = new User(registerRequest.getUsername(), registerRequest.getPassword());
            ReversePiggybank reversePiggybank = new ReversePiggybank();
            reversePiggybankRepository.save(reversePiggybank);
            newUser.setReversePiggybank(reversePiggybank);
            userRepository.save(newUser);
            reversePiggybank.setUser(newUser);
            reversePiggybankRepository.save(reversePiggybank);
            return ResponseEntity.ok("");
        }
    }

    @PutMapping(value = "/login")
    @CrossOrigin(origins = "*")
    public ResponseEntity<UserResponse> loginUser(@RequestBody LoginRequest loginRequest) {
        Optional<User> user = userRepository.findByUsername(loginRequest.getUsername());
        if(user.isPresent()){
            return ResponseEntity.ok(new UserResponse(user.get()));
        }else{
            return null;
        }
    }

    @GetMapping(value = "/getAll")
    @CrossOrigin( origins = "*")
    public List<User> getAllUser(){
        List<User> allUser = userRepository.findAll();
        return allUser;
    }

    @GetMapping(value = "/getMyUser/{username}")
    @CrossOrigin( origins = "*")
    public User getOneUser(@PathVariable("username") String username){
        User user = userRepository.findByUsername(username).get();
        return user;
    }
}
