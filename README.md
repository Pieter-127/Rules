# Rules
A few really basic custom lint rules (and a cat picture, for the people who don't care about lint)

<img src="https://github.com/Pieter-127/Rules/blob/master/app/art/image1.png" width="25%" />

# Summary
This project was made to learn about writing custom lint rules, I just added a few to play around with code analysis. 
To maintain tradition, because there's no actual functionality to display, there's a cat picture (the only thing most people would be interested in).

# How it's done
The app makes use of Kotlin and Lint to write a few custom lint rules, I only played with the very basics here 

- Checking variables for a prefix
- Checking the length of variables
- Checking the length of methods
- Checking if code contains certain literal values
- Checking for outdated variable naming conventions
... and maybe a few more

# How would you run this ? 

You can simply clone this from github and open the project using android studio, the project won't actually compile, due to the lint checks preventing all the incorrect code found in MainActivity
