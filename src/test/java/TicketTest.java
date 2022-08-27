import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TicketTest {

    TicketRepo mock = new TicketRepo();
    TicketManager manage = new TicketManager(mock);

    Ticket ticket1 = new Ticket(1, 100, "AAA", "BBB", 1000);

    Ticket ticket2 = new Ticket(2, 500, "AAA", "XBB", 1111);

    Ticket ticket3 = new Ticket(3, 180, "SSS", "SSR", 1211);

    Ticket ticket4 = new Ticket(4, 450, "AAA", "SBP", 1333);

    Ticket ticket5 = new Ticket(5, 50, "PPP", "BBB", 1500);

    @Test
    public void searchTest() {
        manage.add(ticket5);
        manage.add(ticket4);
        manage.add(ticket3);
        manage.add(ticket2);
        manage.add(ticket1);

        Ticket[] expected = {ticket5, ticket1, ticket4, ticket2};
        Ticket[] actual = manage.findAll("AAA", "BBB");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addTest() {
        manage.add(ticket5);
        manage.add(ticket4);
        manage.add(ticket3);
        manage.add(ticket2);
        manage.add(ticket1);

        Ticket[] expected = {ticket5, ticket1, ticket3, ticket4, ticket2};
        Ticket[] actual = mock.getTickets();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void deleteTest() {
        manage.add(ticket5);
        manage.add(ticket4);
        manage.add(ticket3);
        manage.add(ticket2);
        manage.add(ticket1);

        mock.removeById(1);

        Ticket[] expected = {ticket5, ticket3, ticket4, ticket2};
        Ticket[] actual = mock.getTickets();

        Assertions.assertArrayEquals(expected, actual);
    }


}
