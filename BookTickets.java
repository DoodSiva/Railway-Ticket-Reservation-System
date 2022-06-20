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
    
    static Map <Integer, Passenger> passengers = new HashMap<>();

    
    public void bookTicket(Passenger p)
    {
        bookedTickets.add(p.passengerId);
        passengers.put(p.passengerId, p);

        System.out.println("Booked Successfully");
    }

    public void addToRac(Passenger p)
    {
        p.alloted = "RAC";
        p.number = racPositions.get(0);
        availableRac--;
        racPositions.remove(0);

        passengers.put(p.passengerId, p);
        racList.add(p.passengerId);

        System.out.println("\nAdded to RAC Successfully");
    }

    public void addToWaitingList(Passenger p)
    {
        p.alloted = "WL";
        p.number = waitingListPositions.get(0);
        availableWaitingList--;
        waitingListPositions.remove(0);

        passengers.put(p.passengerId, p);
        waitingList.add(p.passengerId);

        System.out.println("\nAdded to Waiting List Successfully");
    }

    public void cancelTicket(int id)
    {
        Passenger p = passengers.get(id);
        passengers.remove(Integer.valueOf(id));
        bookedTickets.remove(Integer.valueOf(id));

        System.out.println("\nCancelled Successfully");

        int positionBooked = p.number;
       
        if(p.alloted.equals("L")) 
        { 
          availableLowerBerths++;
          lowerBerthPositions.add(positionBooked);
        }
        else if(p.alloted.equals("M"))
        { 
          availableMiddleBerths++;
          middleBerthPositions.add(positionBooked);
        }
        else if(p.alloted.equals("U"))
        { 
          availableUpperBerths++;
          upperBerthPositions.add(positionBooked);
        }

        if(racList.size() > 0)
        {
            Passenger passengerFromRac = passengers.get(racList.poll());
            int positionRac = passengerFromRac.number; 
            racPositions.add(positionRac);
            availableRac++;

            if(waitingList.size() > 0)
            {
                Passenger passengerFromWaitingList = passengers.get(waitingList.poll());
                int positionWaitingList = passengerFromWaitingList.number;
                waitingListPositions.add(positionWaitingList);
                availableWaitingList++;

                passengerFromWaitingList.alloted = "RAC";
                passengerFromWaitingList.number = racPositions.get(0);
                racList.add(passengerFromWaitingList.passengerId);
                
                racPositions.remove(0);
                availableRac--;
            }
            
            App.bookTicket(passengerFromRac);
        }
    }

    public void printBooked()
    {
        if (passengers.size() == 0)
        {
            System.out.println("\nNo Tickets Booked");
            return;
        }

        for (Passenger p : passengers.values())
        {
            System.out.println("\nPassenger ID: " + p.passengerId);
            System.out.println("Name: " + p.name);
            System.out.println("Age: " + p.age);
            System.out.println("Status: " + p.number + p.alloted);
        }
    }

    public void printAvailable()
    {
        System.out.println("\nAvailable Lower Berths: " + availableLowerBerths);
        System.out.println("\nAvailable Middle Berths: " + availableMiddleBerths);
        System.out.println("\nAvailable Upper Berths: " + availableUpperBerths);

        System.out.println("\nAvailable RAC Tickets: " + availableRac);
        System.out.println("\nAvailable Waiting List: " + availableWaitingList);
    }
}