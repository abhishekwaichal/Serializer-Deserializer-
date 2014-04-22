/**
 * 
 */
package genericXMLProcessor.server;

import genericXMLProcessor.util.SerializableObject;

/**
 * @author Abhishek Waichal
 * Interface to Serialize XML
 */
public interface SerXML extends SerDeserXML {
	/**
	 * @param myF SerializableObject, object to be serialized 
	 * @param fileName String, file to which serialized object is written
	 */
	void writeXML(SerializableObject myF, String fileName);
}
