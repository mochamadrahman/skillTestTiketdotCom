# skillTestTiketdotCom

## Software Engineer in Test Skill Test

- This Repository consist of automation script using BDD style with Page Object pattern which using Desktop Web platform and cover scenario :

      - Product Flight: Create transaction with Virtual Account for domestic round trip with xx transit and login with email.
      
      - Product Train: Create transaction with non-instant payment for one-way trip, xx adults and xx infants and select seats.
      
- Cucumber with Maven and Java are used to build automation framework, so to run this script on your environment should install Java version 1.8 or higher and Apache Maven as prerequisite.
- Cloning repository to your IDE e.g Eclipse, run above scenarios with right click **TestRunner.java** file (path: /com.tiket/src/test/java/StepDefinitions) and Run As **JUnit Test**. 
- We can run test via **CLI** with command prompt: **mvn test clean** under root path e.g C:\Users\Pavilion\Downloads\skillTestTiketdotCom-master\skillTestTiketdotCom-master\com.tiket>**mvn test clean**

      - For Feature Product Flight, interval repeat execution test for success case around 2 hours as because booking transaction will expire in 2 hours.
            
      - For Feature Product Train, interval repeat execution test for success case around 30 minutes as because booking transaction will expire in 30 minutes. There is another restriction for non-instant payment e.g Bank Transfer where only available from 07 AM till 8 PM.

###### Let me know if you face problem while execute repository
