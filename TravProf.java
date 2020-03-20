import java.io.Serializable;

public class TravProf implements Serializable{
    String ID;
    String firstName;
    String lastName;
    String address;
    String phone;
    float tripCost;
    String travelType;
    String paymentType;

    // Constructor with parameters.
    // Note: this keyword is self in Python.
    public TravProf(String ID, String firstName, String lastName, String address, String phone, float tripCost, String paymentType, String travelType){
        super();
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.tripCost = tripCost;
        this.travelType = travelType;
        this.paymentType = paymentType;
    }

    @Override
    public String toString(){
        return "Profile: [agentID: " + ID + " , firstName: " + firstName + ", lastName: " + lastName +
                ", address: " + address + ", phone: " + phone + ", tripCost: " + tripCost + ", travelType: " +
                travelType + ", paymentType: " + paymentType + "]";
    }


}
