//Name: Joshua Rony
//CruzID: jrony
//Class: CMPS101
//Assignment Name: pa3


@SuppressWarnings("overrides")



public class Matrix{

    List[] arrayOfLists;

    private int size;

    private int nonZeroEntries;

    private class Entry{

        public int column;

        public double value;

        //Constructor for inner Entry class:

        public Entry(){

            column = 1;

            value = 0;
        }

        public String toString(){

            return("(" + column + ", " + value + ")");
        }
    }

    //Constructor for Matrix class:

    public Matrix(int n) {

        size = n;

        nonZeroEntries = 0;

        arrayOfLists = new List[size]; //Dynamically creates array of n List objects

        for (int x = 0; x < size; x++) {//This loop creates a new List() for each element in 'arrayOfLists[]'.

            arrayOfLists[x] = new List();

        }

    }


    //Access Functions


    int getSize(){

        return(size);
    }

    int getNNZ(){

        return(nonZeroEntries);
    }

    public boolean equals(Object x){

        Matrix M = (Matrix)x;

        Matrix Mcopy = M.copy();

        Entry temp = new Entry();

        Entry temp2 = new Entry();

        if(M.getNNZ() != getNNZ() || M.getSize() != getSize()){

            return(false);
        }

        if((getNNZ() == 0 && M.getNNZ() == 0) && (getSize() == M.getSize())){

            return(true);
        }

        else{

            for(int z = 0; z < M.getSize(); z++){

                if(arrayOfLists[z].length() != M.arrayOfLists[z].length()){

                    return(false);
                }

                arrayOfLists[z].moveFront();

                Mcopy.arrayOfLists[z].moveFront();

                while(arrayOfLists[z].index() != -1){

                    temp = (Entry)arrayOfLists[z].get();

                    temp2 = (Entry)Mcopy.arrayOfLists[z].get();

                    if(temp.value != temp2.value || temp.column != temp2.column){

                        return(false);
                    }

                    arrayOfLists[z].moveNext();

                    Mcopy.arrayOfLists[z].moveNext();

                }
            }
        }

        return(true);

    }


    //Manipulation procedures


    void makeZero(){

        for(int x = 0; x < size; x++){

            arrayOfLists[x].clear();
        }

        nonZeroEntries = 0;
    }

    Matrix copy(){

        Matrix Copy = new Matrix(size);

        for(int x = 0; x < size; x++){

            arrayOfLists[x].moveFront();

            for(int y = 0; y < arrayOfLists[x].length(); y++){

                Entry temp = new Entry();

                temp = (Entry)arrayOfLists[x].get();

                Copy.changeEntry(x + 1, temp.column, temp.value);

                arrayOfLists[x].moveNext();
            }
        }

        return(Copy);
    }

    void Print(){

        if(nonZeroEntries > 0) {

            System.out.println("This matrix has " + nonZeroEntries + " non zero entries:\n");

            for (int x = 0; x < size; x++) {

                arrayOfLists[x].moveFront();

                for (int y = 0; y < arrayOfLists[x].length(); y++) {

                    Entry temp = new Entry();

                    temp = (Entry) arrayOfLists[x].get();

                    System.out.print("(" + temp.column + ", " + temp.value + ")  ");

                    arrayOfLists[x].moveNext();
                }

                System.out.println("\n");

            }

        }
    }

    void changeEntry(int i, int j, double x) {

        //i = row = arrayOfLists[i - 1]

        if(i < 1){

            throw new RuntimeException("Matrix module changeEntry() method cannnot insert new value to non-existent row.\n");
        }

        if(i > size){


            throw new RuntimeException("Matrix module changeEntry() method cannot insert new value to non-existent row.\n");
        }

        if(j < 1){

            throw new RuntimeException("Matrix module changeEntry() method cannnot insert new value to non-existent row.\n");
        }

        if(j > size){

            throw new RuntimeException("Matrix module changeEntry() method cannot insert new value to non-existent row.\n");
        }

        Entry temp = new Entry(); //the object to be inserted.

        temp.column = j;

        temp.value = x;

        if (arrayOfLists[i - 1].length() == 0) {

            if(temp.value != 0.0) {

                arrayOfLists[i - 1].append(temp);

                nonZeroEntries = nonZeroEntries + 1;

            }
        }

        else {

            arrayOfLists[i - 1].moveFront();

            Entry temp2 = new Entry();//Comparison element

            temp2 = (Entry) arrayOfLists[i - 1].get();

            while (j > temp2.column && temp2 != (Entry)arrayOfLists[i - 1].back()) {

                arrayOfLists[i - 1].moveNext();

                temp2 = (Entry) arrayOfLists[i - 1].get();

            }

            if(j > temp2.column && temp2 == (Entry)arrayOfLists[i - 1].back()){

                if(temp.value != 0.0) {

                    arrayOfLists[i - 1].insertAfter(temp);

                    nonZeroEntries = nonZeroEntries + 1;
                }
            }

            else if(j < temp2.column) {

                if(temp.value != 0.0) {

                    arrayOfLists[i - 1].insertBefore(temp);

                    nonZeroEntries = nonZeroEntries + 1;

                }

            }

            else if(j == temp2.column){

                if(temp.value != 0.0){

                    arrayOfLists[i - 1].insertAfter(temp);

                    arrayOfLists[i - 1].delete();
                }

                if(temp.value == 0.0){

                    arrayOfLists[i - 1].delete();

                    nonZeroEntries = nonZeroEntries - 1;


                }


            }

        }

    }

    Matrix scalarMult(double x){

        Matrix scalarMult = new Matrix(size);

        for(int z = 0; z < size; z++){

            arrayOfLists[z].moveFront();

            for(int y = 0; y < arrayOfLists[z].length(); y++){

                double input;

                Entry temp = new Entry();

                temp = (Entry)arrayOfLists[z].get();

                input = temp.value * x;

                scalarMult.changeEntry(z + 1, temp.column, input);

                arrayOfLists[z].moveNext();
            }
        }

        return(scalarMult);
    }

   private List listAddSub(List P, List Q, int flag){//helper method for add() and sub()

        List output = new List();

       P.moveFront();

       Q.moveFront();

       Entry temp = (Entry)P.get();

       Entry temp2 = (Entry)Q.get();

        if(flag == 0){

            while(P.index() != -1 || Q.index() != -1){

                if(P.index() != -1) {

                    temp = (Entry) P.get();

                }

                if(Q.index() != -1) {

                    temp2 = (Entry) Q.get();

                }

                if(P.index() != -1 && Q.index() == -1){

                    output.append(temp);

                    P.moveNext();
                }

                else if(P.index() == -1 && Q.index() != -1){

                    output.append(temp2);

                    Q.moveNext();
                }

                else if(temp.column == temp2.column){

                    Entry temp3 = new Entry();

                    temp3.column = temp.column;

                    temp3.value = temp.value + temp2.value;

                    if(temp3.value != 0.0) {

                        output.append(temp3);

                    }

                    P.moveNext();

                    Q.moveNext();
                }

                else if(temp.column < temp2.column && P.index() != -1 && Q.index() != -1){

                    output.append(temp);

                    P.moveNext();
                }

                else if(temp2.column < temp.column && P.index() != -1 && Q.index() != -1){

                    output.append(temp2);

                    Q.moveNext();
                }
            }
        }

        if(flag == 1){

            while(P.index() != -1 || Q.index() != -1){

                if(P.index() != -1) {

                    temp = (Entry) P.get();

                }

                if(Q.index() != -1) {

                    temp2 = (Entry) Q.get();

                }

                if(P.index() != -1 && Q.index() == -1){

                    output.append(temp);

                    P.moveNext();
                }

                else if(P.index() == -1 && Q.index() != -1){

                    Entry input = new Entry();

                    input.column = temp2.column;

                    input.value = -1.0 * temp2.value;

                    output.append(input);

                    Q.moveNext();
                }

                else if(temp.column == temp2.column){

                    Entry temp3 = new Entry();

                    temp3.column = temp.column;

                    temp3.value = temp.value + (-1.0 * temp2.value);

                    if(temp3.value != 0.0) {

                        output.append(temp3);
                    }

                    P.moveNext();

                    Q.moveNext();
                }

                else if(temp.column < temp2.column && P.index() != -1 && Q.index() != -1){

                    output.append(temp);

                    P.moveNext();
                }

                else if(temp2.column < temp.column && P.index() != -1 && Q.index() != -1){

                    Entry input = new Entry();

                    input.column = temp2.column;

                    input.value = -1.0 * temp2.value;

                    output.append(input);

                    Q.moveNext();
                }

            }
        }

        return(output);

    }

    Matrix add(Matrix M){

        if(size != M.getSize()){

            throw new RuntimeException("Matrix module add() method cannot add two Matrices of differing sizes.\n");
        }

        if(equals(M) == true){

            return(scalarMult(2.0));
        }

        Matrix Add = new Matrix(size);

       for(int x = 0; x < size; x++){

           if(arrayOfLists[x].length() != 0 && M.arrayOfLists[x].length() != 0){

               List input = listAddSub(arrayOfLists[x], M.arrayOfLists[x], 0);

               input.moveFront();

               Entry temp = new Entry();

               for(int y = 0; y < input.length(); y++){

                   temp = (Entry)input.get();

                   Add.changeEntry(x + 1, temp.column, temp.value);

                   input.moveNext();
               }
           }

           if(arrayOfLists[x].length() != 0 && M.arrayOfLists[x].length() == 0){

               Entry temp = new Entry();

               arrayOfLists[x].moveFront();

               while(arrayOfLists[x].index() != -1){

                   temp = (Entry)arrayOfLists[x].get();

                   Add.changeEntry(x + 1, temp.column, temp.value);

                   arrayOfLists[x].moveNext();

               }
           }

           if(arrayOfLists[x].length() == 0 && M.arrayOfLists[x].length() != 0){

               Entry temp = new Entry();

               M.arrayOfLists[x].moveFront();

               while(M.arrayOfLists[x].index() != -1){

                   temp = (Entry)M.arrayOfLists[x].get();

                   Add.changeEntry(x + 1, temp.column, temp.value);

                   M.arrayOfLists[x].moveNext();
               }
           }
       }

        return(Add);

    }

    Matrix sub(Matrix M){

        if(size != M.getSize()){

            throw new RuntimeException("Matrix module sub() method cannot execute subtraction on two Matrices of differing sizes.\n");
        }

        if(equals(M) == true){

            return(add(scalarMult(-1.0)));
        }

        Matrix Sub = new Matrix(size);

        for(int x = 0; x < size; x++){

            if(arrayOfLists[x].length() != 0 && M.arrayOfLists[x].length() != 0){

                List input = listAddSub(arrayOfLists[x], M.arrayOfLists[x], 1);

                input.moveFront();

                Entry temp = new Entry();

                for(int y = 0; y < input.length(); y++){

                    temp = (Entry)input.get();

                    Sub.changeEntry(x + 1, temp.column, temp.value);

                    input.moveNext();
                }
            }

            if(arrayOfLists[x].length() != 0 && M.arrayOfLists[x].length() == 0){

                Entry temp = new Entry();

                arrayOfLists[x].moveFront();

                while(arrayOfLists[x].index() != -1){

                    temp = (Entry)arrayOfLists[x].get();

                    Sub.changeEntry(x + 1, temp.column, temp.value);

                    arrayOfLists[x].moveNext();

                }
            }

            if(arrayOfLists[x].length() == 0 && M.arrayOfLists[x].length() != 0){

                Entry temp = new Entry();

                M.arrayOfLists[x].moveFront();

                double input = 0.0;

                while(M.arrayOfLists[x].index() != -1){

                    temp = (Entry)M.arrayOfLists[x].get();

                    input = -1.0 * temp.value;

                    Sub.changeEntry(x + 1, temp.column, input);

                    M.arrayOfLists[x].moveNext();
                }
            }
        }

        return(Sub);

    }

    Matrix transpose(){

        Matrix transpose = new Matrix(size);

        Entry temp = new Entry();

        for(int x = 0; x < size; x++){

            arrayOfLists[x].moveFront();

            for(int y = 0; y < arrayOfLists[x].length(); y++){

                temp = (Entry)arrayOfLists[x].get();

                if(temp.value != 0.0) {

                    transpose.changeEntry(temp.column, x + 1, temp.value);

                }

                arrayOfLists[x].moveNext();

            }
        }

        return(transpose);
    }

    private double dot(List P, List Q){

        double output = 0.0;

        Entry temp = new Entry();

        P.moveFront();

        Entry temp2 = new Entry();

        Q.moveFront();

        while(P.index() != -1 || Q.index() != -1){

            if(P.index() != -1) {

                temp = (Entry) P.get();
            }

            if(Q.index() != -1) {

                temp2 = (Entry) Q.get();
            }

            if(P.index() != -1 && Q.index() == -1){

                P.moveNext();
            }

            else if(P.index() == -1 && Q.index() != -1){

                Q.moveNext();
            }

            else if(temp.column == temp2.column){

                output = output + (temp2.value * (temp.value));

                P.moveNext();

                Q.moveNext();
            }

            else if(temp.column < temp2.column && P.index() != -1 && Q.index() != -1){

                P.moveNext();
            }

            else if(temp2.column < temp.column && P.index() != -1 && Q.index() != -1){

                Q.moveNext();
            }
        }

        return(output);
    }

    Matrix mult(Matrix M){

        Matrix mult = new Matrix(size);

        for(int x = 0; x < size; x++){

            for(int y = 0; y < size; y++){

                if(arrayOfLists[y].length() != 0 && M.transpose().arrayOfLists[x].length() != 0){

                    double input = dot(arrayOfLists[y], M.transpose().arrayOfLists[x]);

                    if(input != 0.0) {

                        mult.changeEntry(y + 1, x + 1, input);

                    }
                }
            }
        }

        return(mult);
    }


    //Other functions


    public String toString(){

        String str = "";

        for(int x = 0; x < size; x++){

            if(arrayOfLists[x].length() != 0){

                str = str + ((x + 1) + ":" + arrayOfLists[x] + "\n");
            }
        }

        return(str);
    }
}