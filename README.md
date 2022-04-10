# API-Testing-REST-Assured-Framework
# Steps to Import the project in eclipse and execute test suite 

**Technology Used:**
1. RestAssured Java API
2. TestNG Framework 
3. Report and logger for generating reports and logs.

**Github repository:**  https://github.com/Rajyma/RestAssuredAutomation

**Steps to import project**
- Download repo from [https://github.com/Rajyma/RestAssuredAutomation] [RestApiTestingTest.zip]  unzip it
- Go to Eclipse > File > Import > Maven > Existing Maven Projects into Workspace
- Click on Next 
- Click on Browse
- Select the Folder “RestApiTestingTest”
- Click on Open
- Click Finish

Note: Once you Imported the project in eclipse Make sure the project directory is there. 

See Example below: This is the folder structure . 


**Note:**
Once you have same folder structure imported wait for a while until maven download all the dependencies. 

**Now you all set to run the project.**

### It has following this implemented. 
1. Base Class
2. Test Case Class
3. Listeners Class

Each Test Class has multiple test cases created . Also I have added comments in each class.

 **Steps to Run the Test suite using TestNG**

------------


- Right click on testng.xml file in the project directory level
Select Run As >  TestNG Suite

*Note: Now your test suit is running. It will log all the success or errors on the eclipse console*


**Steps to see the results using report.html**

- Go to Reports Directory
- Right click ExtentReport.html > Open With WebBrowser
- This will open the ExtentReport.html in WebBrowser and it will show the entire test suite report
<ROOT_PROJECT>/reports/index.html

![image](https://user-images.githubusercontent.com/26476263/162618695-fc7a47c5-70a2-4552-8186-fc7525276267.png)


**Note:**
- Entire test suite is verified and work as expected with no errors. 




Regards,
Rajesh

Have a great day


