# geektrust
Solution for geektrust problem 1 Meet the Family


## Assumptions
  a. I assumed that in family name is unique
  b. As an input to the program, need to send the absoulte path of a file. content is as follows :
  ```
    ADD_CHILD Chitra Aria Female
    GET_RELATIONSHIP Lavnya Maternal-Aunt
    GET_RELATIONSHIP Aria Siblings
    ADD_CHILD Pjali Srutak Male
    GET_RELATIONSHIP Pjali Son
    ADD_CHILD Asva Vani Female
  ```

## Installation
I have used Maven for build and to generate executable jar file use below command
```
  mvn package
```

To run the jar file
```
  java -jar target\geektrust.jar d:\\anil\input.txt
```
