# CLI Student Management System

A simple command-line application for managing student records, built with Java. Demonstrates clean OOP principles and file persistence.

## Features

- **Add Student** - Register new students with ID, name, and age
- **View All Students** - Display complete student list with numbered entries
- **Search by ID** - Find a specific student by their unique ID
- **Search by Name** - Case-insensitive partial name matching with multiple results
- **Update Student** - Modify existing student name and age
- **Delete Student** - Remove students from the system
- **File Persistence** - Data automatically saved to `students.txt` and loaded on startup

## How to Run

### Prerequisites
- Java 8 or higher

### Compile and Run

From the project root directory:

```bash
# Compile all Java files
javac src/model/Student.java src/service/FileStorage.java src/service/StudentService.java src/ui/MainMenu.java src/Main.java -d src

# Run the application
java -cp src Main
```

Or using a single command:

```bash
javac -d src $(find src -name "*.java") && java -cp src Main
```

## Example Usage

### Adding Students
```
==== Student Management Menu ====
1. Add Student
2. View All Students
3. Search Student by ID or Name
4. Update Student
5. Delete Student
6. Exit
Choose menu (1-6): 1

-- Add Student --
Input ID: S001
Input Name: John Doe
Input Age: 20
Student added successfully.
```

### Viewing Students
```
Choose menu (1-6): 2

-- Student List --
1. Student{id='S001', name='John Doe', age=20}
2. Student{id='S002', name='Jane Smith', age=22}
```

### Searching by Name
```
Choose menu (1-6): 3
-- Search Student --
1. Search by ID
2. Search by Name
Choose search type (1-2): 2
Input name keyword: john
Found 1 student(s):
1. Student{id='S001', name='John Doe', age=20}
```

### Data Persistence
Student data is automatically saved to `students.txt` when exiting:
```
Choose menu (1-6): 6
Exiting application. Goodbye!
Data saved successfully.
```

The file format is simple CSV:
```
S001,John Doe,20
S002,Jane Smith,22
```

## Project Structure

```
src/
├── model/
│   └── Student.java          # Domain class (POJO)
├── service/
│   ├── StudentService.java   # Business logic layer
│   └── FileStorage.java      # File persistence layer
├── ui/
│   └── MainMenu.java         # Console UI and input handling
└── Main.java                 # Application entry point
```

## OOP Concepts Used

| Concept | Application |
|---------|-------------|
| **Encapsulation** | Private fields with public getters/setters in `Student` class |
| **Single Responsibility** | `StudentService` handles business logic, `FileStorage` handles persistence, `MainMenu` handles UI |
| **Dependency Injection** | `MainMenu` receives `StudentService` via constructor |
| **Separation of Concerns** | Three-layer architecture: Model (data) → Service (logic) → UI (presentation) |
| **DRY Principle** | Helper methods like `isNullOrEmpty()`, `printResult()`, `readLine()` reduce code duplication |

## Data File

The application stores data in `students.txt` (created automatically in project root):
- Format: `ID,Name,Age` (one student per line)
- File is loaded on startup if it exists
- File is overwritten on exit with current data
