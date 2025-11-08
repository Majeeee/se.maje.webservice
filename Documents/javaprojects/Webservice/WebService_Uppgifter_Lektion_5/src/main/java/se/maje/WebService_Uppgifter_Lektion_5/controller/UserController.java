package se.maje.WebService_Uppgifter_Lektion_5.controller;
import se.maje.WebService_Uppgifter_Lektion_5.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {


    private final Map<Long, User> userDatabase = new HashMap<>();

    public UserController() {
        userDatabase.put(1L, new User(1L, "Benny", "123", true));
        userDatabase.put(2L, new User(2L, "Frida", "321", true));
    }

    /**
     * DELETE /users/{id} - tar bort en användare
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        if (userDatabase.containsKey(id)) {
            userDatabase.remove(id);
            return ResponseEntity.ok("User with ID " + id + " deleted successfully.");
        } else {
            return ResponseEntity.status(404).body("User with ID " + id + " not found.");
        }
    }
}
