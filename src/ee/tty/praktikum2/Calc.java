package ee.tty.praktikum2;

//represents reusable domain service which calculates daily salaries
public class Calc {
    //employee types
    public static final int JUNIOR = 1;
    public static final int SENIOR = 2;
    public static final int SPECIALIST = 3;

    protected int pay(final int type,final int h) {
        int moneyPerHour = 0;
        int normalHours = 0;
        int extraHoursMultiplier = 0;
        int heroBonus = 0;
        
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
    	int extremeHours = 20;
    	
    	int Sum = 0;
        if (h > normalHours) { // if longer than nine hours
            Sum = moneyPerHour * (h - normalHours) * extraHoursMultiplier;
            Sum += moneyPerHour * normalHours;
        } else {
            Sum += moneyPerHour * h;
        }
        if (h > extremeHours) {
            Sum += heroBonus;
        }
        return Sum;
    }
}