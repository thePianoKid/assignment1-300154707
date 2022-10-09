public class Address {
    String street;
    int number;
    String postal;

    public Address(String street, int number, String postal) {
        this.street = street;
        this.number = number;
        this.postal = postal;
    }

    // ------------- Getters -------------
    public String getStreet() { return street; }

    public int getNumber() { return number; }

    public String postal() { return postal; }

    // ------------- Setters -------------
    public void setStreet(String street) { this.street = street; }

    public void setNumber(int number) { this.number = number; }

    public void setPostal(String postal) { this.postal = postal; }
}