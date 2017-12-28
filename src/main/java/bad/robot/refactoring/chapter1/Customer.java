package bad.robot.refactoring.chapter1;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String statement() {
        StringBuilder result = new StringBuilder(); 
        result.append("Rental record for").append(getName()).append("\n");
        for (Rental rental : rentals) {
        	    result.append("\t").append(rental.getMovie().getTitle())
        	    		  .append("\t").append(rental.getCharge()).append("\n");
        }
        result.append("Amount owed is ").append(getTotalCharge()).append("\n");
        result.append("You earned ").append(getTotalFrequentRenterPoints())
        		  .append(" frequent renter points");
        return result.toString();
    }

    public String htmlStatement() {  // Pode ser refatorado ainda?
        String result = "<h1>Rental record for <b>" + getName() + "</b></h1>\n";
        for (Rental rental : rentals)
            result += "<p>" + rental.getMovie().getTitle() + "\t" + rental.getCharge() + "</p>\n";
        result += "<p>Amount owed is <b>" + getTotalCharge() + "</b></p>\n";
        result += "<p>You earned <b>" + getTotalFrequentRenterPoints() + " frequent renter points</b></p>";
        return result;

    }

    private double getTotalCharge() {
        double total = 0;
        for (Rental rental : rentals)
            total += rental.getCharge();
        return total;
    }

    private int getTotalFrequentRenterPoints() {
        int total = 0;
        for (Rental rental : rentals)
            total += rental.getFrequentRenterPoints();
        return total;
    }

}
