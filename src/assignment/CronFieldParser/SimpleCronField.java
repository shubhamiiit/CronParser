package assignment.CronFieldParser;

import java.util.*;

public class SimpleCronField implements TimeField {
    private final String inputString;
    private final Integer min;
    private final Integer max;
    private final List<Integer> cronFieldValues = new ArrayList<>();

    public SimpleCronField(String inputString, Integer min, Integer max) {
        this.inputString = inputString;
        this.min = min;
        this.max = max;
        parseInputString();
    }

    private void parseInputString() {
        if (inputString.startsWith("*")) {
            parseAsteriskInterval();
        } else if (inputString.contains("/")) {
            parseIntervalValues();
        } else if (inputString.contains("-")) {
            parseRangeOfValues();
        } else {
            parseFixedValues();
        }
        Collections.sort(cronFieldValues);
    }

    private void parseIntervalValues() {
        String[] intervals = inputString.split("/");
        var startValue = parseValue(intervals[0]);
        var intervalValue = parseValue(intervals[1]);
        populateValues(startValue, this.max, intervalValue);
    }

    private void parseAsteriskInterval() {
        String[] intervals = inputString.split("/");
        int interval = intervals.length == 2 ? parseValue(intervals[1]) : 1;
        populateValues(this.min, this.max, interval);
    }

    private void parseRangeOfValues() {
        String[] range = inputString.split("-");
        int start = parseValue(range[0]);
        int end = parseValue(range[1]);
        populateValues(start, end, 1);
    }

    private void parseFixedValues() {
        int value = parseValue(inputString);
        populateValues(value, value, 1);
    }

    private void populateValues(Integer start, Integer end, Integer interval) {
        if (interval == 0 || end < start || start < this.min || end > this.max) {
            throw new IllegalArgumentException("Invalid Cron Expression");
        }
        for (int i = start; i <= end; i += interval) {
            cronFieldValues.add(i);
        }
    }

    Integer parseValue(String value){
        try{
            return Integer.parseInt(value);
        }
        catch(NumberFormatException e) {
            System.out.println("Invalid cron string: Non-numeric value");
            System.exit(1);
        }
        return 0;
    }
    
    @Override
    public List<Integer> getFieldValues() {
        return cronFieldValues;
    }
}
