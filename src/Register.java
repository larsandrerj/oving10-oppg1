import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class Register {
  private ArrayList<Event> events;
  private final Scanner scanner = new Scanner(System.in);
  private final Random random = new Random();

  public Register(ArrayList<Event> events) {
    this.events = events;

  }
  public void addEvent() {
    String name = getUserStringInput("Skriv inn navn på arrangementet");
    String place = getUserStringInput("Skriv inn stedet arrangementet skal holdes");
    String host = getUserStringInput("Skriv inn arrangøren av arrangementet");
    int date = getUserIntInput("Skriv inn datoen arrangementet skal holdes (yyyymmdd)");
    int time = getUserIntInput("Skriv inn tiden arrangementet skal holdes (hhmm)");
    String type = getUserStringInput("Skriv inn typen arrangementet er");

    while (true) {
      int ID = random.nextInt(100000);
      if (events.stream().noneMatch(event -> event.getID() == ID)) {
        events.add(new Event(ID, name, place, host, type, date, time));
        break;
      }
    }
  }
  public Event[] getEventsBasedPlace(String place) {
    return events.stream().filter(event -> event.getPlace().equals(place)).toArray(Event[]::new);
  }

  public Event[] getEventsBasedDate(int date) {
    return events.stream().filter(event -> event.getDate() == date).toArray(Event[]::new);
  }
  public Event[] getEventsBasedTwoDates(int date1, int date2) {
    return events.stream().filter(event -> event.getDate() >= date1 && event.getDate() <= date2).sorted(Comparator.comparing(Event::getTime)).toArray(Event[]::new);
  }
  public Event[] getEvents() {
    return events.stream().sorted(Comparator.comparing(Event::getPlace).thenComparing(Event::getDate).thenComparing(Event::getTime)).toArray(Event[]::new);
  }
  private String getUserStringInput(String message) {
    System.out.println(message);
    return scanner.nextLine();
  }
  private int getUserIntInput(String message) {
    int userInput;
    while (true) {
      try {
        System.out.println(message);
        userInput = Integer.parseInt(scanner.nextLine());
        break;
      } catch (Exception e) {
        System.out.println("Ugyldig inndata: Ikke et heltall");
      }
    }
    return userInput;
  }
}
