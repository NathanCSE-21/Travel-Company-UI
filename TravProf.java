import java.io.Serializable;

public class TravProf implements Serializable{
    static String ID;
    static String firstName;
    static String lastName;
    static String address;
    static String phone;
    static float tripCost;
    static String travelType;
    static String paymentType;
    static MedCond medCond;

    // Constructor with parameters.
    // Note: this keyword is self in Python.
    public TravProf(String ID, String firstName, String lastName, String address, String phone, float tripCost, String paymentType, String travelType, MedCond medCond){
        super();
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.tripCost = tripCost;
        this.travelType = travelType;
        this.paymentType = paymentType;
        this.medCond = medCond;
    }

    @Override
    public String toString(){
        return "Profile: [agentID: " + ID + " , firstName: " + firstName + ", lastName: " + lastName +
                ", address: " + address + ", phone: " + phone + ", tripCost: " + tripCost + ", travelType: " +
                travelType + ", paymentType: " + paymentType + "]";
    }

    static void getFirstName(){
        System.out.println("firstName: " + firstName);
    }

    static void getLastName(){
        System.out.println("lastName: " + lastName);
    }

    static void gettravAgentID(){
        System.out.println("agentID: " + ID);
    }

    static void getAddress(){
        System.out.println("address: " + address);
    }

    static void getPhone(){
        System.out.println("phone: " + phone);
    }

    static void getTravelType(){
        System.out.println("travelType: " + travelType);
    }

    static void getpaymentType(){
        System.out.println("paymentType: " + paymentType);
    }

    static void getTripCost(){
        System.out.println("tripCost: " + tripCost);
    }


    // To be implement getMedCondInfo()
    static void getMedCondInfo() {
        System.out.println("medCond: " + medCond);
    }


    // To be implement updateMedCondInfo(MedCond)
    static void updateMedCondInfo(MedCond medcond) {
        medCond = medcond;
    }


    static void updateFirstName(String firstname){
        firstName = firstname;
    }

    static void updateLastName(String lastname){
        lastName = lastname;
    }

    static void updateAddress(String addr){
        address = addr;
    }

    static void updatePhone(String Phone){
        phone = Phone;
    }

    static void updateTripCost(float TripCost){
        tripCost = TripCost;
    }

    static void updateTravelType(String TravelType){
        travelType = TravelType;
    }

    static void updatePaymentType(String Payment){
        paymentType = Payment;
    }



}
