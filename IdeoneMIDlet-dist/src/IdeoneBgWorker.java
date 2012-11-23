
import java.util.Hashtable;



public class IdeoneBgWorker extends Thread {

    private IdeoneMIDlet parent;
    private IdeoneStub stub = new IdeoneStub();
    private String action = "";
    private boolean running = true;

    private String link;
    private String source;
    private Integer language;
    private String input;
 

    public IdeoneBgWorker(IdeoneMIDlet parent) {
	this.parent = parent;
    }

    public synchronized void run() {
	while (running) {
	    try {
		wait();
	    } catch (InterruptedException ie) {
	    }
	    
	    try {
		if(running && action.equals("createSubmission")) {
		    String newLink = stub.createSubmission(source, language, input, Boolean.TRUE, Boolean.FALSE);
		    String goOn = parent.createSubmissionNotify(newLink);
		    link = newLink;
		    if("OK".equals(goOn)) {
			action = "getSubmissionStatus";
		    }
		    else {
			action = "";
		    }
		}

		if(running && action.equals("getSubmissionStatus")) {
		    do {
			IdeoneSubmissionStatus iss = stub.getSubmissionStatus(link);
			String goOn = parent.getSubmissionStatusNotify(iss);
			if("OK".equals(goOn)) {
			    action = "getSubmissionDetails";
			}
			else if("repeat".equals(goOn)) {
			    action = "repeatGetSubmissionStatus";
			    Thread.sleep(2000);
			}
			else {
			    action = "";
			}
		    } while (running && "repeatGetSubmissionStatus".equals(action));
		}

		if(running && action.equals("getSubmissionDetails")) {
		    IdeoneSubmissionDetails isd = stub.getSubmissionDetails(link, Boolean.FALSE, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE);
		    parent.getSubmissionDetailsNotify(isd);
		    action = "";
		}

		if(running && action.equals("getLanguages")) {
		    Hashtable languages = stub.getLanguages();
		    parent.getLanguagesNotify(languages);
		    action = "";
		}
	    }
	    catch (Exception ex) {
		System.out.println(ex.getMessage());
		parent.errorNotify();
	    }
	}
    }

    public synchronized void runCode(String source, Integer language, String input) {
	action = "createSubmission";
	this.source = source;
	this.language = language;
	this.input = input;
	notify();
    }

    public synchronized void getLanguages() {
	action = "getLanguages";
	notify();
    }

    public synchronized void quit() {
	running = false;
	notify();
    }

}
