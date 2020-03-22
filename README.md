# Travel-Company-UI
This is a simple UI for Travel Company project. There are two options: traveler and agent.

Each users will have different options available to them. 

**Installation:**

$ git clone https://github.com/NathanCSE-21/Travel-Company-UI.git

$ cd Travel-Company-UI

Two options you can compile MainProgram or use it without compiling.

**Without compiling:**
$ java TravProfInterjace.java

**Compiling:**
$ javac TravProfInterjace.java




**Demo:**

	Usage: $ java TravProfInterface

1. You will first encounter the login screen. Here you will need to enter in the AgentID and Agent password. The Login and Password information must match and should only be int type.
![image](https://github.uconn.edu/storage/user/3220/files/1807e280-6c43-11ea-9877-49ed53a41c58)


2. Once you login successfully you will have a list of options available: 
![image](https://github.uconn.edu/storage/user/3220/files/2a821c00-6c43-11ea-9b5c-538d72922d87)
	
3. If this is the first time you login with this ID. You will have no file saved on your local PC. In other words, you will have no Traveler Profile yet. So if you display using (option 5) to show information it will tell you to create a new profile. 


![image](https://github.uconn.edu/storage/user/3220/files/3ff74600-6c43-11ea-8964-6566bb27a494)


4. To create a new profile, pick option 1 and Enter the information. (Note: please information in the correct format avoid white spaces when entering information). Ex: 

![image](https://github.uconn.edu/storage/user/3220/files/51d8e900-6c43-11ea-8b1d-63ee6f222b61)


If the information you entered is correct pick Y. If not pick N. For the Demo I chose N and re-enter information with Medical Information this time: 

![image](https://github.uconn.edu/storage/user/3220/files/5b625100-6c43-11ea-88fd-df622810c767)


Note: As mentioned please pay attention to address and MdContact you should enter information in this format. For address enter 3 things with 2 seperate spaces. For MdContact Dr followed by Dr lastname. 

This will allow the program to easily update information/modify if you pick option 2 in the main menu.


5. Now the information is created but hasn't been saved thus if you pick option 5. To display all the profile it will tell you file does not exist: 

![image](https://github.uconn.edu/storage/user/3220/files/6d43f400-6c43-11ea-8b31-c40fdeca493d)


6. To save pick option 6 and then go to option 5 again you will see the information updated in the system: 

![image](https://github.uconn.edu/storage/user/3220/files/7cc33d00-6c43-11ea-9ac4-6327f7c30a21)

![image](https://github.uconn.edu/storage/user/3220/files/8c428600-6c43-11ea-9bf9-f54f142baa55)

	
7. You can choose to search for a profile using option 4. Just enter in a lastname and the Profile will be display to the screen:

![image](https://github.uconn.edu/storage/user/3220/files/9c5a6580-6c43-11ea-9ab6-87990885af3f)


8. You can also choose to update the profile using option 2. It takes firstname and lastname as input and will give you a range of options for you to update: 

![image](https://github.uconn.edu/storage/user/3220/files/b300bc80-6c43-11ea-8759-3364c782bfed)

In this example let’s update the address and Phone:

![image](https://github.uconn.edu/storage/user/3220/files/c01dab80-6c43-11ea-9dc4-3beacbc7254b)

9. There is also a delete profile option. It allows you to delete a profile given a last name: 

![image](https://github.uconn.edu/storage/user/3220/files/1854ad80-6c44-11ea-9857-2f8564988b6e)


Note: you might tempt to check again using option 5 to display the profile and it will still be there: 

![image](https://github.uconn.edu/storage/user/3220/files/f6f3c180-6c43-11ea-9002-afb0d105ef5c)

This is because you need to save it (option 6) before displaying that profile again( option 5).
Now after you delete it will show nothing: 

![image](https://github.uconn.edu/storage/user/3220/files/260a3300-6c44-11ea-85ea-178e2c41cad0)




Final: That's how our Travel-Company-UI program works. It allows users/agents to manage the information about their travelers and save this information as a file in the PC local path.
