# Guess What And GO a.k.a GWAG game
## Created by "NAMF" team
## V13.0
### Team Members
1. [Naisila Puka](https://github.com/annapecini): Leader
2. [Ana Pecini](https://github.com/annapecini)
3. Mustafa Bayraktar
4. Franc Gripshi
### YouTube Demo
https://www.youtube.com/watch?v=lAGhl3m1_yY
## >>> WE KINDLY INVITE YOU TO BECOME A GWAGER <<<
### Game Description
"Guess What And GO" is a board game that encourages the user to keep answering questions and finish the game first! The board has numbered and grid squares which contain various challenges for the player. The squares might have "positive" or "negative" puzzles! If it is positive, the game awards you with several steps ahead if you answer correctly, otherwise you stay steady. If it is negative, you stay steady if you give the right answer, but if you don't, the game punishes you by regressing some squares back.

### Current status
Complete & Working.

### Accessing the game:
1. Clone the repo: `git clone git@github.com:NaisilaPuka/GWAG_V13.0.git`
2. Run drjava, Compiler MUST BE Java JDK 8.0_101 Compiler
3. Open the project `GWAG.drjava`
4. Compile and run the project.
4. BECOME A GWAGER. 

### Important Note!
DON'T USE YOUR MOST COMMONLY USED PASSWORD SINCE WE AS GAME OWNERS HAVE ACCESS TO EVERY PASSWORD.

### Additional Info
The code consists of a set of Panels for each of the different pages of the game. Functionality of navigation is put to the buttons in a main frame, called Launch Frame. This frame is called in the main class of the project and then we Run the project. 
We used Java JDK 8.0_101 Compiler, JavaFX, Swing (core code); Eclipse Neon(GUI); MySQL tables were used for the user databases on Login, Sign Up and JConnectivity classes(Connection, ResultSet); Text Files are the sources of the questions; Server and Client classes were used for the locally online connection (Socket). 

### Members and their contribution
You can find what each did in the description of each class code.

Naisila Puka: Developed the functionality of the game, fixed the layout and the components of the frames and panels, connected all the frames with each- other with means of ActionListeners in order to be able to play the game. Created LaunchFrame, OnePlayerGame and ProgressPanel. Created jConnectivity class to connect to MySQL database. Installed PhpMyAdmin and MySQL database on Ubuntu 14.04 server and created the user databases. Worked with MySQL language code. Among the rest of the classes, created LogIn and SignUp classes by making use of database system in MySQL.

Ana Peçini: created Question classes, Question textfile, made possible the access of Questions from the textfile, wrote Server and Client classes, GameBoardOnline, SquareOnline, QPanelOnline, QPanelPicOnline classes, provided locally online connection. (these classes are sepereated from the project file and are run within the project using CMD)

Franc Gripshi: made almost all the necessary GUI pages, wrote GameBoard, Game NON- GUI classes, made the background images.

Mustafa Bayraktar:Together with Naisila, wrote jConnectivity, Login, Signup classes and made necessary log in and sign up databases, made the databases local and easily accessible.