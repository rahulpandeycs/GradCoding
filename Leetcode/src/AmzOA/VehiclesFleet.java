package src.AmzOA;

import java.util.Arrays;

public class VehiclesFleet {

    static int[] getFleetVehicleArray(int[] vehicle) {
        int[] possibleFleet = new int[vehicle.length];

        for(int i=0; i < vehicle.length; i++){
            int maxWheel = vehicle[i];
            if(maxWheel % 2 != 0) possibleFleet[i] = 0;
            else{
                possibleFleet[i] = maxWheel/4 + 1;
            }
        }
        return possibleFleet;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getFleetVehicleArray(new int[]{4,5,6})));
    }
}
