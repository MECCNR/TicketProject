public class Ticket implements Comparable<Ticket> {

    protected int id;
    protected int price;
    protected String airportDepart;
    protected String airportArrival;
    protected int time;

    public Ticket(int id, int price, String airportDepart, String airportArrival, int time) {
        this.id = id;
        this.price = price;
        this.airportDepart = airportDepart;
        this.airportArrival = airportArrival;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getAirportDepart() {
        return airportDepart;
    }

    public String getAirportArrival() {
        return airportArrival;
    }

    public int getTime() {
        return time;
    }

    @Override
    public int compareTo(Ticket i) {
        if (getPrice() < i.price) {
            return -1;
        } else if (getPrice() > i.price) {
            return 1;
        } else {
            return 0;
        }
    }

    public String toString() {
        return id + " " + price + " " + airportDepart + " " + airportArrival + " " + time;
    }
}
