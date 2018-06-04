Tink Labs

Product:
-Mobile phone providing services such as free phone calls, internet connection and buying attraction tickets.
- E-commence platform for selling attraction tickets
- Tickets were supplied and sold through third party services, specifically via making web API calls.

Features:

Backend (PHP, MySQL, Docker, AWS)
- Managing content such as ticket descriptions, images, prices, etc
	- synced up with third party services via periodic API calls and cron job
	- time granuity: more frequent for prices than descriptive content
- Managing ticket purchase transactions
	-  Entire transaction has to integrate with third party service. 
	- Reserved -> Confirmed -> Tickets-Sent
	- Each state has its own unique responses and requests based on third party
	- High complexity integrating different third party services as each has their own convention such as booking required information, tickets format, price verification, bugs (from third party or our system)
	- Challenge was to maintain that complexity e.g. keeping code as meaningful as possible, negoatiating API calls with developers from 3rd party service
	- A gradual and incremental process
	- Design patterns: visitor pattern for each ticket service class, each class provides its own unique ticket reservation, booking or content sync implmentation.
	- try to decouple as much as possible to provide isolation during unit testing.
	- semi-test driven: business logics are written such that every single

<!--stackedit_data:
eyJoaXN0b3J5IjpbLTQzODQ0MTQ0NywxMTYxNTI1MDQ4XX0=
-->