import javax.swing.*;
import javax.swing.text.TextAction;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class IITDUFootBallLeague {

    public void collectInfo() {
        JFrame frame = new JFrame("IIT DU FootBall League");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 700);
        frame.setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gridBag = new GridBagConstraints();

        gridBag.insets = new Insets(5, 10, 5, 10);
        gridBag.anchor = GridBagConstraints.WEST;
        gridBag.fill = GridBagConstraints.HORIZONTAL;

        gridBag.gridx = 0;
        gridBag.gridy = 0;

        // Personal Info
        formPanel.add(new JLabel("Full Name:"), gridBag);
        gridBag.gridx = 1;
        formPanel.add(new JTextField(20), gridBag);

        gridBag.gridx = 0; gridBag.gridy++;
        formPanel.add(new JLabel("Phone Number:"), gridBag);
        gridBag.gridx = 1;
        formPanel.add(new JTextField(20), gridBag);

        gridBag.gridx = 0; gridBag.gridy++;
        formPanel.add(new JLabel("Email Address:"), gridBag);
        gridBag.gridx = 1;
        formPanel.add(new JTextField(20), gridBag);

        gridBag.gridx = 0; gridBag.gridy++;
        formPanel.add(new JLabel("Address:"), gridBag);
        gridBag.gridx = 1;
        formPanel.add(new JTextField(20), gridBag);

        gridBag.gridx = 0; gridBag.gridy++;
        formPanel.add(new JLabel("Gender:"), gridBag);
        gridBag.gridx = 1;
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        genderPanel.add(new JRadioButton("Male"));
        genderPanel.add(new JRadioButton("Female"));
        genderPanel.add(new JRadioButton("Other"));
        formPanel.add(genderPanel, gridBag);

        gridBag.gridx = 0; gridBag.gridy++;
        formPanel.add(new JLabel("Date of Birth:"), gridBag);
        gridBag.gridx = 1;
        JTextField dateInout = new JTextField("YYYY-MM-DD", 20);
        dateInout.setAction(new TextAction("hello") {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Date: " + dateInout.getText());
            }
        });
        formPanel.add(dateInout, gridBag);

        gridBag.gridx = 0; gridBag.gridy++;
        formPanel.add(new JLabel("Latest Degree:"), gridBag);
        gridBag.gridx = 1;
        formPanel.add(new JComboBox<>(new String[]{"BSc", "MSc", "PhD"}), gridBag);

        gridBag.gridx = 0; gridBag.gridy++;
        formPanel.add(new JLabel("Upload Picture:"), gridBag);
        gridBag.gridx = 1;
        JButton uploadButton = getUploadButton(frame);
        formPanel.add(uploadButton, gridBag);

        gridBag.gridx = 0; gridBag.gridy++;
        formPanel.add(new JLabel("Preferred Position:"), gridBag);
        gridBag.gridx = 1;
        formPanel.add(new JComboBox<>(new String[]{"Goalkeeper", "Defender", "Midfielder", "Forward"}), gridBag);

        gridBag.gridx = 0; gridBag.gridy++;
        formPanel.add(new JLabel("Played Inter-Department?"), gridBag);
        gridBag.gridx = 1;
        formPanel.add(new JCheckBox("Yes"), gridBag);

        gridBag.gridx = 0; gridBag.gridy++;
        formPanel.add(new JLabel("Experience:"), gridBag);
        gridBag.gridx = 1;
        formPanel.add(new JScrollPane(new JTextArea(4, 20)), gridBag);

        // Submit Button
        gridBag.gridx = 0;
        gridBag.gridy++;
        gridBag.gridwidth = 2;
        gridBag.anchor = GridBagConstraints.CENTER;
        formPanel.add(new JButton("Submit"), gridBag);

        frame.add(formPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private static JButton getUploadButton(JFrame frame) {
        JButton uploadButton = new JButton("Choose File");
        uploadButton.addActionListener(new  ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = getJFileChooser();
                fileChooser.setAcceptAllFileFilterUsed(false);

                int option = fileChooser.showOpenDialog(frame);
                if(option == JFileChooser.APPROVE_OPTION){
                    File file = fileChooser.getSelectedFile();
                    System.out.println("File Selected: " + file.getName());
                }else{
                    System.out.println("Open command canceled");
                }
            }

        });
        return uploadButton;
    }

    private static JFileChooser getJFileChooser() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.addChoosableFileFilter( null );
        return fileChooser;
    }

    public static void main(String[] args) {
        new IITDUFootBallLeague().collectInfo();
    }
}
