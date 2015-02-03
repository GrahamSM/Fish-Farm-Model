import java.io.BufferedReader;
import java.io.FileReader;

public class TemperatureProfile {
	private Month[] months;
	public TemperatureProfile(String filename) throws FeedModelException{
		int count = 0;
		try
		{
			BufferedReader bF = new BufferedReader(new FileReader(filename));	
			String line;
			int cnt = 0;
			while ((line = bF.readLine()) != null) {
				cnt = cnt+1;
			}
			bF.close();
			months = new Month[cnt];
			BufferedReader bR = new BufferedReader(new FileReader(filename));
			while((line = bR.readLine()) != null){
				String mName = line.split(",")[0];
				System.out.println("1");
				double mTemp = Double.parseDouble(line.split(",")[1]);
				System.out.println("2");
				months[count] = new Month(mTemp, mName);
				count+=1;
			}
			bR.close();
		} catch(Exception e){
			throw new FeedModelException("File read error!");
		}
	}
	public Month[] getTemperatureProfile(){
		return months;
	}
	
	
		
}