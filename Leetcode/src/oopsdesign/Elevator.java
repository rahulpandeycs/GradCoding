package src.oopsdesign;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


enum Direction {
    UP, DOWN
}

enum State {
    MOVING, STOPPED
}

enum Door {
    OPEN, CLOSED
}

class Request {
    public long time;
    public Integer floor;
    public Direction direction;

    public Request(long time, Integer floor, Direction direction) {
        this.time = time;
        this.floor = floor;
        this.direction = direction;
    }
}

 class Process implements Runnable {
    private Elevator elevator;

    Process(Elevator elevator){
        this.elevator = elevator;
    }
    @Override
    public void run() {
        elevator.process();
    }
}

 class Listen implements Runnable {
     private Elevator elevator;

     Listen(Elevator elevator){
         this.elevator = elevator;
     }
    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(90000);
            while (true) {
                Socket socket = serverSocket.accept();
                Thread thread = new Thread(new Worker(socket, this.elevator));
                thread.start();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}

 class Worker implements Runnable {
    private Socket s;
    private Elevator elevator;

    public Worker(Socket s, Elevator elevator) {
        this.s = s;
        this.elevator = elevator;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(s.getInputStream()));
            String line;
            while (true) {
                if ((line = reader.readLine()) != null) {
                    String[] tokens = line.split(" ");
                    if(tokens.length == 3 && tokens[0].equals("call")){
                        elevator.call(Integer.parseInt(tokens[1]), tokens[2].equals("up")?Direction.UP:Direction.DOWN);
                    }else if(tokens.length == 2 && tokens[0].equals("go")){
                        elevator.go(Integer.parseInt(tokens[1]));
                    }else{
                        s.getOutputStream().write("Wrong input".getBytes());
                    }
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

public class Elevator {
    private float location = 0;
    private Direction direction = Direction.UP;
    private State state = State.STOPPED;
    private Door door = Door.CLOSED;
    private Thread processingThread;
    private Thread listeningThread;

    public Comparator<Request> upComparator = new Comparator<Request>() {
        public int compare(Request u1, Request u2) {
            return u1.floor.compareTo(u2.floor);
        }
    };

    public Comparator<Request> downComparator = upComparator.reversed();

    private Queue<Request> upQueue = new PriorityQueue<>(upComparator);
    private Queue<Request> currentQueue = upQueue;
    private Queue<Request> downQueue = new PriorityQueue<>(downComparator);

    public void call(int floor, Direction direction) {
        if (direction == Direction.UP) {
            if (floor >= location) {
                currentQueue.add(new Request(System.currentTimeMillis(), floor, direction));
            } else {
                upQueue.add(new Request(System.currentTimeMillis(), floor, direction));
            }
        } else {
            if (floor <= location) {
                currentQueue.add(new Request(System.currentTimeMillis(), floor,
                        direction));
            } else {
                downQueue.add(new Request(System.currentTimeMillis(), floor,
                        direction));
            }
        }
    }

    public void go(int floor) {
        call(floor, direction);
    }

    public void process() {
        while (true) {
            if (!upQueue.isEmpty() && !downQueue.isEmpty()) {
                Request r = currentQueue.poll();
                if (r != null) {
                    goToFloor(r.floor);
                } else {
                    preProcessNextQueue();
                }
            }
        }
    }

    public void goToFloor(int floor) {
        state = State.MOVING;
        for (float i = location; i <= floor; i = (float) (i + 0.1)) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        location = floor;
        door = Door.OPEN;
        state = State.STOPPED;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        door = Door.CLOSED;
    }

    private void preProcessNextQueue() {
        if (getLowestTimeUpQueue() > getLowestTimeDownQueue()) {
            this.direction = Direction.UP;
            currentQueue = upQueue;
            upQueue = new PriorityQueue<>(upComparator);
        } else {
            this.direction = Direction.DOWN;
            currentQueue = downQueue;
            downQueue = new PriorityQueue<>(downComparator);
        }
    }

    private long getLowestTimeUpQueue() {
        long lowest = Long.MAX_VALUE;
        for (Request r : upQueue) {
            if (r.time < lowest)
                lowest = r.time;
        }
        return lowest;
    }

    private long getLowestTimeDownQueue() {
        long lowest = Long.MAX_VALUE;
        for (Request r : downQueue) {
            if (r.time < lowest)
                lowest = r.time;
        }
        return lowest;
    }

    public static void main(String[] args) {
        Elevator elevator = new Elevator();
        elevator.listeningThread = new Thread(new Listen(elevator));
        elevator.listeningThread.start();
        elevator.processingThread = new Thread(new Process(elevator));
        elevator.processingThread.start();
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
