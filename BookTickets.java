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

}