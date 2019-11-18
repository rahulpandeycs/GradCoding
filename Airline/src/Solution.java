import java.io.*;
import java.util.*;

/*
 * Your task is to implement the getOverallTrip() method inside the Journey class.
 * You may add new methods or properties to any pre-defined classes, but please do not remove or modify
 * existing ones in a way that would break the current functionality.
 *
 * A Journey consists of a collection of Trips, where each trip has a Start Airport and an End Airport.
 * No information about the order of Trips within a Journey is provided or can be assumed.
 * Based on the Trip data provided, the goal is to determine the Start and End Airports for the entire
 * Journey, if they can be determined.
 *
 * For example, for a Journey consisting of the following two Trips:
 *
 * Trip 1: BOS --> LAX
 * Trip 2: LAX --> DEN
 *
 * getOverallTrip would return BOS --> DEN
 *
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 *
 * You may run your solution at any time by hitting the Run button in the upper left corner.
 */

class Solution {
    public static void main(String[] args) {

        SampleData sd = new SampleData();
        for (Journey journey : sd.getAllJournies().values()) {
            journey.printJourney();
        }
    }

}


/*
 * A Trip consists of a start airport and an end airport.
 */
class Trip {
    public String startAirport;
    public String endAirport;

    public Trip(String start, String end) {
        this.startAirport = start;
        this.endAirport = end;
    }

    public void printTrip() {
        System.out.println(this.startAirport + "-->" + this.endAirport);
    }
}

/*
 * A Journey is a collection of Trips. No order of the Trips inside a Journey can be assumed.
 */
class Journey {
    private List<Trip> trips;

    public Journey() {
        this.trips = new ArrayList<Trip>();
    }

    public void addTrip(Trip trip) {
        this.trips.add(trip);
    }

    public void printJourney() {
        for (Trip trip : trips) {
            trip.printTrip();
        }
        System.out.println("---------");
        getOverallTrip().printTrip();
        System.out.println("\n");

    }


    /*
     * Cyclic jouney is not a valid scenario, i.e A-B, B-C, C-D, D-A, A-M is not valid.
     *
     */
    private Trip getOverallTrip() {

        String start = null;
        String dest = null;

        HashMap<String, String> reverseTripMap = new HashMap<>();
        HashMap<String, String> onwardJourneyMap = new HashMap<>();

        for(Trip trip: trips){
            onwardJourneyMap.put(trip.startAirport,trip.endAirport);
            reverseTripMap.put(trip.endAirport, trip.startAirport);
        }

        for(Trip trip: trips){
            if(!reverseTripMap.containsKey(trip.startAirport)){ // if it is a start airport
                if(start == null){
                    start = trip.startAirport;
                }else{
                    return new Trip("UNKNOWN","UNKNOWN");
                }
            }
        }

        if(start==null){   // if start airport is null, no start airport can be determined.
            return new Trip("UNKNOWN","UNKNOWN");
        }

        String finalDestination = null;

        dest = onwardJourneyMap.get(start); // get onward startion of start.

        while(dest!=null){

            finalDestination = dest;
            dest = onwardJourneyMap.get(dest);
        }

        if(finalDestination ==null) // if final airport is null, no final airport can be determined.
            return new Trip("UNKNOWN","UNKNOWN");
        else
            return new Trip(start,finalDestination);
    }
}

/*
 * Sample Data
 *
 * This class provides a general framework for constructing sample data to use for testing.
 * You may add additional Journies for testing purposes, but please do not otherwise change
 * the SampleData class as it will be used to test your solution.
 */
class SampleData {

    private Map<Integer, Journey> journies;

    public SampleData(){

        journies = new HashMap<Integer, Journey>();

        // Journey 1
        addToJourney(1,"BOS","LAX");
        addToJourney(1,"LAX","DEN");

        // Journey 2
        addToJourney(2,"LAX","DEN");
        addToJourney(2,"BOS","LAX");
        addToJourney(2,"DEN","ORD");

        //Journey L-B
        addToJourney(3,"C","B");
        addToJourney(3,"L","D");
        addToJourney(3,"F","C");
        addToJourney(3,"D","F");

        //Uknown-->Unknown
        addToJourney(4,"L","D");
        addToJourney(4,"S","C");
        addToJourney(4,"D","F");

        //When a corresponding onward journey doesn't exist
        //Uknown-->Unknown
        addToJourney(5,"A","B");
        addToJourney(5,"B","C");
        addToJourney(5,"C","D");
        addToJourney(5,"L","F");

    }

    public Map<Integer, Journey> getAllJournies() {
        return journies;
    }

    public Journey getJourney(int i) {
        return journies.get(i);
    }

    private void addToJourney(int journeyId, String start, String end) {
        if (journies.get(journeyId) != null) {
            journies.get(journeyId).addTrip(new Trip(start, end));
        } else {
            journies.put(journeyId, new Journey() {{ addTrip(new Trip(start, end)); }});
        }
    }

}

