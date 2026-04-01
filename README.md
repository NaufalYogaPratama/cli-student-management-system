# CLI Student Management System

Simple Java CLI Student Management System for interview practice.

## Features

- Add student
- View all students
- Search student by ID
- Update student data
- Delete student
- Exit menu

## Project Structure

```text
src/
  model/    -> domain class (`Student`)
  service/  -> business logic (`StudentService`)
  ui/       -> console menu/input-output (`MainMenu`)
  Main.java -> application entry point
```

## How to Run

From project root:

```bash
mkdir -p out
javac -d out $(find src -name "*.java")
java -cp out Main
```

## Notes

- Uses only Java standard library
- Data is stored in memory (no file/database persistence yet)
