# 🧬 Game of Life – JavaFX

A JavaFX-based implementation of Conway's Game of Life – a simple life simulation on a 10x10 grid.

---

## 🧩 Project Overview

The Game of Life is a zero-player simulation developed by mathematician John Conway. Each cell in the grid represents a habitat that can be either **alive** (filled square) or **dead** (empty square). The simulation evolves generation by generation according to simple genetic rules.

---

## 🔁 Game Rules

- **Birth** – A dead cell with exactly 3 living neighbors becomes alive.
- **Death** – A live cell with fewer than 2 or more than 3 living neighbors dies (from loneliness or overcrowding).
- **Survival** – A live cell with 2 or 3 living neighbors remains alive.

All changes happen simultaneously, producing the next generation of cells.

---

## 🎨 Features

- **Canvas-based drawing** – The grid is drawn on a `Canvas` using rectangles.
- **Random initialization** – On the first click, the grid is filled with random values.
- **"Next Generation" button** – Triggers the calculation and drawing of the next generation.
- **Full redraw** – The entire grid is redrawn with each generation.
- **Careful state management** – Cells are not updated until all neighbor checks are complete.

---

## 🛠 Technologies Used

- Java  
- JavaFX (`Application`, `Canvas`, `GraphicsContext`)  
- 2D Arrays  
- Neighbor logic and boundary checking

---

## 🧪 How to Run

1. Open the project in a JavaFX-compatible IDE (such as IntelliJ or Eclipse).
2. Run the `Main` class.
3. Click the **Next Generation** button to simulate the next state of the grid.

---

## 👨‍💻 Developed By

Dvir Haham Pour

---

*A simple and fun OOP project using JavaFX 🎉*
