// Try This 12-1

// A simulation of a traffic light that uses 
// an enumeration to describe the light's color. 
 
// An enumeration of the colors of a traffic light. 
enum TrafficLightColor {  
  RED, GREEN, YELLOW 
}

// A computerized traffic light. 
public class TrafficLight implements Runnable {
  private TrafficLightColor tlc; // holds the current traffic light color 
  private boolean stop = false; // set to true to stop the simulation 
  private boolean changed = false; // true when the light has changed
  Thread thread;
  TrafficLight(TrafficLightColor init, String name) {
    tlc = init;
    thread= new Thread( this, name);
  } 
 
  TrafficLight() {
    tlc = TrafficLightColor.RED; 
  } 
 
  // Start up the light. 
  public void run() {
    while(!stop) {
      try {
        switch(tlc) {
          case GREEN: 
            Thread.sleep(5500); // green for 10 seconds
            break; 
          case YELLOW: 
            Thread.sleep(500);  // yellow for 2 seconds
            break; 
          case RED: 
            Thread.sleep(8000); // red for 12 seconds
            break; 
        } 
      } catch(InterruptedException exc) { 
        System.out.println(exc); 
      } 
      changeColor(); 
    }  
  } 
 
  // Change color. 
  synchronized void changeColor() { 
    switch(tlc) { 
      case RED: 
        tlc = TrafficLightColor.GREEN; 
        break; 
      case YELLOW: 
        tlc = TrafficLightColor.RED; 
        break; 
      case GREEN: 
       tlc = TrafficLightColor.YELLOW; 
    } 
 
    changed = true;
    notify(); // signal that the light has changed 
  } 
 
  // Wait until a light change occurs. 
  synchronized void waitForChange() { 
    try { 
      while(!changed) 
        wait(); // wait for light to change 
      changed = false;
    } catch(InterruptedException exc) { 
      System.out.println(exc); 
    } 
  } 
 
  // Return current color. 
  synchronized TrafficLightColor getColor() { 
    return tlc; 
  } 
 
  // Stop the traffic light. 
  synchronized void cancel() { 
    stop = true; 
  }


}
