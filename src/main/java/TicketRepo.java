import java.util.Arrays;

public class TicketRepo {
    private Ticket[] tickets = new Ticket[0];

    public void save(Ticket replacement) {
        Ticket[] tmp = new Ticket[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        tmp[tmp.length - 1] = replacement;
        tickets = tmp;
    }

    public void removeById(int id) {
        Ticket[] tmp = new Ticket[tickets.length - 1];
        int copyToIndex = 0;
        for (Ticket replace : tickets) {
            if (replace.getId() != id) {
                tmp[copyToIndex] = replace;
                copyToIndex++;
            }
        }
        tickets = tmp;
    }

    public Ticket[] getTickets() {
        Arrays.sort(tickets);
        System.out.println(Arrays.toString(tickets));
        return tickets;
    }

    public Ticket[] getTicketsQuietly() {
        Arrays.sort(tickets);
        return tickets;
    }
}
