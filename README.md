ToyRobotSimulator
Description
-	The application is a simulation of a toy robot moving on a square tabletop, of dimensions 5 units x 5 units
-	There are no other obstructions on the table surface
-	The robot is free to roam around the surface of the table, but must be prevented from falling to destruction. 
Any movement that would result in the robot falling from the table must be prevented, however further valid movement commands must 
still be allowed.

The application that can read in commands of the following form

PLACE X,Y,F
MOVE
LEFT
RIGHT
REPORT

-	PLACE will put the toy robot on the table in position X,Y and facing NORTH, SOUTH, EAST or WEST
-	The origin (0,0) can be considered to be the SOUTH WEST most corner
-	The first valid command to the robot is a PLACE command, after that, any sequence of commands may be issued, in any order, including another PLACE command
-	The application should discard all commands in the sequence until a valid PLACE command has been executed
-	MOVE will move the toy robot one unit forward in the direction it is currently facing
-	LEFT and RIGHT will rotate the robot 90 degrees in the specified direction without changing the position of the robot
-	REPORT will announce the X,Y and F of the robot. 

-	Example Input and Output:
o	PLACE 0,0,NORTH
o	MOVE
o	REPORT
	Output: 0,1,NORTH
o	PLACE 0,0,NORTH
o	LEFT
o	REPORT
	Output: 0,0,WEST
o	PLACE 1,2,EAST
o	MOVE
o	MOVE
o	LEFT
o	MOVE
o	REPORT
	Output: 3,3,NORTH
