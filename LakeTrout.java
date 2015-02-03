public class LakeTrout extends fish {
	private double TGC = 0.139;

	public LakeTrout(double iWeight){
		super(iWeight);
		// TODO Auto-generated constructor stub
	}
	public LakeTrout(double iWeight, double cWeight, double pWeight){
		super(iWeight, cWeight, pWeight);
	}
	
	public double getRetainedEnergy(){
		return (4.5 + 0.006 * (currentWeight)) * (currentWeight - previousWeight);
	}
	
	public double getRetainedEnergy(int startWeight, int finalWeight){
		double retainedEnergy = (4.5+0.006*(finalWeight))*(finalWeight-startWeight);
		return retainedEnergy;
	}
	public LakeTrout clone(){
		return new LakeTrout(startWeight, currentWeight, previousWeight);
	}
	
	public void getIntervalWeight(Month month){
		previousWeight = currentWeight;
		currentWeight = Math.pow(Math.cbrt(startWeight) + ((month.getDays() * month.getTemp() * TGC) / 100), 3);
	}
}