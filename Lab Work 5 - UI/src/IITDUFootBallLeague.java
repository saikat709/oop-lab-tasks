import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class IITDUFootBallLeague {
    private JTextField nameInput;
    private JTextField phoneNumberInput;
    private JTextField emailAddressInput;
    private JTextField addressInput;
    private ButtonGroup genderGroup;
    private JComboBox<String> latestDegree;
    private JComboBox<String> preferredPosition;
    private JCheckBox playedInterDept;
    private JTextArea experience;
    private JTextField dateInput;
    private String filepath;

    private JFrame frame;

    public void collectInfo() {
        frame = new JFrame("IIT DU FootBall League");
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

        formPanel.add(new JLabel("Full Name:"), gridBag);
        gridBag.gridx = 1;
        nameInput = new JTextField(20);
        formPanel.add(nameInput, gridBag);

        gridBag.gridx = 0; gridBag.gridy++;
        formPanel.add(new JLabel("Phone Number:"), gridBag);
        gridBag.gridx = 1;
        phoneNumberInput = new JTextField(20);
        formPanel.add(phoneNumberInput, gridBag);

        gridBag.gridx = 0; gridBag.gridy++;
        formPanel.add(new JLabel("Email Address:"), gridBag);
        gridBag.gridx = 1;
        emailAddressInput = new JTextField(20);
        formPanel.add(emailAddressInput, gridBag);

        gridBag.gridx = 0; gridBag.gridy++;
        formPanel.add(new JLabel("Address:"), gridBag);
        gridBag.gridx = 1;
        addressInput = new JTextField(20);
        formPanel.add(addressInput, gridBag);

        gridBag.gridx = 0; gridBag.gridy++;
        formPanel.add(new JLabel("Gender:"), gridBag);
        gridBag.gridx = 1;
        genderGroup = new ButtonGroup();
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JRadioButton male = new JRadioButton("Male");
        JRadioButton female = new JRadioButton("Female");
        JRadioButton other = new JRadioButton("Other");

        male.setActionCommand("male");
        female.setActionCommand("female");
        other.setActionCommand("other");

        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(other);

        genderPanel.add(male);
        genderPanel.add(female);
        genderPanel.add(other);
        formPanel.add(genderPanel, gridBag);


        gridBag.gridx = 0; gridBag.gridy++;
        formPanel.add(new JLabel("Date of Birth:"), gridBag);
        gridBag.gridx = 1;
        dateInput = new JTextField("YYYY-MM-DD", 20);
        formPanel.add(dateInput, gridBag);

        gridBag.gridx = 0; gridBag.gridy++;
        formPanel.add(new JLabel("Latest Degree:"), gridBag);
        gridBag.gridx = 1;
        latestDegree = new JComboBox<>(new String[]{"BSSE", "MSSE"});
        formPanel.add(latestDegree, gridBag);

        gridBag.gridx = 0; gridBag.gridy++;
        formPanel.add(new JLabel("Upload Picture:"), gridBag);
        gridBag.gridx = 1;
        JButton uploadButton = getUploadButton(frame);
        formPanel.add(uploadButton, gridBag);

        gridBag.gridx = 0; gridBag.gridy++;
        formPanel.add(new JLabel("Preferred Position:"), gridBag);
        gridBag.gridx = 1;
        preferredPosition = new JComboBox<>(new String[]{"Goalkeeper", "Defender", "Midfielder", "Forward"});
        formPanel.add(preferredPosition, gridBag);

        gridBag.gridx = 0; gridBag.gridy++;
        formPanel.add(new JLabel("Played Inter-Department?"), gridBag);
        gridBag.gridx = 1;
        playedInterDept = new JCheckBox("Yes");
        formPanel.add(playedInterDept, gridBag);

        gridBag.gridx = 0; gridBag.gridy++;
        formPanel.add(new JLabel("Experience:"), gridBag);
        gridBag.gridx = 1;
        experience = new JTextArea(4, 20);
        formPanel.add(new JScrollPane(experience), gridBag);

        gridBag.gridx = 0;
        gridBag.gridy++;
        gridBag.gridwidth = 2;
        gridBag.anchor = GridBagConstraints.CENTER;
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(this::handleSubmitClick);
        formPanel.add(submitButton, gridBag);

        frame.add(formPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private void handleSubmitClick(ActionEvent actionEvent) {
        if ( isFormCompletedProperly() ) {
            RegistrationFileHandler rg = new RegistrationFileHandler();
            rg.appendToFile(getFormInfoAsString());
            rg.printFileInfo();
        } else {
            showAlert("Please fill up all the fields properly.");
        }
    }

    private JButton getUploadButton(JFrame frame) {
        JButton uploadButton = new JButton("Choose File");
        uploadButton.addActionListener( e -> {
            JFileChooser fileChooser = getJFileChooser();
            fileChooser.setAcceptAllFileFilterUsed(false);

            int option = fileChooser.showOpenDialog(frame);
            if(option == JFileChooser.APPROVE_OPTION){
                File file = fileChooser.getSelectedFile();
                System.out.println("File Selected: " + file.getName());
                filepath = file.getAbsolutePath();
            } else{
                System.out.println("Open command canceled");
            }
        });
        return uploadButton;
    }

    private static JFileChooser getJFileChooser() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.addChoosableFileFilter( null );
        return fileChooser;
    }

    private boolean isFormCompletedProperly(){
        if ( genderGroup.getSelection() == null ) return false;
        if ( nameInput.getText().isEmpty() ) return false;
        if ( phoneNumberInput.getText().isEmpty() ) return false;
        if ( emailAddressInput.getText().isEmpty() ) return false;
        if ( addressInput.getText().isEmpty() ) return false;
        if ( filepath == null || filepath.isEmpty() ) return false;
        if ( latestDegree.getSelectedItem() == null ) return false;
        if ( preferredPosition.getSelectedItem() == null ) return false;
        if ( experience.getText().isEmpty() ) return false;
        if ( dateInput.getText().isEmpty() ) return false;

        return true;
    }

    private String getFormInfoAsString(){
        return "Full Name: " + nameInput.getText() + "\n"
                + "Phone Number: " + phoneNumberInput.getText() + "\n"
                + "Email Address: " + emailAddressInput.getText() + "\n"
                + "Address : " + addressInput.getText() + "\n"
                + "Gender : " + genderGroup.getSelection().getActionCommand() + "\n"
                + "Date of Birth: " + dateInput.getText() + "\n"
                + "Latest Degree: " + latestDegree.getSelectedItem().toString() + "\n"
                + "Picture path: " + filepath + "\n"
                + "Preferred playing position: " + preferredPosition.getSelectedItem().toString() + "\n"
                + "Inter department participation: " + playedInterDept.isSelected() + "\n"
                + "Experience : " + experience.getText() + "\n"
                + "---------------------------------------\n";
    }

    private void showAlert(String message){
        JOptionPane.showMessageDialog(frame, message);
    }
}