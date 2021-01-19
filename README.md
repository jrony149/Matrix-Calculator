# Matrix-Calculator
Repo for sparse matrix calculator

Matrix Calculator 
Takes advantage of matrix sparsity in order to more efficiently calculate the product, sum, or difference of two matrices.  

In order to utilize matrix calculator application:   

Simply type "make" into terminal.  This will build the application.  
To run the application, type "java Sparse <name_of_your_input_file> <name_of_your_output_file> <scalar_value>".  
If any of the command line arguments are omitted, the application will not run.  
The application will direct all output to the outputfile, i.e., command line arg 1.  
Once application has completed running, check the output file for your output.  
The top level file will simply demonstrate the capabilities of the Matrix class on the two matrices you provide, let's call them A and B by:  
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



