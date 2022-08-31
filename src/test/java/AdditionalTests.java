import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AdditionalTests {
    TicketRepo mock = new TicketRepo();
    TicketManager manage = new TicketManager(mock);

    Ticket ticket1 = new Ticket(1, 100, "AAA", "BBB", 1000);

    Ticket ticket2 = new Ticket(2, 500, "AAA", "XBB", 1111);

    Ticket ticket3 = new Ticket(3, 180, "SSS", "SSR", 1211);

    Ticket ticket4 = new Ticket(4, 450, "AAA", "SBP", 1333);

    Ticket ticket5 = new Ticket(5, 50, "PPP", "BBB", 1500);

    @Test
    public void fewTicketsTest() {
        manage.add(ticket1);
        manage.add(ticket2);
        manage.add(ticket3);
        manage.add(ticket4);
        manage.add(ticket5);

        Ticket[] expected = {ticket5, ticket1, ticket4, ticket2};
        Ticket[] actual = manage.findAll("AAA", "BBB");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void onlyOneResultTest() {
        manage.add(ticket1);
        manage.add(ticket2);
        manage.add(ticket3);
        manage.add(ticket4);
        manage.add(ticket5);

        Ticket[] expected = {ticket3};
        Ticket[] actual = manage.findAll("SSS", "SSR");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void noTicketsTest() {
        manage.add(ticket1);
        manage.add(ticket2);
        manage.add(ticket3);
        manage.add(ticket4);
        manage.add(ticket5);

        Ticket[] expected = {};
        Ticket[] actual = manage.findAll("XXX", "XXX");

        Assertions.assertArrayEquals(expected, actual);
    }
}
