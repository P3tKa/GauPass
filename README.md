# GauPass

Secure password generator written in Java

## Features

##### Password generation

&emsp;☒ Toggle to use upper case letters <br />
&emsp;☒ Toggle to use Numbers <br />
&emsp;☒ Toggle to use special characters <br />
&emsp;☒ Generate password of any length <br >
&emsp;☒ Quick copy to clipboard <br />
&emsp;☐ TBA <br />

##### Password Strength checker

&emsp;☒ Evaluate passwords strength with score up to 100 <br />
&emsp;☒ Check if password contains letters <br />
&emsp;☒ Check if password contains numbers <br />
&emsp;☒ Check if password contains special characters <br />
&emsp;☒ Check if password is enough length <br />
&emsp;☐ TBA <br />

## Dependencies

- Jar
- Java
- Java Swing

## Instalation

Move to src directory

    cd src

Compile program into .class files

    javac Main.java

Create a Jar file using .class files and Manifest.txt

    jar cfm GauPass.jar Manifest.txt ./*

Run the generated Jar file

    java -jar GauPass.jar
