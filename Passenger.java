public class Passenger
{
    static int id = 1;
    int passengerId;

    String name;
    int age;
    String preferredBerth;

    String alloted;
    int number; // seat number
    
    public Passenger (String name, int age, String preferredBerth)
    {
        this.passengerId = id++;
        this.name = name;
        this.age = age;
        this.preferredBerth = preferredBerth;
    }
}