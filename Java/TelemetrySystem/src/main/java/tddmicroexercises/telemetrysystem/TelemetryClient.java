package tddmicroexercises.telemetrysystem;


import java.util.Random;

public class TelemetryClient implements TelemetryClientInterface
{
    private final Random connectionEventsSimulator;

    private String diagnosticMessageResult = "";

    public TelemetryClient(){
         connectionEventsSimulator = new Random(42);
    }

    public void send(String message)
    {
        if (message == null || message.isEmpty())
                //"".equals(message))
        {
            throw new IllegalArgumentException();
        }

        //if (message == DIAGNOSTIC_MESSAGE)
        if (DIAGNOSTIC_MESSAGE.equals(message))
        {
            // simulate a status report
            diagnosticMessageResult =
                  "LAST TX rate................ 100 MBPS\r\n"
                + "HIGHEST TX rate............. 100 MBPS\r\n"
                + "LAST RX rate................ 100 MBPS\r\n"
                + "HIGHEST RX rate............. 100 MBPS\r\n"
                + "BIT RATE.................... 100000000\r\n"
                + "WORD LEN.................... 16\r\n"
                + "WORD/FRAME.................. 511\r\n"
                + "BITS/FRAME.................. 8192\r\n"
                + "MODULATION TYPE............. PCM/FM\r\n"
                + "TX Digital Los.............. 0.75\r\n"
                + "RX Digital Los.............. 0.10\r\n"
                + "BEP Test.................... -5\r\n"
                + "Local Rtrn Count............ 00\r\n"
                + "Remote Rtrn Count........... 00";

            //return;
        }

        // here should go the real Send operation (not needed for this exercise)
    }

    public String receive()
    {
        //String message;
        StringBuilder message = new StringBuilder();

        if (diagnosticMessageResult == null || diagnosticMessageResult.isEmpty())
                //"".equals(diagnosticMessageResult))
        {
            // simulate a received message (just for illustration - not needed for this exercise)
            // message = "";
            message = new StringBuilder();
            int messageLength = connectionEventsSimulator.nextInt(50) + 60;
            for(int i = messageLength; i >=0; --i)
            {
                //message += (char)connectionEventsSimulator.nextInt(40) + 86;
                message.append((char)connectionEventsSimulator.nextInt(40) + 86);
            }
            
        } 
        else
        {                
            //message = diagnosticMessageResult;
            message.append(diagnosticMessageResult);
            diagnosticMessageResult = "";
        }

        return message.toString();
    }
}

