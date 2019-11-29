# Search

- To run do the following
- Update the pom.xml to the database driver of choice (postgres or mysql)
- Edit the application-dev.yaml (configurations for dev environment) or application-live.yaml (configurations for live environment) as regards the database configuration and redis
- Edit the TravelBetaConfig-dev.yaml (configurations for dev environment) or TravelBetaConfig-live.yaml (configurations for live environment) as regards connection properties to the endpoint
- Edit the application.yaml file to determine which profile to run ie dev or live
- Start the application
- Go to http://localhost:8080/search-api/swagger-ui.html to display the swagger page

- The Search request first checks against the redis cache if the request has already been asked earlier , if not found it does a db check , if not found makes a rest API call 
- If the a response is found , the result is saved into the redis cache else a Http 400 Error is thrown .


