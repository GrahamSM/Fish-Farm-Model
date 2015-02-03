public class FeedModelException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5894849113372988379L;
	public FeedModelException(){
		super("Illegal parameter value supplied");
	}
	public FeedModelException(String message){
		super(message);
	}

}