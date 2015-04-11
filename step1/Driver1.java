import java.util.*;
interface HourHandler {
  void hourPassed(long current);
}

class ConsoleHandler implements HourHandler {
  public void hourPassed(long current) {
    System.out.println("Cool! an hour passed! " + current);
  }
}
public class Driver1 {
  public static void main(String[] args) { 
    Clock clock = new Clock();
    HourHandler hh = new ConsoleHandler();
    clock.addHourHandler(hh);
    clock.start();
  }
}
class Clock {
  public void addHourHandler(HourHandler hh) {
    //rudimentary
    hourHandlers.add(hh);
  }
  //PRIVATE






























  private final List<HourHandler> hourHandlers = new ArrayList<>();
  void start() {
    Timer timer = new Timer(false);
    timer.schedule(new TimerTask() {
      public void run() {
        for (HourHandler h : hourHandlers) {
          h.hourPassed(System.currentTimeMillis());
        }
      }
    }, 4000L, 5000L); //start after 4secs and simulate an hour every 5 seconds thereafter :-)
  }
}
