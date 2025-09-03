package se.maje.webservice.webservice_uppgifter_lektion_3;

public class Counter {
    private int id;
    private int value;

    // Constructor
    public Counter(int id, int value) {
        this.id = id;
        this.value = value;
    }

    // Getters
    public int getId() {
        return id;
    }

    public int getValue() {
        return value;
    }
}
