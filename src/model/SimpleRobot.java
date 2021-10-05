package model;

import model.interfaces.Robot;

public class SimpleRobot implements Robot{
	
		private String facingDirection;
		private String robotName;
		private int yPosition;
		private int xPosition;
		
		public SimpleRobot(String robotName, int xPosition, int yPosition, String facingDirection)
		{
			this.robotName = robotName;
			this.xPosition = xPosition;
			this.yPosition = yPosition;
			this.facingDirection = facingDirection;
		}


		public String getRobotName() {
			return this.robotName;
		}


		@Override
		public String getFacingDirection() {
			return this.facingDirection;
		}


		@Override
		public int getXPosition() {
			return this.xPosition;
		}


		@Override
		public int getYPosition() {
			return this.yPosition;
		}
		
		@Override
		public String toString() 
		{
			return String.format(
					"Output: %s,%s,%s", xPosition, yPosition, facingDirection);  
		}


		@Override
		public String setFacingDirection(String facingDirection) {
			this.facingDirection = facingDirection;
			return null;
		}


		@Override
		public void setXPosition(int xPosition) {
			this.xPosition = xPosition;
		}


		@Override
		public void setYPosition(int yPosition) {
			this.yPosition = yPosition;
		}

}
