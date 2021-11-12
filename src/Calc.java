import java.util.Stack;
import java.util.StringTokenizer;

public class Calc {
    Stack<Double> digits=new Stack<>();

    public Calc() {
    }

    public double doMath(String str)
    {
        StringTokenizer tokenizer=new StringTokenizer(str," ");
        while (tokenizer.hasMoreTokens())
        {
            double a=0,b=0;
            String symbol=tokenizer.nextToken();
            if (symbol.matches("[0-9]+"))
            {
                digits.push(Double.parseDouble(symbol));
            }
            else
            {
                if (symbol.matches("[-+*/]"))
                {
                    if (!digits.isEmpty()) {
                        b = digits.pop();
                        if (!digits.isEmpty()) {
                            a = digits.pop();
                        }
                        else
                        {
                            System.out.println("Error! Stack is empty!");
                             return -1;
                        }
                    }
                    else
                    {
                        System.out.println("Error! Stack is empty!");
                        return -1;
                    }
                }
                else
                {
                    System.out.println("Wrong symbol for calculator");
                    return -1;
                }
            }
            switch (symbol)
            {
                case "+":
                {
                    digits.push(a+b);
                    break;
                }
                case "-":
                {
                    digits.push(a-b);
                    break;
                }
                case "*":
                {
                    digits.push(a*b);
                    break;
                }
                case "/":
                {
                    digits.push(a/b);
                    break;
                }
                default:
                    break;
            }
        }

        return digits.pop();
    }
}
