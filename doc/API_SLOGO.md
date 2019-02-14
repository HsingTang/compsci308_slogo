API_SLOGO
===
##### ht114, dt135, mmg53, el172

1. When does parsing need to take place and what does it need to start properly?
    Parsing needs to take place at the time of 'execution', which would either be pressing a button, line-by-line, or after a certain number of lines. Parsing requires some type of user input/command formatted properly.
    
2. What is the result of parsing and who receives it?
    Parsed input should not go directly to the backend program. Rather, it should be packaged into a separate class that will be read by some interpreting program that defines the turtle's motions or executes the operation. 
    
3. When are errors detected and how are they reported?
    Commands that aren't 'readable' by the parsing program will cause an error. The readability will be defined by the available commands. To report the error, it would be effective to develop a new Exception class that throws this error to the frontend which visualizes the error in a form of an alert that allows the user to revise their input.
    
4. What do commands know, when do they know it, and how do they get it?
    Commands know when they are called and any additional parameters (speed, direction, etc.). They receive this information when the input is parsed into a package, delivered to the backend, and these methods are called on the application. They get it from a class that interprets parsed input.
    
5. How is the GUI updated after a command has completed execution?
    After each command, parameters (location, speed) that have been changed in the backend will be reflected visually.