import java.util.Scanner;

public class App
{
    public static void main (String[] args)
    {
        Scanner input = new Scanner(System.in);
        boolean loop = true;
        int userChoice;

        while (loop)
        {
            System.out.println("Enter Your Choice:\n1. Book Ticket\n2. Cancel Ticket\n3. Print Booked Tickets\n4. Print Available Tickets\n5. Exit\n");
            userChoice = input.nextInt();
            
            switch (userChoice)
            {
                case 1:
                    ;
                case 2:
                    ;
                case 3:
                    ;
                case 4:
                    ;
                case 5:
                    loop = false;
                    break;
                default:
                    System.out.println("Invalid Choice\nExiting Application...");
            }
        }
    }
}