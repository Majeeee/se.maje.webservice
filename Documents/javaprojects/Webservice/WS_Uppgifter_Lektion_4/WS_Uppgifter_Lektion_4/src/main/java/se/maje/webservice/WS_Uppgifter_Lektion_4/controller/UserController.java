package se.maje.webservice.WS_Uppgifter_Lektion_4.controller;


import se.maje.webservice.WS_Uppgifter_Lektion_4.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


@RestController
public class UserController {


    // En trådsäker lista för vårt exempel (in-memory)
    private final List<User> customUsers = new CopyOnWriteArrayList<>();


    // Konstruktor: lägg in några testanvändare
    public UserController() {
        customUsers.add(new User(1L, "Alice", "pw1", true));
        customUsers.add(new User(2L, "Benny", "pw2", true));
    }


    // Returnerar en ny user direkt — matchar instruktionen
    @GetMapping("/newUser")
    public User newUser() {
        return new User(0L, "Benny", "123", true);
    }


    // Använder @PathVariable för att ta emot ett username
    @GetMapping("/newUser/{username}")
    public User newUserByUsername(@PathVariable String username) {
        return new User(0L, username, "123", true);
    }


    // Hämta alla customUsers (för vidare testning)
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return customUsers;
    }


    // Skapa en ny användare (läggs i vår in-memory-lista)
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        customUsers.add(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }


    // DELETE endpoint som tar emot id och tar bort eventuella matchande användare
    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable long id) {
        boolean removed = customUsers.removeIf(u -> u.id() == id);
        return removed ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}