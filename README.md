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
**Link: https://github.com/asuraxxx/CW2024** 

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
<li>Introduced a main menu that appears upon game startup.</li>
    <ul>
      <li>The main menu has a start button which allows user to start the game.</li>
      <li>The main menu has an instruction button which shows the instruction screen on how to play the game.</li>
      <li>The main menu has a leaderboard button which displays the time to complete all levels in a decending order.</li>
      <li>The main menu has an exit button that allows user to quit the game.</li>
    </ul>
<li>Created a pause menu to manage game pauses.</li>
    <ul>
      <li>The pause menu will appears when the user clicks on the pause button that is available for all levels throughout the game</li>
      <li>The pause menu will display a text that shows user that game is paused.</li>
      <li>The pause menu has a resume button that allows user to resume the game.</li>
      <li>The pause menu has a setting button that allows user to press into instruction screen.</li>
      <li>The pause menu has a return to main menu button to return to main menu.</li>
    </ul><br>


**2. User Plane Enhancements**
<li>The user plane can move left and right, allowing for smooth horizontal navigation during gameplay.</li><br>


**3. Visual and Audio Improvements**
<li>Added and changed background images for various screens throughout the game.</li>
    <ul>
      <li>Changed background image for level one and level boss.</li>
      <li>Added background iamges for main menu, pause screen, leaderboard screen, win game screen, instruction screen and setting screen. </li>
    </ul>
<li>Changed original icons and added icons for new buttons.</li>
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
<li>Included sound effects for firing projectiles and background music.</li><br>


**4. Gameplay Additions**
<li>Added one additional level (Level Two).</li>
<li>Added level transition screens between levels.</li>
    <ul>
      <lil>The le</lil>
      <li>The level transition screen will display a text that says entering the next level.</li>
    </ul>
<li>Implemented a status text.</li>
    <ul>
      <li>The status text will display how many enemy planes are left to advance to the next level in level one and level two.</li>
      <li>The status text will display how many health of the boss are left to win the game in level boss.</li>
    </ul>
<li>Implemented win game screen.</li>
    <ul>
      <li>The win game screen will display a text that shows user has win the game.</li>
      <li>The win game screen will display the total time used to complete all levels.</li>
      <li>The win game screen has a restart button that allows user to restart to level one and play again.</li>
      <li>The win game screen has a return to main menu button that allows user to return to main menu.</li>
    </ul><br>


**5. Leaderboard**
<li>Added a leaderboard screen</li>
    <ul>
      <li>The leaderboard screen will records the time used to complete level one , level two and level boss.</li>
      <li>The leaderboard screen will add up the total time used to complete all levels and display them in a decending order</li>
      <li>The leaderboard screen allows user to clear up previous records.</li>
    </ul><br>
    

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

# New Java Classes

# Modified Java Classes

# Deleted Java Classes

# Unexpected Problems
