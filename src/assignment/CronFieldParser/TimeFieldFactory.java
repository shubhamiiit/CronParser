package assignment.CronFieldParser;

public class TimeFieldFactory {
    public static TimeField createTimeField( String inputString, CronFieldType fieldType) {
        switch (fieldType) {
            case MINUTES:
                return new MinutesField(inputString);
            case HOURS:
                return new HoursField(inputString);
            case DAY_OF_MONTH:
                return new DayOfMonthField(inputString);
            case MONTH:
                return new MonthField(inputString);
            case DAY_OF_WEEK:
                return new DayOfWeekField(inputString);
            default:
                throw new IllegalArgumentException("Invalid field type");
        }
    }
}