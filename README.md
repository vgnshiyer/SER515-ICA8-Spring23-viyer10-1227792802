# SER515-ICA8-Spring23-viyer10-1227792802

# Before you begin

## Requirements
JDK17 or lower

### Build from Source

**MacOS/Linux**
```
./gradlew build
```

**Windows**
```
./gradlew.bat build
```

**Run the custom-built jar file**
 - Replace `<VERSION>` with the version you built (see the `gradle.properties`
   file)
```
java -jar ./app/build/libs/app-0.1.0.jar
```

**If you have make installed, run**

Build & run
```
make run
```

Build
```
make build
```

Test
```
make test
```

### Message for the grader

- I have followed below test-driven development process as advised in class by Dr. Findler
    1. Write an empty(skeleton) definition for a function
    2. Make a commit to git
    3. Write a relevant test case -> which fails
    4. Write the code which satisfies the test case
    5. Make a final commit for that feature (with relevant commit messages which describes the process followed for that feature)
- I have used a build tool (gradle) for this assignment. The instructions to run them are quite simple if the above commands are properly executed. Highly recommend to use the makefile.

**Additional information on testing**

Please input your test data (urinal sequences) in the below file with path:
```
app/src/main/resources/urinal.dat
```

Outputs will be saved in:
```
output/rule.txt
```
At every consecutive run, it will keep on adding 'rule1.txt', 'rule2.txt' and so on.

In the offchance that you face any difficulty in running my project, please reach out to me on canvas.
Also share your valuable feedback in comments.


##### My commit history for this project to view TDD better
```
7ad3b31 (HEAD -> main, origin/main, origin/HEAD) chore: added description to readme file
b0fa879 chore: added main method definition to allow user to input urinal sequences
0f660ac chore: added multiple testcases for countUrinals function. Added the urinal counter algorithm which passes all test cases.
50135e2 chore: added failing test case for checking the countUrinal functions, Added code to check invalid strings before the actual algorithms
a08c622 feat: added makefile for making it easy to run the project
5ccb1a4 chore: added skeleton code for countUrinal
2473bea chore: added test case for checking adjacent urinals, added code to solve that case
3470eee chore: added test case to check -1 as EOF, and coded solution to pass the testcase
9ef26bf chore: added test case for checking if the scanner is reading the list of urinals properly or not. Added the code for scanning the file and returning a list of urinals
2b43445 chore: added test to see if the filename ends with .dat format. Added code to check that and passed assertions
95d17b9 chore: added test case for testing openFile funtion with nonexisting file. Added code to pass the test case
9c0a387 feat: added empty block for openFile function
ef6f09a chore: added test case for checking a valid string, added code to satisfy the test case
a61940e chore: added test case for checking if the chars in a string is valid or not, added code to satisfy the test case
8b7a43b chore: added failing test case for checking strings with len > 20, added code to pass the test case
daf1579 chore: added code to pass test case 1 -> empty string input
de21a87 chore: added test for checking if the string is empty or not
2e5895a chore: added initial main function for the program
560403a chore: Added initial project file with build tool gradle
d78a7c4 Initial commit
```