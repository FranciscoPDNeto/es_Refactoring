import java.util.Enumeration;

public class TextStatement extends Statement {

    private String getRentalHeader(Customer aCustomer) {
        return "Rental Record for " + aCustomer.getName() +
            "\n";
    }

    private String getRentalFigure(Rental aRental) {
        return "\t" + aRental.getMovie().getTitle()+ "\t" +
            String.valueOf(aRental.getCharge()) + "\n";
    }

    private String getRentalFooter(Customer aCustomer) {
        return "Amount owed is " +
            String.valueOf(aCustomer.getTotalCharge()) + "\n" +
            "You earned " +
            String.valueOf(aCustomer.getTotalFrequentRenterPoints()) +
            " frequent renter points";
    }

    public String value(Customer aCustomer) {
        Enumeration rentals = aCustomer.getRentals();
        String result = getRentalHeader(aCustomer);
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            //show figures for this rental
            result += getRentalFigure(each);
        }
        //add footer lines
        result += getRentalFooter(aCustomer);
        return result;
    }
    
}
