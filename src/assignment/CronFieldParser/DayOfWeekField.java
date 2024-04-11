package assignment.CronFieldParser;

public class DayOfWeekField extends SimpleCronField {
    private static final Integer minValue = 1;
    private static final Integer maxValue = 7;

    public DayOfWeekField(String inputString) {
        super(inputString, minValue, maxValue);
    }
}
