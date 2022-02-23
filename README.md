# GitLab repository for CO2201 Group Projects

# Installation instructions for Sprint 2.

As a group, each one of us created a login system (as part of the user stories for this sprint) on our own whilst collaborating with each other on different aspects of the login system. This was to gauge our skill level which would be immensely important going forward and when assigning tasks.

In the files folder, we have our own implementation of the login system stored in folders with our university ID. There are different versions of our login system within those folders.

To install our latest version that we want to submit, please do the following.

PREREQUISITES:
* AndroidStudio (Latest) and an Android Device emulator (can be downloaded from the device manager inside the IDE) or a physical Android device.
* Connection to firebase authentication: Go tools>firebase>authentication>authenticate using a custom authentication system>Follow the steps provided (At least 1 and 2).
* Connection to firebase realtime database: Go tools>firebase>realtime database>get started with realtime database>Follow the steps provided (At least 1 and 2).

1. Go to the files directory in the main branch
2. Copy the AndroidDevelopment folder to your local machine and use AndroidStudio to Open the project.
3. All configurations are exported to Git so nothing should be changed.
4. On the left of the Android Studio, look at the project structure and right-click on "app" and click Run.
5. You should see a login page, Use these credentials - U: testuser@le.ac.uk and P: test1234
6. If you are connected to the internet then you should successfully login and be redirected to the Dashboard.
  TO ADD A PATIENT FOLLOW THESE STEPS
7. Press "Add patient" and fill the entire form of 4 screens.
8. Once, you submit the details and add patient to database (with an internet connection), you can view those details in "View patients".
  TO VIEW ALL PATIENTS FOLLOW THESE STEPS
9. Press "View Patients" to go to a screen with many patients' details, scroll down to find your newly added patient information!


IMPORTANT: If you see the option to Run tests (when you click on "app"), then look at the top bar of the IDE to find a hammer icon. Just to the right of it is a configurations editor where you click and choose "app". Then click the triangular green run button. This should run the program and a login page should appear.
