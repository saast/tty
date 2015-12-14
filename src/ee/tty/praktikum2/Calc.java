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



    protected int pay(final int type,final int h) {
        int moneyPerHour = MONEY_PER_HOUR.get(type);
        int normalHours = NORMAL_HOURS.get(type);
        int extraHoursMultiplier = EXTRA_HOURS_MULTIPLIER.get(type);
        int heroBonus = HERO_BONUS.get(type);
    	int extremeHours = EXTREME_HOURS;
    	
    	return calculatePay(h, moneyPerHour, normalHours, extraHoursMultiplier, heroBonus, extremeHours);
    }
    

    private int calculatePay(int h, int moneyPerHour, int normalHours, int extraHoursMultiplier, int heroBonus, int extremeHours){
    	int Sum = 0;
    	
        if (h > normalHours) {
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