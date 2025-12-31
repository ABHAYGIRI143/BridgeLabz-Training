class CarRental {
    String customerName;
    String carModel;
    int rentalDays;
    double pricePerDay;

   
    CarRental() {
        this("Customer", "Hatchback", 1, 1000);
    }

  
    CarRental(String customerName, String carModel, int rentalDays, double pricePerDay) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        this.pricePerDay = pricePerDay;
    }

    double calculateTotalCost() {
        return rentalDays * pricePerDay;
    }

    void displayRental() {
        System.out.println(customerName + " rented " + carModel +
                " for " + rentalDays + " days. Total Cost: ₹" + calculateTotalCost());
    }

    public static void main(String[] args) {
        CarRental r1 = new CarRental();
        CarRental r2 = new CarRental("Abhay", "SUV", 5, 2500);

        r1.displayRental();
        r2.displayRental();
    }
}
