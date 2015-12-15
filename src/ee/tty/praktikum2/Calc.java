package ee.tty.praktikum2;

//represents reusable domain service which calculates daily salaries
public class Calc {
    //employee types
    public static final int JUNIOR = 1;
    public static final int SENIOR = 2;
    public static final int SPECIALIST = 3;
    
	private int moneyPerHour;
	private int normalHours;
	private int extraHoursMultiplier;
	private int heroBonus;
	private int extremeHours = 20;
	
	private void setEmploeeValues(int type){
    	if (type == JUNIOR) {
    		moneyPerHour = 10;
    		normalHours = 8;
    		extraHoursMultiplier = 2;
    		heroBonus = 10;
    	}
    	if (type == SENIOR) {
    		moneyPerHour = 15;
    		normalHours = 8;
    		extraHoursMultiplier = 2;
    		heroBonus = 20;
    	}
    	if (type == SPECIALIST) {
    		moneyPerHour = 22;
    		normalHours = 9;
    		extraHoursMultiplier = 3;
    		heroBonus = 30;
    	}
	}

	
    protected int pay(final int type,final int hours) {
    	setEmploeeValues(type);
    	int Sum = 0;

    	Sum += calulateNormalHoursPay(hours);
		Sum += calculateExtraHoursPay(hours);
        Sum += calculateHeroBonus(hours);

        return Sum;
    }
    
	private int calulateNormalHoursPay(int hours){
		return Math.min(hours, normalHours) * moneyPerHour;
	}

	private int calculateExtraHoursPay(int hours){
    	if (hours > normalHours){
    		return (hours - normalHours) * moneyPerHour * extraHoursMultiplier;
    	}
    	return 0;
	}
	
	private int calculateHeroBonus(int hours){
        if (hours > extremeHours) {
            return heroBonus;
        }
        return 0;
    }
}