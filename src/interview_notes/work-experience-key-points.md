Tink Labs

Product:
-Mobile phone providing services such as free phone calls, internet connection and buying attraction tickets.
- E-commence platform for selling attraction tickets
- Tickets were supplied and sold through third party services, specifically via making web API calls.

Features:

Backend (PHP, MySQL, Docker, AWS)
1. Managing content such as ticket descriptions, images, prices, etc
	- Synced up with third party services via periodic API calls and cron job
	- SQL tables design: try to avoid JOINs as often as possble and take advantage of caching
2. Managing ticket purchase transactions
	-  Entire transaction has to integrate with third party service. 
	- States: **Reserved** -> **Confirmed** -> **Tickets-Sent**
	- Each state has its own unique responses and requests based on third party
	- High complexity integrating different third party services as each has their own convention such as booking required information, tickets format, price verification, bugs (from third party or our system)
	- Challenge was managing the complexity and robustness e.g. keeping code as meaningful as possible, negoatiating API calls with developers from 3rd party service
	- Design patterns: visitor pattern for each ticket service class, each class provides its own unique ticket reservation, booking or content sync implmentation.
	- Decouple as much as possible to provide isolation during unit testing.
	- Semi-test driven: business logics are written such that every method can be tested against all possible outcomes
	- There is also integration with the Android app via web API, good API design practise taking into account minimizing JSON size and maximize speed. (trade off between 1 API call vs multiple)
	- Logging purchases

Android (Kotlin, RxJava, Retrofit, Mokito, Dagger 2, OkHttp)
- Single Activity, multiple fragaments
- Reactive based Redux pattern
- Mock and test API calls, testing UI elements
- Pair programming with backend
- Protocol buffers library to sync up API structure between backend and Android

Being able to discuss features with product managers using layman language, trying to explain to them why features can or cannot be implemented or delayed can be tricky. Discussing Android design's limitation with UI designers, trade-off between features, time-cost and complexity.

Liricco Technology


<!--stackedit_data:
eyJoaXN0b3J5IjpbLTE4MzAwMjc2OTAsMTE2MTUyNTA0OF19
-->