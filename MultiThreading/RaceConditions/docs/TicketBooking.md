<<<<<<< HEAD
<h1>Ticket Booking Class Diagram</h1>
<center>
<img width="602" height="698" alt="image" src="https://github.com/user-attachments/assets/a6cceaa4-4794-4d50-894b-3bc51d6c0ecc" />
</center>
=======
  UML Diagram:
  
                    +----------------------+
                    |     Main Thread      |
                    |  TicketBooking.main()|
                    +----------+-----------+
                               |
                               |
                     Creates one shared object
                               |
                               v
                    +----------------------+
                    |       Ticket         |
                    |----------------------|
                    | - ticket : int = 5   |
                    |----------------------|
                    | + bookTicket()       |
                    +----------+-----------+
                               ^
                               |
        -------------------------------------------------------
        |        |        |        |        |        |        |
        |        |        |        |        |        |        |
+---------------+  +---------------+             +---------------+
|    User 1     |  |    User 2     |    ...      |    User 10    |
|---------------|  |---------------|             |---------------|
| extends Thread|  | extends Thread|             | extends Thread|
|---------------|  |---------------|             |---------------|
| run()         |  | run()         |             | run()         |
+-------+-------+  +-------+-------+             +-------+-------+
        |                  |                             |
        +------------------+-----------------------------+
                           |
                           |
                    Calls bookTicket()
>>>>>>> a756383 (feat : Prevent negative inventory during concurrent purchases)
