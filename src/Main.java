import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    System.out.println("ØVING 10 OPPGAVE 1");
    ArrayList<Event> events= new ArrayList<>();
    events.add(new Event(1, "Fotballkamp", "Ullevål Stadion", "NFF", "Sport", 20201101, 1800));
    events.add(new Event(2, "Konsert", "Oslo Spektrum", "Live Nation", "Musikk", 20201102, 1900));
    events.add(new Event(3, "Teater", "Oslo Nye Teater", "Oslo Nye Teater", "Teater", 20201103, 2000));

    Register register = new Register(events);
    Scanner scanner = new Scanner(System.in);
    boolean exit = false;
    while (!exit) {
      menu();
      int userChoice = Integer.parseInt(scanner.nextLine());
      switch (userChoice) {
        case (1): {
          printEvents(register.getEvents());
          break;
        }
        case (2): {
          register.addEvent();
          break;
        }
        case (3): {
          System.out.println("Skriv inn sted:");
          printEvents(register.getEventsBasedPlace(scanner.nextLine()));
          break;
        }
        case (4): {
          System.out.println("Skriv inn dato (yyyymmdd)");
          printEvents(register.getEventsBasedDate(Integer.parseInt(scanner.nextLine())));
          break;
        }
        case (5): {
          System.out.println("Skriv inn dato 1 (yyyymmdd)");
          int dato1 = Integer.parseInt(scanner.nextLine());
          System.out.println("Skriv inn dato 2 (yyyymmdd)");
          int dato2 = Integer.parseInt(scanner.nextLine());

          if (dato1 > dato2) {
            int temp = dato1;
            dato1 = dato2;
            dato2 = temp;
          }
          printEvents(register.getEventsBasedTwoDates(dato1, dato2));
          break;
        }
        default: {
          exit = true;
          break;
        }
      }
    }
  }
  public static void menu() {
    System.out.println("MENY---------------------------------------");
    System.out.println("1. Tabell over alle arrangementer");
    System.out.println("2. Legg til nytt arrangement");
    System.out.println("3. Finn arrangement på gitt sted");
    System.out.println("4. Finn arrangement på gitt dato");
    System.out.println("5. Finn arrangement innenfor to datoer");
    System.out.println("6. Avslutt");
  }

  public static void printEvents(Event[] events) {
    System.out.println("Navn : sted : arrangør : type : dato : tid");
    for (Event event : events) {
      System.out.println(event.toString());
    }
    System.out.println("");
  }
}