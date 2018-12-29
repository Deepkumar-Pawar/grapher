/**
 * Class to draw the graph and related components on the window
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Display extends JPanel {

    static Expression exp = HeadClass.exp;

    public Display()
    {
        setLayout(null);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        JTextField inputExpression = new JTextField(15);
        add(inputExpression);
        inputExpression.setLocation(10, ApplicationWindow.windowHeight - 80);
        inputExpression.setSize(100, 28);

        JTextField instruct = new JTextField("  Input Function in x", 40);
        add(instruct);
        instruct.setBounds(ApplicationWindow.windowWidth - 140, ApplicationWindow.windowHeight - 80, 115, 28);
        instruct.setEditable(false);
        instruct.setBackground(Color.RED);
        instruct.setSelectedTextColor(Color.GREEN);

        JButton plotButton = new JButton("PLOT");
        add(plotButton);
        plotButton.setBounds(140, ApplicationWindow.windowHeight - 80, 75, 28);

        plotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Expression _exp = new Expression(inputExpression.getText());
                HeadClass.start(_exp);
                exp = _exp;
                repaint();
            }
        });

        //updating the input system

        setBackground(Color.BLACK);

        g.setColor(Color.WHITE);
        g.drawLine(0,
                (int)DisplayTransformations.origin.y,
                (int) DisplayTransformations.origin.x * 2,
                (int)DisplayTransformations.origin.y
        );
        g.drawLine((int)DisplayTransformations.origin.x,
                0,
                (int) DisplayTransformations.origin.x,
                (int)DisplayTransformations.origin.y * 2
        );

        //drawing the coordinate axes

        g.setColor(Color.RED);
        for (int i = 0; i < exp.pixelCoordinates.size() - 1; i++)
        {
            g.drawLine(
                    (int)exp.pixelCoordinates.get(i).x,
                    (int)exp.pixelCoordinates.get(i).y,
                    (int)exp.pixelCoordinates.get(i + 1).x,
                    (int)exp.pixelCoordinates.get(i + 1).y
            );
        }

        //drawing the graph
    }
}
