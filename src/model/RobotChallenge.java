package model;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import model.interfaces.Robot;

public class RobotChallenge {
	
	// values of the max and min possible x and y coordinates 
	static final int maxXY = 4;
	static final int minXY = 0;
	static int robotNumber = 1;

	public static void main(String[] args){
		
		String[] commands;	
		Robot[] robots = null;
		String commandsFileLocation = "./commands.txt";

		
		// Array list to hold lines from file
		ArrayList<String> commandsArray = new ArrayList<>();
		
		// Try to read in lines from file commands.txt
		try {
			BufferedReader reader = new BufferedReader(new FileReader(commandsFileLocation));
			String line = reader.readLine();
			while (line != null) {
				
				// add each line to commandsArray and then read the next line
				commandsArray.add(line);
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Split the first line into 2 parts. first part should be PLACE and second part should be coordinates X,Y and facing
		String[] lineOneParts = commandsArray.get(0).split(" ");
		
		
		// check that the first command is a PLACE command as required 
		if (lineOneParts[0].equalsIgnoreCase("PLACE") ) {
			// use , to split the coordinates and initialize a robot in the given coordinates
			commands = lineOneParts[1].split(",");
			robots = new Robot[] { new SimpleRobot(robotName(), Integer.parseInt(commands[0]), Integer.parseInt(commands[1]), commands[2])};
		}else {
			// If the command does not start with PLACE then end the program
			System.out.println("It is required that the first command to the robot is a PLACE command");
			System.out.println("Program will now exit");
			System.exit(0);
		}
		
		// Set the new robot as the active robot. 
		//(If multiple robots were added this would be done based off a ROBOT <number> command) 
		Robot activeRobot = robots[0];
		
		for (int i = 0; i < commandsArray.size(); i++) {
			switch(commandsArray.get(i)) {
			  case "MOVE":
				  move(activeRobot);
			    break;
			  case "LEFT":
				 moveLeft(activeRobot);
			    break;
			  case "RIGHT":
				  moveRight(activeRobot);
			    break;
			  case "REPORT":
				  //for(Robot robot : robots)
				  System.out.println(activeRobot.toString());
		    	break;
			}
		}
	}
	
	public static String robotName() {
		String fullName = null;
		String nameBegining = "Robot ";

		fullName = nameBegining.concat(Integer.toString(robotNumber));
		robotNumber += 1;
		
		return fullName;
	}
	
	public static void move(Robot robot) {
		if (robot.getFacingDirection().equalsIgnoreCase("North")) {
	    	moveNorth(robot);
	    } else if (robot.getFacingDirection().equalsIgnoreCase("South")) {
	    	moveSouth(robot);
	    } else if (robot.getFacingDirection().equalsIgnoreCase("East")) {
	    	moveEast(robot);
	    } else {
	    	moveWest(robot);
	    }
	}
	
	public static void moveLeft(Robot robot) {
		if (robot.getFacingDirection().equalsIgnoreCase("North")) {
			robot.setFacingDirection("WEST");
	    } else if (robot.getFacingDirection().equalsIgnoreCase("South")) {
	    	robot.setFacingDirection("EAST");
	    } else if (robot.getFacingDirection().equalsIgnoreCase("East")) {
	    	robot.setFacingDirection("NORTH");
	    } else {
	    	robot.setFacingDirection("SOUTH");
	    }
	}
	
	public static void moveRight(Robot robot) {
		if (robot.getFacingDirection().equalsIgnoreCase("North")) {
			robot.setFacingDirection("EAST");
	    } else if (robot.getFacingDirection().equalsIgnoreCase("South")) {
	    	robot.setFacingDirection("WEST");
	    } else if (robot.getFacingDirection().equalsIgnoreCase("East")) {
	    	robot.setFacingDirection("SOUTH");
	    } else {
	    	robot.setFacingDirection("NORTH"); 
	    }
	}
	
	public static void moveNorth(Robot robot) {
		if (robot.getYPosition() != maxXY) {
			int i = robot.getYPosition() + 1;
			robot.setYPosition(i);
		}
		robot.setYPosition(robot.getYPosition());
	}
	public static void moveSouth(Robot robot) {
		if (robot.getYPosition() != minXY) {
			int i = robot.getYPosition() - 1;
			robot.setYPosition(i);
		}
		robot.setYPosition(robot.getYPosition());
	}
	public static void moveEast(Robot robot) {
		if (robot.getXPosition() != maxXY) {
			int i = robot.getXPosition() + 1;
			robot.setXPosition(i);
		}
		robot.setXPosition(robot.getXPosition());
	}
	public static void moveWest(Robot robot) {
		if (robot.getXPosition() != minXY) {
			int i = robot.getXPosition() - 1;
			robot.setXPosition(i);
		}
		robot.setXPosition(robot.getXPosition());
	}
}