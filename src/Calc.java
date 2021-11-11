import java.util.Stack;
import java.util.StringTokenizer;

public class Calc {
    Stack<Integer> digits=new Stack<>();

    public Calc() {
    }

    public String doMath(String str)
    {
        StringTokenizer tokenizer=new StringTokenizer(str," ");
        while (tokenizer.hasMoreTokens())
        {
            int a=0,b=0;
            String symbol=tokenizer.nextToken();
            if (symbol.matches("[0-9]+"))
            {
                digits.push(Integer.parseInt(symbol));
            }
            else
            {
                if (symbol.matches("[-+*/]"))
                {
                    if (!digits.isEmpty()) {
                        a = digits.pop();
                        if (!digits.isEmpty()) {
                            b = digits.pop();
                        }
                        else
                        {
                            System.out.println("Error! Stack is empty!");
                            return null;
                        }
                    }
                    else
                    {
                        System.out.println("Error! Stack is empty!");
                        return null;
                    }
                }
                else
                {
                    System.out.println("Wrong symbol for calculator");
                    return null;
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

        return digits.pop().toString();
    }
}
