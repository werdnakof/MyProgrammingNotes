import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/** Illustrate Unresponsive UI problem caused by "busy" Event-Dispatching Thread */
public class UnresponsiveUI extends JFrame {
    private boolean stop = false;  // start or stop the counter
    private JTextField tfCount;
    private int count = 1;

    /** Constructor to setup the GUI components */
    public UnresponsiveUI() {
        Container cp = this.getContentPane();
        cp.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        cp.add(new JLabel("Counter"));
        tfCount = new JTextField(String.valueOf(count), 10);
        tfCount.setEditable(false);
        cp.add(tfCount);

        JButton btnStart = new JButton("Start");
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                stop = false;

                // Create our own Thread to do the counting
                Thread t = new Thread() {
                    @Override
                    public void run() {  // override the run() to specify the running behavior
                        for (int i = 0; i < 100000; ++i) {
                            if (stop) break;
                            tfCount.setText(String.valueOf(count++));

                            // Suspend this thread via sleep() and yield control to other threads.
                            // Also provide the necessary delay.
                            try {
                                sleep(1000);  // milliseconds
                            } catch (InterruptedException ex) {}
                        }
                    }
                };
                t.start();  // call back run()

//                for (int i = 0; i < 100000; ++i) {
//                    if (stop) break;  // check if STOP button has been pushed,
//                    //  which changes the stop flag to true
//                    tfCount.setText(count + "");
//                    ++count;
//                }
            }
        });
        cp.add(btnStart);

        JButton btnReset = new JButton("Reset");
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                stop = true;  // set the stop flag
                count = 0;
                tfCount.setText(String.valueOf(count));
            }
        });
        cp.add(btnReset);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Counter");
        setSize(300, 150);
        setVisible(true);
    }

    /** The entry main method */
    public static void main(String[] args) {
        // Run GUI codes in Event-Dispatching thread for thread safety
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new UnresponsiveUI();  // Let the constructor do the job
            }
        });
    }
}