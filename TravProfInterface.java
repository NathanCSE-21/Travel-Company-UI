import java.util.Scanner;
import java.io.Console;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.io.*;

public class TravProfInterface {
    public static void main(String[] args) throws IOException
    {
        // Welcome message.
        System.out.println("Welcome to ITS Travel Agency. Please login:");

        // Agent
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
                String firstName;
                String lastName;
                String address;
                String phone;
                float cost;
                String paymentType;
                String travelType;
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
                            else{
                                mdContact = "None";
                                mdPhone = "None";
                                algType = "None";
                                illType = "None";
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



                            // If the information entered is correct we exit this loop.
                            if(isCorrect.equals("Y")){
                                inCorrect = false;
                                clean();

                                // Put the Travprof object into TravProfDB
                                data.insertNewProfile(newProfile);
                            }
                            clean();
                        }

                    }
                    // Update existing profile.
                    else if (selection.equals("2")) {
                        clean();

                        System.out.println("In order to modify your profile. Please enter the following informations");
                        System.out.println();

                        System.out.print("FirstName: ");
                        Scanner firstNameobj = new Scanner(System.in);
                        String firstname =  firstNameobj.nextLine();

                        System.out.print("LastName: ");
                        Scanner lastNameobj = new Scanner(System.in);
                        String lastname = lastNameobj.nextLine();

                        String profile = data.findProfile(username, lastname);
                        int index = profile.indexOf(firstname);

                        // A match is found.
                        if(index >= 0){
                            System.out.println("I'm here");
                            TravProf newprofile = stringtoTravProf(profile);

                            boolean update = true;
                            while(update) {
                                clean();
                                System.out.println("What would you like to modify?");
                                System.out.println("1. Address");
                                System.out.println("2. Phone");
                                System.out.println("3. TravelType");
                                System.out.println("4. TripCost");
                                System.out.println("5. PaymentType");
                                System.out.println("6. MedCond");
                                System.out.println("7. Save Modification");

                                Scanner  opt = new Scanner(System.in);
                                String pick = opt.nextLine();

                                if(pick.equals("1")) {
                                    clean();
                                    System.out.print("updateAddress: ");
                                    Scanner addrobj = new Scanner(System.in);
                                    String newaddress = addrobj.nextLine();
                                    newprofile.updateAddress(newaddress);
                                }

                                else if(pick.equals("2")) {
                                    clean();
                                    System.out.print("updatePhone: ");
                                    Scanner phoneobj = new Scanner(System.in);
                                    String newphone = phoneobj.nextLine();
                                    newprofile.updatePhone(newphone);
                                }

                                else if(pick.equals("3")) {
                                    clean();
                                    System.out.print("updateTravelType: ");
                                    Scanner trvtypeobj = new Scanner(System.in);
                                    String newtravelType = trvtypeobj.nextLine();
                                    newprofile.updateTravelType(newtravelType);
                                }


                                else if(pick.equals("4")) {
                                    clean();
                                    System.out.print("updateTripCost: ");
                                    Scanner costobj = new Scanner(System.in);
                                    float newcost = costobj.nextFloat();
                                    newprofile.updateTripCost(newcost);
                                }

                                else if(pick.equals("5")) {
                                    clean();
                                    System.out.print("updatePaymentType: ");
                                    Scanner pymentobj = new Scanner(System.in);
                                    String newpayment = pymentobj.nextLine();
                                    newprofile.updatePaymentType(newpayment);
                                }

                                else if(pick.equals("6")) {
                                    clean();
                                    System.out.println("Please select the following Medical information you want to update:");
                                    System.out.println("1. mdContact");
                                    System.out.println("2. mdPhone");
                                    System.out.println("3. illType");
                                    System.out.println("4. algType");

                                    System.out.print("Please select here: ");
                                    Scanner mdobj = new Scanner(System.in);
                                    String scan = mdobj.nextLine();


                                    if(scan.equals("1")) {
                                        clean();
                                        System.out.print("update mdContact: ");
                                        Scanner mdcontobj = new Scanner(System.in);
                                        String newmdcontact = mdcontobj.nextLine();
                                        newprofile.medCond.updateMdContact(newmdcontact);
                                    }

                                    else if(scan.equals("2")) {
                                        clean();
                                        System.out.print("update mdPhone: ");
                                        Scanner mdphone = new Scanner(System.in);
                                        String newmdphone = mdphone.nextLine();
                                        newprofile.medCond.updateMdPhone(newmdphone);
                                    }

                                    else if(scan.equals("3")) {
                                        clean();
                                        System.out.print("update illType: ");
                                        Scanner ill = new Scanner(System.in);
                                        String newill = ill.nextLine();
                                        newprofile.medCond.updateIllType(newill);
                                    }

                                    else if(scan.equals("4")) {
                                        clean();
                                        System.out.print("update AlgType: ");
                                        Scanner algtype = new Scanner(System.in);
                                        String newalgtype = algtype.nextLine();
                                        newprofile.medCond.updateAlgType(newalgtype);
                                    }


                                }

                                else if(pick.equals("7")) {
                                    clean();
                                    data.travelerList.remove(profile);
                                    data.insertNewProfile(newprofile);
                                    data.writeAllTravProf();
                                    update = false;
                                }

                            }
                        }
                        else{
                            while(data.currentTravelerIndex <= data.numTravelers){
                                profile = data.findNextProfile();

                                index = profile.indexOf(firstname);
                                // Found a match
                                if(index >= 0){
                                    clean();
                                    TravProf newprofile = stringtoTravProf(profile);
                                    boolean update = true;
                                    while(update){
                                    System.out.println("What would you like to modify?");
                                    System.out.println("1. Address");
                                    System.out.println("2. Phone");
                                    System.out.println("3. TravelType");
                                    System.out.println("4. TripCost");
                                    System.out.println("5. PaymentType");
                                    System.out.println("6. MedCond");
                                    System.out.println("7. Save Modification");

                                    Scanner  opt = new Scanner(System.in);
                                    String pick = opt.nextLine();

                                        if(pick.equals("1")) {
                                            clean();
                                            System.out.print("updateAddress: ");
                                            Scanner addrobj = new Scanner(System.in);
                                            String newaddress = addrobj.nextLine();
                                            newprofile.updateAddress(newaddress);
                                        }

                                        else if(pick.equals("2")) {
                                            clean();
                                            System.out.print("updatePhone: ");
                                            Scanner phoneobj = new Scanner(System.in);
                                            String newphone = phoneobj.nextLine();
                                            newprofile.updatePhone(newphone);
                                        }

                                        else if(pick.equals("3")) {
                                            clean();
                                            System.out.print("updateTravelType: ");
                                            Scanner trvtypeobj = new Scanner(System.in);
                                            String newtravelType = trvtypeobj.nextLine();
                                            newprofile.updateTravelType(newtravelType);
                                        }


                                        else if(pick.equals("4")) {
                                            clean();
                                            System.out.print("updateTripCost: ");
                                            Scanner costobj = new Scanner(System.in);
                                            float newcost = costobj.nextFloat();
                                            newprofile.updateTripCost(newcost);
                                        }

                                        else if(pick.equals("5")) {
                                            clean();
                                            System.out.print("updatePaymentType: ");
                                            Scanner pymentobj = new Scanner(System.in);
                                            String newpayment = pymentobj.nextLine();
                                            newprofile.updatePaymentType(newpayment);
                                        }

                                        else if(pick.equals("6")) {
                                            clean();
                                            System.out.println("Please select the following Medical information you want to update:");
                                            System.out.println("1. mdContact");
                                            System.out.println("2. mdPhone");
                                            System.out.println("3. illType");
                                            System.out.println("4. algType");

                                            System.out.print("Please select here: ");
                                            Scanner mdobj = new Scanner(System.in);
                                            String scan = mdobj.nextLine();


                                            if(scan.equals("1")) {
                                                clean();
                                                System.out.print("update mdContact: ");
                                                Scanner mdcontobj = new Scanner(System.in);
                                                String newmdcontact = mdcontobj.nextLine();
                                                newprofile.medCond.updateMdContact(newmdcontact);
                                            }

                                            else if(scan.equals("2")) {
                                                clean();
                                                System.out.print("update mdPhone: ");
                                                Scanner mdphone = new Scanner(System.in);
                                                String newmdphone = mdphone.nextLine();
                                                newprofile.medCond.updateMdPhone(newmdphone);
                                            }

                                            else if(scan.equals("3")) {
                                                clean();
                                                System.out.print("update illType: ");
                                                Scanner ill = new Scanner(System.in);
                                                String newill = ill.nextLine();
                                                newprofile.medCond.updateIllType(newill);
                                            }

                                            else if(scan.equals("4")) {
                                                clean();
                                                System.out.print("update AlgType: ");
                                                Scanner algtype = new Scanner(System.in);
                                                String newalgtype = algtype.nextLine();
                                                newprofile.medCond.updateAlgType(newalgtype);
                                            }


                                        }

                                        else if(pick.equals("7")) {
                                            clean();
                                            data.travelerList.remove(profile);
                                            data.insertNewProfile(newprofile);
                                            data.writeAllTravProf();
                                            update = false;
                                        }
                                    }
                                }
                            }
                        }


                    }

                    // Delete a profile
                    else if (selection.equals("3")) {
                        System.out.print("Please insert user lastname to delete profile: ");
                        Scanner lastnameobj = new Scanner(System.in);
                        String findbyLastName = lastnameobj.nextLine();

                        String delete = data.deleteProfile(username , findbyLastName);
                        clean();
                        System.out.println(delete);

                    }

                    // Search a profile.
                    else if (selection.equals("4")) {

                        System.out.print("To search for a profile. Please insert user lastName: ");
                        Scanner lastnameobj = new Scanner(System.in);
                        String findbyLastName =  lastnameobj.nextLine();

                        clean();
                        String profile = data.findProfile(username, findbyLastName);
                        System.out.println(profile);
                    }

                    // Display all profile.
                    else if (selection.equals("5")) {
                        clean();
                        System.out.println("Please wait ...");
                        data.initializeDataBase();

                        for(String prof: data.profile){
                            System.out.println(prof);
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


    static TravProf stringtoTravProf(String profile){
        String split[] = profile.split("\\s+");
        String agentID = split[2];
        String firstname = split[4];
        String lastname = split[6];
        String address = split[8] + " " + split[9] + " " + split[10];
        String phone = split[12];
        String cost = split[14];
        String travelType = split[16];
        String paymentType = split[18];
        String MdContact = split[20];
        String MdPhone = split[22];
        String allergyType = split[24];
        String illnessType = split[26];

        agentID = agentID.substring(0, agentID.length()-1);
        firstname = firstname.substring(0, firstname.length()-1);
        lastname = lastname.substring(0, lastname.length()-1);
        address = address.substring(0, address.length()-1);
        phone = phone.substring(0, phone.length()-1 );
        cost = cost.substring(0, cost.length()-1);
        travelType = travelType.substring(0, travelType.length() -1);
        paymentType = paymentType.substring(0, paymentType.length() - 1);
        MdContact = MdContact.substring(0, MdContact.length() -1 );
        MdPhone = MdPhone.substring(0, MdPhone.length()-1);
        allergyType = allergyType.substring(0, allergyType.length() - 1);
        illnessType = illnessType.substring(0, illnessType.length() - 1);

        System.out.println(agentID);
        System.out.println(firstname);
        System.out.println(lastname);
        System.out.println(address);
        System.out.println(phone);
        System.out.println(cost);
        System.out.println(travelType);
        System.out.println(paymentType);
        System.out.println(MdContact);
        System.out.println(MdPhone);
        System.out.println(allergyType);
        System.out.println(illnessType);
        float newcost = Float.valueOf(cost.trim()).floatValue();


        TravProf newprofile = new TravProf(agentID, firstname, lastname, address,
                phone,
                newcost ,
                travelType, paymentType, new MedCond(MdContact, MdPhone, allergyType, illnessType));

        return newprofile;
    }

}
