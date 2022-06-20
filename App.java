import java.util.Scanner;

public class App
{
    public static void bookTicket(Passenger p)
    {
        BookTickets booker = new BookTickets();

        if (BookTickets.availableWaitingList == 0)
        {
            System.out.println("\nNo tickets available");
            return;
        }

        if( (p.preferredBerth.equals("L") && BookTickets.availableLowerBerths > 0) ||
            (p.preferredBerth.equals("M") && BookTickets.availableMiddleBerths > 0) ||
            (p.preferredBerth.equals("U") && BookTickets.availableUpperBerths > 0) )
        {
            System.out.println("\nPreferred Berth Available");

            if (p.preferredBerth.equals("L"))
            {
                p.alloted = "L";
                p.number = BookTickets.lowerBerthPositions.get(0);
                booker.bookTicket(p);
                BookTickets.availableLowerBerths--;
                BookTickets.lowerBerthPositions.remove(0);
            }

            if (p.preferredBerth.equals("M"))
            {
                p.alloted = "M";
                p.number = BookTickets.middleBerthPositions.get(0);
                booker.bookTicket(p);
                BookTickets.availableMiddleBerths--;
                BookTickets.middleBerthPositions.remove(0);
            }

            if (p.preferredBerth.equals("U"))
            {
                p.alloted = "U";
                p.number = BookTickets.upperBerthPositions.get(0);
                booker.bookTicket(p);
                BookTickets.availableUpperBerths--;
                BookTickets.upperBerthPositions.remove(0);
            }
        }

        else if (BookTickets.availableMiddleBerths > 0)
        {
            System.out.println("\nMiddle Berth Given");

            p.alloted = "M";
            p.number = BookTickets.middleBerthPositions.get(0);
            booker.bookTicket(p);
            BookTickets.availableMiddleBerths--;
            BookTickets.middleBerthPositions.remove(0);  
        }

        else if (BookTickets.availableLowerBerths > 0)
        {
            System.out.println("\nLower Berth Given");

            p.alloted = "L";
            p.number = BookTickets.lowerBerthPositions.get(0);
            booker.bookTicket(p);
            BookTickets.availableLowerBerths--;
            BookTickets.lowerBerthPositions.remove(0);   
        }

        else if (BookTickets.availableUpperBerths > 0)
        {
            System.out.println("\nUpper Berth Given");

            p.alloted = "U";
            p.number = BookTickets.upperBerthPositions.get(0);
            booker.bookTicket(p);
            BookTickets.availableUpperBerths--;
            BookTickets.upperBerthPositions.remove(0);
        }

        else if (BookTickets.availableRac > 0)
        {
            booker.addToRac(p);
        }

        else if (BookTickets.availableWaitingList > 0)
        {
            booker.addToWaitingList(p);
        }        
    }

    
    public static void cancelTicket(int id)
    {
        BookTickets booker = new BookTickets();
        
        if(!BookTickets.passengers.containsKey(id))
        {
            System.out.println("Passenger detail unknown");
        }

        else
        {
            booker.cancelTicket(id);
        }
    }
    
    
    public static void main (String[] args)
    {
        Scanner input = new Scanner(System.in);
        boolean loop = true;
        int userChoice;

        while (loop)
        {
            System.out.print("\n1. Book Ticket\n2. Cancel Ticket\n3. Print Booked Tickets\n4. Print Available Tickets\n5. Exit\n\nEnter Your Choice: ");
            userChoice = input.nextInt();
            
            switch (userChoice)
            {
                case 1:
                {
                    System.out.print("\nName: ");
                    String name = input.next();

                    System.out.print("Age: ");
                    int age = input.nextInt();

                    System.out.print("Preferred Berth (L, M or U): ");
                    String preferredBerth = input.next();

                    Passenger p = new Passenger(name, age, preferredBerth);

                    bookTicket(p);
                }
                    break;
                case 2:
                {
                    System.out.print("\nEnter Passenger ID: ");
                    int id = input.nextInt();
                    cancelTicket(id);
                }
                    break;
                case 3:
                {
                    BookTickets booker = new BookTickets();
                    booker.printBooked();
                }
                    break;
                case 4:
                {
                    BookTickets booker = new BookTickets();
                    booker.printAvailable();
                }
                    break;
                case 5:
                    loop = false;
                    break;
                default:
                    System.out.println("Invalid Choice\nExiting Application...");
                    loop=false;
            }
        }
    }
}