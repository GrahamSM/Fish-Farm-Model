public class Month {
	private String month;
	private double temperature;
	private int numDays;
	public Month(double temp, String name){
			temperature = temp;
			month = name; 
		if ((month.equals("January") || month.equals("March") || month.equals("May") || month.equals("July") || month.equals("August") || month.equals("October") || 
				month.equals("December"))){
			numDays = 31;
		}
		else if ((month.equals("April") || month.equals("June") || month.equals("September") || month.equals("November"))){
			numDays = 30;
		}
		else if (month.equals("February")){
			numDays = 28;
		}
	}
	public int getDays(){
		return numDays;
	}
	public double getTemp(){
		return temperature;
	}	
	public String getMonth(){
		return month;
	}
}