//Name: Joshua Rony
//CruzID: jrony
//Class: CMPS101
//Assignment Name: pa3

import java.util.*;

import java.lang.*;

import java.io.*;

public class Sparse {

    public Scanner s;

    public PrintWriter printWrite;

    private boolean flag = false;

    private int marker;

    public int lineCount = 0;

    private String str;

    public Matrix A;

    public Matrix B;

    public void openInputFile(String str){

        try {

            s = new Scanner(new File(str));

        } catch (Exception e) {

            System.out.println("Could not find file." + System.getProperty("user.dir"));
        }
    }

    public void openOutputFile(String str){

        try{

            printWrite = new PrintWriter(new FileWriter(str));
        }

        catch(Exception e){

            System.out.println("Could not find file." + System.getProperty("user.dir"));
        }
    }

    public void writeString(String str){

        printWrite.print(str);
    }

    public void writeMatrices(Matrix M){

        for(int x = 0; x < M.getSize(); x++){

            if(M.arrayOfLists[x].length() > 0) {

                //printWrite.println(" ");

                printWrite.print((x + 1) + ":");

                M.arrayOfLists[x].moveFront();

                for (int y = 0; y < M.arrayOfLists[x].length(); y++) {

                    String input = M.arrayOfLists[x].get().toString();

                    printWrite.print(input);

                    M.arrayOfLists[x].moveNext();
                }

                printWrite.println("\r\n");

            }

        }

        printWrite.println("\r\n");
    }

    public void closeInputFile(){

        s.close();
    }

    public void closeOutputFile(){

        printWrite.close();
    }

    public void createMatrices() {

        while (s.hasNextLine()) {

            String a = s.nextLine();

            if(lineCount > 1 && a.isEmpty()){

                flag = true;

                marker = lineCount;
            }

            if (lineCount == 0) {

                str = a.substring(0, a.indexOf(" "));

                int matrixSize = Integer.parseInt(str);

                A = new Matrix(matrixSize);

                B = new Matrix(matrixSize);

            }

            if(lineCount > 1 && flag == false) {

                String[] params = a.split(" ");//params[0] = row; params[1] = column; params[2] = value

                A.changeEntry(Integer.parseInt(params[0]), Integer.parseInt(params[1]), Double.parseDouble(params[2]));

            }

            if(lineCount > marker && flag == true){

                String[] params = a.split(" ");

                B.changeEntry(Integer.parseInt(params[0]), Integer.parseInt(params[1]), Double.parseDouble(params[2]));
            }

            lineCount++;
        }
    }

    public static void main(String[] args) {

        Sparse connect = new Sparse();

        connect.openInputFile(args[0]);

        connect.createMatrices();

        connect.closeInputFile();

        connect.openOutputFile(args[1]);

        connect.writeString("A has " + connect.A.getNNZ() + " non-zero entries:\r\n");

        connect.writeMatrices(connect.A);

        connect.writeString("B has " + connect.B.getNNZ() + " non-zero entries:\r\n");

        connect.writeMatrices(connect.B);

        connect.writeString("(1.5)*A =\r\n");

        connect.writeMatrices(connect.A.scalarMult(1.5));

        connect.writeString("A+B =\r\n");

        connect.writeMatrices(connect.A.add(connect.B));

        connect.writeString("A+A =\r\n");

        connect.writeMatrices(connect.A.add(connect.A));

        connect.writeString("B-A =\r\n");

        connect.writeMatrices(connect.B.sub(connect.A));

        connect.writeString("A-A =\r\n");

        connect.writeMatrices(connect.A.sub(connect.A));

        connect.writeString("Transpose(A) =\r\n");

        connect.writeMatrices(connect.A.transpose());

        connect.writeString("A*B =\r\n");

        connect.writeMatrices(connect.A.mult(connect.B));

        connect.writeString("B*B =\r\n");

        connect.writeMatrices(connect.B.mult(connect.B));

        connect.closeOutputFile();

    }

}