HTTP vs WebSocket
http://blog.arungupta.me/rest-vs-websocket-comparison-benchmarks/
https://stackoverflow.com/questions/36517829/what-does-multiplexing-mean-in-http-2

TCP/IP model
- 5 layers: **Application**, **Transport**, **Network**, **Link**, **Physical**

- **HTTP** lives in **Application Layer**, a protocol between browser and server

- **HTTPS** lives in **SSL/TLS  layer**, in-between Application and Transport

- **TCP/UDP** 
    - lives in **Transport Layer**
    - wrap and unwrap TCP/UDP header/footer

- **IP** 
    - lives in **Network Layer** 
    - wrap and unwrap IP header/footer
    - allows communication between PCs from two different networks.

[UDP vs TCP](https://www.techrepublic.com/article/exploring-the-anatomy-of-a-data-packet/)

**UDP - connectionless, unreliable, no flow-control or error-recovery**
- Header size 8 bytes: 
    - source/destination ports, 
    - checksum
    - length
- smaller packet size
- connectionless
- no compensation for lost packers
- message oriented (messages are sent in a single chunk e.g. email, DNS lookups)
- no guarantee in order delivery
- Applications:
    - Tunneling/VPN (lost packets are ok - the tunneled protocol takes care of it)
    - Media streaming (lost frames are ok)
    - Games that don't care if you get every update
    - Local broadcast mechanisms (same application running on different machines "discovering" each other)

**TCP - reliable, stream-oriented connection**
- Header size 20 bytes: 
    - source/destination ports, 
    - sequence number field, 
    - data offset(header length)
    - flags: ACK, SYN, FIN
    - checksum
    - Window field (16 bits) : size of the sender's receive window (that is, buffer space available for incoming data)
    - etc
- a connection requires 2 TCP sockets
- 3 way handshake: Browser -> SYN -> Server (accepted) -> SYN, ACK -> browser (connected) -> SYN Server
- ACK defines window field for how much content to send.
- packets are numbered, which allow in order 
- performs round-trip time estimation
- retransmission: guarantee all files are sent
- congestion control
- Applications
    - Web
    - SSH, FTP, telnet
    - SMTP, sending mail
    - IMAP/POP, receiving mail

**IP**
- Header
    - IP version,
    - Total packet length
    - protocol field (indicates which upper-layer protocol receives it) 
    - source/destination IP address, 
    - time-to-live, 
    - checksum


browser constructs the following multi-layered connection:
IP layer: connect to 10.11.12.13
TCP layer: set packets to destination port 80
HTTP layer: create an HTTP request for the URL /hello.htm on the host www.pippo.it (because the computer at 10.11.12.13 might be hosting several domains, so it needs to know which one is desired) 
"""
GET /hello.htm HTTP/1.1
Host: www.pippo.it
"""

### Example of Headers:

(HTTP request header)
```$xslt
> GET / HTTP/1.1
> Host: www.google.com
> User-Agent: curl/7.47.0
> Accept: text/plain
> Content-Type: text/html; charset=utf-8 or application/json
> Authorization: Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==
> Cookie: $Version=1; Skin=new;	
> Cache-Control: max-age=3600
> Content-Length: 555
```

(HTTP response header)
```$xslt
< HTTP/1.1 302 Found
< Cache-Control: private
< Content-Type: text/html; charset=UTF-8
< Referrer-Policy: no-referrer
< Location: http://www.google.co.uk/?gfe_rd=cr&dcr=0&ei=ci3NWoHiCMPCXprvpIgF
< Content-Length: 269
< Date: Tue, 10 Apr 2018 21:32:34 GMT
< 
<HTML><HEAD><meta http-equiv="content-type" content="text/html;charset=utf-8">
<TITLE>302 Moved</TITLE></HEAD><BODY>
<H1>302 Moved</H1>
The document has moved
<A HREF="http://www.google.co.uk/?gfe_rd=cr&amp;dcr=0&amp;ei=ci3NWoHiCMPCXprvpIgF">here</A>.
</BODY></HTML>
```

**HTTP Request Flow**

- TCP socket is an instance of an endpoint, defined by a IP address and a port

- When a HTTP request is made, browser requests the IP address of given url from an DNS Server via UDP.

- Browser asks OS for the IP address of a DNS server e.g. 8.8.8.8

- The browser constructs the following multi-layered connection:
    IP layer: connect to 8.8.8.8
    UDP layer: set packet for destination port 53
    DNS layer: create a DNS request for an A record for the hostname www.pippo.it

- Once IP address is located, browser init a TCP socket instance to try to init a 3-way handshake with server

- The user's web browser contacts the server using a secure URL.

**Authentication**

[link 1](https://robertheaton.com/2014/03/27/how-does-https-actually-work/)
[link 2](https://stackoverflow.com/questions/470523/how-does-ssl-really-work)

- Asymmetric: Public key encryption, private key decryption
- Symmetric: Public key encryption and decryption

1. Server purchases a SSL certificate from an authority, within the certificate

2. Server attaches its public key to certificate

3. A Certificate Authority (CA) signs the certificate with CA's private key and creates a digital signature, everyone has access to CA's public key

4. Server sends client the certificate

5. Client checks that it either:
    - implicitly trusts the certificate, 
    - Using the CA's public key to decrypt the certificate and match it with the digital signature, if matched, it means a CA has signed the certificate

6. Client generates a symmetric key and encrypt it with certificate's public key, sends it to server

7. server decrypt it to get client's symmetric key

8. actual data communication can occur using the symmetric key

**What is a socket in linux?**

- a socket is a pseudo-file that represents a network connection. 
- once a socket has been created, writes to the socket are turned into network packets
- packets are the sent out, or data received from the network can be read from the socket.

- it is common for programs on a single machine to communicate using standard network protocols, such as TCP; 
- wasteful to go all the way to the network hardware i.e. computing checksums, etc. just to go back to the same host: 
- that's where Unix domains sockets come in. 
- Those are much like regular sockets, except they connect processes on the same host rather than remote processes, 
- they do not attempt to use any network resources at all. In this way, they are a medium of `inter-process communication`.

**Code to port to socket to TCP to IP**

**Server side process**
1. Creates a `socket` i.e. `socket(AF_INET, SOCK_STREAM, 0);`, `SOCK_STREAM` means TCP
2. Bounds it to a particular port number.
```$xslt
    serv_addr.sin_family = AF_INET;
    serv_addr.sin_addr.s_addr = htonl(INADDR_ANY);
    serv_addr.sin_port = htons(80);
```
3. calls `listen()`
4. Keeps on listening on that port number, and the port number is always bound to a listening process.
5. The server will accept the request using `accept()`
6. call `write()` to send data
6. As soon as the server accepts the client request:
    - the kernel allocates a random port number for the server for further `send()` and `receive()`
    - (since the same port number on the server can't be used for sending as well as listening) 
    - now previous port 80 can still listening for new connections

**Client Side**
1. creates a socket
2. Bounds it to a particular port number.
```$xslt
    serv_addr.sin_family = AF_INET;
    serv_addr.sin_port = htons(5000); // port
    serv_addr.sin_addr.s_addr = inet_addr("127.0.0.1");
```
2. send a `connect()` request.
3. if connect is successful, call `read(sockfd, recvBuff, 256)` to receive data

**How does server know which client port to send to?**
It's part of the TCP (or UDP, etc.) header, in the packet. 
So the server finds out because the client tells it. 
This is similar to how it finds out the client's IP address (which is part of the IP header).

E.g. every TCP packet includes an IP header (with source IP, destination IP, and protocol [TCP], at least). 
Then there is a TCP header (with source and destination port, plus more).

When the kernel receives a SYN packet (the start of a TCP connection) with a remote IP of 10.11.12.13 (in the IP header) 
and a remote port of 12345 (in the TCP header), it then knows the remote IP and port. 
It sends back a SYN|ACK. If it gets an ACK back, the listen call returns a new socket, set up for that connection.

[**Why are network interfaces not in /dev like other devices?**](https://unix.stackexchange.com/questions/23199/why-are-network-interfaces-not-in-dev-like-other-devices)

[**Which process is responsible for TCP in Linux**](https://unix.stackexchange.com/questions/418275/which-process-is-responsible-for-tcp-in-linux)

> In terms of code, it is code that exists in kernel space that actually handles the implementation of TCP upward from NIC drivers. The Linux kernel is aware of your network hardware and abstracts it into a set of link adapters. The TCP/UDP/IP stack is then aware of these "link" devices and is further abstracted to Linux/Unix level concepts such as sockets.
  
> Processes access this functionality through system calls to the kernel. While the concept of a process in Linux is isolated or gated from the kernel it is technically true that each process is able to access this functionality through system calls.
  
> This means that when data is received on the NIC its the kernel handling TCP. When an application receives data out of the buffer that process is handling TCP although only in a gated way through system calls in kernel space/memory through its initiation of a system call.
  
> Because Linux is preemptive even calls into kernel space are part of at least how the kernel keeps track of that processes share of time so you might technically consider TCP to be a part of every process. But if you consider only code that belongs to that processes memory space (user space applications) then only the kernel handles TCP.
  
> Keep in mind that Linux/Unix incorporates some socket functionality which is abstracting TCP/IP into libraries that are linked to when compiling an application thus would be in its memory space. Such as memory structures used to represent IP addresses.


**Proxy vs VPN**

Proxy Server

> a proxy server is a server that acts as an intermediary for requests from clients seeking resources from other servers.
Your computer would connect to the proxy server and make a request for a resource (say a web page). The proxy server then goes and gets the resource, and then passes it back to you.

VPN

>  a computer network that uses a public telecommunication infrastructure such as the Internet to provide remote offices or individual users with secure access to their organization's network.

You connect your computer (or network) to a remote network through a virtual network connection. 
This is effectively the same as running a cable from the remote network to your computer, but a lot cheaper. 
Your computer is then a part of the remote network. 
Requests for internet resources (or resources on the remote network) travel down the virtual connection and through the remote network to the internet as if it were the computer's internet connection.

That's all very well, but what's the difference?

VPNs are more difficult to set up but any software can use the internet can use a VPN.
Proxy servers are cheaper and often easier to set up for mass users, but they require specific software support at the user's end to make the requests to the proxy server.
In general a VPN can only support a connection between one computer or network and the remote network. To handle multiple users you need to set up multiple VPNs. (There are special-case exceptions to this but most of the time this is the case).
A single proxy server can service hundreds or thousands of users.

**ipv4 vs ipv6**