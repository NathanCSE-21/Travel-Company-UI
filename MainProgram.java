import java.util.Scanner;
import java.io.Console;

public class MainProgram {
    public static void main(String[] args){
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

        // Two conditions either user enter 1 or 2.
        if(usrinput.equals(new String("1"))){
            // If you're here then proceed to give this user options
            clean();

        }
        else{
            // If you're here give the agent their options
            clean();

            System.out.println("Welcome Agent. Please enter your informations to login");

            Boolean userpassword = true;

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

                }
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

}
