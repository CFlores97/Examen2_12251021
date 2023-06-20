package examen2_12251021;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.ArrayList;


public class EXAMEN2_12251021 extends JFrame implements ActionListener {

    private JButton case1;
    private JButton case2;
    private JButton case3;
    private JLabel welcome;

    int[][] genMatrix;
    int[][] oGMatrix;
    ArrayList<Integer> genArrayEven;
    ArrayList<Integer> genArrayOdd;
    

    public EXAMEN2_12251021() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);

        JPanel window = new JPanel();
        window.setBackground(Color.BLACK);
        window.setLayout(null);

        JLabel welcome = new JLabel("Menu");
        welcome.setBounds(230, 10, getWidth(), 30);
        welcome.setFont(new Font("Serif", Font.ITALIC, 20));
        welcome.setForeground(Color.WHITE);

        case1 = new JButton("CREACION");
        case1.setBounds(100, 100, 100, 50);
        case1.addActionListener(this);

        case2 = new JButton("MODIFICAR");
        case2.setBounds(100, 200, 100, 50);
        case2.addActionListener(this);

        case3 = new JButton("SALIR");
        case3.setBounds(100, 300, 100, 50);
        case3.addActionListener(this);

        window.add(welcome);
        window.add(case1);
        window.add(case2);
        window.add(case3);
        add(window);

    }

    public static void main(String[] args) {
        EXAMEN2_12251021 examen = new EXAMEN2_12251021();

    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == case1) {
            int filas = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese un numero de filas"));
            int columnas = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese un numero de columnas"));

            genMatrix = generateMatrix(filas, columnas);
            oGMatrix = generateNewMatrix(genMatrix);

            Matrices matrix = new Matrices(oGMatrix);

            printMatrixJOP(oGMatrix);
        }
        else if (event.getSource() == case2) {
            genArrayEven = genAEven(oGMatrix);
            genArrayOdd = genAOdd(oGMatrix);
            printA(genArrayEven);
            printB(genArrayOdd);

        }
        
        else if(event.getSource() == case3){
            System.exit(0);
        }

    }

    public int[][] generateMatrix(int filas, int columnas) {

        Random ran = new Random();
        int[][] temp = new int[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                temp[i][j] = ran.nextInt(10) + 1;
            }

        }
        return temp;
    }
    
    public int[][] generateNewMatrix(int[][] a) {

        Random ran = new Random();
        int[][] temp = a;
        int num = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                num = ran.nextInt(10) + 1;
                temp[i][j] = num;
                
                if(checkInt(num, a)){
                    temp[i][j] = ran.nextInt(10) + 1;
                }
                
            }

        }
        return temp;
    }

    public void printMatrixJOP(int[][] matrix) {

        String num = "";
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                num += "[" + matrix[i][j] + "]";
            }
            num += "\n";
        }
        JOptionPane.showMessageDialog(null, num, "Matrix original", JOptionPane.INFORMATION_MESSAGE);
    }

    public static ArrayList<Integer> genAEven(int [][] a) {

        ArrayList<Integer> temp = new ArrayList<>();

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if(a[i][j] % 2 == 0){
                    temp.add(a[i][j]);
                }
            }
        }

        return temp;
    }
    
    public static ArrayList<Integer> genAOdd(int [][] a) {

        ArrayList<Integer> temp = new ArrayList<>();
        

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if(a[i][j] % 2 != 0 && a[i][j] != 0){
                    temp.add(a[i][j]);
                    
                }
            }
        }

        return temp;
    }
    
    public static void printA(ArrayList<Integer> a) {
        String num = "";
        for (int ints : a) {
            num += "[" + ints + "]" + "\n";
        }
        JOptionPane.showMessageDialog(null, num, "Arreglo de pares", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void printB(ArrayList<Integer> a) {
        String num = "";
        
        for (Integer ints : a) {
            num += "[" + ints + "]" + "\n";
        }
        
        JOptionPane.showMessageDialog(null, num, "Arreglo de impares", JOptionPane.INFORMATION_MESSAGE);
    }
    
    static boolean checkInt(int num, int[][] matrix) {
        boolean exists = false;
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (num == matrix[i][j]) {
                    exists = true;
                }
                
            }
            
        }
        
        return exists;
    }
    
    //Tuve que reescribir todo para que sea con array, no me dio tiempo de hacer lo dmas ))),: 

}
