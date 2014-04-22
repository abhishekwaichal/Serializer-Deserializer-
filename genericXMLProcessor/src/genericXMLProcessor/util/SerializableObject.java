/**
 * 
 */
package genericXMLProcessor.util;

import genericXMLProcessor.driver.Debug;

/**
 * @author Abhishek Waichal
 * Class SerializableObject, empty base class extended by test object that are serialized and deserialized. 
 */
public class SerializableObject {

	/**
	 * 
	 */
	public SerializableObject(){
		Debug.printDebug(1, "In Class SerelaizeObject's Constructor");		
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SerializableObject [getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

}
