# Fillr 
## Test Assessment 
### Task 1: General Testing 
 Given a Sign in page and based on the pre-requisites the Test plan and Test cases are builded. Please find the details below
		 <br> 1. Word document (Fillr_Task1_GeneralTesting.doc) and 
		 <br> 2. Respective test cases in the Excel document(Fillr_QA_Assessment.xls)
		 
		 
### Task 2: Automation
 #### Using Amazon(amazon.com.au) as an example merchant to demonstrate Launching of the Chrome broswer --> Entering the Amazon URL --> Searching for a product --> Opening an item from the search result --> Adding the item to the cart --> Navigate to the cart and perform screen orientation.
	 * While in search result page verified the element to be displayed to make sure Search result page is displayed. 
	 * Similarly, item is displayed after opening the item and verifying the element after navigating to cart to make sure the respective page is displayed.  
	 * Used scrollToElement method in touch actions class for scrolling to the element.


	 The folders and it's use in this project is 
		1. src > resources > features > AmazonSample.feature  contains scenario based steps in BDD format
		2. src > test > java > com.qualityassurance > stepdefs > AmazonSampleSteps.java contains the implementation of the scenarios mentioned in #1. 
		This file also have 
			a. @BeforeTest - Contains all the capabilities of mobile and to eastablish connection between the appium server.
			b. @Test - Contains all the actual steps which are defined in AmazonSample.feature file
			c. @AfterTest - Contains the quit the chrome instance to end session.
		
