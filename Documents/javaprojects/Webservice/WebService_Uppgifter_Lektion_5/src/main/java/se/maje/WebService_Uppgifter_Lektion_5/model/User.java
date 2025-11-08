package se.maje.WebService_Uppgifter_Lektion_5.model;

public record User(
        Long id,
        String username,
        String password,
        boolean isEnabled
) {
    // Här kan du lägga till hjälpfunktioner om du vill
}