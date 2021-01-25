Module that covers the RestClient integration with OIDC extension using Keycloak container.
There are two applications:
- Ping application that will invoke the Pong application using the RestClient and will return the expected "ping pong" output.
- Pong application that will return the "pong" output.

Test cases:
- When calling `/ping` or `/pong` endpoints without bearer token, then it should return 401 Unauthorized. 
- When calling `/ping` or `/pong` endpoints with incorrect bearer token, then it should return 401 Unauthorized.
- When calling `/ping` endpoint with valid bearer token, then it should return 200 OK and "ping pong" as response.
- When calling `/pong` endpoint with valid bearer token, then it should return 200 OK and "pong" as response.

Variants:
- Using REST endpoints (quarkus-resteasy extension)
- Using Reactive endpoints (quarkus-resteasy-mutiny extension)
- Using Lookup authorization via `@ClientHeaderParam` annotation 