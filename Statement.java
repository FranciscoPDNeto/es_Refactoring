import java.util.Enumeration;

public abstract class Statement {

    protected abstract String getRentalHeader(Customer aCustomer);
    protected abstract String getRentalFigure(Rental aRental);
    protected abstract String getRentalFooter(Customer aCustomer);
    
    public String value(Customer aCustomer) {
        Enumeration rentals = aCustomer.getRentals();
        String result = getRentalHeader(aCustomer);
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            //show figures for each rental
            result += getRentalFigure(each);
        }
        //add footer lines
        result += getRentalFooter(aCustomer);
        return result;
    }
}
