# My Personal Project

## Moondial

The application, *Moondial* will attempt to teach the user to determine the approximate time, based on the Moon's 
position in the sky. The precision will be determined by the precision of the angle specified Time approximation will 
only be possible when the moon is visible in the user's sky view. The application will use data inputted by the user 
such as:
- current moon phase
- position in the sky 
- approximate angle to the horizon

*Moondial* will not account for daylight savings and only be applicable in the Northern Hemisphere

Consequently, *Moondial* serves to fulfill my overdue promise to a kid, who is an astronomy fanatic and will teach 
them how to use the moon to determine what time it is. Previously, I drew diagrams and explanations on paper to which 
they could not decipher without assistance. With the current situation of COVID-19, I doubt that I will be able to 
teach them in person. Hopefully this application will be simple enough for a child to use and will successfully teach 
any user how to use the moon, when it is visible, to determine the approximate time.  

### User Stories

- As a user, I want to be able to make and add an observation to a list of observations
- As a user, I want to select an entry from my past observations to see (not in GUI)
- As a user, I want to see a list of my past observations that have not been deleted 
- As a user, I want to see a summary of my past observations categorized by moon phase 
- As a user, I want to select observations to delete 
- As a user, I want to be able to save my current list of observations to file 
- As a user, I want to be able to automatically load my previous list of observations from file when the program starts
- As a user, I want to be able to automatically save my observations when I quit (not in GUI)

### Instructions for Grader
- You can generate the first required event by clicking on any moon phase, and clicking on any 
angle, then clicking observe. The top Left panel will update with the currently selected states as you click them. The 
entry list and sorted list will only update when you click observe. 
- You can generate the second required event by clicking remove next to the entry item you want to remove. Both the 
sorted and entry list in the Right panel will update as well as the Top Left panel.
- You can locate my visual component by selecting a moon phase, this will change the image displayed on the angle 
selection buttons.
- You can locate my audio component by clicking the save button
- You can save the state of my application by clicking the save button
- You can reload the state of my application by running the application (it loads automatically)

#### External Citation 
- Code from the audio found: https://stackoverflow.com/questions/2416935/how-to-play-wav-files-with-java

### Phase 4: Task 2
Robust Design: 

The method addObservation() found in the class EntryList, in the model package throws an IllegalListSize Exception when 
the list size is larger than the constant maxListSize. The combination of expecting and not expecting Exceptions can be 
found in the class EntryListTest.

### Phase 4: Task 3

- There is low cohesion in the model class because the class MoonTime and Entry hold extremely similar functions. 

Solution: This was solved by making MoonTime an interface that Entry implements and moving its code and tests to the 
class, Entry, and the class, EntryTest.

- SortedListPanel and EntryListPanel had nearly identical code for their constructors, similar functionality in making 
panel components and resetting the panel.

Solution: I created an abstract ListPanel class which has the resetListPanel() method implemented, has an abstract 
method makePanelComponents(), and most of the constructor's functionality in the abstract class' constructor.
Additionally, I created an interface called MoondialPanel which is implemented by the abstract classes ListPanel and 
SkyPanel with one method that needs to be implemented in the abstract classes/their subclasses called 
makePanelComponents().



