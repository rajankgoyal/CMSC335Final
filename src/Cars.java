public class Cars implements Runnable{
    boolean carRunner;
    String carName;
    Thread thread;
    int location;

    public Cars(String carName, int location) {
        this.carName = carName;
        this.thread = new Thread(this, carName);
        this.location = location;
        carRunner = true;
    }

    @Override
    public void run() {
        while (carRunner){
            location +=1;
        }
    }
}
