import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Formatter;

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
        l.setSize(300,20);
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
                if ( calc.doMath(area.getText())!=-1)
                {
                    Formatter f=new Formatter();
                    if (calc.doMath(area.getText()) % 1 == 0) {
                       f.format("%.0f",calc.doMath(area.getText()));
                    }
                    else {
                        f.format("%.3f", calc.doMath(area.getText()));
                    }
                    l.setText("Result: "+f.toString());
                }
                else
                {
                    l.setText("Error: wrong type input or Stack is empty");
                }

            }
        });
    }
    public static void main(String[] args)
    {
        new Main();
//        2 3 +
//        2 3 * 4 5 * +
//        2 3 4 5 6 * + - /


    }
}
