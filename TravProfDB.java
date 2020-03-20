import java.util.*;
import java.io.*;

public class TravProfDB {
    static String filename;
    static TravProf profile;
    public static ArrayList<TravProf> travelerList = new ArrayList<>();
    static boolean exception;

    public TravProfDB(String filename){
        this.filename = filename;
    }

    static void insertNewProfile(TravProf newprofile){
        profile = newprofile;
    }

    static void deleteProfile(String agentID, String LastName){

    }

    static void findProfile(String agentID , String LastName){

    }

    static void findFirstProfile(){

    }

    static void fineNextProfile(){

    }

    // Save Database
    static void writeAllTravProf(){
        // add profile into a list.
        travelerList.add(profile);

        // Push into the file name.
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(travelerList);

            oos.close();
            fos.close();

            System.out.println("Success");
        }
        catch(IOException ioe){
            // Pull data using method
            initializeDataBase(true);
        }



    }

    // Pull data from filename.
    static void initializeDataBase(boolean write){
        ArrayList<TravProf> profiledata = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);

            profiledata = (ArrayList) ois.readObject();

            ois.close();
            fis.close();

        }
        catch(IOException ioe){
            // If file not found.
            // Check if we need to write(save) to database
            // If we need to write then create new file and set exception boolean to true.
            if(write){
                exception = true;
                profiledata.add(profile);

                try {
                    FileOutputStream fos = new FileOutputStream(filename);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);

                    oos.writeObject(profiledata);

                    oos.close();
                    fos.close();
                }
                catch(IOException io){
                    System.out.println("Writing to file failed.");
                    return;
                }
            }
            else {
                System.out.println("File for this agent is not found. Please create a new profile first");
                return;
            }
        }
        catch(ClassNotFoundException c){
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }

    }


}
