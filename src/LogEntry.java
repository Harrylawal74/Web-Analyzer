public class LogEntry implements Comparable<LogEntry>
{
    // Where the data values extracted from a single
    // log line are stored.
    private int[] dataValues;
    // At which index in dataValues the different fields
    // from a log line are stored.
    private static final int YEAR = 0, MONTH = 1, DAY = 2,
            HOUR = 3, MINUTE = 4;


    public LogEntry(String logline)
    {
        // The array to store the data for a single line.
        dataValues = new int[5];
        // Break up the log line.
        LoglineTokenizer tokenizer = new LoglineTokenizer();
        tokenizer.tokenize(logline,dataValues);
    }


    public int getHour()
    {
        return dataValues[HOUR];
    }


    public int getMinute()
    {
        return dataValues[MINUTE];
    }


    public String toString()
    {
        StringBuffer buffer = new StringBuffer();
        for(int value : dataValues) {
            // Prefix a leading zero on single digit numbers.
            if(value < 10) {
                buffer.append('0');
            }
            buffer.append(value);
            buffer.append(' ');
        }
        // Drop any trailing space.
        return buffer.toString().trim();
    }


    public int compareTo(LogEntry otherEntry)
    {
        if(otherEntry == this) {
            // They are the same object.
            return 0;
        }
        else {
            // Compare corresponding fields.
            for(int i = 0; i < dataValues.length; i++) {
                int difference = dataValues[i] - otherEntry.dataValues[i];
                if(difference != 0) {
                    return difference;
                }
            }
            // No value is different, so the two entries represent
            // identical times.
            return 0;
        }
    }
}