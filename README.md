Slogo
====

*This project builds a simple version of LOGO, a development environment that allows user to input a certain set of commands to control a Turtle "robot" and draw out its trails on the program's GUI, to execute mathematical or boolean commands, and to make queries regarding the Turtle's status.*

*Team members: Hsingchih Tang, Eric Lin, Mary Gooneratne, Duc Tran*

### Timeline

* Start Date: Feb.14, 2018
* Finish Date: Mar.9, 2018
* Hours Spent:
    * Planning meetings ~3 hrs  
    * Team progress meetings ~10 hrs  
    * Outside of meetings:  
        * Hsingchih: ~45 hrs  
        * Duc: ~30 hrs

### Primary Roles
**Hsingchih Tang - Frontend:**
* Designed the GUI for the program for displaying Turtle animation, drawings, variable values, and historical commands to the user; laid out the front-end elements using resource files and reflections.
* Implemented the main Controller for controlling Turtles within different tabs, connecting multiple View/Model pairs, and transferring user-input commands between front and back ends.
* Implemented IModel and IObserver APIs explicitly for communicating variable and historical command data.
* Implemented error/exception handling features for both front (invalid uploaded file, etc) and back (invalid commands, etc) ends.


**Duc Tran - Backend:** 
* Implemented parsing commands from the user into usable information for our program.
* Implemented language translation for commands in different languages.
* Implemented several commands like the math commands and queries.

### Resources Used
[stack overflow](https://stackoverflow.com/)


[Javafx official documentation](https://docs.oracle.com/javase/8/javafx/api/toc.htm)

[Rob's tutorial blog](https://rterp.wordpress.com/2015/09/21/binding-a-list-of-strings-to-a-javafx-listview/)

[java2s](http://www.java2s.com/)

### Running the Program

#### Main class:
Window.java

#### Data files needed:

* *Language resource files*
    For parsing and executing commands input in different languages
* *GUI elements layout resource files*
    Setting the row and column indices for elements laid out in a JavaFX GridPane
* *GUI elements reflection resource files*
    Setting the methods to be invoked by Buttons and ComboBoxes on user actions
* *Alert message source files*
    Which types of customized SlogoExceptions should be thrown under certain scenarios, and what messages should be displayed to user in the form of alert dialogues.

#### Note:
* Mark the resources fold as the resource root.
* Set up VM options for the project library files

# Basic Features implemented:
* Basic commands for controlling Turtle (position, heading, pen status, visibility, etc) and querying Turtle status
* Selectors for changing pen and cavas background colors
* Selectors for changing turtle image and command parsing language
* Commands for defining variables; displaying command history and user-defined variables
* Commands regarding mathematical and boolean operations
* User-defined command structure
* Repeating command structure


## Assumptions or Simplifications made to handle vague, ambiguous, or conflicting requirements:
* **Assumption 1**
    New variables or commands follow the variable and command regex format to simplyfy parsing. Otherwise an error will be thrown.

* **Assumption 2**
    The program allows for additional Turtles created by user at will. To simplify the design, we implement JavaFX's TabPane feature, which enables user to create new tabs. Each tab is independent from all the other tabs, and manages ***one*** single Turtle with commands typed in from the console area inside the same tab.
    Under this design, only one Turtle can be activated at a time, and switching between tabs automatically sets which Turtle is active (as well as inactivates all the other Turtles belonging to the rest of the tabs).

## Known Bugs:
* **Buggy command execution**
    If the first two commands are rt 90 fd (any number), it will cause the turtle to move indefinitly


## Extra credit:
### Basic Extensions
* **Multiple tabs managing separate console inputs and different Turtles** 
    The program is designed to display multiple tabs that user can create and switch between arbitarily. Each tab has its own set of Turtle, canvas, variables, command history, and console. By clicking on the "Add a new tab" button, the user can create a brand new tab with a new Turtle that is independent from all the other tabs.
    
* **Toggling Turtle active status**
    As user switches between tabs by clicking on the tab in the top pane, each Turtle's active status is automatically updated by the user action. Only one tab (and its associated Turtle) is displayed at a moment, and since each console is only associated with its own Turtle in the same tab, any action regarding the currently displayed Turtle has no effect on the other inactive Turtles.
    
* **Displaying real-time Turtle status** 
    Turtle's X/Y coordinates, heading, pen status (up/down), and pen color are all displayed real-time in each individual tab. Any change as a result of command execution is reflected on the display.
    
* **Controlling Turtle graphically** 
    Besides command input via the console, user can also click on buttons on the GUI to control the Turtle's position and heading. Each button is associated with a simple default Slogo command (e.g. the upward arror button stands for "fd 50") and clicking on buttons is equivalent to typing in commands to console and hitting "Excecute" button.
    
* **Controlling pen properties graphically** 
    User can select pen color from a palette on GUI (which shows up as a dropdown after clicking on the corresponding button). Also, pen width is adjustable using a slider on GUI.
    
### Challenging Extensions
* **Animating Turtle movement** 
    Turtle movements (position transition and heading rotation) are all animated when corresponding commands are executed.



## Impressions
**Hsingchih:** 
In this project, I challenged myself to explore the front-end role and really enjoyed the learning process, which allowed me to practice some advanced programming skills (reflection, property binding, usage of resource files), and also gave me the chance to learn about and integrate several design patterns (factory, MVC, etc) into different components of the project.
The Slogo project is a lot more complicated than the previous ones, and requires lots of teamwork as well as a good timeline scheduling. I'm glad that we've thought a little bit ahead and have intentionally made the original design flexible in the beginning, which saved us a lot of time and efforts when adding on new features in the third sprint.


**Duc:**
The project was a lot of work but it was cool to see the end product. I felt like a lot of the things discussed in class came up in this project like or lambdas and reflection.