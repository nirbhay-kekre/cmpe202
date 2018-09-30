
# CRC Cards - Din Tai Fung Design Patterns #


## 1. List of CRC Cards ##

  

**Class name:** Restaurant

Responsibility                   										| Collaborators
----------------------------------------------------------------------- | -------------
**currentState** : which can be openForEnrollment or waitListState .  	| Table
Maintain the total tables which are occupied and available. 			| Party
Ask currentState to add party.    										| OpenForEnrollState  
Notify for tableAvailable to currentState if party  leaves. 			| WaitListState.
allocateTable.                                              			| 

---
<br>

**Class name:** OpenForEnrollState

Responsibility      | Collaborators
------------------- | -------------
**add party:**  <br><em>if #seatsAvailable = party size</em>  allocate table right away.<br> <em>Otherwise</em>,  change state of the restaurant to  WaitListState and ask new state to addParty. | Restaurant
**getNotifiedWhenSeatsAvailable:** ok we're still open | Party

---
<br>

**Class name:** WaitListState

Responsibility  	                                                                             | Collaborators
------------------------------------------------------------------------------------------------ | -------------
Maintain a **waitlist** of parties.                                                              | Restaurant
**addParty( party)**: add party to waitlist.                                                     | Party
**getNotifiedWhenTableAvailable( table)**:  <br> <em>if there are people in Waitlist</em>-  ask biggestPartyWLHandler to enrollFromWaitlist for  Available table.<br>  <em>Otherwise</em>,  change state of restaurant to openForEnrollment state.                                                           | biggestPartyWLHandler: EnrollFromWaitListHandler

---
<br>

**Class name:** EnrollFromWaitListHandler

Responsibility  	                                   | Collaborators
------------------------------------------------------ | -------------
partySize			                                   | nextBiggestPartyWLHandler: EnrollFromWaitListHandler
**enrollFromWaitlist(availableSeats)**: <br> &nbsp;&nbsp;&nbsp;&nbsp;<em> `if the #AvailableSeats on a table >= partySize,`</em> then ask party to confirm, if they confirm allocate table otherwise remove party from WL and check another party in WL.<br>&nbsp;&nbsp;&nbsp;&nbsp;<em> `if #AvailableSeats on a table < partySize`,</em> call nextBiggestPartyWLHandler.enrollFromWaitList      | Party
&nbsp;                                                 | waitListState



	Note: This class is used to demonstrates chain of responsibility, which hides how the party is getting
	seat allocated from the waitingList, there can be  various concrete handlers which can allocate the table 
	according to party size for eg, party of 4 will not get seats allocated on a table of 8, the business logic 
	can be implemented in the concrete handlers.
	
---
<br>

**Class name:** Table

Responsibility  	| Collaborators
------------------- | -------------
Table_Id  			| 
capacity of table  	| 

---
<br>

**Class name:** Party

Responsibility  					| Collaborators
------------------------------------------------------- | -------------
Name of members  					| Restaurant
number of members  					|
phone Number of primary member  			|
respond to table confirmation ('confirm' or 'leave') 	|

---
<br>


## 2. Design Pattern ##

### 2.1 State ###
Restaurant can either be in open for enrollment state where customers come and gets table allotted instantly or  in waiting list state where we have to manage queue to get the next customer for available table.

These two states are represented by **OpenForEnrollState** and **WaitListState** in above CRC cards.

The transition from OpenForEnrollState to WaitList will occur when the restaurant doesn't have table/seat available for the customer. And the transition from WaitListState to OpenForEnrollState will occur when any party leaves and waiting list becomes empty.
The behavior of addParty and leaveParty will differ in both the states hence State pattern is suitable for this scenario.

### 2.2 Chain of Responsibility ###

WaitingListState will ask the Biggest party size handler to give it a customer/party to whom it can allocate a seat. The best part is waitingListState doesn't care which handler handled its request, this way we are able to decouple the party allocation waitingListState. 

In above CRC Cards  **EnrollFromWaitListHandler**  describes the generic handler.

while implementing we can create multiple handlers for different capacity of tables, each of which will take care of returning a appropriate party for its table size. This way its open for extension - since we are not hardcoding how to return a party for a table size. Hence, Chain of responsibility will be a good candidate to implement this. 

