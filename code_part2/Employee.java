public class Employee {
    String name;
    double hours;
    double rate;
    Address[] address;

    public Employee(String name, double hours, Double rate, Address[] address) {
        this.name = name;
        this.hours = hours;
        this.rate = rate;
        this.address = address;
    }    

    // ------------- Getters -------------
    public String getName() { return name; }

    public double getHours() { return hours; }

    public double getRate() { return rate; }

    public Address[] getAddress() { return address; }

    // ------------- Setters -------------
    public void setName(String name) { this.name = name; }

    public void setHours(double hours) { this.hours = hours; }

    public void setRate(double rate) { this.rate = rate; }
        
    public void setAddress(Address[] address) { this.address = address; }

}
