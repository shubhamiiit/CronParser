package test;

import static org.junit.Assert.assertEquals;
import assignment.CronFieldParser.*;
import org.junit.Test;

import java.util.Arrays;

public class CronExpressionTest {

    @Test
    public void testIntervalValues() {
        ComplexCronField complexCronField = new ComplexCronField("1/5", CronFieldType.DAY_OF_MONTH);
        assertEquals(Arrays.asList(1, 6, 11, 16, 21, 26, 31), complexCronField.getFieldValues());
    }

    @Test
    public void testSingleRange() {
        ComplexCronField complexCronField = new ComplexCronField("1-1", CronFieldType.DAY_OF_MONTH);
        assertEquals(Arrays.asList(1), complexCronField.getFieldValues());
    }

    @Test
    public void testMultipleRange() {
        ComplexCronField complexCronField = new ComplexCronField("1-2", CronFieldType.DAY_OF_MONTH);
        assertEquals(Arrays.asList(1, 2), complexCronField.getFieldValues());

        complexCronField = new ComplexCronField("1-15", CronFieldType.DAY_OF_MONTH);
        assertEquals(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15),complexCronField.getFieldValues());
    }

    @Test
    public void testSingleValue() {
        ComplexCronField complexCronField = new ComplexCronField("0", CronFieldType.HOURS);
        assertEquals(Arrays.asList(0), complexCronField.getFieldValues());

        complexCronField = new ComplexCronField("23", CronFieldType.HOURS);
        assertEquals(Arrays.asList(23), complexCronField.getFieldValues());
    }

    @Test
    public void testRange() {
        ComplexCronField complexCronField = new ComplexCronField("0-1", CronFieldType.HOURS);
        assertEquals(Arrays.asList(0,1), complexCronField.getFieldValues());

        complexCronField = new ComplexCronField("0-3", CronFieldType.HOURS);
        assertEquals(Arrays.asList(0,1,2,3), complexCronField.getFieldValues());
    }

    @Test
    public void testComplexMultipleValues() {
        ComplexCronField complexCronField = new ComplexCronField("1/2,6", CronFieldType.DAY_OF_WEEK);
        assertEquals(Arrays.asList(1,3,5,6,7), complexCronField.getFieldValues());

        complexCronField = new ComplexCronField("0/5,1,2/8", CronFieldType.HOURS);
        assertEquals(Arrays.asList(0,1,2,5,10,15,18,20), complexCronField.getFieldValues());
    }

    @Test
    public void testSimpleMultipleValues() {
        ComplexCronField complexCronField = new ComplexCronField("1,2,6", CronFieldType.DAY_OF_WEEK);
        assertEquals(Arrays.asList(1,2,6), complexCronField.getFieldValues());

        complexCronField = new ComplexCronField("4,15,19,23", CronFieldType.HOURS);
        assertEquals(Arrays.asList(4,15,19,23), complexCronField.getFieldValues());
    }
}