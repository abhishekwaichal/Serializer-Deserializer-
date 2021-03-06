package genericXMLProcessor.util;

import genericXMLProcessor.driver.Debug;
import genericXMLProcessor.server.SerDeserXML;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author Abhishek Waichal
 * Class ProxyCreator, used to create a new Proxy instance.
 */
public class ProxyCreator
{
	/**
	 * 
	 */
	public ProxyCreator(){
		Debug.printDebug(1, "In Class ProxyCreator's Constructor");		
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProxyCreator [getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

	/**
	 * @param interfaceArray Class<?>[] 
	 * @param handler InvocationHandler 
	 * @return SerDeserXML
	 */
	public SerDeserXML createProxy(Class<?>[] interfaceArray, InvocationHandler handler){
		SerDeserXML serDeserObj =
            (SerDeserXML)
            Proxy.newProxyInstance(
                                   getClass().getClassLoader(),
                                   interfaceArray,
                                   handler
                                   );
		return serDeserObj;
	}
}
