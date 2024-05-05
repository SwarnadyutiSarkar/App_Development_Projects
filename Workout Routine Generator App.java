import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WorkoutRoutineGeneratorApp extends JFrame {
    private JComboBox<String> goalsComboBox;
    private JCheckBox[] equipmentCheckboxes;
    private JCheckBox[] muscleGroupCheckboxes;
    private JButton generateButton;
    private JTextArea routineTextArea;

    public WorkoutRoutineGeneratorApp() {
        setTitle("Workout Routine Generator");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel preferencesPanel = new JPanel(new GridLayout(3, 1));

        // Fitness Goals
        JLabel goalsLabel = new JLabel("Select Fitness Goals:");
        goalsComboBox = new JComboBox<>(new String[]{"Weight Loss", "Muscle Gain", "Endurance", "Strength"});
        preferencesPanel.add(goalsLabel);
        preferencesPanel.add(goalsComboBox);

        // Available Equipment
        JLabel equipmentLabel = new JLabel("Select Available Equipment:");
        String[] equipmentItems = {"Dumbbells", "Barbell", "Resistance Bands", "Bodyweight"};
        equipmentCheckboxes = new JCheckBox[equipmentItems.length];
        JPanel equipmentPanel = new JPanel(new GridLayout(1, equipmentItems.length));
        for (int i = 0; i < equipmentItems.length; i++) {
            equipmentCheckboxes[i] = new JCheckBox(equipmentItems[i]);
            equipmentPanel.add(equipmentCheckboxes[i]);
        }
        preferencesPanel.add(equipmentLabel);
        preferencesPanel.add(equipmentPanel);

        // Target Muscle Groups
        JLabel muscleGroupLabel = new JLabel("Select Target Muscle Groups:");
        String[] muscleGroupItems = {"Chest", "Back", "Legs", "Shoulders", "Arms", "Core"};
        muscleGroupCheckboxes = new JCheckBox[muscleGroupItems.length];
        JPanel muscleGroupPanel = new JPanel(new GridLayout(1, muscleGroupItems.length));
        for (int i = 0; i < muscleGroupItems.length; i++) {
            muscleGroupCheckboxes[i] = new JCheckBox(muscleGroupItems[i]);
            muscleGroupPanel.add(muscleGroupCheckboxes[i]);
        }
        preferencesPanel.add(muscleGroupLabel);
        preferencesPanel.add(muscleGroupPanel);

        // Generate Button
        generateButton = new JButton("Generate Routine");
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateRoutine();
            }
        });

        add(preferencesPanel, BorderLayout.NORTH);
        add(generateButton, BorderLayout.CENTER);

        routineTextArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(routineTextArea);
        add(scrollPane, BorderLayout.SOUTH);
    }

    private void generateRoutine() {
        // Generate routine based on selected preferences
        StringBuilder routineBuilder = new StringBuilder();
        routineBuilder.append("Generated Workout Routine:\n");

        String selectedGoal = (String) goalsComboBox.getSelectedItem();
        routineBuilder.append("Fitness Goal: ").append(selectedGoal).append("\n");

        routineBuilder.append("Selected Equipment:\n");
        for (JCheckBox checkbox : equipmentCheckboxes) {
            if (checkbox.isSelected()) {
                routineBuilder.append("- ").append(checkbox.getText()).append("\n");
            }
        }

        routineBuilder.append("Selected Muscle Groups:\n");
        for (JCheckBox checkbox : muscleGroupCheckboxes) {
            if (checkbox.isSelected()) {
                routineBuilder.append("- ").append(checkbox.getText()).append("\n");
            }
        }

        routineTextArea.setText(routineBuilder.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WorkoutRoutineGeneratorApp().setVisible(true);
            }
        });
    }
}
