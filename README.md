Flipkart Selenium Automation
Overview
This project automates the process of searching for a product on Flipkart, selecting the first product from search results, clicking the "Buy Now" button, and navigating to the payment page using Selenium WebDriver in Java.

Features
Opens Flipkart website.

Closes the login pop-up (if it appears).

Searches for "iPhone 15".

Selects the first product from search results.

Switches to the new product tab.

Clicks on the "Buy Now" button.

Waits for the checkout page to load.

Navigates to the payment page.

Prerequisites
Ensure you have the following installed:

Java JDK (version 8 or later)

Maven (for dependency management)

Google Chrome (latest version recommended)

ChromeDriver (compatible with your Chrome version)

Dependencies
Add the following dependencies to your pom.xml file (if using Maven):

<dependencies>
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.29.0</version>
    </dependency>
</dependencies>
Setup Instructions
Clone the repository

git clone https://github.com/your-repo/flipkart-automation.git
Navigate to the project directory

cd flipkart-automation
Compile and Run the Selenium script

mvn clean test
or manually run the FirstTestCase.java file from your IDE.

Usage
Run the FirstTestCase.java script to perform an automated search, product selection, and navigation to the payment page.

Troubleshooting
If the script fails to click on elements, check if Flipkart's UI has changed and update the XPaths accordingly.

Ensure that chromedriver.exe is properly configured in the system PATH or explicitly specify its path in the script.

If the browser closes too quickly, remove driver.quit(); for debugging.

Author
Pavlov Mukherjee

Contact: pavlovmukherjee4@gmail.com

License
This project is licensed under the MIT License.
