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
	-  entire transaction has to integrate with third party service. 
	- reserve -> confirmed -> tickets sent
	- each state has its own unique responses and requests based on third party
	- high complexity integrating different third party services as each has their own convention such as booking required information, tickets format, price verification, bugs (from third party or our system)
	- challenge was to maintain that complexity

<!--stackedit_data:
eyJoaXN0b3J5IjpbLTExNzkwNDg5NjMsMTE2MTUyNTA0OF19
-->