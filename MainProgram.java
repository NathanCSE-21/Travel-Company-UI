import java.util.Scanner;
import java.io.Console;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.io.*;

public class MainProgram {
    public static void main(String[] args) throws IOException
    {
        // Welcome message.
        System.out.println("Welcome to ITS Travel Agency. Please select your role:");


        // Display two options
        // Traveler and Agent
        System.out.println("1. Traveler");
        System.out.println("2. Travel Agent");

        System.out.print("Please enter it here: ");
        // Create Scanner object
        Scanner obj= new Scanner(System.in);
        String usrinput = obj.nextLine();

        // User
        if(usrinput.equals("1")){
            // If you're here then proceed to give this user options
            clean();

        }

        // Agent
        else{
            clean();

            System.out.println("Welcome Agent. Please enter your information to login");

            boolean userpassword = true;

            while(userpassword) {
                // Get username.
                System.out.print("AgentID: ");
                Scanner usernameobj = new Scanner(System.in);
                String username = usernameobj.nextLine();

                // Get password.
                System.out.print("Password: ");
                Console console = System.console();
                char[] passwordArray = console.readPassword();
                String password = new String(passwordArray);

                // For testing out password. Keep it hidden always.
                // System.out.println("Real password is " + password);

                if (username.equals(password)) {
                    userpassword = false;
                    clean();
                    System.out.println("Login Success!");

                    boolean agentOption = true;

                    // Variable to use for information
                    // To update, to save to database, to delete.
                    String firstName= "";
                    String lastName = "";
                    String address = "";
                    String phone = "";
                    float cost = 0;
                    String paymentType = "";
                    String travelType = "";
                    String agentfilename = "agent" + username;
                    TravProf newProfile;

                    MedCond medCond;
                    String mdContact;
                    String mdPhone;
                    String algType;
                    String illType;
                    String medCheck;

                    // New object of TravProfDb
                    TravProfDB data = new TravProfDB(agentfilename);

                    // Loop through to allow agent picking options
                    // until they decided to stop. (Option 7)
                    while(agentOption) {
                        System.out.println("Please select your option:");
                        System.out.println("1. Create a new profile");
                        System.out.println("2. Update an existing profile");
                        System.out.println("3. Delete a profile");
                        System.out.println("4. Search a profile");
                        System.out.println("5. Display all profile");
                        System.out.println("6. Save Database");
                        System.out.println("7. Exit Program");

                        System.out.print("Please enter your pick: ");

                        Scanner pickobj = new Scanner(System.in);
                        String selection = pickobj.nextLine();

                        // Create new profile
                        if (selection.equals("1")) {
                            clean();
                            boolean inCorrect = true;
                            while(inCorrect) {
                                firstName= "";
                                lastName = "";
                                address = "";
                                phone = "";
                                cost = 0;
                                paymentType = "";
                                travelType = "";
                                
                                mdContact = "";
                                mdPhone = "";
                                algType = "";
                                illType = "";
                                medCheck = "";

                                System.out.println("Please enter the following information:");
                                System.out.print("First Name: ");

                                Scanner firstNameobj = new Scanner(System.in);
                                firstName += firstNameobj.nextLine();

                                System.out.print("Last Name: ");
                                Scanner lastNameobj = new Scanner(System.in);
                                lastName += lastNameobj.nextLine();

                                System.out.print("address: ");
                                Scanner addressobj = new Scanner(System.in);
                                address += addressobj.nextLine();

                                System.out.print("phone: ");
                                Scanner phoneobj = new Scanner(System.in);
                                phone += phoneobj.nextLine();

                                System.out.print("tripCost: ");
                                Scanner costobj = new Scanner(System.in);
                                cost += costobj.nextFloat();

                                System.out.println("paymentType: 'Credit', 'Check', 'Debit' or 'Invoice'");
                                Scanner paymentobj = new Scanner(System.in);
                                paymentType += paymentobj.nextLine();

                                System.out.print("travelType: ");
                                Scanner travelTypeobj = new Scanner(System.in);
                                travelType += travelTypeobj.nextLine();

                                System.out.println("Do you want to enter your medical information? Y/N");
                                Scanner medobj = new Scanner(System.in);

                                if(medobj.nextLine().equals("Y")) {
                                    
                                    System.out.print("Medical Contact: ");
                                    Scanner mdcontact = new Scanner(System.in);
                                    mdContact += mdcontact.nextLine();

                                    System.out.print("Medical Phone Number: ");
                                    Scanner mdphone = new Scanner(System.in);
                                    mdPhone += mdphone.nextLine();

                                    System.out.print("Allergy Type: ");
                                    Scanner algtype = new Scanner(System.in);
                                    algType += algtype.nextLine();

                                    System.out.print("Illness Type: ");
                                    Scanner illtype = new Scanner(System.in);
                                    illType += illtype.nextLine();

                                    medCheck += "Y";

                                }

                                medCond = new MedCond(mdContact, mdPhone, algType, illType);

                                newProfile = new TravProf(username, firstName, lastName, address, phone, cost, paymentType, travelType, medCond);

                                clean();
                                // Print to test it out
                                TravProf.gettravAgentID();
                                TravProf.getFirstName();
                                TravProf.getLastName();
                                TravProf.getAddress();
                                TravProf.getPhone();
                                TravProf.getTripCost();
                                TravProf.getpaymentType();
                                TravProf.getTravelType();

                                if(medCheck.equals("Y")) {

                                    MedCond.getMdContact();
                                    MedCond.getMdPhone();
                                    MedCond.getAlgType();
                                    MedCond.getIllType();

                                }

                                System.out.println("Is this information correct? Y/N");
                                Scanner correctobj = new Scanner(System.in);
                                String isCorrect = correctobj.nextLine();

                                // Put the Travprof object into TravProfDB
                                data.insertNewProfile(newProfile);

                                // If the information entered is correct we exit this loop.
                                if(isCorrect.equals("Y")){
                                    inCorrect = false;
                                    clean();
                                }
                            }

                        }
                        // Update existing profile.
                        else if (selection.equals("2")) {
                            // TODO
                        }

                        // Delete a profile
                        else if (selection.equals("3")) {
                            // ToDO
                        }

                        // Search a profile.
                        else if (selection.equals("4")) {
                            // Todo
                        }

                        // Display all profile.
                        else if (selection.equals("5")) {
                            clean();
                            System.out.println("Please wait ...");
                            data.initializeDataBase();


                            // Print out list of profiles.
                            for (TravProf profile : data.travelerList) {
                                System.out.println(profile);
                            }

                            // Enter any thing to go back.
                            goback();


                        }

                        // Save Database
                        else if (selection.equals("6")) {
                            clean();
                            System.out.println("Please wait ...");

                            data.writeAllTravProf();

                            goback();


                        }

                        // Exit Program.
                        else if (selection.equals("7")) {
                            agentOption = false;
                            clean();
                        }
                    }

                }


                // Username or password incorrect.
                else {
                    clean();
                    System.out.println("Your username or password is incorrect. Please re-enter the correct info:");
                }
            }


        }




    }

    // Method use to clear the console.
    static void clean(){
        for(int i =0; i<50; i++){
            System.out.println();
        }
    }

    static void goback(){
        System.out.println("Enter anything to go back");
        Scanner randomobj = new Scanner(System.in);
        String random = randomobj.nextLine();
        clean();
    }

}
