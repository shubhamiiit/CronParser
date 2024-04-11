package assignment.CronFieldParser;

public class MonthField extends SimpleCronField {
    private static final Integer minValue = 1;
    private static final Integer maxValue = 12;

    public MonthField(String inputString) {
        super(inputString, minValue, maxValue);
    }
}
