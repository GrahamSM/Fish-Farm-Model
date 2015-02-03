public class IntervalData {
	private Month myMonth;
	private String myMonthString;
	private fish myFish;
	private Cage myCage;
	private double food;
	public IntervalData(String month, fish newFish, Cage newCage){
		myMonthString  = month;
		myFish = newFish.clone();
		myCage = newCage.clone();///make sure to check that the objects are correct.
		for (int i=0; i<myCage.getProfile().length;i++){
			if (myCage.getProfile()[i].getMonth().equals(myMonthString)){
				myMonth = myCage.getProfile()[i];
			}
		}
		myCage.setMonth(myMonth);
	}
	
	public IntervalData(String month, fish newFish, Cage newCage, Month mnth, double f){
		myMonthString = month;
		myFish = newFish.clone();
		myCage = newCage.clone();
		myMonth = mnth;
		food = f;
	}
	public void updateFood(){
		double digEnergy = (myFish.maintenanceEnergy(myMonth) + myFish.getRetainedEnergy())*0.2;
		double NfEnergyLoss = (myFish.maintenanceEnergy(myMonth) + myFish.getRetainedEnergy() + digEnergy)*0.1;
		double totalEnergy = myFish.maintenanceEnergy(myMonth) + myFish.getRetainedEnergy() + digEnergy + NfEnergyLoss;
		double feedWeightPerFish = totalEnergy/Food.getFEC();
		food = feedWeightPerFish * myCage.getNumFish();
		
	}
	public double getFoodAmount(){
		return food/1000;
	}
	
	public void intervalUpdate(){
		myFish.getIntervalWeight(myMonth);
		myCage.setMonth(myMonth);
		myCage.mortalityUpdate();
	}
	public Cage getCageSnapshot(){
		
		return myCage.clone();
	}
	public fish getFishSnapshot(){
		return myFish.clone();
	}

	public void monthUpdate(){
		for (int i = 0; i < myCage.getProfile().length; i++){
			if (myCage.getProfile()[i].getMonth().equals(myMonthString)){
				if (i<11){
					myMonth = myCage.getProfile()[i+1];
				} else{
					myMonth = myCage.getProfile()[0];
				}
				myMonthString = myMonth.getMonth();
			}
		}
	}
	public IntervalData clone(){
		return new IntervalData(myMonthString, myFish, myCage, myMonth, food);
	}
	public String toString(){
		///Month      deg C   #fish  g/fish  feed (kg)
		String s = String.format("%-11s%2.1f%9d%7d&8d", myMonthString, myMonth.getTemp(), myCage.getNumFish(), Math.round(getFoodAmount()));
		return s;
	}
}
