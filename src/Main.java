import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    JButton b=new JButton("Calculate");
    JTextArea area=new JTextArea();
    JLabel l= new JLabel("Result: ");
    Font f=new Font("Helvetica", Font.PLAIN, 16);
    Main()
    {
        super("CalculatorOnStack");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setSize(800,600);
        add(b);
        add(area);
        add(l);
        b.setSize(100,50);
        area.setSize(400,20);
        l.setSize(200,20);
        b.setFont(f);
        area.setFont(f);
        l.setFont(f);
        setVisible(true);
        area.setLocation(200,50);
        l.setLocation(325,100);
        b.setLocation(350,200);
        b.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {

                Calc calc=new Calc();
                if ( calc.doMath(area.getText())!=null)
                {
                    l.setText("Result: "+calc.doMath(area.getText()));
                }
                else
                {
                    l.setText("Error wrong type input or Stack is empty");
                }

            }
        });
    }
    public static void main(String[] args)
    {
        new Main();

    }
}
