# Matrix-Calculator
Repo for sparse matrix calculator

Matrix Calculator 
Takes advantage of matrix sparsity in order to more efficiently calculate the product, sum, or difference of two matrices.  

In order to utilize matrix calculator application:   

Simply type "make" into terminal.  This will build the application.  
To run the application, type "java Sparse <name_of_your_input_file> <name_of_your_output_file> <scalar_value>".  
If any of the command line arguments are omitted, the application will not run.  
The application will derive its input from the file specified in command line arg 0.  
The application will direct all output to the outputfile, i.e., the file specified in command line arg 1.    
Once application has completed running, check the output file for your output.  
The top level file (Sparse.java) will simply demonstrate the capabilities of the Matrix     
class on the two matrices you provide, (let's call them A and B), by:    
-Listing the number of non-zero entries in A.  
-Listing the number of non-zero entries in B.  
-Multiplying matrix A by the scalar your provided as command line arg 2.  
-Adding matrix A and matrix B and outputting the sum matrix.  
-Adding matrix A to itself and outputting the sum matrix.    
-Subtracting matrix A from matrix B and outputting the difference matrix.    
-Subtracting matrix A from itself and outputting the difference matrix (which should be nothing, obviously).    
-Transposing matrix A and outputting the transpose matrix.    
-Multiplying A and B and outputting the product matrix.    
-Mutliplying B and itself and outputting the product matrix.  

Please note that the matrices in the inputfile must be formatted as follows:  

3 9 5  
  
1 1 1.0  
1 2 2.0  
1 3 3.0  
2 1 4.0  
2 2 5.0  
2 3 6.0  
3 1 7.0  
3 2 8.0  
3 3 9.0  
  
1 1 1.0  
1 3 1.0  
3 1 1.0  
3 2 1.0  
3 3 1.0  
  
The above example denotes a pair of matrices. The first line, "3 9 5", denotes the number of rows in both matrix A and matrix B,  
the number of non-zero entries in matrix A, and the number of non-zero entries in matrix B, respectively. The second space in the  
data (between "3 3 9.0" and "1 1 1.0") represents the split between matrix A and matrix B.  The other lines of data represent matrix entries.  
For example, the line "1 1 1.0" denotes the value "1.0" at row 1, column 1 of matrix A.  The output will be formatted thusly:  

A has 9 non-zero entries:  
1: (1, 1.0) (2, 2.0) (3, 3.0)  
2: (1, 4.0) (2, 5.0) (3, 6.0)  
3: (1, 7.0) (2, 8.0) (3, 9.0) 
  
B has 5 non-zero entries:  
1: (1, 1.0) (3, 1.0)    
3: (1, 1.0) (2, 1.0) (3, 1.0)  
  
(1.5)*A =  
1: (1, 1.5) (2, 3.0) (3, 4.5)  
2: (1, 6.0) (2, 7.5) (3, 9.0)  
3: (1, 10.5) (2, 12.0) (3, 13.5)  
  
A+B =  
1: (1, 2.0) (2, 2.0) (3, 4.0)  
2: (1, 4.0) (2, 5.0) (3, 6.0)  
3: (1, 8.0) (2, 9.0) (3, 10.0)
  
A+A =  
1: (1, 2.0) (2, 4.0) (3, 6.0)  
2: (1, 8.0) (2, 10.0) (3, 12.0)  
3: (1, 14.0) (2, 16.0) (3, 18.0)  
  
B-A =  
1: (2, -2.0) (3, -2.0)  
2: (1, -4.0) (2, -5.0) (3, -6.0)  
3: (1, -6.0) (2, -7.0) (3, -8.0)  
  
A-A =  
  
Transpose(A) =    
1: (1, 1.0) (2, 4.0) (3, 7.0)  
2: (1, 2.0) (2, 5.0) (3, 8.0)  
3: (1, 3.0) (2, 6.0) (3, 9.0)  
  
A*B =  
1: (1, 4.0) (2, 3.0) (3, 4.0)  
2: (1, 10.0) (2, 6.0) (3, 10.0)  
3: (1, 16.0) (2, 9.0) (3, 16.0)  
  
B*B =  
1: (1, 2.0) (2, 1.0) (3, 2.0)  
3: (1, 2.0) (2, 1.0) (3, 2.0) 
  
Please note that this application only works for square matrices of equal dimension.  
Happy matrix manipulating!





