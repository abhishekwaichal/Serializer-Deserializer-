/**
 * 
 */
package genericXMLProcessor.SerDeser;

import genericXMLProcessor.driver.Debug;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Abhishek Waichal
 * Class Deserialize used for creating test deserializing XML files.
 */
public class Deserialize {

	/**
	 * 
	 */
	private ArrayList<Object> objectList ;	
	private FileReader in = null; 
	private String currentDirectory = System.getProperty("user.dir");
	private String FilePath;
	private BufferedReader br = null;
	
	/**
	 *  Constructor 
	 * @param args String
	 */
	public Deserialize(String args) {
		Debug.printDebug(1, "In Class Deserialize's Constructor");
		
		objectList = new ArrayList<Object>();
		
		FilePath = "//src//" + args;
//		FilePath = "\\src\\" + args;
//		System.out.println(currentDirectory  + FilePath);
		
		
		try {
			in = new FileReader(currentDirectory  + FilePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		br = new BufferedReader(in);

	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Deserialize [objectList=" + objectList + ", in=" + in
				+ ", currentDirectory=" + currentDirectory + ", FilePath="
				+ FilePath + ", br=" + br + "]";
	}

	/**
	 * @return the objectList
	 */
	public ArrayList<Object> getObjectList() {
		return objectList;
	}

	/**
	 * @param objectList the objectList to set
	 */
	public void setObjectList(ArrayList<Object> objectList) {
		this.objectList = objectList;
	}

	/**
	 * @return the in
	 */
	public FileReader getIn() {
		return in;
	}

	/**
	 * @param in the in to set
	 */
	public void setIn(FileReader in) {
		this.in = in;
	}

	/**
	 * @return the currentDirectory
	 */
	public String getCurrentDirectory() {
		return currentDirectory;
	}

	/**
	 * @param currentDirectory the currentDirectory to set
	 */
	public void setCurrentDirectory(String currentDirectory) {
		this.currentDirectory = currentDirectory;
	}

	/**
	 * @return the filePath
	 */
	public String getFilePath() {
		return FilePath;
	}

	/**
	 * @param filePath the filePath to set
	 */
	public void setFilePath(String filePath) {
		FilePath = filePath;
	}

	/**
	 * @return the br
	 */
	public BufferedReader getBr() {
		return br;
	}

	/**
	 * @param br the br to set
	 */
	public void setBr(BufferedReader br) {
		this.br = br;
	}

	/**
	 * @return Object
	 */
	public Object deserializeFile(){

		int i = 0;
		int j = 0;
		int k = 0;

		String tempString;
		CharSequence className;

		DeserializeTypes deserializeTypes = new DeserializeTypes();

		String objClass[] = new String[128];
		String memName[] = new String[128];
		String memType[] = new String[128];
		String memValue[] = new String[128];

		String classLine = null;
		String memLine = null;

		int temp;
		int temp1;
		try {
			while (true) {

				tempString = br.readLine();

				if (tempString == null)
					break;
				else if (tempString.equalsIgnoreCase("<DPSerialization>"))
					classLine = br.readLine();

				temp = classLine.indexOf("\"");
				className = classLine.subSequence(temp + 1,
						classLine.lastIndexOf("\""));
				objClass[j] = className.toString();
				objectList.add(Class.forName(objClass[j]).newInstance());

				i = 0;

				memLine = br.readLine();

				while (true) {

					temp = memLine.indexOf("xsd:") + 4;
					temp1 = memLine.indexOf("\">");

					memType[i] = memLine.substring(temp, temp1);

					temp = memLine.indexOf("</");

					memValue[i] = memLine.substring(temp1 + 2, temp);

					memName[i] = memLine.substring(temp + 2,
							memLine.length() - 1);

					i++;

					memLine = br.readLine();

					if (memLine.contains("</complexType>"))
						memLine = br.readLine();

					if (memLine.contains("</DPSerialization>"))
						break;
				}

				for (k = 0; k < i; k++) {
					if (memType[k].equalsIgnoreCase("int"))
						deserializeTypes.setInt(objectList.get(j), memValue[k], memName[k]);
					if (memType[k].equalsIgnoreCase("float"))
						deserializeTypes.setFloat(objectList.get(j), memValue[k], memName[k]);
					if (memType[k].equalsIgnoreCase("long"))
						deserializeTypes.setLong(objectList.get(j), memValue[k], memName[k]);
					if (memType[k].equalsIgnoreCase("short"))
						deserializeTypes.setShort(objectList.get(j), memValue[k], memName[k]);
					if (memType[k].equalsIgnoreCase("char"))
						deserializeTypes.setChar(objectList.get(j), memValue[k], memName[k]);
					if (memType[k].equalsIgnoreCase("double"))
						deserializeTypes.setDouble(objectList.get(j), memValue[k], memName[k]);
					if (memType[k].equalsIgnoreCase("String"))
						deserializeTypes.setString(objectList.get(j), memValue[k], memName[k]);
				}
				j++;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return objectList.get(0);
	}
}