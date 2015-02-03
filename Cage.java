public class Cage {
	private int startFish;
	private Month currentMonth;
	private Month[] profile;
	private int currentFish;
	public Cage(int startNumFish, Month[] myProfile){
		startFish = startNumFish;
		currentFish = startNumFish;
		profile = myProfile;
	}
	public Cage(int startNumFish, int currentNumFish, Month[] myProfile, Month month){
		startFish = startNumFish;
		currentFish = currentNumFish;
		profile = myProfile;
		currentMonth = month;
	}
	public Month[] getProfile(){
		return profile;
	}
	public int getNumFish(){
		return currentFish;
	}
	public void setMonth(Month month){
		currentMonth = month;
	}
	public void mortalityUpdate(){
		int num = currentFish;
		for (int i=0;i<currentMonth.getDays(); i++){
			num = (int) (num * (1-0.00022));
		}
		currentFish = num;
	}
	public Cage clone(){
		return new Cage(startFish, currentFish, profile, currentMonth);
	}
}
