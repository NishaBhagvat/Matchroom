	•	Explain why you chose to use those particular tools/frameworks in the technical assessment?
	•	Describe the reason for the scope of your solution. Why did you test what you did, and why didn’t you test others?
	•	If you had to extend this framework to test other parts of the website, what would be the areas you would test first?
	•	After completing the technical challenge, what would you do differently if you were asked to do the same challenge again?


### Explain why you chose to use those particular tools/frameworks in the technical assessment.

To automate AUT, Selenium Webdriver is the best tool because,
* It supports all features of the web application. (It is suitable for the web application requirements)
* It offers a variety of features and functionality.
* We can easily integrate this tool with other variety of frameworks available in the market like Cucumber, BDD, JUnit etc
* It has a great community support.
* It supports multiple languages, and browsers and is open source 

The serenity-BDD framework has been used because,

* Using BDD we can write tests which makes it easier for non-technical stakeholders to understand.
* We can easily integrate Serenity-BDD with Selenium Webdriver, Appium and build a powerful testing framework.
* Serenity offers living documentation describing what your application does, it creates comprehensive reports with graphs, charts and detailed steps, scenarios along with screenshots. 
* Serenity has an in-built reporting and logging feature.
* Serenity allows the creation of user acceptance and functional tests.
* Serenity also supports RestAPI using RestAssured.
* It has a great community support.
* It has many built-in features that help write automation tests faster and more reliable. (Like WebElementFacade interface, Serenity sessions etc)


### Describe the reason for the scope of your solution. Why did you test what you did, and why didn’t you test others?
The scope of the solution involves UI testing of the sports filter feature on the OnDemand Page as the requirement was to filter the VOD section to display only Darts videos.

#### Out of scope
I did not test the below features as it was not part of the requirements,

* Other pages like Home, Sports, Events, FAQs, Login and Subscribe.
* API testing, Component testing, Performance and non functional testing.
* Other features on the OnDemand page.

Though the implementation has not been added for other sports and Competitions and Duration filters, we can easily extend the framework to incorporate the new additions without affecting the existing code.
  
### After completing the technical challenge, what would you do differently if you were asked to do the same challenge again?

I would  include API tests as an additional validation layer provided that API specs are available.

When a sport filter is set for the Dart, a Get request is sent with the sport name as a query parameter and the response should fetch only Darts videos records.

### If you had to extend this framework to test other parts of the website, what would be the areas you would test first?

- Filter the VOD section to display other sports videos.
- Filter the VOD section based on Competitions and duration.
- Login to the website and play the videos.
- Features of the Home page.

### Observations 

- Selection of Short and Long video duration does not highlight the selection.
- Clicking on the top searchbar next to Subscribe, does not point the cursor, in order to search, second click is needed on the search field.
