package uebung_4;

/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.colorchooser.AbstractColorChooserPanel;

/* TopLevelDemo.java requires no other files. */
public class Uebung4 extends JPanel implements ActionListener, MouseListener {

    GeoPainterEK ge;

    JPanel circPanel = new JPanel();
    JPanel rectPanel = new JPanel();
    JPanel startPanel = new JPanel();
    JTextField xCircle, yCircle, radius, depthCircle, xRect, yRect, widthRect, heightRect, depthRect;
    JButton submitCircle, submitRect;
    JColorChooser colorChooserCircle, colorChooserRectangle;
    JRadioButton strokeColorCirc, fillColorCirc, strokeStandardCirc, strokeWideCirc, strokeDashedCirc,
            strokeColorRect, fillColorRect, strokeStandardRect, strokeWideRect, strokeDashedRect;
    Color colorFillRect, colorStrokeRect, colorFillCirc, colorStrokeCirc;
    int strokeTypeCirc = 0;
    int strokeTypeRect = 0;

    Uebung4() {

        ge = new GeoPainterEK();

        //Start
        startPanel.setLayout(new BoxLayout(startPanel, BoxLayout.PAGE_AXIS));
        startPanel.setPreferredSize(new Dimension(600, 1000));
        startPanel.setVisible(true);
        add(startPanel);

        createCirclePanel();
        createRectanglePanel();
    }

    public void createCirclePanel() {
        circPanel.setLayout(new BoxLayout(circPanel, BoxLayout.PAGE_AXIS));

        JPanel circPanel1 = new JPanel(new GridLayout(0, 2));
        JLabel xCircLabel = new JLabel("x-Coordinate");
        xCircle = new JTextField("500");
        JLabel yCircLabel = new JLabel("y-Coordinate");
        yCircle = new JTextField("500");
        JLabel radiusCircLabel = new JLabel("Radius");
        radius = new JTextField("50");
        JLabel depthCircLabel = new JLabel("Depth");
        depthCircle = new JTextField("0");
        circPanel1.add(xCircLabel);
        circPanel1.add(xCircle);
        circPanel1.add(yCircLabel);
        circPanel1.add(yCircle);
        circPanel1.add(radiusCircLabel);
        circPanel1.add(radius);
        circPanel1.add(depthCircLabel);
        circPanel1.add(depthCircle);

        colorChooserCircle = new JColorChooser();
        colorChooserCircle.setPreviewPanel(new JPanel());
        AbstractColorChooserPanel[] chooserpanelsCirc = colorChooserCircle.getChooserPanels();
        colorChooserCircle.removeChooserPanel(chooserpanelsCirc[0]);
        colorChooserCircle.removeChooserPanel(chooserpanelsCirc[2]);
        colorChooserCircle.removeChooserPanel(chooserpanelsCirc[4]);

        JPanel circPanel2 = new JPanel(new GridLayout(0, 2));
        ButtonGroup buttonGroupColorCirc = new ButtonGroup();
        JLabel strokeColorCircLabel = new JLabel("Stroke Color");
        strokeColorCirc = new JRadioButton();
        JLabel fillColorCircLabel = new JLabel("Fill Color");
        fillColorCirc = new JRadioButton();
        buttonGroupColorCirc.add(fillColorCirc);
        buttonGroupColorCirc.add(strokeColorCirc);
        buttonGroupColorCirc.setSelected(fillColorCirc.getModel(), true);
        ButtonGroup buttonGroupStrokeCirc = new ButtonGroup();
        JLabel strokeStandardCircLabel = new JLabel("Standard Stroke");
        strokeStandardCirc = new JRadioButton();
        JLabel strokeWideCircLabel = new JLabel("Wide Stroke");
        strokeWideCirc = new JRadioButton();
        JLabel strokeDashedCircLabel = new JLabel("Dashed Stroke");
        strokeDashedCirc = new JRadioButton();
        buttonGroupStrokeCirc.add(strokeStandardCirc);
        buttonGroupStrokeCirc.add(strokeWideCirc);
        buttonGroupStrokeCirc.add(strokeDashedCirc);
        buttonGroupStrokeCirc.setSelected(strokeStandardCirc.getModel(), true);
        circPanel2.add(fillColorCircLabel);
        circPanel2.add(fillColorCirc);
        circPanel2.add(strokeColorCircLabel);
        circPanel2.add(strokeColorCirc);
        circPanel2.add(strokeStandardCircLabel);
        circPanel2.add(strokeStandardCirc);
        circPanel2.add(strokeWideCircLabel);
        circPanel2.add(strokeWideCirc);
        circPanel2.add(strokeDashedCircLabel);
        circPanel2.add(strokeDashedCirc);

        JPanel circPanel3 = new JPanel();
        submitCircle = new JButton("Kreis zeichnen");
        submitCircle.addActionListener(this);
        circPanel3.add(submitCircle, BorderLayout.CENTER);

        circPanel.add(circPanel1);
        circPanel.add(colorChooserCircle);
        circPanel.add(circPanel2);
        circPanel.add(circPanel3);

        circPanel1.setPreferredSize(new Dimension(600, 200));
        circPanel2.setPreferredSize(new Dimension(600, 200));
        colorChooserCircle.setPreferredSize(new Dimension(600, 500));
        circPanel3.setPreferredSize(new Dimension(600, 100));

        circPanel.setPreferredSize(new Dimension(600, 1000));
        circPanel.setVisible(false);
        add(circPanel);
    }

    public void createRectanglePanel() {
        rectPanel.setLayout(new BoxLayout(rectPanel, BoxLayout.PAGE_AXIS));

        JPanel rectPanel1 = new JPanel(new GridLayout(0, 2));
        JLabel xRectLabel = new JLabel("x-Coordinate Upper Left Corner");
        xRect = new JTextField("200");
        JLabel yRectLabel = new JLabel("y-Coordinate Upper Left Corner");
        yRect = new JTextField("200");
        JLabel widthRectLabel = new JLabel("Width");
        widthRect = new JTextField("50");
        JLabel heightRectLabel = new JLabel("Height");
        heightRect = new JTextField("50");
        JLabel depthRectLabel = new JLabel("Depth");
        depthRect = new JTextField("0");
        rectPanel1.add(xRectLabel);
        rectPanel1.add(xRect);
        rectPanel1.add(yRectLabel);
        rectPanel1.add(yRect);
        rectPanel1.add(widthRectLabel);
        rectPanel1.add(widthRect);
        rectPanel1.add(heightRectLabel);
        rectPanel1.add(heightRect);
        rectPanel1.add(depthRectLabel);
        rectPanel1.add(depthRect);

        colorChooserRectangle = new JColorChooser();
        colorChooserRectangle.setPreviewPanel(new JPanel());
        AbstractColorChooserPanel[] chooserpanelsRect = colorChooserRectangle.getChooserPanels();
        colorChooserRectangle.removeChooserPanel(chooserpanelsRect[0]);
        colorChooserRectangle.removeChooserPanel(chooserpanelsRect[2]);
        colorChooserRectangle.removeChooserPanel(chooserpanelsRect[4]);

        JPanel rectPanel2 = new JPanel(new GridLayout(0, 2));
        ButtonGroup buttonGroupColorRect = new ButtonGroup();
        JLabel strokeColorRectLabel = new JLabel("Stroke Color");
        strokeColorRect = new JRadioButton();
        JLabel fillColorRectLabel = new JLabel("Fill Color");
        fillColorRect = new JRadioButton();
        buttonGroupColorRect.add(fillColorRect);
        buttonGroupColorRect.add(strokeColorRect);
        buttonGroupColorRect.setSelected(fillColorRect.getModel(), true);
        ButtonGroup buttonGroupStrokeRect = new ButtonGroup();
        JLabel strokeStandardRectLabel = new JLabel("Standard Stroke");
        strokeStandardRect = new JRadioButton();
        JLabel strokeWideRectLabel = new JLabel("Wide Stroke");
        strokeWideRect = new JRadioButton();
        JLabel strokeDashedRectLabel = new JLabel("Dashed Stroke");
        strokeDashedRect = new JRadioButton();
        buttonGroupStrokeRect.add(strokeStandardRect);
        buttonGroupStrokeRect.add(strokeWideRect);
        buttonGroupStrokeRect.add(strokeDashedRect);
        buttonGroupStrokeRect.setSelected(strokeStandardRect.getModel(), true);
        rectPanel2.add(fillColorRectLabel);
        rectPanel2.add(fillColorRect);
        rectPanel2.add(strokeColorRectLabel);
        rectPanel2.add(strokeColorRect);
        rectPanel2.add(strokeStandardRectLabel);
        rectPanel2.add(strokeStandardRect);
        rectPanel2.add(strokeWideRectLabel);
        rectPanel2.add(strokeWideRect);
        rectPanel2.add(strokeDashedRectLabel);
        rectPanel2.add(strokeDashedRect);

        JPanel rectPanel3 = new JPanel();
        submitRect = new JButton("Rechteck zeichnen");
        submitRect.addActionListener(this);
        rectPanel3.add(submitRect, BorderLayout.CENTER);

        rectPanel.add(rectPanel1);
        rectPanel.add(colorChooserRectangle);
        rectPanel.add(rectPanel2);
        rectPanel.add(rectPanel3);

        rectPanel1.setPreferredSize(new Dimension(600, 200));
        rectPanel2.setPreferredSize(new Dimension(600, 200));
        colorChooserRectangle.setPreferredSize(new Dimension(600, 500));
        rectPanel3.setPreferredSize(new Dimension(600, 100));

        rectPanel.setPreferredSize(new Dimension(600, 1000));
        rectPanel.setVisible(false);
        add(rectPanel);
    }

    public JMenuBar createMenuBar() {

        //Create the menu bar.  Make it have a green background.
        JMenuBar greenMenuBar = new JMenuBar();
        greenMenuBar.setOpaque(true);
        greenMenuBar.setBackground(new Color(154, 165, 127));
        greenMenuBar.setPreferredSize(new Dimension(400, 20));

        //Menupunkt  hinzufuegen
        JMenu menu_file_shape = new JMenu("Form");
        greenMenuBar.add(menu_file_shape);

        //Menueeintraege hinzufuegen
        JMenuItem item_kreis = new JMenuItem("Kreis");
        JMenuItem item_rechteck = new JMenuItem("Rechteck");
        //1. ActionListener fuer Open anh�ngen

        item_kreis.addActionListener(this);
        item_rechteck.addActionListener(this);

        menu_file_shape.add(item_kreis);
        menu_file_shape.add(item_rechteck);

        // JMenuBar greenMenuBar zur�ckgeben
        return greenMenuBar;
    }

    /**
     * Create the GUI and show it. For thread safety, this method should be
     * invoked from the event-dispatching thread. Problem: Das muss eine
     * statische Methode sein, um thread-save aufgerufen werden zu koennen
     * (siehe Methode main()). Allerdings, eine statische Methode kann nicht mit
     * den Instanzvariablen der Klasse interagieren. Wir umgehen das, indem wir
     * von JPanel erben, und dieses als ContentPane in unseren Frame geben.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("EPRO_Uebung_4_EK © mt151062");
        Uebung4 uebung4 = new Uebung4();

        Container pane = frame.getContentPane();
                
        pane.add(uebung4, BorderLayout.LINE_START);
        pane.add(uebung4.ge.lp, BorderLayout.CENTER);

        frame.setContentPane(pane);
        frame.setPreferredSize(new Dimension(1500, 1000));
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setJMenuBar(uebung4.createMenuBar());
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem itemClicked;
        //Falls es ein MenuItem ist
        if (e.getSource() instanceof JMenuItem) {
            itemClicked = (JMenuItem) e.getSource();

            if (itemClicked.getText() == "Kreis") {
                startPanel.setVisible(false);
                if (rectPanel.isVisible()) {
                    rectPanel.setVisible(false);
                }
                circPanel.setVisible(true);
            }

            if (itemClicked.getText() == "Rechteck") {
                startPanel.setVisible(false);
                if (circPanel.isVisible()) {
                    circPanel.setVisible(false);
                }
                rectPanel.setVisible(true);
            }
        } else {

            if (fillColorCirc.isSelected()) {
                colorFillCirc = colorChooserCircle.getColor();
            }
            if (strokeColorCirc.isSelected()) {
                colorStrokeCirc = colorChooserCircle.getColor();
            }

            if (fillColorRect.isSelected()) {
                colorFillRect = colorChooserRectangle.getColor();
            }
            if (strokeColorRect.isSelected()) {
                colorStrokeRect = colorChooserRectangle.getColor();
            }

            JButton buttonClicked = (JButton) e.getSource();
            if (buttonClicked.getText() == "Kreis zeichnen") {

                try {
                    int circX = Integer.parseInt(xCircle.getText().toString());
                    int circY = Integer.parseInt(yCircle.getText().toString());
                    double circRadius = Integer.parseInt(radius.getText().toString());
                    int circDepth = Integer.parseInt(depthCircle.getText().toString());

                    if (strokeStandardCirc.isSelected()) {
                        strokeTypeCirc = 1;
                    }
                    if (strokeWideCirc.isSelected()) {
                        strokeTypeCirc = 2;
                    }
                    if (strokeDashedCirc.isSelected()) {
                        strokeTypeCirc = 3;
                    }

                    ge.addCircle(new Point(circX, circY), circRadius, colorFillCirc, colorStrokeCirc, strokeTypeCirc, circDepth);
                } catch (NumberFormatException ne) {
                    JOptionPane.showMessageDialog(null, "Bitte in allen Eingabe"
                            + "feldern Zahlen eingeben!");
                }
            }
            if (buttonClicked.getText() == "Rechteck zeichnen") {
                try {
                    int rectX = Integer.parseInt(xRect.getText().toString());
                    int rectY = Integer.parseInt(yRect.getText().toString());
                    int rectWidth = Integer.parseInt(widthRect.getText().toString());
                    int rectHeight = Integer.parseInt(heightRect.getText().toString());
                    int rectDepth = Integer.parseInt(depthRect.getText().toString());

                    if (strokeStandardRect.isSelected()) {
                        strokeTypeRect = 1;
                    }
                    if (strokeWideRect.isSelected()) {
                        strokeTypeRect = 2;
                    }
                    if (strokeDashedRect.isSelected()) {
                        strokeTypeRect = 3;
                    }

                    ge.addRectangle(new Point(rectX, rectY), new Point(rectX + rectWidth, rectY + rectHeight), colorFillRect, colorStrokeRect, strokeTypeRect, rectDepth);
                } catch (NumberFormatException ne) {
                    JOptionPane.showMessageDialog(null, "Bitte in allen Eingabe"
                            + "feldern Zahlen eingeben!");
                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

//TO DO
// MOUSE LISTENER
// RADIOBUTTON FARBE STRICH UND FÜLLFARBE SPEICHERN SIMULTAN
