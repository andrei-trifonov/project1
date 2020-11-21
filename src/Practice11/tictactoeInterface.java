package Practice11;



import javax.swing.*;
import java.awt.*;
import java.awt.desktop.AppEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
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
        ArrayList<JButton> field = new ArrayList<JButton>();
        field.add(button2);
        field.add(button4);
        field.add(button5);
        field.add(button3);
        field.add(button6);
        field.add(button7);
        field.add(button1);
        field.add(button8);
        field.add(button9);
        setContentPane(panel1);
        setVisible(true);
        setMinimumSize(new Dimension(200, 200));
        setMaximumSize(new Dimension(500,500));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        turnName.setText("Your turn");
        if (player2Mark == "X") {
            System.out.println("У компа X");
            compTurn(field, turnName);
        }
        mode.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                for (int i=0;i<field.size();i++) {
                    field.get(i).setText("");
                }
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
                    if (player2Mark == "X")
                        compTurn(field, turnName);
                }
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doTurn(button1, turnName, field);
                VictoryCheck(field, turnName);
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doTurn(button2, turnName, field);
                VictoryCheck(field, turnName);
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doTurn(button3, turnName, field);
                VictoryCheck(field, turnName);
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doTurn(button4, turnName, field);
                VictoryCheck(field,turnName);
            }
        });
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doTurn(button5, turnName, field);
                VictoryCheck(field, turnName);
            }
        });
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doTurn(button6, turnName, field);
                VictoryCheck(field, turnName);
            }
        });
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doTurn(button7, turnName, field);
                VictoryCheck(field, turnName);
            }
        });
        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doTurn(button8, turnName, field);
                VictoryCheck(field, turnName);
            }
        });
        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doTurn(button9, turnName, field);
                VictoryCheck(field, turnName);
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


}
class Service extends beginGame{
    void VictoryCheck(ArrayList<JButton> field, JLabel turnName){
        if (field.get(0).getText()==field.get(4).getText() && field.get(0).getText() == field.get(8).getText()){
            checkWinner(field.get(0), turnName);
        }
        if (field.get(6).getText()==field.get(4).getText() && field.get(6).getText() == field.get(2).getText()){
            checkWinner(field.get(6), turnName);
        }
        if (field.get(0).getText()==field.get(1).getText() && field.get(0).getText() == field.get(2).getText()){
            checkWinner(field.get(0), turnName);
        }
        if (field.get(3).getText()==field.get(4).getText() && field.get(3).getText() == field.get(5).getText()){
            checkWinner(field.get(3), turnName);
        }
        if (field.get(6).getText()==field.get(7).getText() && field.get(6).getText() == field.get(8).getText()){
            checkWinner(field.get(6), turnName);
        }
        if (field.get(0).getText()==field.get(3).getText() && field.get(0).getText() == field.get(6).getText()){
            checkWinner(field.get(0), turnName);
        }
        if (field.get(1).getText()==field.get(4).getText() && field.get(1).getText() == field.get(7).getText()){
            checkWinner(field.get(1), turnName);
        }
        if (field.get(2).getText()==field.get(5).getText() && field.get(2).getText() == field.get(8).getText()){
            checkWinner(field.get(2), turnName);
        }
        int n=0;
        for (int i=0;i<9;i++)
        {

            if(field.get(i).getText()!="") {
                n++;
            }
        }
        if (n==9){
            checkWinner(turnName);
        }
    }

    public int randomCell(int n){
        Random random = new Random();
        return random.nextInt(n);
    }
    public  int putMask(ArrayList<JButton> field, int a, int b, int c){
        int num=999, j=0;
        boolean aBool=false, bBool=false, cBool=false;
        if (field.get(a).getText()==player1Mark){
            aBool=true;
            j++;
        }
        if (field.get(b).getText()==player1Mark){
            bBool=true;
            j++;
        }
        if (field.get(c).getText()==player1Mark){
            cBool=true;
            j++;
        }
        if (j==2){
            if (aBool==false && field.get(a).getText()!=player2Mark)
                num =  a;
            if (bBool==false && field.get(b).getText()!=player2Mark)
                num =  b;
            if (cBool==false && field.get(c).getText()!=player2Mark)
                num =  c;
        }
     return num;
    }
    public  int putCompMask(ArrayList<JButton> field, int a, int b, int c){
        int num=999, j=0;
        boolean aBool=false, bBool=false, cBool=false;
        if (field.get(a).getText()==player2Mark){
            aBool=true;
            j++;
        }
        if (field.get(b).getText()==player2Mark){
            bBool=true;
            j++;
        }
        if (field.get(c).getText()==player2Mark){
            cBool=true;
            j++;
        }
        if (j==2){
            if (aBool==false && field.get(a).getText()!=player1Mark)
                num =  a;
            if (bBool==false && field.get(b).getText()!=player1Mark)
                num =  b;
            if (cBool==false && field.get(c).getText()!=player1Mark)
                num =  c;
        }
        return num;
    }
    public  void compTurn(ArrayList<JButton> field, JLabel turnName){
        int n=0;
        for (int i=0;i<field.size();i++) {
            if(field.get(i).getText()==player1Mark){
             n++;
            }
        }
        if (n<2){
            int rnd= randomCell(9);
            if (field.get(rnd).getText() == ""){
                field.get(rnd).setText(player2Mark);}
            else {
                int t=1;
                while (field.get(rnd).getText() != "") {
                    rnd = randomCell(9);
                    if (field.get(rnd).getText() == "") {
                        field.get(rnd).setText(player2Mark);
                        break;
                    }
                    if (t==9)
                        break;
                }
            }

        }
        if (n>=2){
            boolean isTurn=false;
            if (putCompMask(field,0,1, 2)!=999){
                field.get(putCompMask(field,0,1, 2)).setText(player2Mark);
                isTurn = true;
            }
            if (putCompMask(field,3,4, 5)!=999 && isTurn!=true){
                field.get(putCompMask(field,3,4, 5)).setText(player2Mark);
                isTurn = true;
            }
            if (putCompMask(field,6,7, 8)!=999 && isTurn!=true){
                field.get(putCompMask(field,6,7, 8)).setText(player2Mark);
                isTurn = true;
            }
            if (putCompMask(field,0,3, 6)!=999 && isTurn!=true){
                field.get(putCompMask(field,0,3, 6)).setText(player2Mark);
                isTurn = true;
            }
            if (putCompMask(field,1,4, 7)!=999 && isTurn!=true){
                field.get(putCompMask(field,1,4, 7)).setText(player2Mark);
                isTurn = true;
            }
            if (putCompMask(field,2,5, 8)!=999 && isTurn!=true){
                field.get(putCompMask(field,2,5, 8)).setText(player2Mark);
                isTurn = true;

            }
            if (putCompMask(field,0,4, 8)!=999 && isTurn!=true){
                field.get(putCompMask(field,0,4, 8)).setText(player2Mark);
                isTurn = true;
            }
            if (putCompMask(field,6,4, 2)!=999 && isTurn!=true){
                field.get(putCompMask(field,6,4, 2)).setText(player2Mark);
                isTurn = true;
            }
            if (isTurn == false){
            boolean isParry=false;
            if (putMask(field,0,1, 2)!=999){
                field.get(putMask(field,0,1, 2)).setText(player2Mark);
                isParry = true;
            }
            if (putMask(field,3,4, 5)!=999 && isParry!=true){
                field.get(putMask(field,3,4, 5)).setText(player2Mark);
                isParry = true;
            }
            if (putMask(field,6,7, 8)!=999 && isParry!=true){
                field.get(putMask(field,6,7, 8)).setText(player2Mark);
                isParry = true;
            }
            if (putMask(field,0,3, 6)!=999 && isParry!=true){
                field.get(putMask(field,0,3, 6)).setText(player2Mark);
                isParry = true;
            }
            if (putMask(field,1,4, 7)!=999 && isParry!=true){
                field.get(putMask(field,1,4, 7)).setText(player2Mark);
                isParry = true;
            }
            if (putMask(field,2,5, 8)!=999 && isParry!=true){
                field.get(putMask(field,2,5, 8)).setText(player2Mark);
                isParry = true;

            }
            if (putMask(field,0,4, 8)!=999 && isParry!=true){
                field.get(putMask(field,0,4, 8)).setText(player2Mark);
                isParry = true;
            }
            if (putMask(field,6,4, 2)!=999 && isParry!=true){
                field.get(putMask(field,6,4, 2)).setText(player2Mark);
                isParry = true;
            }
             if (isParry == false) {
                 int rnd= randomCell(9);
                 if (field.get(rnd).getText() == ""){
                     field.get(rnd).setText(player2Mark);}
                 else {
                     int t=1;
                     while (field.get(rnd).getText() != "") {
                         rnd = randomCell(9);
                         t++;
                         if (field.get(rnd).getText() == "") {
                             field.get(rnd).setText(player2Mark);
                             break;
                         }
                         if (t==9)
                             break;
                     }
                 }
             }
            }
        }
            VictoryCheck(field, turnName);

        }

    void  checkWinner (JLabel label){
        label.setText("Draw");
    }
    void  checkWinner (JButton button, JLabel label){
        if (button.getText()== player1Mark){
            label.setText("Player 1 won");

            }
        if (button.getText()== player2Mark){

            label.setText("Player 2 won");}

    }
    public void doTurn(JButton button, JLabel label, ArrayList<JButton> field){

        if ((button.getText() == "") && label.getText()!="Player 1 won" && label.getText()  != "Player 2 won" && label.getText()  != "Draw"){

                if (label.getText() == "Player1 turn"){
                    button.setText(player1Mark);

                }
                if (label.getText()=="Player2 turn"){
                    button.setText(player2Mark);
                }
                if (label.getText()=="Your turn"){
                    button.setText(player1Mark);
                    compTurn(field, label);
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
    static String gameMode;
    static String player1Mark, player2Mark;
    static boolean compWinStrategy = true;

    static final String[] markArray = {"X", "O"};
    public static void randomStrategy(){
        Random random = new Random();
        int index = random.nextInt(2);
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
        if (player1Mark == "O"){
            player2Mark = "X";
        }

    }
    public static void main(String[] args) {
        randomMark();
        randomStrategy();
        gameMode = "AI";
        tictactoeInterface game = new tictactoeInterface();

    }
}
