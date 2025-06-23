
Steps to Run the Automated Scripts
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

1. Download and install IntelliJ IDEA (IDE) on your local machine.
2. Make sure Java is installed. If not, download and install Java 24 from a browser.
3. Clone or download the project files from GitHub. (Not required to download the chromedriver as the project already has it.)
4. If chromedriver is not matching with the local machine's chrome browser, then download the appropriate version of chromedriver from Selenium downloads (https://www.selenium.dev/downloads/)
5. Place the project folder in the default IntelliJ workspace directory: C:\Users\<YourMachineName>\IdeaProjects (or another preferred location).
6. Launch IntelliJ, click the File menu in the top-left corner, then choose Open and select the project folder.
7. Inside the project structure under src, you’ll find two folders: main and test, along with a testng.xml file.
8. To execute the script, open testng.xml, right-click inside the file, and select Run.
9. The automation framework using Page Object Model (POM) will begin executing. Each step uses assertions to show pass/fail status.
10. After the test completes, a confirmation PDF will be automatically downloaded to your local system.