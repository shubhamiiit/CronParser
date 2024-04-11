import CronFieldParser.ComplexCronField;
import CronFieldParser.CronFieldType;
import CronFieldParser.TimeField;

import java.util.ArrayList;
import java.util.List;

public class CronExpression {
    private final String commandField;
    private final List<TimeField> timeFields;
    private final static List<CronFieldType> cronFieldTypes = List.of(CronFieldType.values());

    public CronExpression(String inputString) {
        timeFields = new ArrayList<TimeField>();
        String[] fields = inputString.split("\\s+");

        if (fields.length != 6) {
            throw new IllegalArgumentException("Invalid cron expression");
        }
        for (int i = 0; i < cronFieldTypes.size(); i++) {
            timeFields.add(new ComplexCronField(fields[i], cronFieldTypes.get(i)));
        }
        commandField = fields[5];
    }

    public void print() {
        PrintCronFields printCronFields = new PrintCronFields(timeFields, commandField, cronFieldTypes);
        printCronFields.print();
    }
}
