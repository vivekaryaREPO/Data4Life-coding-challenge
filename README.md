# Data4Life-coding-challenge
A coding challenge given by Data4Life company

Problem statement: Create a simulation that sends e-mail to 1 million people in a performant way.

Proposed solution: Create N tasks where each task sends email to M people, and distribute this N tasks to a thread pool of size K threads.

Technologies used: Spring boot with H2 inbuilt database, JPA, some concepts of Java2EE.

Direction of excution:

Step 1: import the project in your favourite IDE, make sure that your machine has jdk 1.8 installed.
Step 2: Run the project and navigate to http://localhost:8080/home

            NOTE: I am inserting 1000000 records into h2 database where each record consists of a distinct email Id, so
 	      insertion of 1000000 records takes some time between 30-35 seconds, please do not hit the endpoint 	      over and over.

Step 3: Now, click the "SEND EMAIL" button, which'll send the emails to 1000000 emails address and you'll se a message conveying that - the mail was sent successfully.
