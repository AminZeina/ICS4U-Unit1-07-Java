import java.util.Scanner;

/**
 * This uses method overloading to calculate board foot dimensions.
 * 
 * @author Amin Zeina
 * @version 1.0
 * @since 2020-02-28
 */

 
public class BoardFoot {
  
  /**
  * This method calcuates height given length and width.
  */
 
  public static double boardFoot(double length, double width) {
    // Calculate height
    double height = 144 / (length * width);
    return height;
  }
  
  /**
  * This method is the overloaded boardFoot method, which can calculate any of the 3 variables.
  */
  
  public static double boardFoot(double length, double width, double height) {
    // Already calculated height in other method, so only need to check length and width
    
    if (length == 0) {
      // Calculate length
      length = 144 / (width * height);
      return length;
    } else {
      // Calculate width, as it must be the unknown
      width = 144 / (length * height);
      return width;
    }
  }
  
  /**
  * This class gets dimensions from user and calls a boardFoot method based on what is given.
  */
 
  public static void main(String[] args) {
    
    // Declare variables
    double length;
    double width;
    double height;
  
    // Create scanner object
    Scanner userInput = new Scanner(System.in);
    
    System.out.print("Enter the length in inches. If unknown, enter 0: ");
    // Ensure input is a number 
    try {
      length = userInput.nextDouble();
      System.out.print("Enter the width in inches. If unknown, enter 0: ");
      width = userInput.nextDouble();
      System.out.print("Enter the height in inches. If unknown, enter 0: ");
      height = userInput.nextDouble();
      
      // Ensure at least 1 dimension is unknown
      if (length == 0 || width == 0 || height == 0) {
        if (height == 0  && width != 0  && length != 0) {
          // Call method to calculate height, rounding to 2 decimal places.
          System.out.println("The height of this board foot is " 
              + Math.round(boardFoot(length, width) * 100.0) / 100.0 + " inches.");
        } else if ((length == 0  && width != 0  && height != 0)) {
          // Call method to calculate length, rounding to 2 decimal places.
          System.out.println("The length of this board foot is " 
              + Math.round(boardFoot(length, width, height) * 100.0) / 100.0 + " inches.");
        } else if (width == 0  && length != 0  && height != 0) {
          // Call method to calculate width, rounding to 2 decimal places.
          System.out.println("The width of this board foot is " 
              + Math.round(boardFoot(length, width, height) * 100.0) / 100.0 + " inches.");
        } else {
          // More than 1 dimension was entered as 0
          System.err.println("Invalid Input. There can only be 1 unknown dimension.");
        }
      } else {
        // No dimensions were entered as 0
        System.err.println("Invalid Input. At least 1 dimension must be unknown.");
      }
    } catch (Exception e) {
      // Double was not entered
      System.err.println("Invalid input. Please enter a number.");
    }
  }
}