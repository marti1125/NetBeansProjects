
import java.io.IOException;
import java.util.*;
import org.ksoap.*;
import org.ksoap.transport.*;


/**
 * This class is a stub which allows to call ideone api methods.
 * It uses kSoap.
 */
public class IdeoneStub {

    private String url = "http://ideone.com/api/1/service";


    /**
     * Creates a new submission.
     * 
     * @param sourceCode    source code
     * @param language	language identifier
     * @param input	intput
     * @param run	set to true to execute the program
     * @param priv	set to false not to list the submission in the 'recent pastes' page on ideone.com
     * @return		identifier of the submission
     */
    public String createSubmission(String sourceCode, Integer language, String input, Boolean run, Boolean priv) {

	String ret = null;
	Hashtable data = new Hashtable();
	
	try {
	    HttpTransport transport = new HttpTransport(url, "createSubmission");
	    transport.debug = true;
	    SoapObject request = new SoapObject(url, "createSubmission");
	    request.addProperty("user", "test");
	    request.addProperty("pass", "test");
	    request.addProperty("sourceCode", sourceCode);
	    request.addProperty("language", language);
	    request.addProperty("input", input);
	    request.addProperty("run", run);
	    request.addProperty("private", priv);
	    SoapObject so = (SoapObject) transport.call(request);

	    int count = so.getPropertyCount();
	    for(int i = 0; i < count; ++i) {
		SoapObject so2 = (SoapObject)so.getProperty(i);
		String key = (String) so2.getProperty(0);
		Object val = so2.getProperty(1);
		data.put(key, val);
	    }

	    String error = (String) data.get("error");
	    if(!error.equals("OK")) {
		System.out.println("Error occurred: " + error);
		return null;
	    }

	    ret = (String)data.get("link");

	} catch (IOException ex) {
	    System.out.println("IO Error");
	} catch (Exception ex) {
	    System.out.println("Error");
	    System.out.println(ex.getClass() + " " + ex.getMessage());
	}

	return ret;
    }


    /**
     * Returns status and result of the submission.
     *
     * @param link  identifier of the submission
     * @return	inormation about status and result of the submission
     */
    public IdeoneSubmissionStatus getSubmissionStatus(String link) {

	IdeoneSubmissionStatus ret = null;
	Hashtable data = new Hashtable();
	
	try {
	    HttpTransport transport = new HttpTransport(url, "getSubmissionStatus");
	    transport.debug = true;
	    SoapObject request = new SoapObject(url, "getSubmissionStatus");
	    request.addProperty("user", "test");
	    request.addProperty("pass", "test");
	    request.addProperty("link", link);
	    SoapObject so = (SoapObject) transport.call(request);

	    int count = so.getPropertyCount();
	    for(int i = 0; i < count; ++i) {
		SoapObject so2 = (SoapObject) so.getProperty(i);
		String key = (String) so2.getProperty(0);
		Object val = so2.getProperty(1);
		data.put(key, val);
	    }

	    String error = (String) data.get("error");
	    if(!error.equals("OK")) {
		System.out.println("Error occurred: " + error);
		return null;
	    }
	    
	    ret = new IdeoneSubmissionStatus();
	    ret.result = (Integer)data.get("result");
	    ret.status = (Integer)data.get("status");

	} catch (IOException ex) {
	    System.out.println("IO Error");
	} catch (NumberFormatException ex) {
	    System.out.println("Number Format Error");
	} catch (Exception ex) {
	    System.out.println("Error");
	}

	return ret;
    }


    /**
     * Returns information about the submission.
     *
     * @param link	    identifier of the submission
     * @param withSource    set to true if the source code should be returned
     * @param withInput	    set to true if the input should be returned
     * @param withOutput    set to true if the output produced by the program should be returned
     * @param withStderr    set to true if the std error should be returned
     * @param withCmpinfo   set to true if the compilation info should be returned
     * @return	final information about the submission
     */
    public IdeoneSubmissionDetails getSubmissionDetails(String link, Boolean withSource, Boolean withInput,
	    Boolean withOutput, Boolean withStderr, Boolean withCmpinfo) {

	IdeoneSubmissionDetails ret = null;
	Hashtable data = new Hashtable();

	try {
	    HttpTransport transport = new HttpTransport(url, "getSubmissionDetails");
	    transport.debug = true;
	    SoapObject request = new SoapObject(url, "getSubmissionDetails");
	    request.addProperty("user", "test");
	    request.addProperty("pass", "test");
	    request.addProperty("link", link);
	    request.addProperty("withSource", withSource);
	    request.addProperty("withInput", withInput);
	    request.addProperty("withOutput", withOutput);
	    request.addProperty("withStderr", withStderr);
	    request.addProperty("withCmpinfo", withCmpinfo);
	    SoapObject so = (SoapObject) transport.call(request);


	    int count = so.getPropertyCount();
	    for(int i = 0; i < count; ++i) {
		SoapObject so2 = (SoapObject) so.getProperty(i);
		String key = (String) so2.getProperty(0);
		Object val = so2.getProperty(1);
		data.put(key, val);
	    }

	    String error = (String) data.get("error");
	    if(!error.equals("OK")) {
		System.out.println("Error occurred: " + error);
		return null;
	    }
	    
	    ret = new IdeoneSubmissionDetails();

	    ret.langId = (Integer) data.get("result");
	    ret.langName = (String) data.get("langName");
	    ret.langVersion = (String) data.get("langVersion");
	    ret.date = (String) data.get("date");
	    //ret.time = (Float) data.get("time");  // no support for Float on ME kSoap
	    ret.time = Float.valueOf( ((SoapPrimitive) data.get("time")).toString() );
	    ret.result = (Integer) data.get("result");
	    ret.status = (Integer) data.get("status");
	    ret.memory = (Integer) data.get("memory");
	    ret.signal = (Integer) data.get("signal");
	    ret.isPublic = (Boolean) data.get("public");
	    if(withSource.booleanValue()) {
		ret.source = (String) data.get("source");
	    }
	    if(withInput.booleanValue()) {
		ret.input = (String) data.get("input");
	    }
	    if(withOutput.booleanValue()) {
		ret.output = (String) data.get("output");
	    }
	    if(withStderr.booleanValue()) {
		ret.stderr = (String) data.get("stderr");
	    }
	    if(withCmpinfo.booleanValue()) {
		ret.cmpinfo = (String) data.get("cmpinfo");
	    }
	    
	} catch (IOException ex) {
	    System.out.println("IO Error");
	} catch (NumberFormatException ex) {
	    System.out.println("Number Format Error");
	} catch (Exception ex) {
	    System.out.println("Error");
	}

	return ret;
    }


    /**
     * Returns list of supported languages.
     *
     * @return	a map of pairs "language id" => "language name and version"
     */
    public Hashtable getLanguages() {

	Hashtable ret = new Hashtable();
	Hashtable data = new Hashtable();

	try {
	    HttpTransport transport = new HttpTransport(url, "getLanguages");
	    transport.debug = true;
	    SoapObject request = new SoapObject(url, "getLanguages");
	    request.addProperty("user", "test");
	    request.addProperty("pass", "test");
	    SoapObject so = (SoapObject) transport.call(request);

	    int count = so.getPropertyCount();
	    for(int i = 0; i < count; ++i) {
		SoapObject so2 = (SoapObject) so.getProperty(i);
		String key = (String) so2.getProperty(0);
		Object val = so2.getProperty(1);
		data.put(key, val);
	    }

	    String error = (String) data.get("error");
	    if(!error.equals("OK")) {
		System.out.println("Error occurred: " + error);
		return null;
	    }

	    so = (SoapObject)data.get("languages");
	    count = so.getPropertyCount();
	    for(int i = 0; i < count; ++i) {
		SoapObject so2 = (SoapObject) so.getProperty(i);
		Integer key = (Integer) so2.getProperty(0);
		String val = (String) so2.getProperty(1);
		ret.put(key, val);
	    }

	} catch (IOException ex) {
	    System.out.println("IO Error" + "\n" + ex.getMessage());
	} catch (NumberFormatException ex) {
	    System.out.println("Number Format Error");
	} catch (Exception ex) {
	    System.out.println("Error");
	}

	return ret;
    }
}
