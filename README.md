# TestNgProject

Prerequisites
•	JDK Version: 19
•	Maven Version: 3.9.1
Note
This project was developed using Eclipse IDE. It is recommended to use Eclipse for smooth setup and execution, though it can be run using any IDE that supports Maven and Java. Ensure that the appropriate TestNG plugin is installed in the IDE for seamless execution of TestNG test cases.
Steps to Clone and Run the Project
Open Git Bash and execute the following commands:
1.	Clone the repository from the master branch:
    git clone -b master https://github.com/srihari-2097/entrataProject.git
2.	Navigate into the project directory:
  cd entrataProject
3.	Execute Maven tests:
    mvn test
Automated Test Cases
1.	Schedule Your Demo Form:
Verify the functionality of the "Schedule Your Demo" form, including form validation and window handling.
2.	Summit Page:
Verify the functionality of the Summit page, ensuring the dynamic data (such as the Date, Summit heading, number of sessions, guest list, and their respective professions) is correctly displayed.
3.	Page Navigation:
Verify that the application successfully navigates to multiple pages by clicking on the respective links and ensuring each page opens correctly.
4.	Guides Page:
Verify that all the guides listed on the Guides page have a 'Download Now' button available.
5.	Webinar Access:
Verify that a user cannot watch the webinar unless they are a registered user.

