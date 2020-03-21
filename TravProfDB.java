import java.util.*;
import java.io.*;

public class TravProfDB implements Serializable{
    static String filename;
    static ArrayList<TravProf> travelerList = new ArrayList<TravProf>();

    public TravProfDB(String filename){
        this.filename = filename;
    }

    public void insertNewProfile(TravProf newprofile){
        this.travelerList.add(newprofile);
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
    static void writeAllTravProf() throws IOException{

        // Try to pull data from filename
        // If filename exists push profile on it
        // If not create new one and push on it.
        ArrayList <TravProf> newprofile = new ArrayList<>();
        boolean exception = false;

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
        }
    }

    // Pull data from filename.
    public void initializeDataBase(){
        try{
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);

            travelerList = (ArrayList) ois.readObject();

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

        for(TravProf profile: travelerList){
            System.out.println(profile);
        }


    }


}
