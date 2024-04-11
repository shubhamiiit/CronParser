
public class CronExpression {
    private final CronField minutesCronField;
    private final CronField hoursCronField;
    private final CronField daysOfMonthCronField;
    private final CronField monthsCronField;
    private final CronField daysOfWeekCronField;
    private final String commandField;

    public CronExpression(String inputString) {
        String[] fields = inputString.split("\\s+");

        if (fields.length != 6) {
            throw new IllegalArgumentException("Invalid cron expression");
        }

        minutesCronField = new ComplexCronField(fields[0], CronFieldType.MINUTES);
        hoursCronField = new ComplexCronField(fields[1], CronFieldType.HOURS);
        daysOfMonthCronField = new ComplexCronField(fields[2], CronFieldType.DAY_OF_MONTH);
        monthsCronField = new ComplexCronField(fields[3], CronFieldType.MONTH);
        daysOfWeekCronField = new ComplexCronField(fields[4], CronFieldType.DAY_OF_WEEK);
        commandField = fields[5];
    }

    public void print() {
        printField("minute", minutesCronField);
        printField("hour", hoursCronField);
        printField("day of month", daysOfMonthCronField);
        printField("month", monthsCronField);
        printField("day of week", daysOfWeekCronField);
        System.out.println("command " + commandField);
    }

    public void printField(String field, CronField cronField) {
        System.out.printf("%-14s ", field);
        for (int value : cronField.getFieldValues()) {
            System.out.printf(value + " ");
        }
        System.out.println();
    }
}
