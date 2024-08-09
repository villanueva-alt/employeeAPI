/**
 * ArrayManager.java
 * This file contains the declaration for the ArrayManager Class of objects
 *
 * @author Rigo Villanueva
 * @since 2022-02-15
 */
package EmpProject;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class ArrayManager extends Employee
{
    // declare properties
    protected int length;       // stores length of list
    protected int maxSize;      // stores max size of list
    protected Employee [] list;     // array to hold list of elements

    // declare constructors
    public ArrayManager()
    {
       length = 0;
       maxSize = 10;
       list = new Employee[maxSize];
    }       // end default constructor
    public ArrayManager(int size)
    {
        if (size <= 0)
        {
            System.err.println("The array size must be positive." + "Creating an array of size 100");
            maxSize = 100;
        }       // end if
        else
            maxSize = size;
        length = 0;
        list = new Employee[maxSize];
    }       // end initializing constructor

    /**
     * @param newEmployee object to append
     */
    public void append(Employee newEmployee)
    {
        if (length == maxSize)
        {
            System.err.println("Cannot insert in a full list.");
        }       // end if
        else
        {
            // list is empty
            list[length] = newEmployee;         // insert item
            length++;       // length points at next available spot
        }      //end else
    }       // end append()

    /**
     *  print array
     */
    public void print()
    {
        int count = 0;
        while (count < length)
        {
            System.out.println(list[count].toString());
            count++;
        }      // end while()
    }       // end print()

    /**
     * method to load employee objects into array
     */
    public void loadEmployees()
    {
        //Record Description of Employee Test Data File:
        //
        //First Name, ID, date hired, employee type


        try
        {
            File file = new File("testdata.txt");
            Scanner empdata = new Scanner(file);

            while (empdata.hasNext())
            {
                Employee temp = new Employee();
                String record = empdata.nextLine();
                String[] fields = record.split(",");
                temp.setName(fields[0]);
                temp.setID(Integer.parseInt(fields[1]));
                temp.setHired(fields[2]);
                temp.setType(fields[3]);
                append(temp);
            }      // end while
            print();
        }       //end try
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }      // end catch()
    }       // end loadEmployees()

    /**
     * @return new employee object to be appended to array
     */
    public Employee create()
    {
        Scanner K = new Scanner(System.in);
        String Name;        // employee name
        int ID;     // employee ID number
        String Hired;       // employee hire date
        String Type;        // employee type
        String infoCorrect;     // is information correct
        Employee tempEmp = new Employee();      // temporary Employee object that will be returned to Main()

        System.out.println("\t> Create New Employee <");
        System.out.print("Name: ");
        Name = K.nextLine();

        System.out.print("\nEmployee ID: ");
        ID = K.nextInt();

        System.out.print("\nHire date(m/d/y): ");
        Hired = K.next();

        System.out.print("\nEmployee Type: ");
        Type = K.next();

        // Echo user input for validation

        System.out.println("\n> Verify <\n");
        System.out.println("Name: " + Name);
        System.out.println("Employee ID: " + ID);
        System.out.println("Hired: " + Hired);
        System.out.println("Employee type: " + Type);
        System.out.print("\nIs this information correct(Y/N): ");
        infoCorrect = K.next();
        infoCorrect = infoCorrect.toUpperCase();

        if (infoCorrect.equals("Y"))
        {
            tempEmp.setName(Name);
            tempEmp.setID(ID);
            tempEmp.setHired(Hired);
            tempEmp.setType(Type);

        }      // end if(infoCorrect)

        return tempEmp;
    }       // end create()

    /**
     * outputs current employee objects to text file
     */
    public void save()
    {
        //Record Description of Employee Test Data File:
        //
        //First Name, ID, date hired, employee type

        try
        {
            File file = new File("testdata.txt");
            PrintWriter printer = new PrintWriter(file);
            int counter = 0;
            String printline = "";

            while(counter < length)
            {
                Employee tempemp = new Employee();      // create temporary employee object
                tempemp = list[counter];        // load tempemp with employee object at index 'counter'

                printline = tempemp.getName() + ",";
                printline += tempemp.getID() + ",";
                printline += tempemp.getHired() + ",";
                printline += tempemp.getType();

                printer.println(printline);
                System.out.println(printline);
                counter++;

            }      // end while(counter<length)

            printer.close();

        }       // end try
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }      // end catch(e)
    }       // end save()

    /**
     * @param find employee object
     * @return index of matching ID
     */
    public int search(Employee find)
    {
        int loc;
        boolean found = false;
        for (loc = 0; loc < length; loc++)
        {
            if (list[loc].equals(find))
            {
                found = true;
                break;
            }      // end if

        }      // end for loop
        if(found)
            return loc;
        else
            return -1;
    }      // end Search(Employee)

    /**
     * @param location index of employee object to be deleted
     */
    public void removeAt(int location)
    {
        if (location < 0 || location >= length)
        {
            System.err.println("location out of range");
        }      // end if
        else
        {
            for (int i = location; i < length; i++ )
                list[i] = list[i + 1];
            list[length - 1] = null;
            length--;
        }      // end else

    }      // end delete()

    /**
     * @param location index of employee object that will be reset
     */
    public void reset(int location)
    {
        if (location < 0 || location >= length)
        {
            System.err.println("location out of range");
        }      // end if()
        else
        {
            Scanner K = new Scanner(System.in);
            String Name;        // employee name
            int ID;     // employee ID number
            String Hired;       // employee hire date
            String Type;        // employee type
            String infoCorrect;     // is information correct

            System.out.print("Name: ");
            Name = K.nextLine();

            System.out.print("\nEmployee ID: ");
            ID = K.nextInt();

            System.out.print("\nHire date(m/d/y): ");
            Hired = K.next();

            System.out.print("\nEmployee Type: ");
            Type = K.next();

            // Echo user input for validation

            System.out.println("\n> Verify <\n");
            System.out.println("Name: " + Name);
            System.out.println("Employee ID: " + ID);
            System.out.println("Hired: " + Hired);
            System.out.println("Employee type: " + Type);
            System.out.print("\nIs this information correct(Y/N): ");
            infoCorrect = K.next();
            infoCorrect = infoCorrect.toUpperCase();

            if (infoCorrect.equals("Y"))
            {
                list[location].setName(Name);
                list[location].setID(ID);
                list[location].setHired(Hired);
                list[location].setType(Type);

            }      // end if(infoCorrect)
        }      // end else()
    }      // end reset

}       // end class ArrayManager