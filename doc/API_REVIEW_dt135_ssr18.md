API DESIGN REVIEW
=================

_dt135 (Duc) and ssr18 (Samuel)_

### Part 1

One potential issue that I noticed with my current API design is adding new features. For adding new commands, our current 
design is to add new methods to the correct Calculation class, but this might lead to more hard coded strings, which is
bad design. Additionally, I haven't thought about the situation of adding/handling turtles in our program. Thinking about
right now, I think out master class will have to hold a list of active turtles and after parsing a command, we will loop
through a command tree for each active turtle. I also didn't really think about error handling but after the discussion 
me and my partner decided there are going to be two general types of errors: parsing errors and runtime errors. For parsing
errors, these are errors where the parser encounters wrongly formatted commands. The way I was thinking of handling these 
are by throwing a class that contains a visual element and the error so that when the front end receives the error, it 
can display the error on the window. The next type of errors are runtime errors, or errors that occur when trying to implement
a command. An example is the classic division by zero error. There are going to be a lot of these types of errors but generally,
when the program catches these errors it will throw a class, the exact same class as the one mentioned in handling parsing 
errors. Further API improvements could involve how our command node is constructed. Right now, they are very generic and only
hold information, but they could be expanded to do more things.

### Part 2

**Use Cases**
1. The user inputs a command while another command is already running.
    * Current idea is to clear the command tree and execute the new command.
2. Creating and Controlling multiple turtles.
    * Having a list of active turtles.
3. The user selects/or inputs an old command.
    * Potentially having a list of old command tree so it will be quicker to access the command tree.
4. The user wishes create their own commands using "To" or "Make Set"
    * The backend needs to keep track of these user defined commands. The command could potentially be a list of commands.
5. The user inputs a command that would cause a run time error.