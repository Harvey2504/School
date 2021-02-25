package DemoSchool.exception;

public class SchoolCustomException extends Exception {

	public SchoolCustomException() {
		super();
	}

	public SchoolCustomException(Throwable arg0) {
		super(arg0);
	}

	public SchoolCustomException(String arg0) {
		super(arg0);
	}

	public SchoolCustomException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
