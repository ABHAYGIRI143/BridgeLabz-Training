public class VolumeOfEarth {
    public static void main(String args[]){
       
        float pi = 3.14f;// Standard value of pi is 3.14
        int radius1 = 6378;// Radius in km
        int radius2 = (int)(6378*1.6f);// Radius in Miles
        float volumeInCubicKilometers = (4/3)*pi*(radius1^3);
        float volumeInCubicMiles = (4/3)*pi*(radius2^3);
        System.out.println("The volume of  Earth in cubic kilometers is "+ volumeInCubicKilometers +" and cubic miles is "+volumeInCubicMiles);
    }    
}
