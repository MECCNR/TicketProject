import java.util.Arrays;

public class TicketManager {
    private TicketRepo repo;

    public TicketManager(TicketRepo repo) {
        this.repo = repo;
    }

    public void add(Ticket ticket) {
        repo.save(ticket);
    }

    public Ticket[] findAll(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket replace : repo.getTickets()) {
            if (matchesDepart(replace, from)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = replace;
                result = tmp;
            } else if (matchesArrival(replace, to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = replace;
                result = tmp;
            }
        }
        Arrays.sort(result);
        System.out.println(Arrays.toString(result));
        return result;
    }

    public boolean matchesDepart(Ticket ticket, String search) {
        if (ticket.getAirportDepart().contains(search)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean matchesArrival(Ticket ticket, String search) {
        if (ticket.getAirportArrival().contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}
