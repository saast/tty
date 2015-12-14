package ee.tty.praktikum2;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

//represents reusable domain service which calculates daily salaries
public class Calc {
    //employee types
    public static final int JUNIOR = 1;
    public static final int SENIOR = 2;
    public static final int SPECIALIST = 3;
    
    static final Map<Integer, Integer> MONEY_PER_HOUR;
    static {
    	Map<Integer, Integer> tmp = new LinkedHashMap<Integer, Integer>();
    	tmp.put(JUNIOR, 10);
    	tmp.put(SENIOR, 15);
    	tmp.put(SPECIALIST, 22);
    	MONEY_PER_HOUR = Collections.unmodifiableMap(tmp);
    }

    static final Map<Integer, Integer> NORMAL_HOURS;
    static {
    	Map<Integer, Integer> tmp = new LinkedHashMap<Integer, Integer>();
    	tmp.put(JUNIOR, 8);
    	tmp.put(SENIOR, 8);
    	tmp.put(SPECIALIST, 9);
    	NORMAL_HOURS = Collections.unmodifiableMap(tmp);
    }

    static final Map<Integer, Integer> EXTRA_HOURS_MULTIPLIER;
    static {
    	Map<Integer, Integer> tmp = new LinkedHashMap<Integer, Integer>();
    	tmp.put(JUNIOR, 2);
    	tmp.put(SENIOR, 2);
    	tmp.put(SPECIALIST, 3);
    	EXTRA_HOURS_MULTIPLIER = Collections.unmodifiableMap(tmp);
    }

    static final Map<Integer, Integer> HERO_BONUS;
    static {
    	Map<Integer, Integer> tmp = new LinkedHashMap<Integer, Integer>();
    	tmp.put(JUNIOR, 10);
    	tmp.put(SENIOR, 20);
    	tmp.put(SPECIALIST, 30);
    	HERO_BONUS = Collections.unmodifiableMap(tmp);
    }
    
    public static final int EXTREME_HOURS = 20;



    protected int pay(final int type,final int hours) {
        int moneyPerHour = MONEY_PER_HOUR.get(type);
        int normalHours = NORMAL_HOURS.get(type);
        int extraHoursMultiplier = EXTRA_HOURS_MULTIPLIER.get(type);
        int heroBonus = HERO_BONUS.get(type);
    	int extremeHours = EXTREME_HOURS;
    	
    	return calculatePay(hours, moneyPerHour, normalHours, extraHoursMultiplier, heroBonus, extremeHours);
    }
    
	private int calulateNormalHoursPay(int hours, int normalHours, int moneyPerHour){
		return Math.min(hours, normalHours) * moneyPerHour;
	}

	private int calculateExtraHoursPay(int hours, int normalHours, int moneyPerHour, int extraHoursMultiplier){
    	if (hours > normalHours){
    		return (hours - normalHours) * moneyPerHour * extraHoursMultiplier;
    	}
    	return 0;
	}
	
	private int calculateHeroBonus(int hours, int extremeHours, int heroBonus){
        if (hours > extremeHours) {
            return heroBonus;
        }
        return 0;
    }
	
    private int calculatePay(int hours, int moneyPerHour, int normalHours, int extraHoursMultiplier, int heroBonus, int extremeHours){
    	int Sum = 0;

    	Sum += calulateNormalHoursPay(hours, normalHours, moneyPerHour);
		Sum += calculateExtraHoursPay(hours, normalHours, moneyPerHour, extraHoursMultiplier);
        Sum += calculateHeroBonus(hours, extremeHours, heroBonus);

        return Sum;
    }
}