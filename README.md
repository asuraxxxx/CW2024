# Content Table

- [Github Repository](#github-repository)
- [My Info](#my-info)
- [Compilation Instructions](#compilation-instructions)
- [Implemented and Working Properly](#implemented-and-working-properly)
- [Implemented but Not Working Properly](#implemented-but-not-working-properly)
- [Features Not Implemented](#features-not-implemented)
- [New Java Classes](#new-java-classes)
- [Modified Java Classes](#modified-java-classes)
- [Deleted Java Classes](#deleted-java-classes)
- [Unexpected Problems](#unexpected-problems)

# Github Repository
https://github.com/asuraxxxx/CW2024

# My Info
**Name: Adrian Fo Wen Keat**  <br>
**Student ID: 20509540**  <br>
**Link: https://github.com/asuraxxxx/CW2024** 

# Compilation Instructions
## Prerequisites
**1. Java Development Kit (JDK) 21** <br>
**2. Eclipse 2023-12+** <br>
**3. Git**

## Steps to set Up the project
**1. Clone the Repository**
```
git clone https://github.com/asuraxxxx/CW2024.git
cd CW2024
```
<br>

**2. Open the Project in Eclipse**
<li>Launch Eclipse on your computer.</li>
<li>Go to File > Import.</li>
<li>Select Git > Projects from Git and click Next.</li>
<li>Select Clone URI and click Next.</li>
<li>Enter the repository URL https://github.com/asuraxxxx/CW2024.git and click Next.</li>
<li>Choose the branch you want to work on (usually main or master) and click Next.</li>
<li>Select the local directory where you want to store the repository and click Next.</li>
<li>Choose Import existing Eclipse projects and click Next.</li>
<li>Select the project and click Finish.</li>
<br>


**3. Install Dependencies**
<li>Ensure you have all necessary dependencies installed.</li>
<li>For Maven:</li>
  <ul>
    <li>Right-click on the project in the Project Explorer.</li>
    <li>Select Run As > Maven install.</li>
  </ul>
  <br>


**4. Compile the Code**
<li>Eclipse will automatically compile the code as you make changes.</li>
<li>To manually build the project, go to Project > Build Project.</li>
<br>


**5. Run the Application**
<li>Right-click the file and select Run <code>GameLauncher.java</code> located at <code>src/main/java/com/example/demo/controller</code></li>
<br>


**6. Right-click on the main class file and select Run As > Java Application.**
<li>Ensure any additional dependencies or special settings required are configured. This might include setting up environment variables or configuring specific IDE settings.</li>
<br>


# Implemented and Working Properly
**1. Main Menu and Pause Menu**
<table style="width:100%">
  <tr>
    <th>Feature</th>
    <th>Description</th>
  </tr>
  <tr>
    <td>
      Introduced a main menu that appears upon game startup.
    </td>
    <td>
      <ul>
      <li>The main menu has a start button which allows user to start the game.</li>
      <li>The main menu has an instruction button which shows the instruction screen on how to play the game.</li>
      <li>The main menu has a leaderboard button which displays the time to complete all levels in a decending order.</li>
      <li>The main menu has an exit button that allows user to quit the game.</li>
      </ul>
    </td>
  </tr>
  <tr>
    <td>
    Created a pause menu to manage game pauses.
    </td>
    <td>
      <ul>
      <li>The pause menu will appears when the user clicks on the pause button that is available for all levels throughout the game</li>
      <li>The pause menu will display a text that shows user that game is paused.</li>
      <li>The pause menu has a resume button that allows user to resume the game.</li>
      <li>The pause menu has a setting button that allows user to press into instruction screen.</li>
      <li>The pause menu has a return to main menu button to return to main menu.</li>
    </ul>
    </td>
  </tr>
</table><br>


**2. User Plane Enhancements**
<table style="width:100%">
  <tr>
    <th>Feature</th>
    <th>Description</th>
  </tr>
  <tr>
    <td>
     Enable more types of user plane movement
    </td>
    <td>
      <ul>
     <li>The user plane can move left and right, allowing for smooth horizontal navigation during gameplay.</li>
      </ul>
    </td>
  </tr>
</table><br>


**3. Visual and Audio Improvements**
<table style="width:100%">
  <tr>
    <th>Feature</th>
    <th>Description</th>
  </tr>
  <tr>
    <td>
     Added and changed background images for various screens throughout the game.
    </td>
    <td>
      <ul>
      <li>Changed background image for level one and level boss.</li>
      <li>Added background iamges for main menu, pause screen, leaderboard screen, win game screen, instruction screen and setting screen. </li>
    </ul>
    </td>
  </tr>
  <tr>
    <td>
   Changed original icons and added icons for new buttons.
    </td>
    <td>
      <ul>
      <li>Added close button icon for close button.</li>
      <li>Added exit button icon for exit button.</li>
      <li>Added instruction button icon for instruction button.</li>
      <li>Added restart button icon for restart button.</li>
      <li>Added resume button icon for resume button.</li>
      <li>Added setting button icon for setting button.</li>
      <li>Added pause screen button icon for pause screen button.</li>
      <li>Changed heart icon.</li>
    </ul>
    </td>
  </tr>
   <tr>
    <td>
    Added Audios
    </td>
    <td>
      <ul>
     <li>Included sound effects for firing projectiles and background music.</li>
      </ul>
    </td>
  </tr>
</table><br>
    
    
**4. Gameplay Additions**
<table style="width:100%">
  <tr>
    <th>Feature</th>
    <th>Description</th>
  </tr>
  <tr>
    <td>
    Added one additional level.
    </td>
    <td>
      <ul>
     Created another additional level called Level Two to increase difficulty of the oeverall gaming.
      </ul>
    </td>
  </tr>
  <tr>
    <td>
    Added level transition screens between levels.
    </td>
    <td>
      <ul>
      <li>The level transition screen has a penguin shape passing through. </li>
      <li>The level transition screen will display a text that says entering the next level.</li>
      <li>The level tarnsition screen will appears when users win a level</li>
      </ul>
    </td>
  </tr>
   <tr>
    <td>
    Implemented a status text.
    </td>
    <td>
      <ul>
      <li>The status text will display how many enemy planes are left to advance to the next level in level one and level two.</li>
      <li>The status text will display how many health of the boss are left to win the game in level boss.</li>
      </ul>
    </td>
  </tr>
  <tr>
    <td>
    Implemented win game screen.
    </td>
    <td>
      <ul>
      <li>The win game screen will display a text that shows user has win the game.</li>
      <li>The win game screen will display the total time used to complete all levels.</li>
      <li>The win game screen has a restart button that allows user to restart to level one and play again.</li>
      <li>The win game screen has a return to main menu button that allows user to return to main menu.</li>
      </ul>
    </td>
  </tr>
</table><br>


**5. Leaderboard**
<table style="width:100%">
  <tr>
    <th>Feature</th>
    <th>Description</th>
  </tr>
  <tr>
    <td>
     Added a leaderboard screen
    </td>
    <td>
      <ul>
      <li>The leaderboard screen will records the time used to complete level one , level two and level boss.</li>
      <li>The leaderboard screen will add up the total time used to complete all levels and display them in a decending order</li>
      <li>The leaderboard screen allows user to clear up previous records.</li>
      </ul>
    </td>
  </tr>
</table><br>


# Implemented but Not Working Properly
**1. Hitbox Adjustments**
<table style="width:100%">
  <tr>
    <th>Feature</th>
    <th>Encountered Issue</th>
    <th>Steps Taken to Address</th>
  </tr>
  <tr>
    <td>
     Adjusting the hitbox of the user plane, enemy planes, and boss plane to be smaller, preventing projectiles from hitting empty space.
    </td>
    <td>
      Despite attempts to adjust the hitboxes, projectiles still hit empty spaces around the planes. The hitboxes are not accurately reflecting the visual boundaries of the planes.
    </td>
    <td>
     Reviewed the hitbox calculation and test with different hitbox sizes <br><br>
      Current steps to address:
      <ul>
        <li>Ensure that the hitbox dimensions are correctly calculated based on the visual dimensions of the planes.</li>
        <li>Verify that the hitbox coordinates are correctly aligned with the plane sprites.</li>
        <li>Experiment with different hitbox sizes and shapes to find the optimal dimensions that prevent projectiles from hitting empty spaces.</li>
        <li>Test the adjustments in various scenarios to ensure consistency across different planes and levels.</li>
      </ul>
      Unfortunely, the problem remains unsolved currently and needed to be solved in the future.
    </td>
  </tr>
</table><br>


# Features Not Implemented
**1. In-Game Power-ups**
<table style="width:100%">
  <tr>
    <th>Feature</th>
    <th>Reason for Not Implementing</th>
  </tr>
  <tr>
    <td>
      Did not add any additional power ups for game interaction throughtout the whole game.
    </td>
    <td>
      <ul>
        <li>Implementing in-game power-ups requires significant changes to the game mechanics and balancing. Due to time constraints and the complexity involved in designing and integrating various power-ups, this feature was not prioritized.</li>
      </ul>
    </td>
  </tr>
</table><br>

**2. LoseGameScreen**
<table style="width:100%">
  <tr>
    <th>Feature</th>
    <th>Reason for Not Implementing</th>
  </tr>
  <tr>
    <td>
     Lose game screen is not created
    </td>
    <td>
      <ul>
        <li>A lose game screen was not created due to time constraints and the need to focus on other essential features. Developing a lose screen would require additional design and implementation efforts, which were allocated to more critical aspects of the game. As a result, this feature was not included in the current version of the game.</li>
      </ul>
    </td>
  </tr>
</table><br>


# New Java Classes
<table style="width:100%">
<tr>
  <th>New Classes</th>
  <th>Description</th>
  <th>Location</th>
</tr>
<tr>
   <td>
    1. EnemyPlane2
    </td>
    <td>
     The EnemyPlane2 class is a new type of enemy aircraft in a game that moves horizontally and can randomly fire projectiles at the player.
    </td>
    <td>
    src/main/java/com/example/demo/actor/planes/EnemyPlane2.java
    </td>
</tr>
<tr>
   <td>
    2. ShieldActivation
    </td>
    <td>
     The ShieldActivation class manages the activation, deactivation, and cooldown of a shield for an actor, including its visual representation and duration logic.
    </td>
    <td>
    src/main/java/com/example/demo/actor/ShieldActivation.java
    </td>
</tr>
<tr>
   <td>
    3. MusicController
    </td>
    <td>
     The MusicController class manages the playback of background music in a game, ensuring only one instance exists using the singleton pattern.
    </td>
    <td>
    src/main/java/com/example/demo/audios/MusicController.java
    </td>
</tr>
<tr>
   <td>
    4. ProjectileSoundController
    </td>
    <td>
     The ProjectileSoundController class handles the playback of sound effects for projectiles by providing a method to play specified sound files.
    </td>
    <td>
    src/main/java/com/example/demo/audios/ProjectileSoundController.java
    </td>
</tr>
<tr>
   <td>
    5. LevelFactory
    </td>
    <td>
     The LevelFactory class is responsible for creating instances of different game levels using a factory method to instantiate the appropriate level based on the provided level name.
    </td>
    <td>
    src/main/java/com/example/demo/factories/LevelFactory.java
    </td>
</tr>
<tr>
   <td>
    6. LevelViewFactory
   </td>
   <td>
     The LevelViewFactory class is responsible for creating instances of different level views using a factory method to determine the appropriate level view based on the provided level type.
   </td>
   <td>
   src/main/java/com/example/demo/factories/LevelViewFactory.java
   </td>
</tr>
<tr>
   <td>
    7. PlaneFactory
   </td>
   <td>
     The PlaneFactory class is responsible for creating instances of different types of planes using a factory method to instantiate the appropriate plane based on the provided type.
   </td>
   <td>
   src/main/java/com/example/demo/factories/PlaneFactory.java
   </td>
</tr>
<tr>
   <td>
    8. ProjectileFactory
   </td>
   <td>
     The ProjectileFactory class is responsible for creating instances of different types of projectiles using a factory method to determine the appropriate projectile based on the provided type.
   </td>
   <td>
   src/main/java/com/example/demo/factories/ProjectileFactory.java
   </td>
</tr>
<tr>
   <td>
    9. LevelTwo
   </td>
   <td>
     The LevelTwo class represents the second level of the game, extending the LevelParent class, and manages level-specific enemies, game state transitions, and gameplay logic for advancing to the next stage.
   </td>
   <td>
   src/main/java/com/example/demo/levels/LevelTwo.java
   </td>
</tr>
<tr>
   <td>
    10. LevelBossView
   </td>
   <td>
     The LevelBossView class represents the visual components of the boss level, managing the display and visibility of the shield image alongside other visual elements.
   </td>
   <td>
   src/main/java/com/example/demo/levels/LevelBossView.java
   </td>
</tr>
<tr>
   <td>
    11. ActorManager
   </td>
   <td>
     The ActorManager class manages game actors, including friendly units, enemy units, and projectiles, handling their updates, removal of destroyed actors, collisions, and spawning logic.
   </td>
   <td>
   src/main/java/com/example/demo/managers/ActorManager.java
   </td>
</tr>
<tr>
   <td>
    12. BackgroundManager
   </td>
   <td>
     The BackgroundManager class handles the background image in the game, including initializing its size, adding it to the scene, and managing potential updates.
   </td>
   <td>
   src/main/java/com/example/demo/managers/BackgroundManager.java
   </td>
</tr>
<tr>
   <td>
    13. CollisionManager
   </td>
   <td>
     The CollisionManager class handles collision detection and damage application between two lists of game actors.
   </td>
   <td>
   src/main/java/com/example/demo/managers/CollisionManager.java
   </td>
</tr>
<tr>
   <td>
    14. EnemyManager
   </td>
   <td>
     The EnemyManager class handles the spawning, updating, and management of enemy units in the game, including detecting enemy penetration and removing destroyed enemies.
   </td>
   <td>
   src/main/java/com/example/demo/managers/EnemyManager.java
   </td>
</tr>
<tr>
   <td>
    15. GameStateManager
   </td>
   <td>
     The GameStateManager class handles the win and lose conditions of the game, managing the game state by checking if the user has won or lost and transitioning to the next level if conditions are met.
   </td>
   <td>
   src/main/java/com/example/demo/managers/GameStateManager.java
   </td>
</tr>
<tr>
   <td>
    16. InputManager
   </td>
   <td>
     The InputManager class manages user input for controlling the user plane's movement and firing projectiles. It listens for key events, such as movement and space bar presses, and invokes the appropriate actions on the user plane and projectiles.
   </td>
   <td>
   src/main/java/com/example/demo/managers/InputManager.java
   </td>
</tr>
<tr>
   <td>
    17. PauseManager
   </td>
   <td>
     The PauseManager class manages the pause functionality in the game. It allows the game to be paused and resumed, displays the pause screen, and manages the pause button. The class interacts with other game components to pause the timeline, stop the timer, and show a settings menu.
   </td>
   <td>
   src/main/java/com/example/demo/managers/PauseManager.java
   </td>
</tr>
<tr>
   <td>
    18. ProjectileManager
   </td>
   <td>
     The ProjectileManager class manages the projectiles fired by both user and enemy units in the game. It handles generating enemy fire, spawning projectiles, and managing the list of projectiles for both user and enemy units. The class is responsible for adding projectiles to the scene and updating their positions.
   </td>
   <td>
   src/main/java/com/example/demo/managers/ProjectileManager.java
   </td>
</tr>
<tr>
   <td>
    19. StatusTextManager
   </td>
   <td>
     The StatusTextManager class manages the status text displayed on the screen. It handles the initialization, positioning, and updating of the status text. The text is displayed in a specified font and centered horizontally. The class also ensures that the text remains visible by bringing it to the front when updated.
   </td>
   <td>
   src/main/java/com/example/demo/managers/StatusTextManager.java
   </td>
</tr>
<tr>
   <td>
    20. TimelineManager
   </td>
   <td>
     The TimelineManager class manages the game loop timeline for updating the scene. It controls the timing of scene updates by running a game loop at a fixed interval. The timeline can be started, paused, resumed, and stopped, allowing for flexible control over the game's update cycle. The class ensures that the game's update routine is executed repeatedly at a specified delay.
   </td>
   <td>
   src/main/java/com/example/demo/managers/TimelineManager.java
   </td>
</tr>
<tr>
   <td>
    21. HorizontalMovementStrategy
   </td>
   <td>
     The HorizontalMovementStrategy class implements the MovementStrategy interface and defines a strategy for moving a fighter plane horizontally. It allows a fighter plane to move at a specified velocity in the horizontal direction. This class encapsulates the behavior of horizontal movement, enabling flexibility in controlling how the plane moves.
   </td>
   <td>
   src/main/java/com/example/demo/strategies/movement/HorizontalMovementStrategy.java
   </td>
</tr>
<tr>
   <td>
    22. MovementStrategy
   </td>
   <td>
     The MovementStrategy interface defines the method required for a movement strategy. Any class implementing this interface must provide an implementation for updating the position of a fighter plane. This interface decouples the movement logic from specific plane types, allowing for different movement strategies (e.g., horizontal, vertical, or combined movements) to be easily swapped and applied to various plane types.
   </td>
   <td>
   src/main/java/com/example/demo/strategies/movement/MovementStrategy.java
   </td>
</tr>
<tr>
   <td>
    23. VerticalMovementStrategy
   </td>
   <td>
     The VerticalMovementStrategy class implements the MovementStrategy interface. It defines a strategy for moving a fighter plane vertically. The strategy ensures that the plane moves vertically at a specified velocity and prevents the plane from moving out of the allowed vertical bounds (e.g., the screen limits). If the plane exceeds these bounds, its position is reset to the previous valid position, ensuring controlled movement within the screen.
   </td>
   <td>
   src/main/java/com/example/demo/strategies/movement/VerticalMovementStrategy.java
   </td>
</tr>
<tr>
   <td>
    24. HorizontalProjectileMovementStrategy
   </td>
   <td>
     The HorizontalProjectileMovementStrategy class implements the ProjectileMovementStrategy interface. It defines a strategy for moving a projectile horizontally. The strategy ensures that the projectile moves horizontally at a specified velocity, which can be customized upon instantiation. This class provides a method to update the position of the projectile by adjusting its horizontal movement.
   </td>
   <td>
   src/main/java/com/example/demo/strategies/projectile/HorizontalProjectileMovementStrategy.java
   </td>
</tr>

<tr>
   <td>
    25. ProjectileFiringStrategy
   </td>
   <td>
     The ProjectileFiringStrategy interface defines the method required for a projectile firing strategy. Any class implementing this interface must provide an implementation for firing a projectile. The firing method returns the fired projectile (or null if no projectile is fired).
   </td>
   <td>
   src/main/java/com/example/demo/strategies/projectile/ProjectileFiringStrategy.java
   </td>
</tr>
<tr>
   <td>
    26. ProjectileMovementStrategy
   </td>
   <td>
     The ProjectileMovementStrategy interface defines the method required for a projectile movement strategy. Any class implementing this interface must provide an implementation for updating the position of a projectile.
   </td>
   <td>
   src/main/java/com/example/demo/strategies/projectile/ProjectileMovementStrategy.java
   </td>
</tr>
<tr>
   <td>
    27. LeaderboardScreen
   </td>
   <td>
     The LeaderboardScreen class displays the leaderboard with the times of each playthrough.
   </td>
   <td>
   src/main/java/com/example/demo/ui/LeaderboardScreen.java
   </td>
</tr>
<tr>
   <td>
    28. MainMenu
   </td>
   <td>
     The MainMenu class creates the main menu interface for the game, including buttons to start the game, view instructions, and exit.
   </td>
   <td>
   src/main/java/com/example/demo/ui/MainMenu.java
   </td>
</tr>
<tr>
   <td>
    29. PauseScreen
   </td>
   <td>
     The PauseScreen class represents a pause screen in a JavaFX application. It provides options to resume the game, go to settings, or return to the main menu.
   </td>
   <td>
   src/main/java/com/example/demo/ui/PauseScreen.java
   </td>
</tr>
<tr>
   <td>
    30. WinGameScreen
   </td>
   <td>
     The WinGameScreen class displays the screen shown when the player wins the game. It includes options to restart the level or return to the main menu. The screen also shows the total time taken to win the game.
   </td>
   <td>
   src/main/java/com/example/demo/ui/WinGameScreen.java
   </td>
</tr>
<tr>
   <td>
    31. GameController (Controller.java to GameController.java)
   </td>
   <td>
     The GameController class manages the game's flow, including launching the game, transitioning between levels, and handling errors. It also handles level transitions with fade-in and fade-out effects and shows error messages if any issues occur during level loading.
   </td>
   <td>
   src/main/java/com/example/demo/controller/GameController.java
   </td>
</tr>
<tr>
   <td>
    32. GameLauncher (Main.java to GameLauncher.java)
   </td>
   <td>
     The GameLauncher class is the entry point for the game application. It sets up the main menu and initial stage properties. It also provides methods to start the game levels and initializes the MusicController for background music.
   </td>
   <td>
   src/main/java/com/example/demo/controller/GameLauncher.java
   </td>
</tr>
<tr>
   <td>
    33. LevelBossView (LevelViewLevelTwo.java to LevelBossView.java)
   </td>
   <td>
     The LevelBossView class represents the visual components of the boss level, including the display and management of the shield image. It handles adding, displaying, and removing the shield image in the game scene.
   </td>
   <td>
   src/main/java/com/example/demo/levels/LevelBossView.java
   </td>
</tr>
<tr>
   <td>
    34. TimerManager
   </td>
   <td>
    The TimerManager class manages the timing and duration tracking for different levels in the game. It provides functionality to start, stop, and store elapsed times for individual levels and calculate the total time across all levels.
   </td>
   <td>
    src/main/java/com/example/demo/managers/TimerManager.java
   </td>
</tr>
</table><br>


# Modified Java Classes
**1. ActiveActor**
<table style="width:100%; border-collapse: collapse;">
  <tr>
    <th>Original Version</th>
    <th>Modified Version</th>
  </tr>
  <tr>
    <td>
       <li>The movement methods (moveHorizontally and moveVertically) are protected, which means only the ActiveActor class and its subclasses can access them. This limits the scope of these methods and may not be ideal if other classes need to manipulate the actor's movement.</li>
    </td>
    <td>
    <li>The movement methods are made public, allowing any class to access and use these methods. This increases flexibility, enabling other classes to directly manipulate the actor’s position if needed.</li>
    </td>
  </tr>
</table><br>

**2. ActiveActorDestructible**
<table style="width:100%; border-collapse: collapse;">
  <tr>
    <th>Original Version</th>
    <th>Modified Version</th>
  </tr>
  <tr>
    <td>
       <li>The `updateActor()` method is defined as an abstract method but lacks specific documentation or additional logic, making it unclear for subclasses on how to implement this method.</li>
    </td>
    <td>
    <li>The `updateActor()` method is clearly defined with a comment specifying that it must be implemented by subclasses. The abstract method remains the same, but the documentation emphasizes the need for subclasses to implement this method, improving code clarity.</li>
    </td>
  </tr>
  <tr>
    <td>
       <li>The constructor for the `ActiveActorDestructible` class is quite straightforward, initializing the `isDestroyed` flag to `false` without any additional logic or comments.</li>
    </td>
    <td>
    <li>The constructor in the modified version includes an added comment explaining the purpose of each parameter and the initialization of the `isDestroyed` flag. This improves code readability and understanding for developers working with this class.</li>
    </td>
  </tr>
</table><br>

**3. BossPlane**
<table style="width:100%; border-collapse: collapse;">
  <tr>
    <th>Original Version</th>
    <th>Modified Version</th>
  </tr>
  <tr>
    <td>
       <li>The Boss class uses a list (`movePattern`) to define a movement pattern, and the movement is updated with a manual index and logic for the next move. The vertical movement is adjusted through a custom method and constants like `VERTICAL_VELOCITY` and `ZERO`.</li>
    </td>
    <td>
    <li>The BossPlane class uses a `VerticalMovementStrategy` for handling movement. This encapsulates the logic for vertical movement, making it more modular and easier to change the movement behavior if needed. The movement pattern itself is defined by predefined values, which include both small and large vertical steps.</li>
    </td>
  </tr>
  <tr>
    <td>
       <li>The original Boss class manually handles the activation and deactivation of the shield within the `updateShield()` method and tracks the shield's frames, while also determining when the shield should be activated based on random chance.</li>
    </td>
    <td>
    <li>The Modified BossPlane class delegates shield handling to a separate `ShieldActivation` class, which is responsible for managing the shield's state and behavior. The shield is activated immediately upon creation, and the logic is decoupled from the `BossPlane` class, making the code cleaner and more maintainable.</li>
    </td>
  </tr>
</table><br>

**4. EnemyPlane**
<table style="width:100%; border-collapse: collapse;">
  <tr>
    <th>Original Version</th>
    <th>Modified Version</th>
  </tr>
  <tr>
    <td>
       <li>The `updatePosition()` method directly calls the `moveHorizontally()` method with a fixed velocity. This limits the flexibility of the movement logic and makes it harder to change the movement behavior later.</li>
    </td>
    <td>
    <li>The `updatePosition()` method uses a `HorizontalMovementStrategy` object for horizontal movement. This approach follows the strategy design pattern, making it easier to change or extend the movement behavior without modifying the `EnemyPlane` class directly.</li>
    </td>
  </tr>
  <tr>
    <td>
       <li>The `fireProjectile()` method directly creates an `EnemyProjectile` within the method by computing the projectile's position each time it is called.</li>
    </td>
    <td>
    <li>The `fireProjectile()` method uses a firing strategy (`setFiringStrategy`) that encapsulates the logic of projectile creation. This change makes it easier to modify or extend the firing logic in the future without changing the core `EnemyPlane` class.</li>
    </td>
  </tr>
</table><br>

**5. UserPlane**
<table style="width:100%; border-collapse: collapse;">
  <tr>
    <th>Original Version</th>
    <th>Modified Version</th>
  </tr>
  <tr>
    <td>
       <li>The `updatePosition()` method only supports vertical movement with a multiplier for controlling speed. Horizontal movement is not supported, and the plane's position is constrained vertically between an upper and lower bound.</li>
    </td>
    <td>
    <li>The `updatePosition()` method supports both vertical and horizontal movement, allowing the plane to move in all directions. Horizontal bounds are also set, enabling the plane to move freely within the game area horizontally and vertically.</li>
    </td>
  </tr>
  <tr>
    <td>
       <li>The `fireProjectile()` method creates a new projectile with a fixed X and Y offset for the initial position each time it is called.</li>
    </td>
    <td>
    <li>The `fireProjectile()` method remains the same but with a more structured approach for managing projectile creation and adding directional movement for the plane.</li>
    </td>
  </tr>
</table><br>

**6. FighterPlane**
<table style="width:100%; border-collapse: collapse;">
  <tr>
    <th>Original Version</th>
    <th>Modified Version</th>
  </tr>
  <tr>
    <td>
       <li>The `updatePosition()` method only supports vertical movement with a multiplier for controlling speed. Horizontal movement is not supported, and the plane's position is constrained vertically between an upper and lower bound.</li>
    </td>
    <td>
    <li>The `updatePosition()` method supports both vertical and horizontal movement, allowing the plane to move in all directions. Horizontal bounds are also set, enabling the plane to move freely within the game area horizontally and vertically.</li>
    </td>
  </tr>
  <tr>
    <td>
       <li>The `fireProjectile()` method creates a new projectile with a fixed X and Y offset for the initial position each time it is called.</li>
    </td>
    <td>
    <li>The `fireProjectile()` method remains the same but with a more structured approach for managing projectile creation and adding directional movement for the plane.</li>
    </td>
  </tr>
  <tr>
    <td>
       <li>The `takeDamage()` method reduces the plane's health by one and destroys the plane if health reaches zero. The plane's health is managed as an integer.</li>
    </td>
    <td>
    <li>The `takeDamage()` method is similar, but health is still reduced by one and the plane is destroyed if health reaches zero. It has been integrated with a broader design where movement and firing strategies are set through separate mechanisms.</li>
    </td>
  </tr>
  <tr>
    <td>
       <li>The `getProjectileXPosition()` and `getProjectileYPosition()` methods calculate the position for firing projectiles using `getLayoutX()` and `getLayoutY()` along with the provided offsets.</li>
    </td>
    <td>
    <li>The same methods for calculating projectile position are retained but the calculation remains tightly integrated with the broader design, with added flexibility in handling the plane's dynamic position adjustments.</li>
    </td>
  </tr>
  <tr>
    <td>
       <li>In the original, the `FighterPlane` class only manages health and destruction. There is no separate handling for movement strategies or projectile firing strategies.</li>
    </td>
    <td>
    <li>The `FighterPlane` class now includes additional handling for movement and firing strategies, allowing for better separation of concerns and making the plane's behavior more customizable and extensible.</li>
    </td>
  </tr>
</table><br>

**7. BossProjectile**
<table style="width:100%; border-collapse: collapse;">
  <tr>
    <th>Original Version</th>
    <th>Modified Version</th>
  </tr>
  <tr>
    <td>
       <li>The `updatePosition()` method moves the projectile horizontally by a fixed velocity without using any movement strategy.</li>
    </td>
    <td>
    <li>The `updatePosition()` method still moves the projectile horizontally by a fixed velocity, but it uses a `HorizontalProjectileMovementStrategy` to manage the movement, providing a more flexible and extendable design.</li>
    </td>
  </tr>
  <tr>
    <td>
       <li>The class directly defines the movement logic for the projectile in the `updatePosition()` method.</li>
    </td>
    <td>
    <li>The class delegates the movement logic to a `HorizontalProjectileMovementStrategy`, separating the movement behavior from the class itself, making it easier to modify or extend in the future.</li>
    </td>
  </tr>
  <tr>
    <td>
       <li>The `updateActor()` method calls `updatePosition()` to update the projectile's position.</li>
    </td>
    <td>
    <li>The `updateActor()` method remains the same but relies on the strategy pattern for movement, which separates concerns more effectively.</li>
    </td>
  </tr>
  <tr>
    <td>
       <li>The `BossProjectile` class directly manages its horizontal velocity and movement in a less modular way.</li>
    </td>
    <td>
    <li>The `BossProjectile` class utilizes a strategy pattern, encapsulating movement behavior and improving modularity and flexibility in how projectiles can move.</li>
    </td>
  </tr>
  <tr>
    <td>
       <li>The image height for the projectile is set to 75 pixels in the original version.</li>
    </td>
    <td>
    <li>The image height for the projectile is reduced to 50 pixels in the modified version, possibly for consistency with the design or desired appearance of the projectile.</li>
    </td>
  </tr>
</table><br>

**8. EnemyProjectile**
<table style="width:100%; border-collapse: collapse;">
  <tr>
    <th>Original Version</th>
    <th>Modified Version</th>
  </tr>
  <tr>
    <td>
       <li>The `updatePosition()` method moves the projectile horizontally by a fixed velocity without using any movement strategy.</li>
    </td>
    <td>
    <li>The `updatePosition()` method still moves the projectile horizontally by a fixed velocity, but it uses a `HorizontalProjectileMovementStrategy` to handle the movement, which provides greater flexibility for future modifications.</li>
    </td>
  </tr>
  <tr>
    <td>
       <li>The class directly defines the movement logic for the projectile in the `updatePosition()` method.</li>
    </td>
    <td>
    <li>The class delegates the movement logic to a `HorizontalProjectileMovementStrategy`, thus decoupling the movement logic from the class itself, which is a more modular and maintainable approach.</li>
    </td>
  </tr>
  <tr>
    <td>
       <li>The `updateActor()` method calls `updatePosition()` to update the projectile's position.</li>
    </td>
    <td>
    <li>The `updateActor()` method remains unchanged, but relies on the strategy pattern for movement management, which enhances modularity and separates concerns effectively.</li>
    </td>
  </tr>
  <tr>
    <td>
       <li>The `EnemyProjectile` class directly manages its horizontal velocity and movement in a less modular way.</li>
    </td>
    <td>
    <li>The `EnemyProjectile` class utilizes a strategy pattern, encapsulating movement behavior in the `HorizontalProjectileMovementStrategy`, making it more flexible and easier to extend or modify.</li>
    </td>
  </tr>
</table><br>

**9. UserProjectile**
<table style="width:100%; border-collapse: collapse;">
  <tr>
    <th>Original Version</th>
    <th>Modified Version</th>
  </tr>
  <tr>
    <td>
       <li>The `UserProjectile` class moves the projectile horizontally by a fixed velocity.</li>
    </td>
    <td>
    <li>The `UserProjectile` class still moves the projectile horizontally by a fixed velocity, but now it also plays a shooting sound when the projectile is created, adding an audio effect to the action.</li>
    </td>
  </tr>
  <tr>
    <td>
       <li>The class only focuses on managing the projectile's movement in the `updatePosition()` method.</li>
    </td>
    <td>
    <li>The class also handles playing the shooting sound in the constructor by invoking `ProjectileSoundController.playSound()`, enhancing the user experience with audio feedback.</li>
    </td>
  </tr>
  <tr>
    <td>
       <li>The `updateActor()` method calls `updatePosition()` to update the projectile's position.</li>
    </td>
    <td>
    <li>The `updateActor()` method remains unchanged but benefits from the added audio functionality in the constructor to handle sound effects when a projectile is created.</li>
    </td>
  </tr>
  <tr>
    <td>
       <li>The `UserProjectile` class does not include any sound or audio-related features.</li>
    </td>
    <td>
    <li>The `UserProjectile` class integrates audio feedback for a more immersive gameplay experience by playing a shooting sound when the projectile is created.</li>
    </td>
  </tr>
</table><br>

**10. Projectile**
<table style="width:100%; border-collapse: collapse;">
  <tr>
    <th>Original Version</th>
    <th>Modified Version</th>
  </tr>
  <tr>
    <td>
       <li>The `Projectile` class does not use any movement strategy for handling position updates and directly implements the movement logic in the `updatePosition()` method.</li>
    </td>
    <td>
    <li>The `Projectile` class uses a `ProjectileMovementStrategy` to handle the movement logic, allowing for greater flexibility and decoupling of the movement behavior from the class itself.</li>
    </td>
  </tr>
  <tr>
    <td>
       <li>The `updatePosition()` method in the original version directly manages the position update.</li>
    </td>
    <td>
    <li>The `updatePosition()` method in the modified version delegates the position update to the assigned `ProjectileMovementStrategy`, enabling different movement behaviors without modifying the class itself.</li>
    </td>
  </tr>
  <tr>
    <td>
       <li>The `Projectile` class does not include functionality for setting a movement strategy.</li>
    </td>
    <td>
    <li>The modified class allows for setting a `ProjectileMovementStrategy`, making it more modular and flexible for different types of projectile movement behaviors.</li>
    </td>
  </tr>
  <tr>
    <td>
       <li>The `takeDamage()` method directly destroys the projectile when damage is taken.</li>
    </td>
    <td>
    <li>The `takeDamage()` method remains the same but benefits from the additional movement strategy feature, allowing the class to be more adaptable in terms of behavior separation.</li>
    </td>
  </tr>
</table><br>

**11. Destructible**
<table style="width:100%; border-collapse: collapse;">
  <tr>
    <th>Original Version</th>
    <th>Modified Version</th>
  </tr>
  <tr>
    <td>
       <li>The original `Destructible` interface simply defines two methods: `takeDamage()` and `destroy()`, without additional documentation.</li>
    </td>
    <td>
    <li>The modified `Destructible` interface includes detailed documentation for both methods, explaining the expected behavior for `takeDamage()` (how the object should respond to damage) and `destroy()` (what should happen when the object is destroyed).</li>
    </td>
  </tr>
  <tr>
    <td>
       <li>The original version does not provide any implementation or guidelines for what should happen in the `takeDamage()` or `destroy()` methods.</li>
    </td>
    <td>
    <li>The modified version still does not provide implementations but provides clear explanations and expectations for those implementing the interface, encouraging more structured and consistent behavior.</li>
    </td>
  </tr>
</table><br>

**12. LevelBoss (previously Level Two)**
<table style="width:100%; border-collapse: collapse;">
  <tr>
    <th>Original Version</th>
    <th>Modified Version</th>
  </tr>
  <tr>
    <td>
       <li>The `LevelTwo` class is a simple implementation that includes a boss and basic game logic, such as spawning the boss and checking for game over conditions.</li>
    </td>
    <td>
    <li>The `LevelBoss` class expands upon this with more complex behavior, including the addition of a shield for the boss plane, a timer manager, and integration with a win game screen. It also uses a factory method to instantiate the level view, offering more flexibility and separation of concerns.</li>
    </td>
  </tr>
  <tr>
    <td>
       <li>The `LevelTwo` class defines a fixed background and boss setup, with a straightforward flow for handling level completion.</li>
    </td>
    <td>
    <li>The `LevelBoss` class introduces a more dynamic setup, such as binding the shield's position to the boss and starting/stopping the game timer based on the level’s progress. The level also transitions more smoothly to the next stage with proper time tracking.</li>
    </td>
  </tr>
  <tr>
    <td>
       <li>The `LevelTwo` class uses a static approach to define the boss and other units.</li>
    </td>
    <td>
    <li>The `LevelBoss` class is more modular, using a factory pattern for the level view and incorporating the `ShieldImage` class to handle the boss’s shield.</li>
    </td>
  </tr>
  <tr>
    <td>
       <li>The `checkIfGameOver()` method in `LevelTwo` checks only the user and boss for destruction, transitioning the game based on their states.</li>
    </td>
    <td>
    <li>The `checkIfGameOver()` method in `LevelBoss` is similar but also includes the stopping of the timer when the game ends and tracks time for further levels, providing more control over the game flow.</li>
    </td>
  </tr>
  <tr>
    <td>
       <li>The `spawnEnemyUnits()` method in `LevelTwo` simply adds the boss when there are no enemies.</li>
    </td>
    <td>
    <li>The `spawnEnemyUnits()` method in `LevelBoss` uses a more flexible approach, where enemy units are added as necessary, with more control over the boss's behavior and state.</li>
    </td>
  </tr>
</table><br>

**13. LevelOne**
<table style="width:100%; border-collapse: collapse;">
  <tr>
    <th>Original Version</th>
    <th>Modified Version</th>
  </tr>
  <tr>
    <td>
       <li>The `LevelOne` class is responsible for the first level, including checking for game over conditions based on the user's destruction or the kill target.</li>
    </td>
    <td>
    <li>The modified `LevelOne` class introduces more sophisticated game management, with dedicated managers for actors, game state, and status text. It also integrates a timer manager and factory-based level view instantiation, improving flexibility and modularity.</li>
    </td>
  </tr>
  <tr>
    <td>
       <li>The `checkIfGameOver()` method checks if the user is destroyed or if the kill target is reached, transitioning to the next level accordingly.</li>
    </td>
    <td>
    <li>The `checkIfGameOver()` method now stops the timer and stores the level time, delegating the decision-making to a `GameStateManager`, allowing for easier future modifications and enhanced game flow control.</li>
    </td>
  </tr>
  <tr>
    <td>
       <li>`initializeFriendlyUnits()` adds the user plane to the game screen.</li>
    </td>
    <td>
    <li>The `initializeFriendlyUnits()` method now uses `ActorManager` to initialize both friendly units and enemy units, centralizing unit management and making the class more scalable.</li>
    </td>
  </tr>
  <tr>
    <td>
       <li>The `spawnEnemyUnits()` method uses a simple random spawn logic for enemies.</li>
    </td>
    <td>
    <li>The `spawnEnemyUnits()` method now leverages `ActorManager` to handle enemy spawning, allowing more complex behaviors to be integrated (e.g., different spawn patterns) and improving code maintainability.</li>
    </td>
  </tr>
  <tr>
    <td>
       <li>The `instantiateLevelView()` method directly creates a new `LevelView` for the first level.</li>
    </td>
    <td>
    <li>The `instantiateLevelView()` method uses a factory pattern (`LevelViewFactory`) to create the level view, which enhances flexibility and decouples view instantiation logic from the rest of the class.</li>
    </td>
  </tr>
  <tr>
    <td>
       <li>The original code used a simple random chance to determine enemy spawns.</li>
    </td>
    <td>
    <li>The modified code abstracts the enemy spawning logic into the `ActorManager`, which uses a lambda to create enemy units, improving modularity and readability.</li>
    </td>
  </tr>
</table><br>

**14. LevelParent**
<table style="width:100%; border-collapse: collapse;">
  <tr>
    <th>Original Version</th>
    <th>Modified Version</th>
  </tr>
  <tr>
    <td>
       <li>The `LevelParent` class serves as a base class for individual levels, providing essential game flow logic.</li>
    </td>
    <td>
    <li>The modified `LevelParent` class introduces a more modular structure by separating the responsibilities of managing actors, game state, and UI elements into dedicated managers, improving scalability and flexibility.</li>
    </td>
  </tr>
  <tr>
    <td>
       <li>The original `LevelParent` class directly managed the initialization of various game elements, including actors, timers, and score display.</li>
    </td>
    <td>
    <li>The modified `LevelParent` class offloads these responsibilities to specialized managers, such as `ActorManager`, `TimerManager`, and `ScoreManager`, making the class more maintainable and allowing for better separation of concerns.</li>
    </td>
  </tr>
  <tr>
    <td>
       <li>The `initialize()` method initializes the level's components directly within the `LevelParent` class.</li>
    </td>
    <td>
    <li>The `initialize()` method is now a more generic method that delegates initialization tasks to dedicated manager classes, ensuring better modularity and clearer responsibilities for each class.</li>
    </td>
  </tr>
  <tr>
    <td>
       <li>The original code placed all game logic inside the `LevelParent` class, including game flow management, which resulted in a less modular and harder-to-maintain design.</li>
    </td>
    <td>
    <li>The modified `LevelParent` class separates game flow, actor management, UI handling, and state tracking into distinct classes, improving the flexibility of adding new features and modifying the game's behavior without impacting other areas.</li>
    </td>
  </tr>
  <tr>
    <td>
       <li>The `endLevel()` method directly handled level transitions and end-of-level checks.</li>
    </td>
    <td>
    <li>The `endLevel()` method now works with the `GameStateManager` to handle level transitions and ensure game state consistency, improving extensibility for future game features.</li>
    </td>
  </tr>
  <tr>
    <td>
       <li>The `scoreDisplay` was managed directly within the `LevelParent` class.</li>
    </td>
    <td>
    <li>The `scoreDisplay` in the modified version is managed by a `ScoreManager`, allowing for more flexible and centralized control over the player's score display and making future changes easier to implement.</li>
    </td>
  </tr>
</table><br>

**15. LevelView**
<table style="width:100%; border-collapse: collapse;">
  <tr>
    <th>Original Version</th>
    <th>Modified Version</th>
  </tr>
  <tr>
    <td>
       <li>The `LevelView` class manages the visual components of a level, including the heart display and game-over image.</li>
    </td>
    <td>
    <li>The modified `LevelView` class introduces more dynamic and flexible management of the heart display and game-over images, including automatic centering of the game-over image based on screen size.</li>
    </td>
  </tr>
  <tr>
    <td>
       <li>The `HEART_DISPLAY_X_POSITION` and `HEART_DISPLAY_Y_POSITION` constants are used to set the heart display's position.</li>
    </td>
    <td>
    <li>The heart display's position remains static in the modified version, but the game-over image's position is dynamically calculated to be centered based on the scene’s dimensions.</li>
    </td>
  </tr>
  <tr>
    <td>
       <li>The `showHeartDisplay()` method adds the heart display to the root group of the scene.</li>
    </td>
    <td>
    <li>The `showHeartDisplay()` method still adds the heart display to the root group, maintaining consistent logic, while the game-over image handling has been separated into its own method for better readability.</li>
    </td>
  </tr>
  <tr>
    <td>
       <li>The `showWinImage()` and `showGameOverImage()` methods are used to display win and game-over images, respectively.</li>
    </td>
    <td>
    <li>The `showGameOverImage()` method in the modified version now adds the game-over image to the root group after calculating its centered position, which enhances the game's responsiveness to screen size.</li>
    </td>
  </tr>
  <tr>
    <td>
       <li>The `removeHearts()` method adjusts the heart display by removing hearts based on the remaining health.</li>
    </td>
    <td>
    <li>The `removeHearts()` method is unchanged, still removing hearts from the display as needed, but the class structure has been refactored for better maintainability and UI handling separation.</li>
    </td>
  </tr>
  <tr>
    <td>
       <li>The `GameOverImage` class in the original version did not consider window size when positioning the image.</li>
    </td>
    <td>
    <li>The `GameOverImage` in the modified version is positioned dynamically based on the screen size, ensuring that it is always centered properly.</li>
    </td>
  </tr>
</table><br>

**16. GameOverImage**

<table style="width:100%; border-collapse: collapse;">
  <tr>
    <th>Original Version</th>
    <th>Modified Version</th>
  </tr>
  <tr>
    <td>
       <li>The `GameOverImage` class is a simple `ImageView` that displays a "Game Over" image at a given position.</li>
    </td>
    <td>
    <li>The modified `GameOverImage` class extends `ImageView` and adds more flexibility by allowing you to specify both the image's position and dimensions (width and height), improving customization.</li>
    </td>
  </tr>
  <tr>
    <td>
       <li>The original class only allowed positioning the image at a specified (x, y) position, but it did not offer control over the image's size.</li>
    </td>
    <td>
    <li>The modified class introduces additional parameters for width and height, allowing the image to be resized as needed.</li>
    </td>
  </tr>
  <tr>
    <td>
       <li>The `GameOverImage` class in the original code only initialized the image with a default size.</li>
    </td>
    <td>
    <li>The modified code uses the `setFitWidth()` and `setFitHeight()` methods to set custom dimensions, providing greater flexibility in image scaling.</li>
    </td>
  </tr>
  <tr>
    <td>
       <li>The original code did not explicitly set the image dimensions; they were implicitly determined by the `ImageView` class itself.</li>
    </td>
    <td>
    <li>The modified version explicitly defines the width and height of the image, allowing for precise control over its display size.</li>
    </td>
  </tr>
  <tr>
    <td>
       <li>The image is loaded using the `getResource()` method, but no scaling options were provided.</li>
    </td>
    <td>
    <li>The image is still loaded using `getResource()`, but now the code also scales it to the specified width and height, giving better control over how the image appears on the screen.</li>
    </td>
  </tr>
</table><br>

**17. HeartDisplay**

<table style="width:100%; border-collapse: collapse;">
  <tr>
    <th>Original Version</th>
    <th>Modified Version</th>
  </tr>
  <tr>
    <td>
       <li>The `HeartDisplay` class manages a display of heart images in a `HBox`, with the ability to initialize a specified number of hearts and remove them as necessary.</li>
    </td>
    <td>
    <li>The modified `HeartDisplay` class also manages the display of heart images in a `HBox`, but the code now includes detailed comments and explanations to improve readability and understanding of each function's purpose.</li>
    </td>
  </tr>
  <tr>
    <td>
       <li>The original version does not include JavaDoc comments for methods and class functionality, which makes it less intuitive to understand.</li>
    </td>
    <td>
    <li>The modified version adds JavaDoc comments to each method and the class itself, improving clarity, maintainability, and self-documentation.</li>
    </td>
  </tr>
  <tr>
    <td>
       <li>The heart image is loaded from a static path (`/com/example/demo/images/heart.png`) with the same height (`50px`) for all heart images.</li>
    </td>
    <td>
    <li>The heart image is still loaded from the same static path, but now the code ensures proper preservation of the aspect ratio, making it more flexible for resizing.</li>
    </td>
  </tr>
  <tr>
    <td>
       <li>The `initializeHearts()` method initializes the hearts and adds them to the container without further checks or explanations.</li>
    </td>
    <td>
    <li>The `initializeHearts()` method is more clearly explained with an explanation of how each heart image is initialized and added to the container, contributing to better readability.</li>
    </td>
  </tr>
  <tr>
    <td>
       <li>The `removeHeart()` method simply removes the first heart from the container without verifying if the container is empty.</li>
    </td>
    <td>
    <li>The `removeHeart()` method in the modified version now includes a check to ensure that the container is not empty before attempting to remove a heart, improving robustness.</li>
    </td>
  </tr>
  <tr>
    <td>
       <li>The original class had minimal error-handling or validation for empty states.</li>
    </td>
    <td>
    <li>The modified class improves safety by checking for empty states before removing a heart, reducing the likelihood of errors during runtime.</li>
    </td>
  </tr>
</table><br>

**18. ShieldImage**

<table style="width:100%; border-collapse: collapse;">
  <tr>
    <th>Original Version</th>
    <th>Modified Version</th>
  </tr>
  <tr>
    <td>
       <li>The `ShieldImage` class manages a shield image, allowing it to be displayed at a specified position with a fixed size.</li>
    </td>
    <td>
    <li>The modified `ShieldImage` class retains the functionality of the original but adds more detailed comments and error-handling for image loading, improving code clarity and robustness.</li>
    </td>
  </tr>
  <tr>
    <td>
       <li>The `ShieldImage` class in the original version loads the shield image and sets its visibility to false initially, but it does not handle image loading errors.</li>
    </td>
    <td>
    <li>The modified class includes error handling by checking if the image loaded successfully using `image.isError()`. If there is an error, it logs a message to indicate the problem.</li>
    </td>
  </tr>
  <tr>
    <td>
       <li>The original class uses a hardcoded path (`"/com/example/demo/images/shield.jpg"`) for the shield image, which may be less flexible and harder to manage if the path changes.</li>
    </td>
    <td>
    <li>The modified class uses a more consistent and organized path (`"/com/example/demo/images/shield.png"`) and offers a more standardized approach to managing resource paths.</li>
    </td>
  </tr>
  <tr>
    <td>
       <li>The original code sets the shield's size via hardcoded values and applies them directly.</li>
    </td>
    <td>
    <li>The modified version introduces the `SHIELD_SIZE` constant, making the shield's size configurable and improving maintainability.</li>
    </td>
  </tr>
  <tr>
    <td>
       <li>The original version simply sets the shield to invisible by default and provides methods to show and hide it.</li>
    </td>
    <td>
    <li>The modified class retains the visibility control but improves readability by adding detailed comments about the purpose of methods like `showShield()` and `hideShield()`.</li>
    </td>
  </tr>
  <tr>
    <td>
       <li>The original class does not include JavaDoc comments, making it harder to understand the purpose of each method at a glance.</li>
    </td>
    <td>
    <li>The modified class includes JavaDoc comments for methods and class-level explanations, improving readability and making the code easier to maintain and understand.</li>
    </td>
  </tr>
</table><br>

# Deleted Java Classes
<table style="width:100%">
  <tr>
    <th>Deleted Java Classes</th>
    <th>Reasons for Deletion</th>
  </tr>
  <tr>
    <td>
      WinImage.java
    </td>
    <td>
      <li>The functionality of displaying a win screen has been replaced with a full-screen win game screen implementation to provide a more immersive experience. The standalone image view approach is no longer required.</li>
    </td>
  </tr>
</table>


# Unexpected Problems
