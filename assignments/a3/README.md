# CS 349 Assignment 3: Model-View-Controller in Java -- Fotag

## Description:<br />
Allow users to load images, and display the images and metadata in a dynamic layout.<br />
Allow users to rate images, and filter them based on this rating.<br />
Click on "grid layout button" or "list layout button" to switch between two view modes.<br />
Click on "load button" to select .png or .jpg files.<br />
Click on the image in the application will enlarge it.<br />
Click on "star button" below an image or next to an image to rate the image.<br />
Click on "clear button" below an image or next to an image to clear the rate of the image (i.e. set rating to zero star).<br />
Click on "star button" from to the toolbar to use rating filter.<br />
Click on "clear button" from to the toolbar to clear the rating filter (i.e. set filter to zero star).<br />
When exiting the application, the list of images' path will be stored to a file called old_state.<br />
When relaunching the application, the images from the old_state will be loaded.<br />

## To start:<br />
Type "./gradlew run" under a3 folder to run on macOS.<br />

## Development environment:<br />
macOS High Sierra version 10.13.4<br />
java version "10.0.1" 2018-04-17<br />
Java(TM) SE Runtime Environment 18.3 (build 10.0.1+10)<br />
Java HotSpot(TM) 64-Bit Server VM 18.3 (build 10.0.1+10, mixed mode)<br />
