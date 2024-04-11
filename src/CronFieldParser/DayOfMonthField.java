package CronFieldParser;

public class DayOfMonthField extends SimpleCronField {
    private static final Integer minValue = 0;
    private static final Integer maxValue = 23;

    public DayOfMonthField(String inputString) {
        super(inputString, minValue, maxValue);
    }
}
