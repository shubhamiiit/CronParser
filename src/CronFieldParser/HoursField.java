package CronFieldParser;

public class HoursField extends SimpleCronField {
    private static final Integer minValue = 0;
    private static final Integer maxValue = 23;

    public HoursField(String inputString) {
        super(inputString, minValue, maxValue);
    }
}
