
/**
 * Provides functions that translate status and result from integer to text.
 */
public class IdeoneTranslator {

    public static String translateStatus(int status) {

	if(status < 0) {
	    return "waiting for compilation";
	}
	else if(status == 0) {
	    return "done";
	}
	else if(status == 1) {
	    return "compilation";
	}
	else if(status == 3) {
	    return "running";
	}

	return "unknown status";
    }


    public static String translateResult(int result) {

	switch(result) {
	    case 0: return "not running";
	    case 11: return "compilation error";
	    case 12: return "runtime error";
	    case 13: return "time limit exceeded";
	    case 15: return "success";
	    case 17: return "memory limit exceeded";
	    case 19: return "illegal system call";
	    case 20: return "internal error";
	}

	return "unknown result";
    }
}
