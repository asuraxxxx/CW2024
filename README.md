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
      <a href="src/main/java/com/example/demo/actor/planes/EnemyPlane2.java">src/main/java/com/example/demo/actor/planes/EnemyPlane2.java</a>
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
      <a href="src/main/java/com/example/demo/actor/ShieldActivation.java">src/main/java/com/example/demo/actor/ShieldActivation.java</a>
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
      <a href="src/main/java/com/example/demo/audios/MusicController.java">src/main/java/com/example/demo/audios/MusicController.java</a>
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
      <a href="src/main/java/com/example/demo/audios/ProjectileSoundController.java">src/main/java/com/example/demo/audios/ProjectileSoundController.java</a>
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
      <a href="src/main/java/com/example/demo/factories/LevelFactory.java">src/main/java/com/example/demo/factories/LevelFactory.java</a>
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
      <a href="src/main/java/com/example/demo/factories/LevelViewFactory.java">src/main/java/com/example/demo/factories/LevelViewFactory.java</a>
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
      <a href="src/main/java/com/example/demo/factories/PlaneFactory.java">src/main/java/com/example/demo/factories/PlaneFactory.java</a>
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
      <a href="src/main/java/com/example/demo/factories/ProjectileFactory.java">src/main/java/com/example/demo/factories/ProjectileFactory.java</a>
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
      <a href="src/main/java/com/example/demo/levels/LevelTwo.java">src/main/java/com/example/demo/levels/LevelTwo.java</a>
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
      <a href="src/main/java/com/example/demo/levels/LevelBossView.java">src/main/java/com/example/demo/levels/LevelBossView.java</a>
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
      <a href="src/main/java/com/example/demo/managers/ActorManager.java">src/main/java/com/example/demo/managers/ActorManager.java</a>
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
      <a href="src/main/java/com/example/demo/managers/BackgroundManager.java">src/main/java/com/example/demo/managers/BackgroundManager.java</a>
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
      <a href="src/main/java/com/example/demo/managers/CollisionManager.java">src/main/java/com/example/demo/managers/CollisionManager.java</a>
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
      <a href="src/main/java/com/example/demo/managers/EnemyManager.java">src/main/java/com/example/demo/managers/EnemyManager.java</a>
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
      <a href="src/main/java/com/example/demo/managers/GameStateManager.java">src/main/java/com/example/demo/managers/GameStateManager.java</a>
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
      <a href="src/main/java/com/example/demo/managers/InputManager.java">src/main/java/com/example/demo/managers/InputManager.java</a>
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
      <a href="src/main/java/com/example/demo/managers/PauseManager.java">src/main/java/com/example/demo/managers/PauseManager.java</a>
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
      <a href="src/main/java/com/example/demo/managers/ProjectileManager.java">src/main/java/com/example/demo/managers/ProjectileManager.java</a>
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
      <a href="src/main/java/com/example/demo/managers/StatusTextManager.java">src/main/java/com/example/demo/managers/StatusTextManager.java</a>
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
      <a href="src/main/java/com/example/demo/managers/TimelineManager.java">src/main/java/com/example/demo/managers/TimelineManager.java</a>
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
      <a href="src/main/java/com/example/demo/strategies/movement/HorizontalMovementStrategy.java">src/main/java/com/example/demo/strategies/movement/HorizontalMovementStrategy.java</a>
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
      <a href="src/main/java/com/example/demo/strategies/movement/MovementStrategy.java">src/main/java/com/example/demo/strategies/movement/MovementStrategy.java</a>
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
      <a href="src/main/java/com/example/demo/strategies/movement/VerticalMovementStrategy.java">src/main/java/com/example/demo/strategies/movement/VerticalMovementStrategy.java</a>
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
      <a href="src/main/java/com/example/demo/strategies/projectile/HorizontalProjectileMovementStrategy.java">src/main/java/com/example/demo/strategies/projectile/HorizontalProjectileMovementStrategy.java</a>
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
      <a href="src/main/java/com/example/demo/strategies/projectile/ProjectileFiringStrategy.java">src/main/java/com/example/demo/strategies/projectile/ProjectileFiringStrategy.java</a>
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
      <a href="src/main/java/com/example/demo/strategies/projectile/ProjectileMovementStrategy.java">src/main/java/com/example/demo/strategies/projectile/ProjectileMovementStrategy.java</a>
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
      <a href="src/main/java/com/example/demo/ui/LeaderboardScreen.java">src/main/java/com/example/demo/ui/LeaderboardScreen.java</a>
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
      <a href="src/main/java/com/example/demo/ui/MainMenu.java">src/main/java/com/example/demo/ui/MainMenu.java</a>
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
      <a href="src/main/java/com/example/demo/ui/PauseScreen.java">src/main/java/com/example/demo/ui/PauseScreen.java</a>
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
      <a href="src/main/java/com/example/demo/ui/WinGameScreen.java">src/main/java/com/example/demo/ui/WinGameScreen.java</a>
   </td>
</tr>
</table><br>



# Modified Java Classes

# Deleted Java Classes

# Unexpected Problems
