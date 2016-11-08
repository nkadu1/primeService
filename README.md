# primeService
Client-Server-based-Multi-threaded-application

Author(s): Niraj Kadu
e-mail(s): nkadu1@binghamton.edu

PURPOSE:
Design a simple multi-threaded client-server code in Java


FILES:

Following are the files that are necessary for the project to run:-
1)PrimeDriver.java
2)ClientDriver.java
3)ServerDriver.java
4)ClientMenu.java
5)ServerMenu.java
6)PrimeServerSocket.java
7)PrimeServerWorker.java
8)PrimeClientWorker.java
8)PrimeClientSocket.java
11)CheckPrime.java
10)AllPrimeQueries.java
11)Debug.java
12)ShowMenuInterface.java

SAMPLE OUTPUT:

Client Name: John
Client Number: 23
Server Response: Is a prime number

## To clean:
ant -buildfile src/build.xml clean

## To compile: 
ant -buildfile src/build.xml all

## To run
ant -buildfile src/build.xml run <args>
ant -buildfile src/build.xml run -Darg0=Server -Darg1=5000
ant -buildfile src/build.xml run -Darg0=Client -Darg1=localhost -Darg2 = 5000 -Darg3=4

## To create tarball for submission
ant -buildfile src/build.xml tarzip
