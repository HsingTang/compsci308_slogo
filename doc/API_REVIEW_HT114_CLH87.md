API_REVIEW
===
##### ht114, clh87
## Part 1
Both people should complete Part 1 before continuing on to Part 2.
#### What about your API/design is intended to be flexible?
* clh87:
We have a method that will take in a String and display an error to the user. This will make it easy for the Backend to throw different and new errors and for the Frontend to catch those and alert the user.
Additionally, we have a method to add a new element to the GUI. If new features are added during Sprint 2, it will be possible to create a new class for that element and then simply call the addElement() method to 
* ht114:
I am planning to implement the JavaFX TabPane feature and create a TurtleFactory class, which provides the interface for creating multiple TurtleViews on the front end. This might not be a must in the first sprint, but will provide enough flexibility for implementing extra feature in the long run.
Additionally, we have separate executioner classes on the back end for handling different types of commands. As the front end consists of several separate components (Console, TurtleView, VariablePane, etc.), the external API of View component will provide channels for executioner classes to communicate with each of the front-end classes separately (TurtleView.setX(), VariablePane.addVariable(), etc).

#### How is your API/design encapsulating your implementation decisions?
* clh87:
We are trying to be careful to separate our front end and back end as thoroughly as possible by making methods public only when absolutely necessary. For example, we have methods to clear the console and to print to the console, but these are the only way the back end can directly change what is seen by the user.

* ht114:
The external API is intended to establish separate channels between different frontend classes with corresponding backend executioner classes, instead of having one main front-end class handling all types of information together.

#### What exceptions (error cases) might occur in your part and how will you handle them (or not, by throwing)?
* clh87:
The backend will throw different exceptions based on errors from the user. For example, if a command is entered that doesn't exist. In the Front End, I will then catch these errors and alert the user with an appropriate message either through an alert box or through printing something on the screen.

* ht114:
The user might upload an non-exist image for the turtle's visualization, which could lead to a FileNotFoundException. The Exception can be handled by creating a SlogoException class, wrapping the FileNotFoundException as a SlogoException, and eventually throwing it to either Master or Window -- one of the main classes on backend or frontend will be responsible for handling all types of Exceptions, probably by popping up alert messages to user.

#### Why do you think your API/design is good (also define what your measure of good is)?
* clh87:
    Our API is setup such that there are core methods available to make changes between classes without allowing access to data internal to the class. For example, the Console Class will have a printToConsole() method which will allow for other classes, if necessary, to communicate directly with the user.
    Additionally, the classes are being divvied up such that adding new features should be doable. For example, adding another element to the GUI will be as simple as either creating a method or class that returns the element and then addElement() can be called such that it appeasrs on the GUI.
* ht114:
    * Extensible to new features
        * The API allows new communication channels between front and back ends to be established easily by adding new classes or functions.
    * Keeping the core classes intact when adding the new features
        * With communication channels being established separately, the main classes of front and back ends (i.e. Window and Master) won't have to change, or at least the changes can be kept to the minimal extent, since the exectioner and front end component classes are actually taking detours from the main classes.

## Part 2
#### How do you think Design Patterns are currently represented in the design or could be used to help improve the design?
* clh87:
    * MVC Pattern
        *  A command is taken in by the Console and then passed back to the Parser/controller. The controller can then update the necessary model or display. For example, we will have a TurtleModel, a VariableModel, etc and each of these models will be linked with a corresponding view (TurtleView, etc). When a model is updated, it will alert the view which will update accordingly.

* ht114:
    * Chain of Responsibility:
        The communication from front end to back end is established by Window (main class of View component) and Master (main class of Model component, i.e. the Controller). There could be multiple independent SlogoTabs in the program, each managing its own commands, variables and TurtleView, and any user inputs will be handed over by SlogoTab to Window, who will then communicate with Master and let Master coordinate with back-end classes to parse and execute the commands. An ID value associated with the SlogoTab where the user input is received will be passed along the way, so that at the end of the chain the backend executioner class who finally handle the command will directly contact the SlogoTab for front-end display of the execution results. With this pattern, when handing out the user input, a SlogoTab does not need to know who will eventually be handling the inputs and can simply wait for being contacted by one of the backend classes at the end.
    * Factory Pattern
        The Factory pattern is implemented for creating multiple TurtleViews, one per SlogoTab. When a SlogoTab is initialized in Window (the main front-end class), Window calls TurtleFactory to obtain a new TurtleView object without any knowledge about the initialization logic. The returned TurtleView is then passed into the constructor of the new SlogoTab, who will take the TurtleView as one of its instance fields without knowing how it's created.
#### What feature/design problem are you most excited to work on?
* clh87:
    Creating the Console view and using panes to setup the visualization. During Breakout, I didn't know that panes existed and I'm excited to try and learn more about them and to use them for formatting the screen.
* ht114:
    Implementing the interaction between TurtleView and Canvas so that a Turtle bot can paint down its trail along the movement path in an animated fashion.
#### What feature/design problem are you most worried about working on?
* clh87:
    Creating the communication between the Models and the View. My group's design was rather vague about this element of the design, because we were hoping we would learn more about binding, and as a result we still have a few ideas floating around. I am worried that if we aren't careful, there will be too many dependencies.
* ht114:
    Implementing communication from the backend to frontend. For transferring user inputs from frontend to backend, we are planning to let everything go through the channel between main classes of front and back ends, while the other way around will be taking detours and establishing separate communication channels, which could be effective and extensible to new features, but might also be potentially messy.
#### Come up with at least five use cases for your part (it is absolutely fine if they are useful for both teams)
* "fd 50"
    * Console reads in command and passes command to backend.
        * clh87: call parse() method on the command to pass it to the backend parser. It will then be interpreted and the Turtle Model will be updated with the new coordinates. The model will then notify the TurtleView. This will then adjust the visual of the turtle and the change will be visible to the user on the GUI.
        * ht114: SlogoTab calls transferCommand() on Window, which then pass the command and TabID to Master through the external API of Model componenet. Master identifies the type of command and invokes corresponding parser (TurtleParser in this case), who will parse the command and transfer information to associated exceturioner class (TurtleController). The executioner will execute the command and directly communicate with Tab (via the TabID) to modify the TurtleView on frontend.
        
* "SetBackground White"
    * clh87: Console reads in commands and passes it back to the parser using the parse() method. The parser will then interpret the command and will be able to directly call a changeBackground() method on the GUI. This method will check that the background is valid and will update the visual accordingly.
    * ht114: SlogoTab reads input from Console, transfers command and its own ID to Window -> Master -> EnvironmentParser -> EnvironmentController. The chain eventually communicates the executioner result by calling setBackground on the SlogoTab where the commands set off in the beginning.
* "XCOR"
    * clh87: The Console will read the input and pass it back to the Parser where it will then be passed to the Turtle Controller to be interpreted. Once it is parsed, the Turtle Controller will call the Turtle Model to retrieve the X coordinate. Lastly, the Turtle Controller will call the Console's printToConsole() method where the value will be displayed.
    * ht114: SlogoTab -> Window -> Master -> TurtleParser -> TurtleController, which eventually invokes getX() on the backend Turtle class (the backend model corresponding to frontend TurtleView) and then passes the retrieved information to frontend SlogoTab for printing the query result to Console.
* "SUM 1 2":
    * clh87: The console will take in the command and pass it back to the Controller. This will then be passed on to the MathController where the appropriate calculations will be performed. Lastly, the Math Controller will call the Console's printToConsole() method to display the value to the user.
    * ht114: SlogoTab -> Window -> Master -> MathParser -> MathCalculator (the executioner for math commands), which invokes method of SlogoTab to print the calculation result to Console.
* "MAKE myVar 20"
    * clh87: The Console will take in the command and pass it to the parser where it will then be passed to the Variables model. It will be added to the storage and the Console will be notified of the change. The Variable View will then be updated as appropriate.
    * ht114: VariablePane of SlogoTab maintains a map of variables & values, which is empty in the beginning. SlogoTab takes the command from Console -> Window -> Master -> VariableParser -> Storage, where the full list of variables is kept. While updating its own data, Storage also notifies SlogoTab for updating the variable map held in its VariablePane, so that the most updated variables will be displayed on the frontend.