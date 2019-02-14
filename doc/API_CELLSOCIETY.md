API_CELLSOCIETY
===
##### ht114, dt135, mmg53, el172
##### api_cellsociety_team15


## Not in the API

## In external API
Cell.userSwitchState()
Cell.setNextTurnsSurvived(double turnsSurvived)
CellWATOR.setNextSharkEnergy(double energy)
Simulation.start(Stage stage)
Simulation.setSimType(String s)
Simulation.getGrid() 
Simulation.getStateImageMap()
Simulation.startSimulation()
Simulation.pauseSimulation()
Simulation.playSimulation() 
Simulation.stepSimulation() 
Simulation.resetSimulation()
Simulation.switchSimulation(String newSimType)
Simulation.setSpeed(Double d) 
Simulation.getSimulationType()
CellWATOR.getNextLocCell()
CellPercolation.findNextState()
CellWATOR.findNextState() 
Cell.findNextState()
Cell.getState()
Cell.findNeighbors()
Cell.setNextState()
cell.userSwitchState()

## In internal API

XMLParser.isParseSuccess()
XMLParser.isSpecConfig()
XMLParser.getSimType()
XMLParser.getCellShape()
XMLParser.getEdgeType()
XMLParser.getStateImage()
XMLParser.getStatePercent()
XMLParser.getNeighbors()
XMLParser.getParameters()
XMLParser.getCellState()
XMLParser.getWidth()
XMLParser.getHeight()
NeighborsTriangle.NeighborsTriangle()
Neighbors.initializeEdgeAndIndexes()
Neighbors.getNeighborsList()
NeighborsSquare.NeighborsSquare()
UI.drawGrid()
UI.drawGraph()


# SIMULATION INTERNAL API
Cell.findNextState()
Cell.findNeighbors()
Cell.setNextState()

The internal API for the simulation scope of the project deals with configuring the next state foreach cell within the grid of cells, and updating the the cells current state to the  cells next state. In doing so, the simulation's internal API uses a findNeighbors method that is returned from an interaction with the XML parsing. Using this findNeighbors method withinthe simulation scope, the user can obtain an ArrayList of neighbors and use these neighborsin the cell interaction knowledge. 


# SIMULATION EXTERNAL API
Cell.getState()
Simulation.getGrid()
Simulation.getSimType()
Simulation.getSpeed()
Simulation.resetSimulation()


The external API allows for the grid to view each Cell's state in order to show the appropriate image for the Cell and allows for the UI to view changes in state or speed and update as appropriate. The getState() method is what allows the visualization to pick the correct image. The getGrid() function allows the visualization to view the position of the cells, getSimType() allows for the correct visualization, getSpeed() permits for changes in speed to be reflected in the visualization, resetSimulation() allows the model to be restarted both visually and in the simulation.