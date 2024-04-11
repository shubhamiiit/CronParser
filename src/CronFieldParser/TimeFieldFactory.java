package CronFieldParser;

public class TimeFieldFactory {
    public static TimeField createTimeField( String inputString, CronFieldType fieldType) {
        return switch (fieldType) {
            case CronFieldType.MINUTES -> new MinutesField(inputString);
            case CronFieldType.HOURS -> new HoursField(inputString);
            case CronFieldType.DAY_OF_MONTH -> new DayOfMonthField(inputString);
            case CronFieldType.MONTH -> new MonthField(inputString);
            case CronFieldType.DAY_OF_WEEK -> new DayOfWeekField(inputString);
            default -> throw new IllegalArgumentException("Invalid field type");
        };
    }
}