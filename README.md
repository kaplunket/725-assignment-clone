# COMPSYS 725 Assignment 2

The second assignment for COMPSYS 725 at the University of Auckland. The assignment is concerned with mutual exclusion algorithms implemented via a simulation
tool for Functional Blocks [FDBK](http://ftp.holobloc.com/fbdk2/index.htm). In
particular, the mutual exclusion algorithms considered are:
* Central Server
* Ring Token
* Multicast

## Each Section
The first critical section (considering conveyors 2 and 6 going into conveyor 7) is implemented using central server.
The second critical section (considering conveyors 4 & 7 going into conveyor 8) is implemented using ring token.
The third critical section (considering conveyors 8 & 11 going into conveyor 9)) is implemented using multicast.

## Running The Assignment
In order to run this assignment (using ubuntu), first extract the compsys-725-assignment 2. Inside, go into the fbdk directory. once in the directory open the terminal and run:
```
java -jar editor.jar
```
once the fbdk JEditor opens up click on the yes button when ask "I agree with the terms and conditions".
Once in the main window, press the play on the button to launch the BaggageSystemCTL. There will be two windows that pop up, a view window and a HMI window. The view window is a visual representation of the baggage system and the HML window can used to add bags onto the conveyors. Bag in 1 will send a bag into conveyor 1, bag in 2 will send a bag into conveyor 2 and so on for 3 and 4. 

## Contributors
<table>
  <tr>
    <td align="center"><a href="https://github.com/kaplunket"><img src="https://avatars1.githubusercontent.com/u/48303748?s=400&v=4" width="100px;" alt=""/><br /><sub><b>Kazuki Saegusa</b></sub></a><br /></td>
    <td align="center"><a href="https://github.com/rishab-goswami"><img src="https://avatars2.githubusercontent.com/u/48303763?s=400&v=4" width="100px;" alt=""/><br /><sub><b>Rishab Goswami</b></sub></a><br /></td>
    <td align="center"><a href="https://github.com/Matteas-Eden"><img src="https://avatars0.githubusercontent.com/u/45587386?v=4" width="100px;" alt=""/><br /><sub><b>Matt Eden</b></sub></a><br /></td>
  </tr>
</table>

