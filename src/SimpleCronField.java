import java.util.*;

public class SimpleCronField implements CronField {
    private final String inputString;
    private final CronFieldType type;
    private final List<Integer> cronFieldValues = new ArrayList<>();

    public SimpleCronField(String inputString, CronFieldType type) {
        this.inputString = inputString;
        this.type = type;

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
        var endValue = type.max;
        var intervalValue = parseValue(intervals[1]);
        populateValues(startValue, endValue, intervalValue);
    }

    private void parseAsteriskInterval() {
        String[] intervals = inputString.split("/");
        int interval = intervals.length == 2 ? parseValue(intervals[1]) : 1;
        populateValues(type.min, type.max, interval);
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
        if (interval == 0 || end < start || start < type.min || end > type.max) {
            throw new IllegalArgumentException("Invalid Cron Expression");
        }
        for (int i = start; i <= end; i += interval) {
            cronFieldValues.add(i);
        }
    }

    Integer parseValue(String value){
        return Integer.parseInt(value);
    }
    
    @Override
    public List<Integer> getFieldValues() {
        return cronFieldValues;
    }
}
