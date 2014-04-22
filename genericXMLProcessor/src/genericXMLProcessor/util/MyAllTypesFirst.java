/**
 * 
 */
package genericXMLProcessor.util;

import genericXMLProcessor.driver.Debug;

/**
 * @author Abhishek Waichal
 * Class MyAllTypesFirst used for creating test Objects.
 */
public class MyAllTypesFirst extends SerializableObject{

	int myInt;
	String myString;
	double myDouble;
	long myLong;
	char myChar;
	
	/**
	 * 
	 */
	public MyAllTypesFirst(){
		Debug.printDebug(1, "In Class MyAllTypesFirst's (Default)Constructor");
	}

	
	/**
	 * @param myIntIN int
	 * @param myStringIN String
	 * @param myDoubleIN double
	 * @param myLongIN long
	 * @param myCharIN char
	 */
	public MyAllTypesFirst(int myIntIN, String myStringIN, double myDoubleIN, long myLongIN, char myCharIN){		
		Debug.printDebug(1, "In Class MyAllTypesFirst's (Parameterised)Constructor");
		this.myChar = myCharIN;
		this.myDouble = myDoubleIN;
		this.myInt = myIntIN;
		this.myLong = myLongIN;
		this.myString = myStringIN;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MyAllTypesFirst [myInt=" + myInt + ", myString=" + myString
				+ ", myDouble=" + myDouble + ", myLong=" + myLong + ", myChar="
				+ myChar + ", getMyInt()=" + getMyInt() + ", getMyString()="
				+ getMyString() + ", getMyDouble()=" + getMyDouble()
				+ ", getMyLong()=" + getMyLong() + ", getMyChar()="
				+ getMyChar() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + "]";
	}


	/**
	 * @return the value of myInt
	 */
	public int getMyInt() {
		return myInt;
	}

	/**
	 * @param myInt int 
	 */
	public void setMyInt(int myInt) {
		this.myInt = myInt;
	}

	/**
	 * @return String
	 */
	public String getMyString() {
		return myString;
	}

	/**
	 * @param myString String 
	 */
	public void setMyString(String myString) {
		this.myString = myString;
	}

	/**
	 * @return double
	 */
	public double getMyDouble() {
		return myDouble;
	}

	/**
	 * @param myDouble double 
	 */
	public void setMyDouble(double myDouble) {
		this.myDouble = myDouble;
	}

	/**
	 * @return long
	 */
	public long getMyLong() {
		return myLong;
	}

	/**
	 * @param myLong long
	 */
	public void setMyLong(long myLong) {
		this.myLong = myLong;
	}

	/**
	 * @return char
	 */
	
	public char getMyChar() {
		return myChar;
	}

	/**
	 * @param myChar char
	 */
	public void setMyChar(char myChar) {
		this.myChar = myChar;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + myChar;
		long temp;
		temp = Double.doubleToLongBits(myDouble);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + myInt;
		result = prime * result + (int) (myLong ^ (myLong >>> 32));
		result = prime * result
				+ ((myString == null) ? 0 : myString.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof MyAllTypesFirst)) {
			return false;
		}
		MyAllTypesFirst other = (MyAllTypesFirst) obj;
		if (myChar != other.myChar) {
			return false;
		}
		if (Double.doubleToLongBits(myDouble) != Double
				.doubleToLongBits(other.myDouble)) {
			return false;
		}
		if (myInt != other.myInt) {
			return false;
		}
		if (myLong != other.myLong) {
			return false;
		}
		if (myString == null) {
			if (other.myString != null) {
				return false;
			}
		} else if (!myString.equals(other.myString)) {
			return false;
		}
		return true;
	}
}
