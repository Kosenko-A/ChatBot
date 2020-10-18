package ru.geekbrains.homeworks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Window extends JFrame implements ActionListener{
    final String TITLE_OF_PROGRAM = "Chat Bot: ";
    JTextField message;
    JTextArea dialogue;
    SimpleBot simpleBot;
    JCheckBox ai;

    public Window(){
        Font font = new Font("Verdana", Font.ITALIC, 12);
        Font fontForButton = new Font("Verdana", Font.BOLD, 12);
        setTitle(TITLE_OF_PROGRAM);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(200,200, 500,450);
        setResizable(false);
        dialogue = new JTextArea();
        dialogue.setBackground(new Color(255, 255, 224));
        dialogue.setLineWrap(true);
        dialogue.setEditable(false);
        dialogue.setFont(font);
        JScrollPane scrollPane = new JScrollPane(dialogue);

        JPanel buttons = new JPanel();
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.X_AXIS));
        ai = new JCheckBox("AI");
        ai.setBackground(new Color(255, 215, 0));

        message = new JTextField();
        message.setBackground(new Color(255, 250, 205));
        message.addActionListener(this);
        message.setFont(fontForButton);
        JButton send = new JButton("Send");
        send.setBackground(Color.YELLOW);
        send.setFont(fontForButton);
        send.addActionListener(this);
        buttons.add(ai);
        buttons.add(message);
        buttons.add(send);
        add (BorderLayout.CENTER,scrollPane);
        add (BorderLayout.SOUTH, buttons);
        setVisible(true);

        simpleBot = new SimpleBot();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (message.getText().trim().length()>0){
            dialogue.append(message.getText() + "\n");
            dialogue.append(TITLE_OF_PROGRAM.substring(0, 10) +
                    simpleBot.sayInReturn(message.getText(), ai.isSelected()) + "\n");
        }
        message.setText("");
        message.requestFocusInWindow();
    }
}

