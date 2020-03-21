import java.util.*;
import java.io.*;

public class TravProfDB implements Serializable{
    static String filename;
    static ArrayList<String> travelerList = new ArrayList<>();
    static int numTravelers;
    static int currentTravelerIndex=0;
    static ArrayList <String> profile = new ArrayList<>();

    public TravProfDB(String filename){
        this.filename = filename;
    }

    public void insertNewProfile(TravProf newprofile){
        this.travelerList.add("Profile: [agentID: " + newprofile.ID +
                " , firstName: " + newprofile.firstName +
                ", lastName: " + newprofile.lastName +
                ", address: " + newprofile.address +
                ", phone: " + newprofile.phone +
                ", tripCost: " + newprofile.tripCost +
                ", travelType: " + newprofile.travelType +
                ", paymentType: " + newprofile.paymentType +
                ", Medical Contact: " + newprofile.medCond.mdContact +
                ", Medical phone: "+ newprofile.medCond.mdPhone +
                ", allergyType: " + newprofile.medCond.algType +
                ", illness Type: " + newprofile.medCond.illType +"]");


    }

    static String deleteProfile(String agentID, String LastName){
            String profile = findFirstProfile();
            int index = profile.indexOf(LastName);
            if(index >=0){
                travelerList.remove(currentTravelerIndex);
                return "Success";
            }
            while(currentTravelerIndex <= numTravelers){
                profile = findNextProfile();
                index = profile.indexOf(LastName);
                if(index >= 0){
                    travelerList.remove(currentTravelerIndex);
                    return "Success";
                }
            }

            return "Profile not found!";
    }

    static String findProfile(String agentID , String LastName){
        String profile = findFirstProfile();
        int index = profile.indexOf(LastName);
        if(index>=0){
            return profile;
        }

        while(currentTravelerIndex <= numTravelers){
            profile = findNextProfile();
            //System.out.println(profile);
            index = profile.indexOf(LastName);
            if(index >= 0){
                return profile;
            }
        }

        String notFound = "Profile not found!";
        return notFound;
    }

    static String findFirstProfile(){
        initializeDataBase();
        currentTravelerIndex =0;
        return profile.get(currentTravelerIndex);

    }

    static String findNextProfile(){
        currentTravelerIndex++;
        return profile.get(currentTravelerIndex);

    }

    // Save Database
    static void writeAllTravProf() throws IOException{

        // Try to pull data from filename
        // If filename exists push profile on it
        // If not create new one and push on it.

        boolean exception = false;
        ArrayList <TravProf> newprofile = new ArrayList<>();
        // Pull object from file
        try{
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);

            newprofile = (ArrayList) ois.readObject();

            ois.close();
            fis.close();


        } catch(IOException ioe){
            // IF you can't pull object then file does not exists
            // So you push and create a new profile.

            // push new data in file.
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(travelerList);
            exception = true;

            System.out.println("Success");

        }catch(ClassNotFoundException c){
            System.out.println("Class not found");
            return;
        }

        // If file exists, then simply add object to the file.
        if(!exception){
            // Push into the file
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(travelerList);

            oos.close();
            fos.close();

            System.out.println("Success");
        }
    }

    // Pull data from filename.
    static void initializeDataBase(){
        numTravelers = travelerList.size();
        currentTravelerIndex = numTravelers;

        try{
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);

            profile = (ArrayList<String>) ois.readObject();

            ois.close();
            fis.close();

        }
        catch(IOException ioe){
            System.out.println("File not found. Please create a new profile and save it.");
            return;
        }
        catch(ClassNotFoundException c){
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }

        //for(String prof: profile){
        //    System.out.println(prof);
        //}


    }


}
