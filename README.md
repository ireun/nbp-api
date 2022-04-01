# NBP Api implemented in Spring Reactive

## How to build:
`.\gradlew build`

## How to run:
`.\gradlew bootRun`

## How to use:
Server by default runs on localhost:8080. Below you can find a list of endpoints:
* `GET /api/gold` - returns average gold price in PLN for the last 14 days.
* `GET /api/exchange-rates/{currency_code}` - returns currency exchange rate PLN to `{currencyCode}` for the last 5 business days. 
    * `{currencyCode}` needs to be in ISO 4217 format.

## How to run in docker
1. `docker pull ireun/nbp-api-spring:latest`
2. `docker run -p 8080:8080 ireun/nbp-api-spring:latest`

## How to build docker image
1. Clone the repo
2. `cd` to the path where you've cloned the repo
3. Run `docker build .`

## How to deploy to k8s
1. `cd` to the path where you've cloned the repo
2. Run `kubectl apply -f deployment.yaml`
3. Forward port from the pod `kubectl port-forward svc/nbp-api-spring 8080:8080`
