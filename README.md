2014DriverUI
============

Also includes the custom dashboard / smart dashboard (to be implemented) CVAgent.

RESTRICTED
------------
This code is restricted to the following editors:

	- Jake

RUN INSTRUCTIONS
------------
  Only follow these steps if Jake is not available available to setup the driver station.
  
	1. Hit "Clone in Desktop"
	2. Go into userdoc//Github//2014DriverUI//dist
	3. Run 2014DriverUI.jar
	
  
  Note : This dashboard also requires the installation of OpenCV and SmartDashboard's JavaCV
	
	1. Download the latest SmartDashboard FULL installer (http://wpilib.screenstepslive.com/s/3120/m/7932/l/93058-smart-dashboard-standalone-vision-installer) (May be outdated)
	2. Run the installer, the basic extract paths should be fine for then dashboard (not all steps on above link are required)
	3. Download the latest version of OpenCV (this build should be flexible based on opencv version, see below links for download)
	4. Install OpenCV as instructed by http://docs.opencv.org/doc/tutorials/introduction/windows_install/windows_install.html and http://docs.opencv.org/doc/tutorials/introduction/windows_install/windows_install.html#windowssetpathandenviromentvariable
	5. Go into //opencvfolder//build//java//x64 and x86 (see step 6)//opencv_java###.dll
	6. Place that dll in the folder C://Windows//System32 for x64 and Windows//SYSWOW64 for x86
