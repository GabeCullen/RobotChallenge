package model.interfaces;

/**
 * 	interface for FP representing the robot
 * 	to be implemented by SimpleRobot class with the following constructor:
 * 	public SimpleRobot(String robotName, int xPosition, int yPosition, String facingDirection)
 * 
 */
public interface Robot
{
   /**
    * @return robot name as a String
    */
   public abstract String getRobotName();
   
   
   /**
    * @return direction the robot is facing
    */
   public abstract String getFacingDirection();
   
   
   /**
    * @param facingDirection - the direction you wish to set as the robots facing direction
    * @return direction the robot is facing as a String
    */
   public abstract String setFacingDirection(String facingDirection);
  
   /**
    * @return current value of x 
    */
   public abstract int getXPosition();
   
   /**
    * @param xPosition - x position you wish the robot to be located at 
    * @return current value of x 
    */
   public abstract void setXPosition(int xPosition);
   
   /**
    * @return current value of y 
    */
   public abstract int getYPosition();  
   
   /**
    * @param xPosition - x position you wish the robot to be located at 
    * @return current value of x 
    */
   public abstract void setYPosition(int yPosition);  
  
   /**
    * @return output for given robot 
    * e.g. "Output: 2,2,WEST"
    */
   public abstract String toString();

}
