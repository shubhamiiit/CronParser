package assignment.CronFieldParser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class ComplexCronField implements TimeField {
    private final String inputString;
    private final CronFieldType cronFieldType;
    private final HashSet<Integer> cronFieldValues = new HashSet<>();

    public ComplexCronField(String inputString, CronFieldType cronFieldType) {
        this.inputString = inputString;
        this.cronFieldType = cronFieldType;
        parseInputString();
    }

    private void parseInputString() {
        String[] simpleInputStrings = inputString.split(",");
        for (var simpleInputString : simpleInputStrings) {
            var simpleCronField = TimeFieldFactory.createTimeField(simpleInputString, cronFieldType);
            cronFieldValues.addAll(simpleCronField.getFieldValues());
        }
    }

    @Override
    public List<Integer> getFieldValues() {
        List<Integer> list = new ArrayList<>(cronFieldValues);
        Collections.sort(list);
        return list;
    }
}
