package genericXMLProcessor.driver;

/**
 * @author Abhishek Waichal
 * Class Debug used for logging purposes.
 */
public class Debug {
	private static int DEBUG_VALUE;

	/**
	 * @param value int set the DEBUG_VALUE to this
	 * 
	 * This method is used to set the DEBUG value.
	 *  
	 */

	public static void setDebugValue(int value) {
		DEBUG_VALUE = value;
	}

	/**
	 * @return - returns the DEBUG_VALUE
	 *  
	 * This method is used to obtain the DEBUG value.
	 *  
	 */

	public static int getDebugValue() {
		return DEBUG_VALUE;
	}

	/**
	 * Prints the contents as per the debug value
	 * 
	 * @param value int
	 * DEBUG_VALUE
	 * 
	 * @param Message String
	 * message to print
	 * 
	 *  
	 * This method is used to print the logging message as per the DEBUG value.
	 *  
	 */

	public static void printDebug(int value, String Message) {

		if (getDebugValue() == value) {
			switch (value) {
			case 0:
				System.out.println(Message);
				break;
			case 1:
				System.out.println(Message);
				break;
			case 2:
				System.err.println(Message);
				System.exit(0);
				break;
			default:
				break;
			}
		}
	}
}