import java.util.InputMismatchException;
import java.util.Scanner;
// import java
public class Main extends Object
{
 
  
  //precondition: wholeNumber >= 0
  private static int numberOfDigitsIn(int wholeNumber)
  {
    return (int)Math.log(wholeNumber)+1;
  }
  
  //when n = 0, the final digit of wholeNumber is returned
  private static int extractNthDigitFromWholeNumber(int n, int wholeNumber)
  {
    return ((wholeNumber/(int)(Math.pow(10, n)) %10) );
  }

  // Sort values from lo to hi using the Radix sorwho we described in class
  private static void radixSort(int[] values)
  {
  IntQueue[] vals = {new IntQueue(), new IntQueue(),new IntQueue(),new IntQueue(),new IntQueue(),new IntQueue(),new IntQueue(),new IntQueue(),new IntQueue(),new IntQueue()};

  
    
    // int[] temp = new int[values.length];
    // int n = 0;
   for (int n = 0; n<7; n++){
    for (int x = 0; x<values.length; x++){
      int y = extractNthDigitFromWholeNumber(n,values[x]); // 0-9
       // System.out.println(x+"   "+values[x] + " "+ y);

     vals[y].enqueue(values[x]); // enqueue number in queue 0-9
      } 
    
     int k = 0;
    for (int z =0; z<10;z++){
    while (!vals[z].isEmpty() && k<=values.length-1){
      
      values[k] = ((int)vals[z].dequeue());//assign num from queue z
      // System.out.println(values[k] + " " + k);
      k++;
    } 
      
    }
     }
    
  }
  
  private static void printArray(int[] x)
  {
    for (int m = 0; m < x.length; m++)
    {
      System.out.print(x[m]);
      if (m != x.length-1) System.out.print(", ");
    }
  }
    
    
  public static void main(String[] args)
  {
    /*
    213 3465 7 29 541 45
    5 -3 9 55 687 21 21 0 0 0
    9 9 9 9 9
    */
    
    boolean quit = false; //used to determine when to quit the app    
    while (quit == false) //repeat this until quit becomes true
    {
      Scanner keyboard = new Scanner(System.in);
      boolean retry; //used to determine if the user needs to re-enter the grades
      int size = -1;
      String prompt = "How many positive integer numbers do you have? ";
      do
      {
        retry = false; //assume for now that user will not need to re-enter the data
        System.out.print(prompt);        
        try
        {
          keyboard = new Scanner(System.in); //clear out any data left in the stream
          size = keyboard.nextInt();
          if (size < 0) throw new InputMismatchException(); //make sure at least one student
        }
        catch (InputMismatchException ime)
        {
          prompt = "Incorrect input: how many integer numbers do you have? ";
          retry = true;
        }          
      }
      while (retry == true);
     
      prompt = "Enter "+size+" integer numbers: "; //inital user prompt for data
      do
      {
        retry = false; //assume for now that user will not need to re-enter the data
        System.out.print(prompt);        
        try
        {
          keyboard = new Scanner(System.in); //clear out any data left in the stream
          // int[] values= {7, 60, 5, 9, 8, 4, 3, 1, 2, 0};
          int[] values = new int[size]; //create an array to store the grades
          for (int m = 0; m < size; m++) //fill the array
          {
            // m++;
            values[m] = keyboard.nextInt();
          }
          if (size == 0) System.out.println();
          System.out.println("-----------------------------------------------------");
          System.out.print("Inputs array before sorting (radix): ");
          Main.printArray(values);
          
          System.out.print("\n Inputs array after sorting (radix): ");
          Main.radixSort(values);
          Main.printArray(values);
        }
        catch (InputMismatchException ime)
        {
          prompt = "Incorrect input, re-enter "+size+" valid integer numbers: ";
          retry = true;
        }          
      }
      while (retry == true);
      
      keyboard = new Scanner(System.in); //clear out any leftover data in the stream
      String again = ""; //used to determine whether the user wants the app to continue
      do
      {
        System.out.print("\n\nTry again (Y/N)? ");
        again = keyboard.nextLine().trim().toUpperCase(); //convert to uppercase and remove leading and trailing whitespace
      }
      while (!again.equals("Y") && !again.equals("N")); //repeat if the user typed in something other than Y or N

      if (again.equals("N")) quit = true; //this will cause the outermost while loop Boolean test to evaluate to false
      System.out.println();
    }
  }
}
