# CLI Student Management System

Simple Java CLI project structure for a Student Management System.

## Project Structure

```text
src/main/java/
  model/    -> domain classes (e.g., Student)
  service/  -> business logic (e.g., StudentService)
  ui/       -> console menu/input-output
  app/      -> application entry point (Main)
```

## Current Status

- Folder structure initialized
- `Main.java` entry point created
- Business logic is not implemented yet

## How to Run

From project root:

```bash
javac -d out src/main/java/app/Main.java
java -cp out app.Main
```

If you want to compile all Java files later:

```bash
javac -d out $(find src/main/java -name "*.java")
java -cp out app.Main
```
