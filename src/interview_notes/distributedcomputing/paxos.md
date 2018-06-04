# Paxos

[Google Talk](https://www.youtube.com/watch?v=d7nAGI_NZPk)

[Paxos in simple words](https://pdos.csail.mit.edu/6.824/papers/paxos-simple.pdf)

Assume a collection of processes that can propose values. 

A consensus algorithm ensures that a single one among the proposed values is chosen. 

If no value is proposed, then no value should be chosen. 

If a value has been chosen, then processes should be able to learn the chosen value. 

The safety requirements for consensus are:
• Only a value that has been proposed may be chosen,
• Only one single value is chosen, and
• A process never learns that a value has been chosen unless it actually has been.

**Goal**: ensure that some proposed value is eventually chosen and, if a value has
been chosen, then a process can eventually learn the value

The consensus algorithm be performed by 3 classes of agents: proposers, acceptors, and learners

- Agents operate at arbitrary speed, may fail by stopping, and may restart.

- agents can communicate with one another by sending messages

- Since all agents may fail after a value is chosen and then restart, 
  a solution is impossible unless some information can be remembered by 
  an agent that has failed and restarted.

- Messages can take arbitrarily long to be delivered, can be duplicated, 
  and can be lost, but they are not corrupted.

### Choosing a value

- A proposer sends a proposed value to a set of acceptors. 
- An acceptor may accept the proposed value.
- The value is chosen when a large enough set of acceptors have accepted it

> To ensure that only a single value v is chosen, 
> select only one proposal from a pool of proposals which are all accepted by majority (Requirement R1)
 
Any **two majorities** have at least **one** acceptor in common

If there is **only one single value** proposed by all the proposers,
which may or may not be accepted by all acceptors to become the majority,
we have to accept that single proposal because we want a value to be chosen.  

Hence,
> An acceptor must accept the first proposal that it receives (Requirement R2)

This raises a problem. Several values could be proposed by
different proposers at about the same time, leading to every acceptor has accepted a value, 
but no single value is accepted by a majority of them. 
We can assign a random number to ensure they arrive in sequence

R1 and R2 together mean that each acceptor should also be able to accept more proposals, even if it has already accepted one.

we can keep track of the different proposals that an
acceptor accept by assigning an **increasing (natural) number** to each proposal, so each
proposal consists of an unique proposal number and a value

> If a proposal of value v (accepted by majority) has already been chosen,

> then every latter proposals chosen must have the same value v and higher-numbered, (R3)

(satisfy R1)

In order to ensure the already chosen proposal's value doesn't change by latter proposals, 

> then every latter proposals accepted by any acceptors must have value v (R4)

because any latter proposals can have different values, which are also accepted by majority. 

However if an agent dies, and have not accepted any proposals, then wakes up and proposes.

By R2, it must accept a its own proposal, but contradicting R4. Hence,

> then every latter proposals issued by any proposer must have value v,



> (Requirement R3)

R3 guarantees R1



