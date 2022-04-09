# NBP Api implemented in Spring Reactive

## How to build:
`.\gradlew build`

## How to run:
`.\gradlew bootRun`

## How to use:
Server by default runs on localhost:8080. Below you can find a list of endpoints:
* `GET /api/gold` - returns average gold price in PLN for the last 14 days.
* `GET /api/exchange-rates/{currency_code}` - returns currency exchange rates of PLN to `{currencyCode}` for the last 5 business days.
  * `{currencyCode}` needs to be in ISO 4217 format.

## Examples
### `/api/gold/`
```json
{
    "price": 265.61929
}
```
### `/api/exchange-rates/USD`
```json
{
    "pair": "PLN/USD",
    "rateList": [
        {
            "date": "2022-03-28",
            "value": 0.23373
        },
        {
            "date": "2022-03-29",
            "value": 0.23301
        },
        {
            "date": "2022-03-30",
            "value": 0.23988
        },
        {
            "date": "2022-03-31",
            "value": 0.23923
        },
        {
            "date": "2022-04-01",
            "value": 0.23822
        }
    ]
}
```

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
