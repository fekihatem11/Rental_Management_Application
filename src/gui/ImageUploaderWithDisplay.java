package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.ImageIcon;

public class ImageUploaderWithDisplay {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Image Uploader");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new BorderLayout());

        JButton editPictureButton = new JButton("Edit Picture");
        JLabel imageLabel = new JLabel();

        editPictureButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "jpg", "png", "gif", "jpeg");
                fileChooser.setFileFilter(filter);
                int returnValue = fileChooser.showOpenDialog(null);

                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    String imagePath = selectedFile.getAbsolutePath();
                    try {
                        saveImageToProject(selectedFile);
                        ImageIcon imageIcon = new ImageIcon(imagePath);
                        imageLabel.setIcon(imageIcon);
                        JOptionPane.showMessageDialog(null, "Image saved to project assets folder!");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error saving image!");
                    }
                }
            }
        });

        frame.add(editPictureButton, BorderLayout.NORTH);
        frame.add(imageLabel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public static void saveImageToProject(File file) throws IOException {
        Path destination = Paths.get("assets/" + file.getName()); // Change the folder path accordingly
        Files.copy(file.toPath(), destination, StandardCopyOption.REPLACE_EXISTING);
    }
}