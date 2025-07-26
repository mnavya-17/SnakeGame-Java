# 🐍 Java Snake Game – OOP Based GUI Project

A classic *2D Snake Game* built using *Java Swing* and *OOP concepts*. This project simulates the traditional snake gameplay with real-time graphics, key controls, apple consumption logic, and a replay feature – designed to strengthen Java fundamentals in a fun, interactive way.

---

## 📑 Table of Contents

- [🧾 About](#-about)
- [🚀 Features](#-features)
- [🧠 Concepts Learned](#-concepts-learned)
- [📂 Project Structure](#-project-structure)
- [⚙️ Class Responsibilities](#-class-responsibilities)
- [🛠️ Tech Stack](#-tech-stack)
- [🧪 How to Run](#-how-to-run)
- [🔁 Try Again Feature](#-try-again-feature)
- [✨ Future Improvements](#-future-improvements)
- [📄 License](#-license)
- [🙌 Author](#-author)

---

## 🧾 About

This project was developed after completing a *Beginner to Advanced Java Course*. The main objective was to build something fun and logic-heavy while applying:
- Core Java programming
- Object-Oriented Principles
- GUI development using Swing
- Real-time gameplay concepts (timers, listeners, and collision detection)

It’s designed to help solidify my understanding of *OOP, **event handling, and **Java graphics*.

---

## 🚀 Features

- ✅ Real-time snake movement with keyboard controls  
- 🍎 Apple spawns at random positions  
- 🐍 Snake grows with each apple  
- 💥 Collision detection with walls and self  
- 🧮 Score tracking  
- 🔁 Replay support with "Try Again" button  
- 🎨 Built using pure Java Swing GUI  
- 🧼 Clean OOP code with modular classes

---

## 🧠 Concepts Learned

| Concept                | Usage Description                                                                 |
|------------------------|------------------------------------------------------------------------------------|
| OOP                    | Classes like Snake, GamePanel, and GameFrame separate responsibilities      |
| GUI Programming        | Implemented with JFrame, JPanel, Graphics, and layout managers              |
| Event Handling         | Managed with KeyListener and ActionListener                                   |
| Game Loop              | Handled using javax.swing.Timer for consistent frame updates                    |
| Collision Detection    | Between snake and walls/self                                                      |
| Randomization          | Used for apple placement via Random class                                       |
| Arrays for State       | Snake's body tracked with parallel arrays for X and Y positions                   |

---

## 📂 Project Structure


src/

├── Snake.java         # Snake data & logic (direction, length, position)

├── GamePanel.java     # Core game logic, rendering, collisions, controls

└── GameFrame.java     # Sets up the game window and launches the panel


---

## ⚙️ Class Responsibilities

### ✅ Snake.java
- Stores position of snake body using x[] and y[] arrays.
- Handles:
  - Snake movement
  - Snake growth
  - Self-collision detection
- Provides utility methods:
  - move()
  - grow()
  - checkCollision()

---

### ✅ GamePanel.java
- Renders the game screen, including:
  - Snake
  - Apple
- Handles user keyboard inputs via KeyListener.
- Manages game logic like:
  - Score tracking
  - Game state (Running or Game Over)
- Calls relevant methods from Snake.java.
- Displays a *"Try Again"* button when the game ends.

---

### ✅ GameFrame.java
- Launches the main game window.
- Adds GamePanel to the frame.
- Configures frame settings:
  - Window size
  - Close operation
  - Visibility (setVisible(true))

---

## 🛠️ Tech Stack

- Java (Beginner to Advanced level)
- Swing (GUI)
- AWT Event Handling
- Object-Oriented Programming (OOP)

---

## 🧪 How to Run

> You can run the project on any Java IDE like IntelliJ, Eclipse, or VS Code.

1. Clone the repository or download ZIP
2. Open the project in your IDE
3. Run `GameFrame.java` as Java Application


---

## 🔁 Try Again Feature

Once the snake collides with the wall or itself, a *"Try Again"* button appears on the screen. Clicking it:
- Instantly resets the game state
- Clears the score and snake body
- Starts a new game without closing the window

This improves user experience by avoiding manual restarts or re-running the app.

---

## ✨ Future Improvements

- 🎮 Speed increase on higher scores / level system  
- 💾 Save/load high scores  
- ⏸ Pause and resume gameplay  
- 🔊 Add sound effects  
- 🎨 Add different snake or theme colors  
- 👥 Add multiplayer mode  

---

## 📄 License

This project is licensed under the [MIT License](LICENSE).

---

Made with ❤️ in Java

---

## 🙌 Author

*Navya M*  
Aspiring Software Engineer | Java & DSA Enthusiast | ECE Engineer
