package Practice11;

import javafx.application.Application;

import javax.swing.*;
import java.awt.*;
import java.awt.desktop.AppEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Random;

public class tictactoeInterface extends Service {
    private JPanel panel1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JLabel turnName;
    private JCheckBox mode;
    private JButton restart;

    public tictactoeInterface() {
        setContentPane(panel1);
        setVisible(true);
        setMinimumSize(new Dimension(200, 200));
        setMaximumSize(new Dimension(500,500));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        turnName.setText("Your turn");
        if (player1Mark != "X")
           compTurn();

        mode.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (mode.isSelected()){
                    gameMode = "2Players";
                    if (player1Mark == "X")
                        turnName.setText("Player1 turn");
                    else
                        turnName.setText("Player2 turn");
                }
                else {
                    gameMode = "AI";
                    turnName.setText("Your turn");
                    if (player1Mark != "X")
                        compTurn();
                }
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doTurn(button1, turnName);
                VictoryCheck();
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doTurn(button2, turnName);
                VictoryCheck();
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doTurn(button3, turnName);
                VictoryCheck();
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doTurn(button4, turnName);
                VictoryCheck();
            }
        });
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doTurn(button5, turnName);
                VictoryCheck();
            }
        });
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doTurn(button6, turnName);
                VictoryCheck();
            }
        });
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doTurn(button7, turnName);
                VictoryCheck();
            }
        });
        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doTurn(button8, turnName);
                VictoryCheck();
            }
        });
        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doTurn(button9, turnName);
                VictoryCheck();
            }
        });

        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                destroy();
            }
        });
    }
    void VictoryCheck(){
        if (button2.getText()==button6.getText() && button9.getText() == button2.getText()){
            checkWinner(button2, turnName);
        }
        if (button1.getText()==button2.getText() && button1.getText() == button3.getText()){
            checkWinner(button1, turnName);
        }
        if (button4.getText()==button6.getText() && button4.getText() == button8.getText()){
            checkWinner(button4, turnName);
        }
        if (button5.getText()==button7.getText() && button5.getText() == button9.getText()){
            checkWinner(button5, turnName);
        }
        if (button2.getText()==button4.getText() && button2.getText() == button5.getText()){
            checkWinner(button2, turnName);
        }
        if (button3.getText()==button6.getText() && button3.getText() == button7.getText()){
            checkWinner(button3, turnName);
        }
        if (button1.getText()==button8.getText() && button9.getText() == button1.getText()){
            checkWinner(button8, turnName);
        }
    }

}
class Service extends beginGame{
    public  void compTurn(){

    }
    void  checkWinner (JButton button, JLabel label){
        if (button.getText()== player1Mark){
            label.setText("Player 1 won");

            }
        if (button.getText()== player2Mark){

            label.setText("Player 2 won");}

    }
    public void doTurn(JButton button, JLabel label){

        if ((button.getText() == "") && label.getText()!="Player 1 won" && label.getText() != "Player 2 won"){
                System.out.println(label.getText());
                if (label.getText() == "Player1 turn"){
                    button.setText(player1Mark);
                }
                if (label.getText()=="Player2 turn"){
                    button.setText(player2Mark);
                }
                if (label.getText()=="Your turn"){
                    button.setText(player1Mark);
                    compTurn();
                }
                }


        if (gameMode != "AI"){


        {
            if (label.getText()=="Player1 turn"){
                label.setText("Player2 turn");
            }
            else {
                label.setText("Player1 turn");
            }
        }
    }

    }


}
class beginGame extends  JFrame{
    public static void destroy(){
        String arg[] = new String[2];
        arg[0]= "eng";
        arg[1]= "low";

        main(arg);
    }
    String gameMode = "AI";
    static String player1Mark="O", player2Mark="X";
    static boolean compWinStrategy = true;

    static final String[] markArray = {"X", "O"};
    public static void randomStrategy(){
        Random random = new Random();
        int index = random.nextInt(markArray.length);
        if (index == 1){
            compWinStrategy = true;
        }
        else {
            compWinStrategy = false;
        }
    }
    public static void randomMark(){
        Random random = new Random();
        int index = random.nextInt(markArray.length);
        player1Mark = (markArray[index]);
        if (player1Mark == "X"){
            player2Mark = "O";
        }
        else
        {
            player2Mark = "X";
        }
    }
    public static void main(String[] args) {
        tictactoeInterface game = new tictactoeInterface();
        randomMark();
        randomStrategy();
    }
}
