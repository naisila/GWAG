*"Guess What And GO" a.k.a "GWAG" game
*Created by the group "NAMF team"
*Project Leader: Naisila Puka
*Members: Ana Pecini, Mustafa Bayraktar, Franc Gripshi

*Final Project Code V13.0
>>>>>>> WE KINDLY INVITE YOU TO BECOME A GWAGER <<<<<<<

*Game Description: "Guess What And GO" is a board game that encourages the user to keep answering questions and finish the game first! The board has numbered and grid squares which contain various challenges for the player. The squares might have "positive" or "negative" puzzles! If it is positive, the game awards you with several steps ahead if you answer correctly, otherwise you stay steady. If it is negative, you stay steady if you give the right answer, but if you don't, the game punishes you by regressing some squares back.

*Current status: Complete & Working.


*IN ORDER TO ACCESS THE PROJECT:
**DOWNLOAD THE ZIP FILE
***Run drjava, Compiler MUST BE Java JDK 8.0_101 Compiler then open the project GWAG>GWAG.drjava to compile and run the project.
****WE INVITE YOU TO BECOME A GWAGER. NOTE: DON'T USE YOUR MOST COMMONLY USED PASSWORD SINCE WE AS GAME OWNERS HAVE ACCESS TO 
EVERY PASSWORD.


*The code consists of a set of Panels for each of the different pages of the game. Functionality of navigation is put
to the buttons in a main frame, called Launch Frame. This frame is called in the main class of the project
and then we Run the project. 

*We used Java JDK 8.0_101 Compiler, JavaFX, Swing (core code); Eclipse Neon(GUI); MySQL tables were used for the user databases on Login, Sign Up and JConnectivity classes(Connection, ResultSet); Text Files are the sources of the questions; Server and Client classes were used for the locally online connection (Socket). 

*Members and their contribution to this upload:(You can find what each did in the description of each class code)

 ---Naisila Puka(LEADER): Developed the functionality of the game, fixed the layout and the components of the frames and panels, connected all the frames with each- other with means of ActionListeners in order to be able to play the game. Created LaunchFrame, OnePlayerGame and ProgressPanel. Created jConnectivity class to connect to MySQL database. Installed PhpMyAdmin and MySQL database on Ubuntu 14.04 server and created the user databases. Worked with MySQL language code. Among the rest of the classes, created LogIn and SignUp classes by making use of database system in MySQL.

 ---Ana Peçini:           created Question classes, Question textfile, made possible the access of Questions from the textfile, wrote Server and Client classes, GameBoardOnline, SquareOnline, QPanelOnline, QPanelPicOnline classes, provided locally online connection. (these classes are sepereated from the project file and are run within the project using CMD)

 ---Franc Gripshi:        made almost all the necessary GUI pages, wrote GameBoard, Game NON- GUI classes, made the background images.

 ---Mustafa Bayraktar:    Together with Naisila, wrote jConnectivity, Login, Signup classes and made necessary log in and sign up databases, made the databases local and easily accessible.


