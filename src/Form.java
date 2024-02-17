import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Form extends JFrame {

    private JTextField nameField;
    private JSlider slider;

    public Form() {
        super("Оценка треков");
        super.setBounds(200, 100, 400, 200);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = super.getContentPane();
        container.setLayout(new GridLayout(4, 2, 5, 5));

        JLabel nameLabel = new JLabel("Название трека");
        nameField = new JTextField("", 1);

        // Добавление слайдера
        slider = new JSlider(JSlider.HORIZONTAL, 0, 10, 1);
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        container.add(nameLabel);
        container.add(nameField);
        container.add(new JLabel("Структура текста"));
        container.add(slider);

        // Добавление кнопки
        JButton saveButton = new JButton("Сохранить");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveToFile();
            }
        });

        container.add(saveButton);

        // Остальной код формы (если есть)
    }

    private void saveToFile() {
        String name = nameField.getText();
        int sliderValue = slider.getValue();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
            writer.write("Название трека: " + name);
            writer.newLine();
            writer.write("Значение слайдера: " + sliderValue);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Данные сохранены в файл: output.txt");
    }
}