# Design Patterns Exercise: Weather Problem
## Check temperature below 5 degrees.

## Setup

- Clone the repository
- Open the project in ECLIPSE
- Review The class structure and build the program

## Design Patterns that needs to be used:

- Observer - When getting the information of the weather we need to observe the changes and display an alert if the temperature is below 5 degrees, another observer will be checking if the temperature is greater than 10 degrees.

- Singleton - We need to use the singleton to keep the new information of the weather.

- Builder - We need to build the request and pass it to the 

#### Weather Api Response

```java
public interface ApiResponse {

	public int responseCode();
	public String responseBody();
	
}
```

#### Builder usage:

```java
WeatherApiRequestBuilder builder = new WeatherApiRequestBuilder();
WeatherApiRequest request = builder.apiKey('apikey').location('Buenos Aires').days(1).build();
WeatherApiResponse response = request.get();
```

#### Weather api key:

#### Api documentation:

https://www.weatherapi.com/api-explorer.aspx#forecast


```
06712f56f6e2431590b184348232905
```


