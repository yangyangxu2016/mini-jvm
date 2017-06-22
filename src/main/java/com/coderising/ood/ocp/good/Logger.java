package com.coderising.ood.ocp.good;

/**
 * @author xyy
 * @create 2017-06-22 10:37
 **/
public class Logger {


    private Formatter formatter;
    private Sender sender;

    public Logger(Formatter formatter, Sender sender) {
        this.formatter = formatter;
        this.sender = sender;
    }

    public void log(String msg) {
        sender.send(formatter.format(msg));
    }

    public static void main(String[] args) {

        Logger loggers = new Logger(FormatterFactory.createFormatter("RAW_LOG_WITH_DATE"), SenderFactory.createSendType("PRINT_LOG"));
        loggers.log("SAFDA");

    }

}
