/**
 * 
 */
package genericXMLProcessor.xmlSerDeser;

import genericXMLProcessor.SerDeser.Deserialize;
import genericXMLProcessor.SerDeser.Serialize;
import genericXMLProcessor.driver.Debug;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Abhishek Waichal
 * Class XML Handler, to handle all dynamic proxy invocations.
 */
public class XMLHandler implements InvocationHandler {

	
	/**
	 * 
	 */
	public XMLHandler(){
		Debug.printDebug(1, "In Class XMLHandler's Constructor");		
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "XMLHandler [getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		if (method.getName().equals("writeXML")) {

			Serialize serialize = new Serialize((String) args[1]);
			serialize.serializeObject((Object) args[0]);
			
		} else if (method.getName().equals("readXML")) {
			
			Deserialize deserialize = new Deserialize((String) args[0]);
			return deserialize.deserializeFile();
			
		}
		return null;
	}
}
