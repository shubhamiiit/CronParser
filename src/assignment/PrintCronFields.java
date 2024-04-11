package assignment;

import assignment.CronFieldParser.CronFieldType;
import assignment.CronFieldParser.TimeField;

import java.util.List;

public class PrintCronFields {

    private final List<TimeField> timeFields;
    private final String commandField;
    private final List<CronFieldType> cronFieldTypes;

    public PrintCronFields(List<TimeField> timeFields, String commandField, List<CronFieldType> cronFieldTypes) {
        this.timeFields = timeFields;
        this.commandField = commandField;
        this.cronFieldTypes = cronFieldTypes;
    }

    private static String printFieldAsString(CronFieldType fieldType) {
        return switch (fieldType) {
            case MINUTES -> "minute";
            case HOURS -> "hour";
            case DAY_OF_MONTH -> "day of month";
            case MONTH -> "month";
            case DAY_OF_WEEK -> "day of week";
            default -> throw new IllegalArgumentException("Invalid field type: " + fieldType);
        };
    }

    public void print() {
        for (int i = 0; i < timeFields.size(); i++) {
            var output = printFieldAsString(cronFieldTypes.get(i));
            printField(output, timeFields.get(i));
        }
        System.out.printf("%-14s %s", "command" , commandField);
    }

    public void printField(String field, TimeField cronField) {
        System.out.printf("%-14s ", field);
        for (int value : cronField.getFieldValues()) {
            System.out.printf(value + " ");
        }
        System.out.println();
    }
}
