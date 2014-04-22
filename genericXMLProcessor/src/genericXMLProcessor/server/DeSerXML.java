/**
 * 
 */
package genericXMLProcessor.server;

import genericXMLProcessor.util.SerializableObject;

/**
 * @author Abhishek Waichal
 * Interface DeSerXML to deserialize XML
 */
public interface DeSerXML extends SerDeserXML {
	 /**
	 * @param fileName String
	 * 
	 * @return Object
	 */
	SerializableObject readXML(String fileName);
}
