# GitLab repository for CO2201 Group Projects

## Alternate accounts of group members for this repo
* RuHostile = Dante Baptiste (db470)
* Femlol & root = Femi Osibemekun (oo158)
* Abdul Nafey = Abdul Nafey Mohammed (anm30)

## Source code for Sprint 2
Our collective work can be found in the main branch by navigating to files/AndroidDevelopment. All the files inside that directory are directly related to our program. The program can be run using Andriod Studio, by opening the AndroidDevelopment folder within the Andriod Studio and running 'app' in the project explorer.

# Installation instructions for Sprint 3.

For Sprint 3, we have worked on the Add Scenario, View Scenario features and also fixed the calendar and drop down list in Add patient. To see them follow the steps below: 

PREREQUISITES:
* AndroidStudio (Latest) and an Android Device emulator (can be downloaded from the device manager inside the IDE) or a physical Android device.
* Connection to firebase authentication: Go tools>firebase>authentication>authenticate using a custom authentication system>Follow the steps provided (At least 1 and 2).
* Connection to firebase realtime database: Go tools>firebase>realtime database>get started with realtime database>Follow the steps provided (At least 1 and 2).

1. Go to the files/Sprint3_Final directory in the main branch
2. Copy the AndroidDevelopment folder to your local machine and use AndroidStudio to Open the project.
3. All configurations are exported to Git so nothing should be changed.
4. On the left of the Android Studio, look at the project structure and right-click on "app" and click Run.
5. You should see a login page, Use these credentials - U: testuser@le.ac.uk and P: test1234
6. If you are connected to the internet then you should successfully login and be redirected to the Main Menu.
7. TO ADD A SCENARIO FOLLOW STEPS (7-8): Press "Add Scenario", and a patient's name to link a scenario to and enter scenario details.
8. Once, you submit the details and add scenario to database (with an internet connection), you can view those details in "View Scenario".

9. TO VIEW A SCENARIO FOLLOW STEP 9: Press "View Scenario" and click start to import all details from the firebase database!


IMPORTANT: If you see the option to Run tests (when you click on "app"), then look at the top bar of the IDE to find a hammer icon. Just to the right of it is a configurations editor where you click and choose "app". Then click the triangular green run button. This should run the program and a login page should appear.
