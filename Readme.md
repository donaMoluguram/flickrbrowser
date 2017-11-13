# RUN CONFIGURATIONS
    -   Chance the device name to desired device
    -   Change app location to where exactly app is downloaded
    
             *   Above 2 properties can be found @ src/test/resources/config.properties,
                 To change device please refer "SAMPLE DEVICES" in readme file below

# HOW TO RUN

-  Follow RUN CONFIGURATIONS section
-  With-out Command line 
    -   run appium on terminal or start appium ui client
    -   Go to src/test/java you will find RunCukesTest.java and run
- With command line (run below sh files )
    -   stop_server.sh 
    -   start_server.sh
    -   mvn test 

# FRAMEWORK HIGHLIGHTS
    -   Followed page object design pattern 
    -   Page factory model 
    -   BDD style of writing test 
    -   Setup and installation is metion in install.sh file 


# TOOL USED
1. Java
2. Appium
3. Maven 
4. Cucumber
5. Hamcrest
6. Rest assured 

# INSTALLATION

1. Make sure Xcode is installed, if not do download
2. Make sure appium is installed if not 
    -   npm install -g appium
    
    or 
    
    follow instruction in install.sh file 

# SAMPLE DEVICES
    -   iPhone 5s 
    -   iPhone 6 
    -   iPhone 6 Plus 
    -   iPhone 6s 
    -   iPhone 6s
    -   iPhone 7
    -   To find out more available devices using command:
        xcrun simctl list

# Can improve 

    Want to start and stop appium server programmatically

    Take screen shot on test failure
     
    