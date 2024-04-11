package assignment.CronFieldParser;

public class MinutesField extends SimpleCronField {
    private static final Integer minValue = 0;
    private static final Integer maxValue = 59;

    public MinutesField(String inputString) {
        super(inputString, minValue, maxValue);
    }
}
