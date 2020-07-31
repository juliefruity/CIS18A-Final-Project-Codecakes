/*Julissa Mota. CIS-18A; Final Project.
This is a menu, step-by-step and decision-based program
designed for orders from Codecakes, a cupcake store.
Designed by the company, Pro-J, this program is easy
use for customers who place their personal orders online,
or for staff operation to place orders for the customer.
This menu allows easy guidance for the user to be able to
order what flavors they wish through tiers of the base flavor,
the frosting flavor, and choice of topping, and ultimately
providing a reciept.*/

package codecakespack;		//Import package that includes the class Closure.
import java.util.*;		
import java.math.BigDecimal;	
import java.math.RoundingMode;	

interface opening	//Interface for opening msg1.
{
  void msg1();
}

interface processing	//Interface for processing msg2.
{
  void msg2();
}

//Class WelcomeMenu that Implements the Opening & Display msgs.
class WelcomeMenu implements opening, processing {

  //Interface opening msg1.
  public void msg1() {
  System.out.println();
  System.out.println("\t *Welcome to CodeCakes*");
  System.out.println("\t A Yummy Cupcake Store!");
  System.out.println("\t ----------------------");
  }

  //Interface opening msg2.
  public void msg2() {
  System.out.println();
  System.out.println("Processing your order...");
  System.out.println();
  System.out.println("Here is your reciept:");
  System.out.println();
  System.out.println("Tier\t\t\t\tPrice");
  System.out.println("--------------------------------------");
  }
}

//Class UserChoice that includes variables for each tier choice for user.
class UserChoice {
  int base_choice;
  int frosting_choice;
  int topping_choice;
  int change;
}

//Main class for the program.
class Codecakes {
  public static void main(String args[]) throws java.io.IOException {

//Construct objects.
  UserChoice userpick = new UserChoice();
  codecakesendpack.Closure bye = new codecakesendpack.Closure();
  WelcomeMenu ob1 = new WelcomeMenu();

//Calls for Interface msgs.
  //Interface opening.
  ob1.msg1();

//Array price. (In order: base, frosting, topping.)
  double prices[] = {2.00,1.00,0.99};

//Variables.
  int i;
  double base_total = 0;
  double frosting_total = 0;
  double topping_total = 0;
  double reciept_total = 0;
  double user_change = 0;
  double tax_rate = 0.0725;
  double tax_total = 0;
  double only_tax = 0;

//***STEP 1***
  System.out.println();
  System.out.println("-Step 1-");
  System.out.println();
  System.out.println("Pick the base flavor:");
  System.out.println("--------------------------------------");

//*Base* flavor menu.
  for(i=0; i<4; i++)
    switch(i) {
      case 0:
        System.out.println("1. Vanilla");
        break;
      case 1:
        System.out.println("2. Chocolate");
        break;
      case 2:
        System.out.println("3. Strawberry");
        break;
      case 3:
        System.out.println("4. Quit");
        break;
  }

  System.out.println();

//*Base* input from user.
  Scanner sc = new Scanner(System.in);
  System.out.print("Enter your base choice: ");
  if (sc.hasNextInt()) {
     userpick.base_choice = sc.nextInt();
     sc.nextLine();
     }
  else {
      System.out.println("Your input was invalid.\nPlease restart the program to try again.\nThank you for using the Codecakes program!\nPlease come again!\n\n(c)Pro-J");
      System.exit(0);
      }

//*Base* outputs for inputs 1-4 and invalid.
  if (userpick.base_choice == 1) {
  System.out.print("Your base is Vanilla.");
  }

  if(userpick.base_choice == 2) {
  System.out.println("Your base is Chocolate.");
  }

  if(userpick.base_choice == 3) {
  System.out.println("Your base is Strawberry.");
  }

  if(userpick.base_choice == 4) {
  System.out.println("Thank you for using our Codecakes program!\nPlease come again!\n\n(c)Pro-J");
  System.exit(0);
  }

  if(userpick.base_choice != 1 && userpick.base_choice != 2 && userpick.base_choice !=3 && userpick.base_choice !=4) {
  System.out.println("Invalid input. Please try again.");
  System.exit(0);
  }

  if(userpick.base_choice == 1 || userpick.base_choice == 2 || userpick.base_choice == 3) {
  base_total = base_total + prices[0];		//Add base price to base_total.
  }

  System.out.println();

//***STEP 2***
  System.out.println();
  System.out.println("-Step 2-");
  System.out.println();
  System.out.println("Pick the frosting flavor:");
  System.out.println("--------------------------------------");

//*Frosting* flavor menu.
  for(i=0; i<4; i++)
    switch(i) {
      case 0:
        System.out.println("1. Rasberry");
        break;
      case 1:
        System.out.println("2. Marshmellow");
        break;
      case 2:
        System.out.println("3. Fudge");
        break;
      case 3:
        System.out.println("4. Quit");
        break;
  }

  System.out.println();

//*Frosting* input from user.
  System.out.print("Enter your frosting choice: ");

  if (sc.hasNextInt()) {
  userpick.frosting_choice = sc.nextInt();
  sc.nextLine();
      }

  else {
  System.out.print("Invalid input. Please try again.");
  System.exit(0);
      }

//*Frosting* outputs for inputs 1-4 and invalid.
  if (userpick.frosting_choice == 1) {
  System.out.println("Your frosting is Rasberry.");
  }

  if(userpick.frosting_choice == 2) {
  System.out.println("Your frosting is Marshmellow.");
  }

  if(userpick.frosting_choice == 3) {
  System.out.println("Your frosting is Fudge.");
  }

  if(userpick.frosting_choice == 4) {
  System.out.println("Thank you for using our Codecakes program!\nPlease come again!\n\n(c)Pro-J");
  System.exit(0);
  }

  if(userpick.frosting_choice != 1 && userpick.frosting_choice != 2 && userpick.frosting_choice !=3 && userpick.frosting_choice !=4) {
  System.out.println("Your input was invalid.\nPlease restart the program to try again.\nThank you for using the Codecakes program!\nPlease come again!\n\n(c)Pro-J");
  System.exit(0);
  }

  if(userpick.frosting_choice == 1 || userpick.frosting_choice == 2 || userpick.frosting_choice == 3) {
  frosting_total = base_total + prices[1];		//Add base_total and frosting price to frosting_total.
  }

//***STEP 3***
  System.out.println();
  System.out.println("-Step 3-");
  System.out.println();
  System.out.println("Pick the topping:");
  System.out.println("--------------------------------------");

//*Topping* flavor menu.
  for(i=0; i<4; i++)
    switch(i) {
      case 0:
        System.out.println("1. Cookie Dough");
        break;
      case 1:
        System.out.println("2. Cherry");
        break;
      case 2:
        System.out.println("3. Rainbow Sprinkles");
        break;
      case 3:
        System.out.println("4. Quit");
        break;
  }

  System.out.println();
  System.out.println("*ATTENTION: THIS DECISION WILL COMPLETE YOUR ORDER.*");
  System.out.println();

//*Topping* input from user.
  System.out.print("Enter your topping choice: ");

  if (sc.hasNextInt()) {
  userpick.topping_choice = sc.nextInt();
  sc.nextLine();
      }

  else {
  System.out.print("Invalid input. Please try again.");
  System.exit(0);
      }

//*Topping* ouputs for inputs 1-4 and invalid.
  if (userpick.topping_choice == 1) {
  System.out.println("Your topping is Cookie Dough.");
  }

  if(userpick.topping_choice == 2) {
  System.out.println("Your topping is Cherry.");
  }

  if(userpick.topping_choice == 3) {
  System.out.println("Your topping is Rainbow Sprinkles.");
  }

  if(userpick.topping_choice == 4) {
  System.out.println("Thank you for using our Codecakes program!\nPlease come again!\n\n(c)Pro-J");
  System.exit(0);
  }

  if(userpick.topping_choice != 1 && userpick.topping_choice != 2 && userpick.topping_choice !=3 && userpick.topping_choice !=4) {
  System.out.println("Your input was invalid.\nPlease restart the program to try again.\nThank you for using the Codecakes program!\nPlease come again!\n\n(c)Pro-J");
  System.exit(0);
  }

  if(userpick.topping_choice == 1 || userpick.topping_choice == 2 || userpick.topping_choice == 3) {
  topping_total = frosting_total + prices[2];
  reciept_total = reciept_total + topping_total;		//Add reciept_total and topping_total to reciept_total (overall price).
  }

//***RECIEPT***
//*Reciept* menu.
  //Interface processing.
  ob1.msg2();  

//*Reciept* display & prices.
//*Reciept* for base.
  if (userpick.base_choice == 1) {
  System.out.println("Base: VANILLA\t\t\t$" + prices[0]);
  }

  if(userpick.base_choice == 2) {
  System.out.println("Base: CHOCOLATE\t\t\t$" + prices[0]);
  }

  if(userpick.base_choice == 3) {
  System.out.println("Base: STRAWBERRY\t\t$" + prices[0]);
  }

//*Reciept* for frosting.
  if (userpick.frosting_choice == 1) {
  System.out.println("Frst: RASBERRY\t\t\t$" + prices[1]);
  }

  if(userpick.frosting_choice == 2) {
  System.out.println("Frst: MARSHMELLOW\t\t$" + prices[1]);
  }

  if(userpick.frosting_choice == 3) {
  System.out.println("Frst: FUDGE\t\t\t$" + prices[1]);
  }

//*Reciept* for topping.
  if (userpick.topping_choice == 1) {
  System.out.println("Topp: COOKIE DOUGH\t\t$" + prices[2]);
  }

  if(userpick.topping_choice == 2) {
  System.out.println("Topp: CHERRY\t\t\t$" + prices[2]);
  }

  if(userpick.topping_choice == 3) {
  System.out.println("Topp: RAINBOW SPRKLS\t\t$" + prices[2]);
  }


//*Reciept* total with tax and closure.
  System.out.println("Total:\t\t\t\t$" + reciept_total);

  only_tax = reciept_total * tax_rate;
  tax_total = reciept_total + only_tax;

//*Reciept* setting decimal rounding for tax.
  BigDecimal bd = new BigDecimal(only_tax).setScale(2, RoundingMode.HALF_UP);
  double only_tax_dec = bd.doubleValue();
  BigDecimal bd1 = new BigDecimal(tax_total).setScale(2, RoundingMode.HALF_UP);
  double tax_total_dec = bd1.doubleValue();

  System.out.println("Tax:\t\t\t\t$" + only_tax_dec);
  System.out.println();
  System.out.println("Total w/tax:\t\t\t$" + tax_total_dec);

  System.out.println();

//Call from Closure class (from seperate package: Codecakesendpack).
  bye.msg();

///////////////////////////////////////////////////////////////end.

 }
}

