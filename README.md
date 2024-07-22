# javaCalculator

Technologies and Concepts
Java Swing:

The primary technology used for building the graphical user interface (GUI) of the calculator.
Components like JFrame, JButton, JTextField, and JPanel are part of the Swing library.
Event Handling:

Implements the ActionListener interface to handle button click events.
The actionPerformed method is overridden to define the actions performed when a button is clicked.
Layouts:

GridLayout and null layout are used to arrange components in the frame.
GridLayout is used for the panel containing the number and function buttons.
Font and Component Customization:

Customizes the font of buttons and the display field using the Font class.
Sets bounds and other properties for components to arrange them properly.

Detailed Component Breakdown

JFrame: The main window of the application.
setTitle(), setSize(), setDefaultCloseOperation(), and setLayout() methods configure the frame.

JTextField: Used to display the input and output of the calculator.
setEditable(false) makes the text field non-editable by the user directly.

JButton: Represents the number buttons and function buttons (+, -, *, /, =, ., Del, Clr).
Buttons are added to an array for easy iteration and event handling.

JPanel: Groups the buttons in a grid layout.
setLayout(new GridLayout(4, 4, 10, 10)) arranges buttons in a 4x4 grid with 10-pixel gaps.

Event Handling:
actionPerformed(ActionEvent e) method handles different actions based on the source of the event (e.getSource()).
Different operations (+, -, *, /) are executed based on the button clicked, and results are displayed in the text field.
