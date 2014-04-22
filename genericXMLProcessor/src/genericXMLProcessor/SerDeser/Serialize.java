/**
 * 
 */
package genericXMLProcessor.SerDeser;

import genericXMLProcessor.driver.Debug;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Abhishek Waichal
 * Class Serialize use to serialize the Objects to an XML file.
 */
public class Serialize {

	private static String filepath;
	private String currentDirectory ;
	private PrintWriter writer = null;

	/**
	 * Constructor
	 * @param args String
	 */
	public Serialize(String args){
		Debug.printDebug(1, "In Class Serelaize's Constructor");		
		currentDirectory = System.getProperty("user.dir");
		filepath  = currentDirectory+"//src//"+args;
//		filepath  = currentDirectory+"\\src\\"+args;

		try {
			writer = new PrintWriter(filepath, "UTF-8");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Serialize [currentDirectory=" + currentDirectory + ", writer="
				+ writer + ", getCurrentDirectory()=" + getCurrentDirectory()
				+ ", getWriter()=" + getWriter() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}


	/**
	 * @return the filepath
	 */
	public static String getFilepath() {
		return filepath;
	}


	/**
	 * @param filepath the filepath to set
	 */
	public static void setFilepath(String filepath) {
		Serialize.filepath = filepath;
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
	 * @return the writer
	 */
	public PrintWriter getWriter() {
		return writer;
	}


	/**
	 * @param writer the writer to set
	 */
	public void setWriter(PrintWriter writer) {
		this.writer = writer;
	}


	/**
	 * @param ob Object, Object to be serialized
	 */
	public void serializeObject(Object ob) {

		writer.println("<DPSerialization>");
		writer.println(" <complexType xsi:type=\""
				+ ob.getClass().toString().substring(6) + "\">");
		Field fields[] = ob.getClass().getDeclaredFields();
		Field tempField;
		String value = null;
		Method methods[];

		for (int i = 0; i < fields.length; i++) {
			tempField = fields[i];

			methods = ob.getClass().getDeclaredMethods();

			for (int q = 0; q < methods.length; q++)
				if (methods[q].getName().contains("get")
						&& methods[q].getReturnType().getName()
								.contains(tempField.getType().getSimpleName())) {
					try {
						value = "" + methods[q].invoke(ob);
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
				}
			writer.println("  <" + tempField.getName() + " xsi:type=\"xsd:"
					+ tempField.getType().getSimpleName().toLowerCase() + "\">" + value + "</"
					+ tempField.getName() + ">");
		}
		writer.println(" </complexType>");
		writer.println("</DPSerialization>");
		writer.close();
	}
}
