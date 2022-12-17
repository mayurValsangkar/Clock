import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyFrame extends JFrame {

    SimpleDateFormat timeFormat;
    SimpleDateFormat dayFormat;
    SimpleDateFormat dateFormat;
    JLabel timeLabel;
    JLabel dayLabel;
    JLabel dateLabel;
    String time;
    String day;
    String date;

    // Constructor
    MyFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My Clock Program");
        this.setLayout(new FlowLayout());
        this.setSize(350, 200);
        //this.setResizable(false);

        // Setting time format
        timeFormat = new SimpleDateFormat("hh:mm:ss a");  //(hh:mm:ss a) -> Format specifier

        // Setting day format
        dayFormat = new SimpleDateFormat("EEEE");  //(EEEE) -> Format specifier

        // Setting date format
        dateFormat = new SimpleDateFormat("MMMMM dd, yyyy"); //(MM dd, yyyy) -> Format specifier

        // Initialize time label
        timeLabel = new JLabel();

        // Setting font, and appearance of time label
        timeLabel.setFont(new Font("Verdana", Font.PLAIN, 50));
        timeLabel.setForeground(new Color(0x00FF00));
        timeLabel.setBackground(Color.BLACK);
        timeLabel.setOpaque(true);

        // Initialize day label
        dayLabel = new JLabel();

        // Setting font of time label
        dayLabel.setFont(new Font("Ink Free", Font.PLAIN, 35));

        // Initialize date label
        dateLabel = new JLabel();

        // Setting font of date label
        dateLabel.setFont(new Font("Ink Free", Font.PLAIN, 25));

        // Adding label to frame
        this.add(timeLabel);
        this.add(dayLabel);
        this.add(dateLabel);

        // Make frame visible
        this.setVisible(true);

        setTime();
    }

    public void setTime() {

        // Updating time every 1000 milli second
        while (true) {

            // This will get us, the current time
            time = timeFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText((time));

            // This will get us, the current day
            day = dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText((day));

            // This will get us, the current date
            date = dateFormat.format(Calendar.getInstance().getTime());
            dateLabel.setText((date));

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();  // Exception Handling
            }
        }

    }
}
