/** Class that determines whether or not a year is a leap year.
 *  @author Zhenghui Wu
 */
public class LeapYear {

    /** Calls isLeapYear to print correct statement.
    @param  year to be analyzed
     */
    public static void checkLeapYear(int year) {
        if (isLeapYear(year)) {
            System.out.printf("%d is a leap year.\n", year);
        } else {
            System.out.printf("%d is not a leap year.\n", year);
        }
    }


	/** Calculates if input year is leap year
	@param year input year
	@return returns if input year is leap year or not
	*/
	public static boolean isLeapYear(int year) {
		if (year % 400 == 0) return true;
		return (year % 4 == 0 && year % 100 != 0);
	}


  /** Must be provided an integer as a command line argument ARGS.
	@param args input arguments
	*/
    public static void main(String[] args) {
        /*if (args.length < 1) {
            System.out.println("Please enter command line arguments.");
            System.out.println("e.g. java Year 2000");
        }*/
        int[] years = new int[] {2000,1999,2018,1900,2008};
        for (int i = 0; i < years.length; i++) {
            try {
                //int year = Integer.parseInt(args[i]);
                int year = years[i];
                checkLeapYear(year);
            } catch (NumberFormatException e) {
                System.out.printf("%s is not a valid number.\n", args[i]);
            }
        }
    }
}
