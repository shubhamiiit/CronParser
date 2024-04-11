package assignment.CronFieldParser;

public class DayOfMonthField extends SimpleCronField {
    private static final Integer minValue = 1;
    private static final Integer maxValue = 31;

    public DayOfMonthField(String inputString) {
        super(inputString, minValue, maxValue);
    }
}
