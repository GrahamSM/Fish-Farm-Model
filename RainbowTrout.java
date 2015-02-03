public class RainbowTrout extends fish {
	private double TGC = 0.191;
	public RainbowTrout(double iWeight){
		super(iWeight);
		// TODO Auto-generated constructor stub
	}
	public RainbowTrout(double iWeight, double cWeight, double pWeight){
		super(iWeight, cWeight, pWeight);
	}
	public RainbowTrout clone(){
		return new RainbowTrout(startWeight, currentWeight, previousWeight);
	}
	public void getIntervalWeight(Month month){
		previousWeight = currentWeight;
		currentWeight = Math.pow(Math.cbrt(previousWeight) + (month.getDays() * month.getTemp() * TGC / 100), 3);
	}
	public double getRetainedEnergy(){
		double retainedEnergy = (5.0+0.005*currentWeight)*(currentWeight - previousWeight);
		return retainedEnergy;
	}
}