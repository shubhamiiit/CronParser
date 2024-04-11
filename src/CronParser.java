class CronParser {
    public static void main(String[] args) {

//        if (args.length != 1) {
//            System.err.println("Usage: java CronParser '*/15 0 1,15 * 1-5 /usr/bin/find'");
//            System.exit(1);
//        }
//
//        String cronString = args[0];
        String cronString = "*/10,2-4,11/5,8 15 1 * 1-5 /usr/bin/find";
        CronExpression cronExpression = new CronExpression(cronString);
        cronExpression.print();
    }
}
