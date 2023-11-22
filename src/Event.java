public class Event {
  private final int ID;
  private final String name;
  private final String place;
  private final String host;
  private final String type;
  private final int date;
  private final int time;

  public Event(int ID, String name, String place, String host, String type, int date, int time) {
    this.ID = ID;
    this.name = name;
    this.place = place;
    this.host = host;
    this.type = type;
    this.date = date;
    this.time = time;
  }

  public int getID() {
    return ID;
  }

  public String getName() {
    return name;
  }

  public String getPlace() {
    return place;
  }

  public String getHost() {
    return host;
  }

  public String getType() {
    return type;
  }

  public int getDate() {
    return date;
  }

  public int getTime() {
    return time;
  }

  public String toString() {
    return name + " : " + place + " : " + host + " : " + type + " : " + date + " : " + time;
  }
}
