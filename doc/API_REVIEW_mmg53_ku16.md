# API Review
## Part 1
### What about your API/design is intended to be flexible?
The external model API has separate controllers for each kind of command and properties of these controllers are part of the API. The flexibility is rooted in the ability to create new commands easily and separately from the existing programs. A command and controller is necessary and the properties of this controller would be added to this API.

### How is your API/design encapsulating your implementation decisions?
The API encapsulates our implementation decisions because we wanted the updating of various parameters like position and color to happen exclusively in the backend where the frontend acts more as a reader and updates its variables based on changes it observes in the backend. By adding these property visibility methods, it ensures that the only functionality of the frontend is viewing and displaying.

### What exceptions (error cases) might occur in your part and how will you handle them (or not, by throwing)?
Errors can arise from properties not being defined in the API or being visible properties. I think instead of throwing errors, it would be best to have a default value.

### Why do you think your API/design is good (also define what your measure of good is)?
I think our API is good because all updatable properties are separated and new commands and controllers are added on their own and don't require going back into programs and changing things.


## Part 2
### How do you think Design Patterns are currently represented in the design or could be used to help improve the design?
The design patterns are represented by the existence of these multiple controllers. It shows the inheritance hierarchy of controllers and the different kinds of commands.

### What feature/design problem are you most excited to work on?
I am most excited to work on a parser. It seems like an awesome challenge.

### What feature/design problem are you most worried about working on?
I also am most worried to work on the parser because it will be challenging.