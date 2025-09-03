package se.maje.webservice.webservice_uppgifter_lektion_3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest-kontroller som exponerar en GET-endpoint och returnerar Counter.
 */
@RestController
public class CounterController {

    @GetMapping("/counter")
    public Counter getCounter() {
        return new Counter(1, 100);
    }
}
