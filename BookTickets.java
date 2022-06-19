import java.util.*;

public class BookTickets
{
    static int availableLowerBerths = 1;
    static int availableMiddleBerths = 1;
    static int availableUpperBerths = 1;
    static int availableRac = 1;
    static int availableWaitingList = 1;

    static List <Integer> bookedTickets = new ArrayList<>();
    static Queue <Integer> racList = new LinkedList<>();
    static Queue <Integer> waitingList = new LinkedList<>();

    static List <Integer> upperBerthPositions = new ArrayList<>(Arrays.asList(1));
    static List <Integer> middleBerthPositions = new ArrayList<>(Arrays.asList(1));
    static List <Integer> lowerBerthPositions = new ArrayList<>(Arrays.asList(1));
    static List <Integer> racPositions = new ArrayList<>(Arrays.asList(1));
    static List <Integer> waitingListPositions = new ArrayList<>(Arrays.asList(1));
    
    static Map <Integer, Passenger> passenger = new HashMap<>();

    
    public void bookTicket(Passenger p)
    {
        bookedTickets.add(p.passengerId);
        passenger.put(p.passengerId, p);

        System.out.println("Booked Successfully");
    }

    public void addToRac(Passenger p)
    {
        p.alloted = "RAC";
        p.allotedSeat = racPositions.get(0);
        availableRac--;
        racPositions.remove(0);

        passenger.put(p.passengerId, p);

        System.out.println("\nAdded to RAC Successfully");
    }

    public void addToWaitingList(Passenger p)
    {
        p.alloted = "WL";
        p.allotedSeat = waitingListPositions.get(0);
        availableWaitingList--;
        waitingListPositions.remove(0);

        passenger.put(p.passengerId, p);

        System.out.println("\nAdded to Waiting List Successfully");
    }
}