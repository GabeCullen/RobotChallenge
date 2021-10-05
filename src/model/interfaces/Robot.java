package model.interfaces;

/**
 * <pre>Assignment interface for FP representing the player
 * to be implemented by SimplePlayer class with the following constructor:
 * 	  public SimpleRobot(int xPosition, int xPosition, String facingDirection)
 * 
 */
public interface Robot
{
   /**
    * @return human readable robot name
    */
   public abstract String getRobotName();
   
   public abstract String getFacingDirection();
   
   public abstract String setFacingDirection(String facingDirection);
  
   public abstract int getXPosition();
   
   public abstract void setXPosition(int xPosition);
   
   public abstract int getYPosition();  
   
   public abstract void setYPosition(int yPosition);  
  
   public abstract String toString();

}
