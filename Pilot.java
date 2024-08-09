/**
 * Pilot.java
 * This file contains the declaration for Pilot Class of objects
 *
 * @author Rigo Villanueva
 * @version 1.0
 * @since 2022-02-07
 */

package EmpProject;


//Create a Class Pilot extends Employee
public class Pilot extends Employee
{
    //Declare Pilot properties
    private int LicNum;        //pilot license number (key field)
    private double Rate;       //pilot rating
    private int Hours;      //pilot flight hours

    //Declare Pilot methods
    public Pilot()       //Null Constructor
    {

    }       //end Pilot()

    /**
     * @param LicNum pilot license number
     * @param Hours pilot flight hours
     */
    public Pilot(int LicNum, int Hours)
    {
        this.LicNum = LicNum;
        this.Hours = Hours;
    }       // end initializing Constructor

    /**
     * @param LicNum pilot license number
     */
    public void setLicNum(int LicNum)
    {
        this.LicNum = LicNum;
    }       //end setLicNum()

    /**
     * @param Rate pilot rating
     */
    public void setRate(double Rate)
    {
        this.Rate = Rate;
    }       //end setRate()

    /**
     * @param Hours pilot flight hours
     */
    public void setHours(int Hours)
    {
        this.Hours = Hours;
    }       //end setHours()


    /**
     * @return pilot license number
     */
    public int getLicNum()
    {
        return LicNum;
    }       //end getLicNum()

    /**
     * @return pilot rating
     */
    public double getRate()
    {
        return Rate;
    }       //end getRate()

    /**
     * @return pilot flight hours
     */
    public int getHours()
    {
        return Hours;
    }       //end getHours()

    public String toString()        //toString()
    {
        String info;

        info = "\nPilot License Number: " + LicNum;
        info += "\nPilot Rating: " + Rate;
        info += "\nPilot Flight Hours: " + Hours;

        return info;
    }       //end toString()


    /**
     * @param two second Pilot object
     * @return true if pilot license numbers are the same
     */
    public boolean equals(Pilot two)
    {
        return LicNum == two.LicNum;
    }      //end equals()

    /**
     * @param two second Pilot object
     * @return compares pilots' license numbers
     */
    public int compareTo(Pilot two)     // compareTo()
    {
        if (LicNum > two.LicNum)
            return 1;
        if (LicNum < two.LicNum)
            return -1;
        else
            return 0;
    }       //end compareTo()


    /**
     * @return string indicating the pilot has ejected
     */
    public String eject()
    {
        return "Pilot " + LicNum + " has ejected!";
    }

}       //end Class Pilot
