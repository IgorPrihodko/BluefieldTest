# BluefieldTest
Simple calculator for two Big Numbers.
General Task : Calculate mutiplication.
"Write a program which computes the multiplication of two large numbers (integers) entered as command line arguments. 
Each number can have any number of digits (up to the maximum length of a CLI argument, try at least 20 digits for each).
It is mandatory to provide two implementations of the algorithm computing the multiplication (one of them can use
e.g.: BigInteger class another one should implement the algorithm from scratch).
Program must allow to choose one of the implementations by arguments.
It is also mandatory to implement at least one unittest which computes multiplication using both algorithms for
the same inputs and compares results which must be equal.
E.g. for 12345678901234567890*11111111111111111111:
$ ./multiply.sh --alg1 12345678901234567890 11111111111111111111  Result = 137174210013717420998628257899862825790."
 
For starting program from desktop, need to create file multiply.sh and paste there following code:
#!/bin/bash
##directory where jar file is located    
dir=/directory/where/jar/file/is/located
##jar file name
jar_name=testforbluefieldtech-1.0-SNAPSHOT-jar-with-dependencies.jar
java -jar $dir/$jar_name $1 $2 $3
