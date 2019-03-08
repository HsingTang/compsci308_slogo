Slogo Design
===
##### ht114, dt135, mmg53, el172

# Introduction

This project aims at designing a programming enviroment that parses user input commands, executes the codes, and displays the execution results on the front end. By inputting valid commands, the user will be able to perform some logical/math operations or control a virtual turtle robot's behavior.  

Some of the main goals include developing a nearly closed front end and backend with limited dependencies. The front and and back end are the two major distinctions of the project, the View and Model, respectively. The only dependencies should be the raw text from the command window and the changing properties of the backend. This design would ensure flexibility to add additional features and support of commands.

# Design Overview
* **View**  
    * View.View.Window
    Main class of the front end. Holds all different front end components (View.GUIFeatures.Panes.SlogoCanvas, View.GUIFeatures.Panes.Console , etc.), arrange them on the UI and communicate with Model classes on the back end for displaying user command execution results.
        * Variables:
        myTurtleView
        myCanvas
        myConsole
        myVariablePanel
        myCommandHistoryPanel
        myLanguageChooser
        myAlertPopper
        * Methods:
        updateVariables(name,value)
       updateTurtleView(xpos,ypos,heading,image)
       resetTurtleView()
       setTurtleVisible()
       setTurtleInvisible()
       setPenColor(color)
       setPenSize(size)
       setPenDown()
       setPenUp()
       updateCanvasColor(color)
       clearCanvas()
       printToConsole(String)
    
    * ObjectView
    Projection of back-end objects on the front end. Here it refers to the front-end view of the Turtle. Might extend ImageView class.
        * Variables:
        myXPos
        myYPos
        myXDir
        myYDir
        myImg
        myCanvas
        myTrailColor
        myTrailSize
        * Methods:
        setVisible()
        setInvisible()
        setPenUp()
        setPenDown()
        setImg(image)
        setXPos(x)
        setYPos(y)
        setXDir(x)
        setYDir(y)
        setTrailColor(color)
        setTrailSize(size)
        
    * View.GUIFeatures.Panes.SlogoCanvas
    Where the object view (i.e. Turtle) resides and draws trails.
        * Variables:
        myColor
        * Methods:
        draw()
        clear()
    * View.GUIFeatures.Panes.Console
    Command prompt component where user can type in commands and hit ENTER to confirm executing the commands, as well as where responses to user commands (queries about Turtle position, math calculation, etc.) are displayed to user after execution.
        * Variables:
        myEnterButton
        myText
        * Methods:
        print(String)
    * VariablePanel
    Communicates with the back-end VariableController class and displays the most up-to-date variable values.
        * Variables:
        myVarMap
        * Methods:
        updateVar(name,value)
    * CommandHistoryPanel
    Communicates with the back-end History class and displays a number of historical commands that have been executed.
        * Variables:
        myMaxNum
        myCommands
        * Methods:
        addCommand(String)
    * View.GUIFeatures.Choosers.LanguageChooser
    Allows user to set language.
        * Variables:
        myLanguage
        * Methods:
        setLanguage(language)
    * AlertPopper
    Receive notification from back end to pop up Alerts for invalid user commands.
        * Variables:
        myAlert
        * Methods:
        showAlert()

* **Model**  
    * View.Window
    Main class of the back end as well as of the program. Takes in command from View component (front end), passes commands to Parser, receives parsed commands, passes them to executioner classes, who will be responsible for executing the commands and communicating with front-end components respectively.
    * History
    Stores commands that have been executed.
    * SlogoParser (abstract super class)
    Parses the input line/block commands into valid Java commands. Each concrete subclass implements a specific language.properties file to parse commands in different languages.
        * EnglishParser (concrete class)
        * FrenchParser (concrete class)
        * ChineseParser (concrete class)
        * ... etc.
    * Command (abstract super class)
    Results from Parsers will be returned in Command objects, where each Command object holds its own variables. Each concrete subclass has a "label" indicating the certain operation to be performed.
        * MathCommand (concrete class)
        * LogicCommand (concrete class)
        * ObjectCommand (concrete class)
        * ... etc.
    * CommandController
    Stores Command objects in a tree structure. Each Command will be a node in the tree and has its own parent/child nodes. A parent node will have to receive execution results from all its children nodes to execute its own commands.
    * "Executioner" Classes
        * EnvironmentController
            Changes background color, language, etc.
        * ObjectController
            Controls objects on the canvas (i.e. Turtle only in the first sprint). Handles commands including setting object position & heading, pen up/down, etc. More objects might be added in the next sprint, and each object would need one corresponding controller on the back end.
        * QueryController
            Responds to object queries (i.e. queries regarding the Turtle in the first sprint) regarding object position, heading, etc.
        * MathCalculator
            Handles math operation commands.
        * LogicCalculator
            Handles boolean operation commands.
        * VariableController
            Handles commands that define/modify variable values or define "user-defined commands". Invoke Variables class or UserCommand classes accordingly.
    * Variables
    Stores variables & data structure that have been defined through user commands. All executioner classes would be able to access these variables & data structures based on user commands.
    * UserCommands
    Stores user-defined commands to be executed later.
    * SlogoAlert
    Extends Alert class. Specifically designed to display Alert dialogues to users when invalid commands are input through console. Alert messages should be read in and stored by View.Window, who will initialize the SlogoAlert objects and pass them to AlertPopper on the front end when necessary.
    * Errors
    Extens RuntimeException class. Specifically designed such that Errors can be thrown through layers of callers till they reach View.Window class, who would trigger corresponding SlogoAlerts.

### API Design
* **Internal APIs**
    * View  
    The internal API will be responsible for setting up the display and our GUI. After command execution and reception of new updated state, internal 
    methods will be executed to allow for changes onscreen to happen. So although the external API of the frontend will be responsible for the 
    communication with the backend to receieve new state, internal methods will be called to visually update those states. 
    * Model  
    The internal model API for the model will be responsible for parsing the command received from the front end and turning that command into a more readable/executable format. The internal model will also be responsible for carrying out the command and passing relevent information to different Calculator classes so they can perform the relevent calculation.
    
* **External APIs**
    * View  
    *The external View API is responsible for notifying View.Window on the back end about any user input action, and receiving command execution result from backend executioner classes. The API will includes public methods that allow back-end classes to retrieve or modify fields held in front-end classes.*
    * Model  
    *The external model API will be responsible to communicate the changes made to the backend by the command line back to the front end in the form of updated properties of nodes of the GUI. This API will be in the form of getter methods of controllers. These getter methods access the properties continously changed by the API. This serves the functionality of the program with limited dependencies as the frontend can only access what must be changed about the display of the JavaFX nodes*


# User Interface
### GUI Components
![GUI Design](https://i.imgur.com/zBtXCOj.png)

The GUI will consist of the following visualizaiton components:
* View.GUIFeatures.Panes.Console
Place where the user can type in Slogo commands in lines or blocks. The input command will not be transferred to back end and get processed until user hit ENTER on the keyboard or press a 'Excute' button in the console component.
* Language chooser
Place where the user can make choice of the command language. The chooser will be in the form of a dropdown menu, with which the user can click on one of the selections.
* VariablePanel
Place where all variables that have been defined by user will be displayed in [name | value] pairs.
* CommandHistoryPanel
Place where past commands that have been input and executed by the user will be displayed.
* Help Button
If the user clicks on the button, the program shall display the URL link to the 308 course website's "Slogo Basic Commands" page, or trigger the user's browser to directly open the webpage (final implementation choice depends on the technical difficulty).

### Expected Erroneous Situations
If any erroneous situation occurs with invalid user input commands, the View.Window class on the back end will trigger the AlertPopper on the front end by passing in the appropriate SlogoAlert object, with which AlertPopper will be able to display an Alert dialogue to user with messages such as "Undefined variable", "Command not found", etc.


# API Details 

### View Internal API
* Supported Features
    * ObjectView
    Projection of back-end objects on the front end. Here it refers to the front-end view of the Turtle. 
        * Variables:
        myXPos
        myYPos
        myXDir
        myYDir
        myImg
        myCanvas
        myTrailColor
        myTrailSize
        * Methods:
        setVisible()
        setInvisible()
        setPenUp()
        setPenDown()
        setImg(image)
        setXPos(x)
        setYPos(y)
        setXDir(x)
        setYDir(y)
        setTrailColor(color)
        setTrailSize(size)
        
    * View.GUIFeatures.Panes.SlogoCanvas
    Where the object view (i.e. Turtle) resides and draws trails.
        * Variables:
        myColor
        * Methods:
        draw()
        clear()
    * View.GUIFeatures.Panes.Console
    Command prompt component where user can type in commands and hit ENTER to confirm executing the commands, as well as where responses to user commands (queries about Turtle position, math calculation, etc.) are displayed to user after execution.
        * Variables:
        myEnterButton
        myText
        * Methods:
        print(String)
        setText();
        getText();
        clearText(); erases the consoles text

* Resource Requirement
Language property files, image files (if necessary for different buttons). 

* Extension
Easy to add on features internally, given that there would be no need to synchronize communication with the backend. Can implement new classes
that represent new features to add on internally. 

### Model Internal API
* Supported Features
    * Parser
        * checkEmpty()
        * removeCommentsAndSpaces(); returns a list of strings so going through each word will be easier
        * createCommands()
    * CommandController
        * Constructor()
        * executeCommand()
    * ObjectController
        * AnyMovementMethod((x_pos, y_pos) or distance)
    * MathController
        * AnyOperation(value_1, value_2, etc.)
        * randomNum(max)
        * Sin->Atan(degree)
        * power(exponent)
        * log(value)
    * LogicController
        * AnyBooleanOperation(value1, value2)
    * UserCommandController
        * setNewCommand(command)
        * checkUserCommandList()
    * VariableController
        * setNewVariable(Variable)
        * checkUserVariableList()

* Resource Requirement: We will need the Java.Math api and potentially the ImageView class or whatever class the ObjectController uses to display itself.

* Extension: For any additional math, movement, and boolean operation those can be added as additional methods. For more complex commands, new Handlers classes might have to be created.

### View External API
The View.View.Window class holds all the front-end components except for Alert dialogues, and will be the only channel for View to communicate with Model. After receiving arguments through the external API, View.View.Window will distribute the tasks internally to corresponding front-end components.
* Supported Features
    * View.View.Window
        * updateVariables(name,value)
        * updateTurtleView(xpos,ypos,heading,image)
        * resetTurtleView()
        * setTurtleVisible()
        * setTurtleInvisible()
        * setPenColor(color)
        * setPenSize(size)
        * setPenDown()
        * setPenUp()
        * updateCanvasColor(color)
        * clearCanvas()
        * printToConsole(String)
    * AlertPopper
        * showAlert()
    * CommandWrapper
        * wrapText();
        * getCommands();
* Resource Requirement
Language properties files are be required for the language choosing feature. After the user has selected a command language, corresponding .properties file will beloaded by the program.  
Additionally, AlertPopper will receive SlogoAlert objects from View.Window if any errorneous situation occurs, after which the showAlert() call will be invoked for displaying alert dialogues to user on the front end. The Alert messages are expected to read from a source file for avoiding hard-coding.
* Extension
For new features/components to be added, the corresponding front-end component will need to be added as a field to the View.View.Window class, where specific functions will also be developed in order for corresponding back-end classes to acquire control of the new feature and affect its front-end display.

### Model External API
The model's external API will consist of methods from a series of controllers used in the model/backend. These controllers, EnvironmentController, ObjectController, MathController, LogicController, QueryController, UserCommandController, and VariableControlller, hold values and methods updated and called upon by commands. These values drive updates in the View/frontend.
* Supported Features
    * EnvironmentController
        * getPenColor()
        * getBackgroundColor()
    * ObjectController
        * getImage()
        * getRotate()
        * getX()
        * getY()
        * getPen()
        * getVisible()
        * getCleared()
        * getHome()
    * MathController
        * getValue()
    * LogicController
        * getValue()
    * QueryController
        * getValue()
    * UserCommandController
        * getCreated()
    * VariableController
        * getDefined()
* Resource Requirement: Some of the values presented to the front end require values specific to the frontend in JavaFX and the image of the ObjectController must be a resource.
* Extension: For further extension of the project, other updatable features can be added to the frontend by adding a getter class for that parameter.

### Justification for Class Designs
* Design's Key Goals
Our designs key goal is to be as modular as possible, while limiting blatant interactions and obvious implementation details between the model 
and the view class. In that regard, we allow the view class to handle the main displaying of features, panels, images, etc., without letting it
be directly linked to our model. An example of this is that the back-end would not be updating the "turtle" on the front end directly, but rather
updating it's own turtle. Then, the view class would have to access these changes and update it's own "projection" of that turtle on the front end.
This allows it so that the back-end is not reliant on directly modifying front-end structures. To dig deeper into implementation details, the front
end will be split up into it's individual componets, i.e. canvas, language chooser, console, history panel, etc... and have certain classes that allow
communication with updated features in the back end. The back end, however, will be much more complicated. Commands will be wrapped, parsed based off
of language, and different commands will be handled by different back-end classes. This allows for classes to hold differing responsibilities. Then 
the aforementioned update procedure will be implemented. 
* Principles
Main principles include hiding the back end from the front end and vice versa, and ensuring that our implementations are modular in a way that
classes don't get bogged down with too much responsibility when they can handle a very certain aspect of the project. 
* Abstractions
Main abstractions would be how the back-end handles the commands that are packaged up for it by the front-end. 

### Throwing Errors
If the user inputs some invalid commands, View will be unable to detect the error and will simply pass the commands to View.Window, who make an elementary scan on the command type (i.e. math, logic, object control, etc.) and transfers the commands to the corresponding concrete Parser class for further parsing. A Errors could either occur at View.Window (unidentifiable command type) or at a Parser class (invalid data, undefined variable, etc.), and will ultimately be thrown back to View.Window, who then invokes AlertPopper in the View component with appropriate SlogoAlert. AlertPopper will then be able to display the corresponding alert message to user on the front end.


# API Example Code
'fd 50 executed' ...
``` java
myConsole.setText('fd 50');
CommandWrapper.wrapText(myConsole.getText());
// backend can communicate with command wrapper to get the list of commands
myConsole.clearText(); 

// WITHIN BACKEND
Parser.parseCommand(CommandWrapper.getCommands());
// LOOP THROUGH COMMAND LIST AND EXECUTE
History.addCommand(CommandWrapper.getCommands());
ObjectController.setY(myObject.getY() + 5); // back-end turtle
ImagieView.setY(myObject.getY()); 
// front-end turtle
```

# Design Considerations 

### Design Decision 1: Tree structure in CommandController
The CommandController class is a class that stores a singular 'input' from the command line. An input is defined as when a user keys 'Enter' in the command line. This input can consist of multiple commands, nested commands, or a singular command. Regardless, once parsed into Command objects, they are stored in a CommandController object with its primary data structure being a tree. We decided on a tree structure instead of Iterable objects or Maps.
* **Pros**
Using a tree structure enables for command line functionality that includes nesting, loops, and multiple commands. ArrayLists, Maps, and Queues work linearly and have one-way flows. Unlike these data structures, trees enable  multilevel commands that travel down for structures (nodes in a tree).
* **Cons**
Using the tree structure may have a significant memory cost and cause implementation difficulties. A for loop that runs 100 times with 60 nested statements would necessitate creating a tree with 6,000 nodes. Creating an object this large to distinguish between commands may result in a a great deal of memory used. Furthermore, tree traversals may prove to be challenging to implement.
* **Ambiguities, Assumptions, Dependencies**
This design decision functions on the assumption that the data structures provided in the basic specification are the only data structures required for implementation. There may be commands that require data structures that may not be supported by a tree or require some sort of cyclical patterning also not supported by a tree. There also still remains some ambiguity regarding the generation of the tree and how for loops will be structured and how the tree will be traversed to accurately represent the format of the command.

### Design Decision 2: Having "executioner" classes communicate directlly with front-end components
As described in previous sections, after a series of user commands have been successfully parsed by Parsers, transformed into concrete Command objects and organized in a tree structure in CommandController, each Command will be passed to its corresponding executioner class (e.g. a MathCommand goes to the MathCalculator), where the executioner reads the label variable stored in Command to figure out which specific operation to perform, and directly pass the output to appropriate "client" classes.
* **Pros**
Each "executioner" class handles a special type of Command and interacts directly with its client classes who'll eventually show the execution results to user (modifying object properties, displaying operation results, updating variables, etc.) on the front end. Therefore if new commands or front-end components are to be added in the future, the change can be accomplished by creating new executioner and client classes with their own logics withouth having to touch the core classes such as View.Window and CommandController.
* **Cons**
An alternate approach is to let the executioner classes return all the results to View.Window, who will serves as the only communication channel between View and Model. In comparison to this approach, our design choice will result in a lot more dependencies since communications for different types of commands are established separately, which will probably make the structuret less neat.
* **Ambiguities, Assumptions, Dependencies**
The design decision is made based on the assumptions that all types of commands can be categorized and get mapped to a certain executioner class, and that any command has a recepient (client) class for displaying the execution result. Additionally, dependencies will need to be established between each pair of executioner and client classes across Model and View.

# Team Responsibilities
*This section describes the program components each team member plans to take primary and secondary responsibility for and a high-level plan of how the team will complete the program.*
### View
* Eric Lin: Internal View API Design
* Hsingchih Tang: External View API Design

### Model
* Duc Tran : Internal API's Design
* Mary Gooneratne: External Model API Design