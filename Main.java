/**
 * <h1>User Defined Object: Employee and Pilot Classes</h1>
 * The EmpProject demonstrates inheritance by initializing Pilot objects, which are extended from Class Employee
 *
 * @author Rigo Villanueva
 * @version 2.0
 * @since 2022-02-15
 */

package EmpProject;

import java.util.Scanner;
public class Main
{

    public static ArrayManager manage = new ArrayManager();         // instantiates class level instance of ArrayManager object

    public static void main(String[] args)
    {
        manage.loadEmployees();
        menu();

    }       //end main()
    public static void menu()
    {
        int selection = 0;
        Scanner K = new Scanner(System.in);

        while (selection != 7)
        {
            System.out.println("\t>>Array API<<");
            System.out.print("1 | List Employees\n2 | Add Employee\n3 | Delete Employee\n4 | Search\n5 | Edit Employee\n6 | Save Changes\n7 | Exit\n> ");
            selection = K.nextInt();

            if (selection == 1)
            {
                System.out.println("\t> Employees <");
                manage.print();
            }      //end if(1)
            else if (selection == 2)
            {
                Employee newEmployee;
                newEmployee = manage.create();
                manage.append(newEmployee);

            }      // end else if(2)
            else if (selection == 3)
            {
                delete(manage);
            }      // end else if(3)
            else if (selection == 4)
            {
                int back = manage.search(getEmpID());       // index returned saved to variable back
                if (back != -1)
                    System.out.println("\n" + manage.list[back]);
                else
                    System.out.println("\n> Employee not in database.");
            }      // end else if(4)
            else if(selection == 5)
            {
                edit(manage);
                System.out.println("\n>> Employee has been edited");
            }      // end else if(5)
            else if (selection == 6)
            {
                manage.save();
                System.out.println("\n>> Changes have been saved\n");

            }      // end else if (6)
            else if (selection == 7)
            {
                System.out.println("\tBye-bye");
            }      // end else if(7)
        }      // end while()
        K.close();
    }       // end menu()
    public static Employee getEmpID()
    {
        Employee tempemp = new Employee();      // hold state of ID being searched for
        int tempID;         // holds ID user is searching for
        String response;        // holds user validation response
        Scanner K = new Scanner(System.in);

        System.out.println("\n\t> Employee Search <");
        System.out.print("\nEnter Employee ID: ");
        tempID = K.nextInt();

        System.out.println("\n\t> Please Verify <");
        System.out.println("Searching Employee ID: " + tempID);
        System.out.print("Verify(Y/N): ");
        response = K.next();

        if(response.toUpperCase().equals("Y"))
        {
            tempemp.setID(tempID);
        }      // end if()

        return tempemp;
    }      // end getEmpID()
    public static void delete(ArrayManager manage)
    {
        Employee tempemp;       // temporary employee object to find employee object in array
        int empID;      // employee ID to be removed
        int index;      // index of matching employee ID
        String verify;      // user verification response

        Scanner K = new Scanner(System.in);

        System.out.println("\n\t> Delete Employee <");
        System.out.print("\nEnter employee ID: ");
        empID = K.nextInt();

        tempemp = new Employee();       // instantiate tempemp to null
        tempemp.setID(empID);       // set tempemp ID to user input ID
        index = manage.search(tempemp);     // search array for ID

        if (index >= 0)
        {
            System.out.println("\n> Are you sure you want to delete:\n" + manage.list[index]);
            System.out.print("> Verify(Y/N): ");
            verify = K.next();

            if(verify.toUpperCase().equals("Y"))
            {
                manage.removeAt(index);
                System.out.println("Employee has been removed.\n");
            }       // index sent to removeAt()
            // end if(verify)
        }      // end if
    }      // end delete()
    public static void edit(ArrayManager manage)
    {
        Employee grabber = new Employee();      // object used to search
        int empID;      // employee ID
        int index;      // index of matching employee ID
        String verify;      // user verification response

        Scanner K = new Scanner(System.in);

        System.out.println("\n\t> Edit Employee <");
        System.out.print("\nEnter employee ID: ");
        empID = K.nextInt();

        grabber.setID(empID);       // set grabber ID to user input
        index = manage.search(grabber);     // search array for user ID

        if (index >= 0)
        {
            System.out.println("\n> Are you sure you want to edit:\n" + manage.list[index]);
            System.out.print("> Verify(Y/N): ");
            verify = K.next();

            if (verify.toUpperCase().equals("Y"))
            {
                manage.reset(index);
                System.out.println("Employee has been edited.\n");
            }      // end edit if()
        }      // end verify if()

    }      // end edit()


}       //end Class Main