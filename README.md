# Number Guessing Game 🎮

This is my proposed solution for the **Number Guessing Game** challenge from **roadmap.sh**:
https://roadmap.sh/projects/number-guessing-game

It is a classic Command Line Interface (CLI) guessing game where the player must discover a randomly generated secret number before running out of attempts.

---

## 🚀 Project Features

### Core Requirements Implemented

- **Welcome message and game rules:** A clear introduction is displayed when the game starts.
- **Random number generation:** The game selects a secret number between **1 and 100**.
- **Difficulty levels:**
  - **Easy:** 10 attempts.
  - **Medium:** 5 attempts.
  - **Hard:** 3 attempts.
- **Real-time feedback:** After each guess, the game tells you whether the secret number is **higher** or **lower** than your current guess.
- **Attempt counter:** If you win, the game displays the exact number of attempts it took to guess the correct number.

### ⭐ Additional Features

- **Multi-round mode:** After each game, you can choose to play again or exit.
- **Timer:** Records the number of seconds it took you to guess the secret number.
- **High Score leaderboard:** The game stores the best results and allows you to view the **Top 10** scores.

---

## 🛠️ Technologies Used

- **Language:** Java
- **Main Libraries:**
  - Jackson (JSON serialization/deserialization)
  - JUnit (unit testing)
  - Maven (dependency management and build automation)

---

## 📦 Installation and Running

Follow these steps to clone and run the project locally.

### Clone the repository

```bash
git clone https://github.com/YOUR_USERNAME/YOUR_REPOSITORY.git
```

### Navigate to the project directory

```bash
cd YOUR_REPOSITORY
```

### Build the project

```bash
mvn clean install
```

### Run the application

```bash
mvn exec:java
```

Or, if you're using **IntelliJ IDEA**, simply open the project as a Maven project and run the `Main` class.

---

## 🎯 How to Play

1. Launch the game.
2. Select a difficulty level.
3. Enter your guesses.
4. Use the feedback ("higher" or "lower") to find the secret number.
5. Try to beat your best score and climb the leaderboard!

---

## 🧪 Running the Tests

Run the unit tests with:

```bash
mvn test
```

---

## 📄 License

This project was created for educational purposes as part of the **roadmap.sh** backend project challenges.
