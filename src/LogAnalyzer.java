public class LogAnalyzer
{
    // Array to store hourly access counts.
    private int[] hourCounts;
    // Use a LogfileReader to access the data.
    private LogfileReader reader;


    public LogAnalyzer()
    {
        //array has fixed size of 24, index 0 therefore (0-23)
        hourCounts = new int[24];
        // Create the reader to obtain the data.
        reader = new LogfileReader();
    }


    public void analyzeHourlyData()
    {
        while(reader.hasMoreEntries()) {
            LogEntry entry = reader.nextEntry();
            int hour = entry.getHour();
            hourCounts[hour]++;
        }
    }


    public void printHourlyCounts()
    {
        System.out.println("Hr: Count");
        for(int hour = 0; hour < hourCounts.length; hour++) {
            System.out.println(hour + ": " + hourCounts[hour]);
        }
    }


    public void printData()
    {
        reader.printData();
    }
}

