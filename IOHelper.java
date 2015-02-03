import javax.swing.JOptionPane;
public class IOHelper {
	public IOHelper(){
		
	}
	public static String getString(String month){
		String firstMonth = JOptionPane.showInputDialog(month);
		return firstMonth;
	}
	public static int getInt(int min, String startNum, int max) throws FeedModelException{
		String num = JOptionPane.showInputDialog(startNum);
		try{
			int number = Integer.parseInt(num);
			if (number < min || number > max){
				System.out.println("Input value out of range!");
			}
			return number;
		} catch (NumberFormatException e){
			throw new FeedModelException("Invalid entry!");
		}
		}
}