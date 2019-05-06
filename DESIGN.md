# Design Goals
### Description
This project builds a simple version of LOGO, a development environment that allows user to input a certain set of commands to control Turtle "robots" and draw out the trails on the program's GUI, to execute mathematical or boolean commands, and to make queries regarding the Turtle's status.  
The design adopts the Model-View-Controller pattern, and aims at decoupling frontend and backend implementations to the best extent in order to provide flexibility for adding extension features, such as adjustable GUI layouts and new command parsing/execution, without requiring significant changes on project structure and core codes.

### **Project Structure:**
* **View component:**  
  The highest-level class of the View component is Window, which extends *javafx.application.Application* and serves as the main class of the whole program. Window is in charge of all separate tabs, each containing its own set of GUI elements that interact solely within the front-end: choosers for changing the pen/canvas colors and the Turtle's visualization image, buttons for directly controlling Turtle movements with pre-set simple commands, etc. These elements are instantiated only within the View scope without engaging the Model and Controller components.  
  At the creation of each tab, Window passes in a reference to the main Controller into a tab factory class, and the tab stores the reference as an instance field so that it can access the Controller when receiving user inputs that will require backend actions. User interactions with the front-end tab elements (button clicking, command input, etc.) invoke transfer and execution of commands on the backend via the main Controller, and the execution results are reflected on data held by the corresponding backend Model components (TurtleModel, ReturnValModel, etc., which implement Model interfaces). Each front-end View component (TurtleView, Console, etc.) implements the appropriate interface (TurtleObserver or IObserver, depending on its class) and is registered as an observer of its associated Model, so that it can be invoked to update data and GUI visualization to complete a full round of command execution.  

* **Controller component:**  
  While the main resides in Window, which is the highest-level class of View component and has only one instance for the whole program, it creates the main Controller (which also has only one instance) when the application is launched. The main Controller sits between View and Model, creates new instances of Model classes (TurtleModel, ReturnValModel, VariablePaneModel, etc.) when receiving user action for adding new tabs, and supplies the new Model components to the front end for linking the View/Model pairs.  
  Additionally, the Controller is connected to the Parser and CommandHandler. When commands are received from the front end, Controller is responsible for identifying which Models would be affected, and invokes the Parser and CommandHandler for processing the commands. As described above, the execution results are reflected on the corresponding Model instances, and any change on a Model's data will trigger notifications being sent to its paired View components ("observers") so that the front end can retrieve the new data and update the GUI.
  The StringParser takes in strings that represents a user's command from the controller. Then using regex expressions and the Pattern API, translates and converts the command into a string that the CommandRoot class can you to execute the original command. The StringParser can switch languages rather easily since the languages are saved in resource bundles that can be easily created or edited.    

* **Model component:**  
  The TurtleModel, VariablePaneModel, CommandPaneModel and ReturnValModel are designed for storing data on the back end as a result of command executions and for interacting with front-end View components. Each Model component implements either the TurtleModel- or IModel interface, and maintains its own list of observers (View components that implement the appropriate observer interfaces). 
  Execution of commands would affect these "observable" Models and their data. On change of the data, the registered observers (View components) would get notified and update accordingly. The use of interfaces reduces the direct dependencies between front and back ends for data transfer and updates.
  
* **Command component:**  
    Execution of commands are handled mostly in the backend. After the StringParser parses a user's command, it passes that information to the CommandRoot. The CommandRoot is in charge of both creating a structure to represent the typed comands and also executing these commands.
    The structure chosen to represent a list of commands is a tree execute through pre-order traversal. The tree is made up of objects that fall under the abstract CommandNode type. When the array is passed to the CommandRoot, the class redirects to a factory class to create CommandNodes using reflection, based on the individual strings. These CommandNodes store unique parameters of the command in addition to the shared CommandHandler for the whole root. 
    When executing a series of commands, the CommandRoot is what is "executed". At a high level, this is a pre-order, recursive call to an execute method on each of the CommandNodes. Each CommandNode is "responsible" for its own functionality. More specifically, there are CommandNode child classes for each type of command, each with a unique execute() method that redirects to the CommandNodes' shared handler which then implements these changes to the program states based on the kind of CommandNode executed.
  
  
### Feature Implementation:   
* **Separate tabs for multiple Turtles**   
  In order to realize the multi-Turtle feature, JavaFX's TabPane feature is utilized in Window such that the GUI can display separate tabs to users, with each tab containing its own set of visualization components, including the input console, buttons, variable/command display, etc. A tab can be created by user at will by clicking on the "Add a new tab" button in one of the already-created tabs. It is worth noting that at the creation of each tab, Window notifies Controller to create and supply new Model/View pairs to the new tab, so that necessary dependencies across front and back ends can be established for later data transfer and updates.
  
* **GUI layout flexibly adjustable via source files**   
  A tab is splited into five pane sections (top, bottom, left, right, center), and the layouts and event-based actions of most elements (buttons, color selectors, file chooser, etc.) contained in each section are not hard-coded. In order to accomplish flexible layout and action set-up, we utilize Resource Bundle and Reflections for the GUI initialization. This feature enables easy rearrangement of the GUI elements by editing parameters in resource files, without the need for modifying source codes.
  
* **Error/Exception Handling**  
  The program is able to detect invalidity in user-input commands beyond our parsing dictionary, and can also handle error cases of unreachable help page directory, as well as invalid or missing configuration files.
  If any error or exception occurs, the program will pop up a dialogue box to user containing case-specific alert messages, which are also loaded from resource files.
  
* **Nested Commands**  
  Nested commands such as Forward Sum Sum 50 50 50 will execute without error as long as the correct number of values are given entered.
  
* **Turtle States**  
  In the second sprint, further frontend funtionality was added to show the user life updates regarding the program environment. "Observers" not only updated the turtle but also the data present in the upper right hand of the screen.



# Adding New Features

### New Feature 1: New Languages
* **Changes in View:**  
One will need to add the name of the Language to the LanguageList.properties file as well as add the corresponding new resource bundle file defining all command translations to the directory resources.languages.  
At the initialization, the language chooser element in View will be able to automatically identify all available languages and can display the options on GUI.
* **Changes in Controller:**   
N/A
* **Changes in Model:**   
N/A
### New Feature 2: New components on the front-end
* **Changes in View:**  
The ElementFactory and PaneLayoutManager classes are capable of customizing element behavior (i.e. which functions to invoke and which arguments to pass in when the user acts on a certain button/slider/chooser) and layout by loading resource bundle files under the resources.elements directory.  
To add a new type of element or manipulate an existing element, the developer needs to decide the pane section the element would reside in, define corresponding methods to be invoked by the element, and specify the element's class path, layout and behaviors in the resource bundle files. Then, simply adding a few lines in the corresponding pane class to invoke the ElementFactory and PaneLayoutManager will be sufficient for setting up the new element. 
* **Changes in Controller:**   
N/A
* **Changes in Model:**   
N/A
### New Feature 3: New Commands
* **Changes in View:**  
N/A
* **Changes in Controller:**   
N/A
* **Changes in Model:**   
You will need to add a new node class that encapsulates the command and its return value. Then within the command handler you will need to create an execution method that this node can be called on tree traversal. This execution command will act upon the model and change the model's instance variables that can determine certain features on the front-end. 

# Major Design Choices

* **Exception handling:**  
    * *Description*  
    The SlogoException class is specifically created for wrapping any Java exception or when encountering missing/invalid commands in parsing or executing command. There are several concrete Exception classes extending the super class SlogoException, and different types of errors will trigger corresponding concrete Exception to be thrown. All intermediate classes will rethrow any Exception they've received as a SlogoException (either via directly rethrowing or after wrapping the Exception) until the SlogoException reaches Window. Window invokes AlertFactory to look up the resource bundle and pop up corresponding Alert message dialogues to user.
    * *Pro & Trade-off*  
    The design enables handling all Exceptions/Error cases intensively in one class, so that all classes can easily throw the Exceptions away until they reach and get handled at Window. Also, the alert message popped up to users are read from source file, which effectively avoids hard-coding.
    
* **Observers update all its properties on one change of model properties**  
    * *Description*  
    In this example, the turtle observer has to update all its properties and features on every update to the model. So say the command to move forward is called, then the model updates, and a method update is called on the view such that everything, even angles rotated (even if it is 0) is updated as well. This is opposed to having a specific update method for each instance variable. So for example, this alternate design would mean that if you only call a command to make pen up, only the views pen up is updated as well. This is because the observer interface would implement different kinds of updates instead of an all-encapsulating update. 
    * *Pro & Trade-off*  
    Making this choice of creating all updates allowed us to animate the the items in sequence; however, it was hard to coordinate because even though nothing was changing, we would have to update everything on the view (even when there was no change). Overall, there were less lines of code needed and we could create an interface with just an "update" method instead of multiple "update" methods specific to the turtle view. This allows for a flexible interface. 

* **Multiple interfaces for View and Model components**  
    * *Description*  
    You might have noticed that there are respectively two interfaces on both the View and Model ends: for the Views, we have IObserver and TurtleObserver; and for the Models, we've designed IModel and TurtleModelInterface. While we define there to be View/Model pairs for the project's MVC design pattern, the TurtleView and TurtleModel classes implement TurtleObserver and TurtleModelInterface, whereas all the other View/Model pairs (Console/ReturnValModel, VariablePane/VariablePaneModel, etc.) implement IObserver/IModel interfaces.
    * *Pro*  
    The design choice is made because of the unneglectable differences in the data held by Turtle View/Model and the other V/M pairs. While all the others do not have too much data to store, a Turtle could exhibit a wide range of complicated behaviors and would need to store significantly more data, so the distinct interfaces would allow for customized interactions between the Turtle V/M pair.
    * *Trade-off*  
    This design requires multiple interfaces developed for different V/M pairs, which makes the project structure a little more complex.
    
* **Individual Classes For Each Command**  
    * *Description*  
    Each command that was tasked to be implemented is represented by its own command node. For example the sum command has a SumNode class while the Forward command has a ForwardNode. Each command node extends the CommandNode abstract class. 
    * *Pro*  
    Allowed for reflection to easily create the required CommandNode from the parsed information data. 
    * *Trade-off*  
    Each CommandNode of specifc types were implemented very similarly, so we had a lot of classes that looked the same. Like the SumNode and the ProductNode were almost entirely the same except, a + was replaced with a *. This could have been potentially been fixed by having a CommandType and within each command type each method of that type and use reflection to select a method.

# Assumptions or Decision

* **Multiple tabs holding independent Turtles and command input consoles**  
The program allows for additional Turtles created by user at will. To simplify the design, we implement JavaFX's TabPane feature, which enables user to create new tabs. Each tab is independent from all the other tabs, and manages one single Turtle with commands typed in from the console area inside the same tab.
Under this design, only one Turtle can be activated at a time, and switching between tabs automatically sets which Turtle is active (as well as inactivates all the other Turtles belonging to the rest of the tabs).

* **Any word entered that didn't follow the regex format was considered wrong:**  
If the user tried to set var2 to be a variable, the parser would throw an error since var2 did not follow any of the regex formats. This was done to avoid the user from entering in any weird commands or words and crashing the program.

* **Commands and calls to commands had to be completed in separate executions**  
**The nature of the CommandRoot is that it has a "loaded list" of valid methods that is unique to each root. Therefore, calling a command in the same root it was created would not be functional. This assumption was made to prevent users from redesigning commands within commands.