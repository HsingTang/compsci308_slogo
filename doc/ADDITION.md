ADDITION_ht114
===
## Estimation: 
* Time anticipated: ~2 hours
* Number of files needed to update: around 5 (Create a new Button class, a new Scene class, modify one of the front-end Pane classes to display the button, modify 1~2 properties files to set up the button's position and functionality)
# Review:
* Time taken: ~2 hours
* Number of files updated: 10
    * 1 new Button class (ViewTurtlesButton)
    * 1 new Scene (ViewTurtleScreen)
    * 2 properties files: respectively for instantiating the new Button and setting up its layout
    * Controller: added a new method for retrieving all existing Turtles (which wasn't implemented before)
    * ControllerInterface: same reason as the update on Controller
    * TurtleChooser: extended this already existing class to reuse its functionality for updating turtle images 
    * TurtleView: updated the `setImgView` method for setting the fitWidth/Height after every update call
    * TopPane: the Pane on which the new Button lies
    * Window: implements the method for instantiating the ViewTurtleScreen to serve the additional feature  
* If not familiar:
    It would have taken me significantly more time to figure out where to add the new classes and which existing classes should be modified. I might also have to spend a great deal of time to understand the design pattern of this project, and to identify which parts belong to the front end. 