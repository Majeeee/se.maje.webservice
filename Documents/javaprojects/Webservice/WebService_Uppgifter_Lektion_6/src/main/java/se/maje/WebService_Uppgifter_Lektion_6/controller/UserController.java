package se.maje.WebService_Uppgifter_Lektion_6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.maje.WebService_Uppgifter_Lektion_6.model.User;
import se.maje.WebService_Uppgifter_Lektion_6.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;


    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // GET /users  Hämta alla användare
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // POST /users  Skapa en ny användare
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    // DELETE /users/{id} Ta bort användare
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.deleteById(id);
            return ResponseEntity.ok().build(); // 200 OK
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }


    // Update /users/{id} → updatera användare  uppgift 6
    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(
            @PathVariable Long id,
            @RequestBody User updatedUser) {

        // Hämta användare från databasen
        Optional<User> existingUserOpt = userRepository.findById(id);

        if (existingUserOpt.isEmpty()) {
            return ResponseEntity.status(404)
                    .body("Användare med ID " + id + " finns inte.");
        }

        User existingUser = existingUserOpt.get();

        // Validera att användarnamn och lösenord finns i request
        if (updatedUser.getUsername() == null || updatedUser.getUsername().isBlank()) {
            return ResponseEntity.badRequest()
                    .body("Användarnamn måste anges.");
        }
        if (updatedUser.getPassword() == null || updatedUser.getPassword().isBlank()) {
            return ResponseEntity.badRequest()
                    .body("Lösenord måste anges.");
        }

        // Uppdatera fälten
        existingUser.setUsername(updatedUser.getUsername());
        existingUser.setPassword(updatedUser.getPassword());
        existingUser.setEnabled(updatedUser.isEnabled());

        // Spara tillbaka i databasen
        userRepository.save(existingUser);

        return ResponseEntity.ok("Användare med ID " + id + " uppdaterad.");
    }
}
