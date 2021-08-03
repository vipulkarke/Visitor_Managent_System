# Visitor_Managent_System
This Project(Application) is on Android Studio and its Name is Visitor Management System.
This VMS creates a gatepass for visitor, This can be used by any Building, ShoppingMall, ParkingLot, Cafe, Society, etc.

It Creates a gatepass in PDF format inside your mobile internal storage that can be printed or kept as it is or used for security purpose.




--------------------------(Software, Hardware req, steps to run)------------------------------------------------
System requirements
Windows
Microsoft® Windows® 7/8/10 (64-bit)
4 GB RAM minimum, 8 GB RAM recommended
2 GB of available disk space minimum,
4 GB Recommended (500 MB for IDE + 1.5 GB for Android SDK and emulator system image)
1280 x 800 minimum screen resolution


--------------------------Software Requriments---------------------------------------------------------------------
1.Android Studio 4.1.3 
	for Windows 64-bit (896 MiB) link to download this file ( https://developer.android.com/studio?gclid=Cj0KCQjwyZmEBhCpARIsALIzmnL1rQ-0wFD9FL96YUfKevDOiwUCepm4B14CUWwaRfawqEL3ToFVKnQaAqEeEALw_wcB&gclsrc=aw.ds)
	    Mac 64-bit  (877 MiB) link to download this file (https://developer.android.com/studio?gclid=CjwKCAjw7J6EBhBDEiwA5UUM2gppZ2LZJPayKMPy6I4atpDufQhKeBCeidMoek_FWB1Yaf0YY1jkCRoCZvgQAvD_BwE&gclsrc=aw.ds#downloads)

2. SDK tools package 
	
2.If running this application on android device then you need android verison above:- Oreo 8.0 API level 26

3.Internet connection in computer and mobile.


--------------------------How to run the code-------------------------------------------------------------------- 

I'll provide an vms2_final-solved.Rar file with the project that you have to import in you android studio

	step 1:- To run the project file extract the given file to path C:\Users\your name\AndroidStudioProjects.
	step 2:- Then Launch Android Studio
	step 3:- Go to file> New> ImportProject> then select vms2_fianl-solved then click OK.
	step 4:- Then it will build the project automaticaly if not then click Build in toolbar on top BUILD> MAKE PROJECT> or Ctrl+F9.
	step 5:- Then click on play button on right top toolbar OR Click RUN> Run App> OR Ctrl+F10
	step 6:- It will run the application in you emulator.

If you are using Ryzen processor then you need to give permissions to the system follow  these:-
		
	 Alright, first of all, open your
	 Android SDK Manager: Tools -> Android -> SDK Manager, 
	 then chose any platform/package you want to download, expand it and select ARM EABI v7a System Image or ARM 64 v8a System Image then install.
		
	*NOTE: You don't need the beta version of Android Studio or Android Emulator.
		Go to the MB bios and turn SVM on (CPU Virtualization).
		In Windows right click Windows Button => Select "Apps and Features" => "Programs and features" => "Turn Windows Features on and off"
		In the displayed list select Hyper-V checkbox == Make sure the subfolders are all selected. When prompted to restart, restart the PC.
		After restart and update instalation screen you are back in Windows and you should be able to run the Emulator.

-----------------------------How to run Application VMS----------------------------------------------------------

	step 1:- Login credential are Username-Admin, Password-1234 click login.
	step 2:- click on gatepass button on the screen 
	step 3:- Enter details regarding visitor and click on save button now it will give a Toast data saved.
	step 4:- To view data that is saved Click on View Visitors it will navigate to the data that is saved in Google Firestore(Database).
	step 5:- Click on that data it will navigate to next page where you can UPDATE DATA , DELETE DATA , CREATE GATEPASS 
	Step 6:- Click on Create Pass you will get a Toast PDF CREATED.
	step 7:- Go to home page by clicking back button on your screen in bottom and LOGOUT from application.
	step 8:-  Open you file manager to go internalstorage/emualted/0 and search Visitor_gatepass.pdf there is your gate pass created by this application 


-----------------------------How to check the Google Firestore Database----------------------------------

	step 1:- Login credential for Google Email-id-vipulspamtest@gmail.com, Password-Vipulspam@1 click login.
	step 2:- Now to to https://console.firebase.google.com/	
	step 3:- Now select VMS2 final and agree firebase terms and conditions and click continue.
	step 4:- On left side click on Build> Firestore> it will show the table Visitors and its Data.


----------------------------Privacy policy-------------------------------------------------------------------------------

When you use our services, you’re trusting us with your information. We understand this is a big responsibility and work hard to protect your information and put you in control.

This Privacy Policy is meant to help you understand what information we collect, why we collect it, and how you can update, manage, export, and delete your information.


  
