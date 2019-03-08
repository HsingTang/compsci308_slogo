SLOGO_REFACTORING_DISCUSSION
===
##### ht114, el132, dt135

# Long Methods
* ElementFactory.setInvokedMethod
* TurtleView.animateTranslation
* CommandNodeFactory.newNode
### Design Issues
* ElementFactory.setInvokedMethod
    * Lengthy if blocks for checking the instance type of element being processed in the ElementFactory
* TurtleView.animateTranslation
    * Slightly complicated calculations and turtleView motion control crowded in one method
* CommandNodeFactory.newNode
    * Author not here today
### Fixable Methods
* ElementFactory.setInvokedMethod
* TurtleView.animateTranslation
### Design changes or refactorings
* ElementFactory.setInvokedMethod
    * Initiate the myArgs variable as null and update it with arguments extracted from properties file if available
* TurtleView.animateTranslation
    * Split the parameter calculation and animation control into two separate shorter methods and process the animate in a pipeline



# Checklist Refactoring
### Communication
* Magic Values  
Issues occur in frontend GUI layout codes. Can be eliminated by replacing hard-coded values with data read from source files.

* Variable Scope (StringParser)  
Can be fixed by migrating globally declared final variable into appropariate methods.

* Exception/Error Handling  
Building Errors and SlogoAlert classes for popping alert dialogues to users upon any exception/invalid command input. Errors generated in any class will be thrown all the way to Window, who will invoke the appropriate alert dialogues. Alert messages shall be read from a source file to eliminate hard-coding.

* Duplicate Codes (VariablePaneModel and CommandPaneModel)  
VariablePaneModel and CommandPaneModel both implement the ModelInterface, while the two classes have duplicate codes in many of their common methods. The design issue can be fixed by refactoring ModelInterface into an abstract class and have VariablePaneModel and CommandPaneModel extend the super class instead of implementing the interface. The shared portion of codes can then be migrated into the abstract super class, which could eliminate the duplication in two concrete subclasses.


### Flexibility
No remaining issue after the if structure in ElementFactory has been refactored.

### Modularity
Varaible declaration issues fixed. 


# General Refactoring
### Code Smells
No code smells :) Go team!

### Java Notes
* Exception handling:  
Can be fixed by replacing printStackTrace by throwing SlogoExceptions to Window and having Window handle the exceptions with popped-up dialogue boxes
* Empty methods:  
Those are placeholder methods; will be implemented soon.