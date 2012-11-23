/*
 * ideone.com
 * This program shows how to use ideone api.
 */


import java.util.*;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;


public class IdeoneMIDlet extends MIDlet implements CommandListener {

    private Display disp;
    private IdeoneBgWorker worker;
    private Form form;
    private Command cmdExit;
    private StringItem strMainMessage;
    private Form formExecuting;
    private TextBox textSource;
    private TextBox textInput;
    private TextBox textOutput;
    private TextBox textStderr;
    private TextBox textCmpinfo;
    private Command cmdOK;
    private Command cmdSource;
    private Command cmdInput;
    private Command cmdOutput;
    private Command cmdStderr;
    private Command cmdCmpinfo;
    private Command cmdChooseLang;
    private StringItem strLanguage;
    private StringItem strLink;
    private StringItem strDate;
    private StringItem strResult;
    private StringItem strTime;
    private StringItem strMemory;
    private StringItem strOutput;
    private StringItem strStderr;
    private StringItem strCmpinfo;
    private Command cmdRun;
    private StringItem strStatus;
    private String link;
    private Hashtable languages;
    private Hashtable listIndexes2LangsIds;
    private Form formLanguages;
    private Command cmdLangYes;
    private Command cmdLangNo;
    private StringItem strLangMsg;
    private Form formMsg;
    private StringItem strMsg;
    private List listLanguages;
    private Command cmdChooseLangCancel;
    private Command cmdChooseLangChoose;
    private Integer chosenLangId;
    
    private static final String TITLE = "Ideone Mobile Environment";
    private static final String TITLE_WAIT = "Running your submission...";
    private static final String TITLE_LANGS = "Retrieving list of languages...";
    private static final String TITLE_CHOOSE_LANG = "Choose language";
    private static final int MAX_TEXT_SIZE = 64 * 1024;

    public IdeoneMIDlet() {

	// ==== main form ====
	form = new Form(TITLE);

	cmdExit = new Command("Exit", Command.EXIT, 0);
	form.addCommand(cmdExit);

	strMainMessage = new StringItem("Welome to Ideone Mobile Environment!",
		"Choose programming language, provide source code and input data and then watch your program being executed!");
	form.append(strMainMessage);

	cmdOK = new Command("OK", Command.OK, 1);
	textSource = new TextBox("Source code", "", MAX_TEXT_SIZE, TextField.ANY);
	textSource.addCommand(cmdOK);
	textInput = new TextBox("Input data", "", MAX_TEXT_SIZE, TextField.ANY);
	textInput.addCommand(cmdOK);
	textOutput = new TextBox("Output", "", MAX_TEXT_SIZE, TextField.ANY);
	textOutput.addCommand(cmdOK);
	textStderr = new TextBox("Standard error", "", MAX_TEXT_SIZE, TextField.ANY);
	textStderr.addCommand(cmdOK);
	textCmpinfo = new TextBox("Compilation info", "", MAX_TEXT_SIZE, TextField.ANY);
	textCmpinfo.addCommand(cmdOK);

	cmdChooseLang = new Command("Choose language", Command.ITEM, 1);
	form.addCommand(cmdChooseLang);
	cmdSource = new Command("Edit source code", Command.ITEM, 1);
	form.addCommand(cmdSource);
	cmdInput = new Command("Edit input data", Command.ITEM, 1);
	form.addCommand(cmdInput);
	cmdOutput = new Command("View output", Command.ITEM, 1);
	form.addCommand(cmdOutput);
	cmdStderr = new Command("View stderr", Command.ITEM, 1);
	form.addCommand(cmdStderr);
	cmdCmpinfo = new Command("View cmpinfo", Command.ITEM, 1);
	form.addCommand(cmdCmpinfo);

	strLanguage = new StringItem("Language:", "");
	form.append(strLanguage);
	strLink = new StringItem("Link:", "");
	form.append(strLink);
	strDate = new StringItem("Server time:", "");
	form.append(strDate);
	strResult = new StringItem("Result:", "");
	form.append(strResult);
	strTime = new StringItem("Execution time:", "");
	form.append(strTime);
	strMemory = new StringItem("Memory usage:", "");
	form.append(strMemory);
	strOutput = new StringItem("Ouput:", "");
	form.append(strOutput);
	strStderr= new StringItem("Stderr:", "");
	form.append(strStderr);
	strCmpinfo = new StringItem("Cmpinfo:", "");
	form.append(strCmpinfo);

	cmdRun = new Command("Run", Command.ITEM, 1);
	form.addCommand(cmdRun);

	// ==== execution form ====
	formExecuting = new Form(TITLE_WAIT);

	strStatus = new StringItem("Status:", "");
	formExecuting.append(strStatus);

	// ==== languages form ====
	formLanguages = new Form(TITLE_LANGS);

	strLangMsg = new StringItem("Retrieving list of languages", "\nWould you like to retrieve a list of supported languages from ideone server?\n\n");
	formLanguages.append(strLangMsg);

	cmdLangNo = new Command("No", Command.CANCEL, 1);
	formLanguages.addCommand(cmdLangNo);
	cmdLangYes = new Command("Yes", Command.OK, 1);
	formLanguages.addCommand(cmdLangYes);

	// ==== msg form ====
	formMsg = new Form("");

	strMsg = new StringItem("", "");
	formMsg.append(strMsg);

	formMsg.addCommand(cmdOK);

	// ==== languages list ====
	listLanguages = new List(TITLE_CHOOSE_LANG, List.EXCLUSIVE);

	cmdChooseLangCancel = new Command("Cancel", Command.CANCEL, 1);
	listLanguages.addCommand(cmdChooseLangCancel);
	cmdChooseLangChoose = new Command("OK", Command.OK, 1);
	listLanguages.addCommand(cmdChooseLangChoose);

	// add some default languages to the list
	listLanguages.append("C", null);
	listLanguages.append("C++", null);
	listLanguages.append("C#", null);
	listLanguages.append("Java", null);
	listLanguages.append("PHP", null);
	listLanguages.append("Python", null);
	listLanguages.append("Visual Basic .NET", null);

	listIndexes2LangsIds = new Hashtable();
	listIndexes2LangsIds.put(new Integer(0), new Integer(11));
	listIndexes2LangsIds.put(new Integer(1), new Integer(1));
	listIndexes2LangsIds.put(new Integer(2), new Integer(27));
	listIndexes2LangsIds.put(new Integer(3), new Integer(10));
	listIndexes2LangsIds.put(new Integer(4), new Integer(29));
	listIndexes2LangsIds.put(new Integer(5), new Integer(4));
	listIndexes2LangsIds.put(new Integer(6), new Integer(101));

	languages = new Hashtable();
	languages.put(new Integer(11), "C");
	languages.put(new Integer(1), "C++");
	languages.put(new Integer(27), "C#");
	languages.put(new Integer(10), "Java");
	languages.put(new Integer(29), "PHP");
	languages.put(new Integer(4), "Python");
	languages.put(new Integer(101), "Visual Basic .NET");

	selectDefaultLanguage(1);


	// ==== listeners ====
	form.setCommandListener(this);
	formExecuting.setCommandListener(this);
	formLanguages.setCommandListener(this);
	formMsg.setCommandListener(this);
	listLanguages.setCommandListener(this);
	textSource.setCommandListener(this);
	textInput.setCommandListener(this);
	textOutput.setCommandListener(this);
	textStderr.setCommandListener(this);
	textCmpinfo.setCommandListener(this);
    }
    
    public void startApp() {
	worker = new IdeoneBgWorker(this);
	worker.start();

	disp = Display.getDisplay(this);
	disp.setCurrent(formLanguages);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command c, Displayable d) {

	if(c == cmdOK) {
	    disp.setCurrent(form);
	    return;
	}
	else if(c == cmdChooseLang) {
	    disp.setCurrent(listLanguages);
	    return;
	}
	else if(c == cmdCmpinfo) {
	    disp.setCurrent(textCmpinfo);
	    return;
	}
	else if(c == cmdInput) {
	    disp.setCurrent(textInput);
	    return;
	}
	else if(c == cmdOutput) {
	    disp.setCurrent(textOutput);
	    return;
	}
	else if(c == cmdSource) {
	    disp.setCurrent(textSource);
	    return;
	}
	else if(c == cmdStderr) {
	    disp.setCurrent(textStderr);
	    return;
	}
	else if(c == cmdRun) {
	    strStatus.setText("wait");
	    disp.setCurrent(formExecuting);
	    // create submission and run program
	    worker.runCode(textSource.getString(), chosenLangId, textInput.getString());
	    return;
	}
	else if(c == cmdLangNo) {
	    disp.setCurrent(form);
	    return;
	}
	else if(c == cmdLangYes){
	    strStatus.setText("retrieving...");
	    disp.setCurrent(formExecuting);
	    worker.getLanguages();
	    return;
	}
	else if(c == cmdChooseLangCancel) {
	    disp.setCurrent(form);
	    return;
	}
	else if(c == cmdChooseLangChoose) {
	    chosenLangId = (Integer)listIndexes2LangsIds.get(new Integer(listLanguages.getSelectedIndex()));
	    strLanguage.setText((String)languages.get(chosenLangId));
	    disp.setCurrent(form);
	    return;
	}

	worker.quit();
	this.notifyDestroyed();
    }

    public String createSubmissionNotify(String link) {
	this.link = link;
	strLink.setText("http://ideone.com/" + link);
	if(link == null) {
	    displayErrorInfo();
	    return "error";
	}
	strStatus.setText("submission created");
	return "OK";
    }

    public String getSubmissionStatusNotify(IdeoneSubmissionStatus iss) {
	if(iss == null) {
	    displayErrorInfo();
	    return "error";
	}

	int status = iss.status.intValue();
	strStatus.setText( IdeoneTranslator.translateStatus(status) );
	if(status == 0) {
	    // ideone has finished handling the program; it's time to get the details about the execution
	    return "OK";
	}
	else {
	    // the program is still running, so we need to get status and result of the submission again
	    return "repeat";
	}
    }

    public void getSubmissionDetailsNotify(IdeoneSubmissionDetails isd) {
	if(isd != null) {
	    strResult.setText( IdeoneTranslator.translateResult( isd.result.intValue() ) );
	    strTime.setText( isd.time.toString() + "s");
	    strMemory.setText( isd.memory.toString() + "KB");
	    strOutput.setText( "".equals(isd.output) ? "No" : "Yes" );
	    strStderr.setText( "".equals(isd.stderr) ? "No" : "Yes" );
	    strCmpinfo.setText( "".equals(isd.cmpinfo) ? "No" : "Yes" );
	    strDate.setText( isd.date );
	    textOutput.setString( isd.output );
	    textStderr.setString( isd.stderr );
	    textCmpinfo.setString( isd.cmpinfo );
	    disp.setCurrent( form );
	}
	else {
	    displayErrorInfo();
	}
    }

    public void getLanguagesNotify(Hashtable languages) {
	if(languages == null || languages.size() < 7) {
	    // if the list is empty or it is smaller than the default one, it means that something went wrong
	    strMsg.setText("Failed to retrieve list of languages from server.");
	    disp.setCurrent(formMsg);
	}
	else {
	    this.languages = languages;
	    listLanguages.deleteAll();
	    listIndexes2LangsIds.clear();
	    Enumeration en = languages.keys();
	    Integer langId = null;
	    int i = 0;
	    while( en.hasMoreElements() ) {
		langId = (Integer)en.nextElement();
		String langName = (String)languages.get(langId);
		listLanguages.append(langName, null);
		listIndexes2LangsIds.put(new Integer(i), langId);
		if(langId.intValue() == 1) {
		    selectDefaultLanguage(i);
		}
		++i;
	    }
	    disp.setCurrent(form);
	}
    }

    public void selectDefaultLanguage(int index) {
	chosenLangId = new Integer(1);
	strLanguage.setText((String)languages.get(chosenLangId));
	listLanguages.setSelectedIndex(index, true);
    }

    public void errorNotify() {
	displayErrorInfo();
    }

    private void displayErrorInfo() {
	strResult.setText("error occured");
	disp.setCurrent(form);
    }
}
