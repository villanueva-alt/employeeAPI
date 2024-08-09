/**
 * Employee.java
 * This file contains the declaration for the Employee class of objects.
 *
 * @author Rigo Villanueva
 * @version 2.0
 * @since 2022-02-15
 */

package EmpProject;

public class Employee
{
    //Declare Employee properties
    int ID;      //Employee ID number (key field)
    String Name;        //Employee Name
    String Hired;         //Date employee was hired
    String Type;        //type of employee

    //Declare Employee methods

    public Employee()       //Null Constructor
    {

    }       //end Null Constructor

    /**
     * @param Name employee name
     * @param ID employee ID
     */
    public Employee(String Name, int ID)
    {
        this.Name = Name;
        this.ID = ID;
    }       //end initializing Constructor

    //Declare set/get methods for each property

    /**
     * @param ID employee ID
     */
    public void setID(int ID)
    {
        this.ID = ID;
    }       //end setID()

    /**
     * @param Name employee name
     */
    public void setName(String Name)
    {
        this.Name = Name;
    }       //end setName()

    /**
     * @param Hired employee hire date
     */
    public void setHired(String Hired)
    {
        this.Hired = Hired;
    }      //end setHired()

    /**
     * @param Type employee type
     */
    public void setType(String Type)
    {
        this.Type = Type;
    }       //end setType()

    /**
     * @return employee ID
     */
    public int getID()
    {
        return this.ID;
    }       //end getID()

    /**
     * @return employee name
     */
    public String getName()
    {
        return this.Name;
    }       //end getName()

    /**
     * @return employee hire date
     */
    public String getHired()
    {
        return this.Hired;
    }       //end getHired()

    /**
     * @return employee type
     */
    public String getType()
    {
        return this.Type;
    }       //end getType()

    /**
     * @return Employee Name, ID, Type, hire date
     */
    public String toString()
    {
        String Info;
        Info = "Employee Name: " + Name;
        Info += "\nEmployee ID: " + ID;
        Info += "\nEmployee Type: " + Type;
        Info += "\nEmployee hire date: " + Hired;
        Info += "\n";

        return Info;
    }

    /**
     * @param two second employee object
     * @return true if employee ID matches
     */
    public boolean equals(Employee two)
    {
        return ID == two.ID;
    }      //end equals()


}       //end class Employee
