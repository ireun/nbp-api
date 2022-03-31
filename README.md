# NBP Api implemented in Spring

## How to build:
`.\gradlew build`

## How to run:
`.\gradlew bootRun`

## How to use:
Server by default runs on localhost:8080. Below you can find a list of endpoints:
* `/api/gold` - returns average gold price in PLN for the last 14 days.
* `/api/exchange-rates/{currency_code}` - returns currency exchange rate PLN to `{currencyCode}` for the last 5 business days.

## How to build docker image
1. Clone the repo
2. cd to the path where you've cloned the repo
3. run `docker build .`
