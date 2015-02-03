public abstract class fish {
	protected double startWeight;
	protected double currentWeight;
	protected double previousWeight;
	
	///Next, define constructors for these, and write code for their implementation within extension classes (based on McLeods code)
	
	public fish(double iWeight){
			startWeight = iWeight;
			currentWeight = iWeight;
	}
	public fish(double iWeight, double cWeight, double pWeight){
		startWeight = iWeight;
		currentWeight = cWeight;
		previousWeight = pWeight;
	}
	
	public double maintenanceEnergy(Month month){
		return (-0.0104 + 3.26 * month.getTemp() - 0.05 * month.getTemp() * month.getTemp()) * Math.pow(currentWeight/1000, 0.824) * month.getDays();
	}
	public abstract void getIntervalWeight(Month month);
	public abstract double getRetainedEnergy();
	public abstract fish clone();
	public double getWeight(){
		return currentWeight;
	}
	public double getStartWeight(){
		return startWeight;
	}
}
