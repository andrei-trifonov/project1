package Practice9;


import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class Calculator extends JFrame
{

    public Calculator ()
    {
        super("Calculator");
        setPreferredSize(new Dimension(200, 200));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);




        JPanel content = new JPanel();
        JTextField data = new JTextField("", 15);
        Container container = new Container();
        Container textfield = new Container();
        container.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        container.setLayout(new GridBagLayout());
        textfield.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        content.add(container);

        for (int i=0;i<10;i++){
            JButton button = new JButton(String.valueOf(i));

            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                   data.setText(data.getText() + e.getActionCommand());
                }
            });
            if (i<3)
                constraints.gridx = i;
                constraints.gridy = 1;
            if (i>=3 && i<6) {
                constraints.gridx = i-3;
                constraints.gridy = 2;}
            if (i>=6 && i<9){
                constraints.gridx = i-6;
                constraints.gridy = 3;}
            if (i==9 ){
                constraints.gridx = 1;
                constraints.gridy = 4;}
            container.add (button,constraints);
        }
        JButton point = new JButton(".");
        point.addActionListener((new ActionListener() {
            String last;
            public void actionPerformed(ActionEvent e) {
                try {
                    last = data.getText().substring(data.getText().length() - 1);
                    switch (last) {
                        case ".": break;
                        default: data.setText(data.getText() + e.getActionCommand()); break;
                    }
                }
                catch (StringIndexOutOfBoundsException ex){
                    System.out.println("Нельзя начинать с точки");
                }



            }
        }));
        constraints.gridx = 2;
        constraints.gridy = 4;
        container.add(point, constraints);
        JButton clear = new JButton("Clear");
        clear.addActionListener((new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                data.setText(data.getText().substring(data.getText().length()));
            }
        }));
        constraints.gridx = 4;
        constraints.gridy = 1;
        container.add(clear, constraints);

        JButton back = new JButton("Back");
        back.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {data.setText(data.getText().substring(0,data.getText().length()-1));}
                catch (StringIndexOutOfBoundsException ex){
                    System.out.println("Строка уже пуста");
                }
            }
        }));
        constraints.gridx = 4;
        constraints.gridy = 2;
        container.add(back, constraints);
        JButton calc = new JButton("=");
        calc.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str;
                char sign = '&';
                double a = 0;
                double b = 0;
                String tmps = "";
                str = data.getText();
                for (int i = 0; i < str.length(); i++) {
                    if(str.charAt(i) != '+' && str.charAt(i) != '-' && str.charAt(i) != '/' && str.charAt(i) != '*' ){
                        tmps += str.charAt(i);
                        if (i== str.length()-1){



                            try {b = Double.parseDouble(tmps);}
                            catch (NumberFormatException ex){
                                System.out.println("Ошибка в числе");
                            }
                            System.out.println(b);
                            switch (sign) {
                                case '+': a= a+b; break;
                                case '/': a= a/b; break;
                                case '*': a= a*b; break;
                                case '-': a= a-b; break;}
                        }
                    }
                    else {
                        if (sign != '&'){

                            try {b = Double.parseDouble(tmps);}
                            catch (NumberFormatException ex){
                                System.out.println("Ошибка в числе");
                            }
                            System.out.println(b);
                            switch (sign) {
                                case '+': a= a+b; break;
                                case '/': a= a/b; break;
                                case '*': a= a*b; break;
                                case '-': a= a-b; break;}
                            tmps = "";
                            sign = str.charAt(i);
                        }
                        if (sign == '&'){
                            sign = str.charAt(i);

                            try {a = Double.parseDouble(tmps);}
                            catch (NumberFormatException ex){
                                System.out.println("Ошибка в числе");
                            }
                            System.out.println(a);
                            tmps = "" ;
                        }

                    }
                }
                sign = '&';
                data.setText(""+a);

            }}));

        constraints.gridx = 4;
        constraints.gridy = 3;
        container.add(calc, constraints);
        for(int i=0; i<4;i++){
            JButton button = new JButton();
            constraints.gridx = 3;


            switch (i){
                case 0: {button.setText("+"); constraints.gridy = 1;}break;
                case 1: {button.setText("-"); constraints.gridy = 2;} break;
                case 2: {button.setText("*"); constraints.gridy = 3;} break;
                case 3: {button.setText("/"); constraints.gridy = 4;} break;
            }




            button.addActionListener(new ActionListener() {
                String last;
                public void actionPerformed(ActionEvent e) {
                    last = data.getText().substring(data.getText().length() - 1);

                    switch (last) {
                        case "+": break;
                        case "-": break;
                        case "*":break;
                        case "/":break;
                        default: data.setText(data.getText() + e.getActionCommand()); break;
                    }

                }
            });
            content.add(button,constraints);
        }
        content.add(textfield);
        content.setComponentZOrder(textfield, 0);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor   = GridBagConstraints.PAGE_START;
        textfield.add(data,constraints);


        setContentPane(content);
        content.setSize(200,200);
        content.setVisible(true);
        pack();

    }

    public static void main(String[] args)
    {
        JFrame.setDefaultLookAndFeelDecorated(true);
        new Calculator();
    }
}