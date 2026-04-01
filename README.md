# CLI Student Management System

Simple Java CLI Student Management System for interview practice.

## Features

- Add student
- View all students
- Search student by ID
- Search student by name (partial match, case-insensitive, multiple results)
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

## Example Usage (Search by Name)

Example students:
- Student{id='S001', name='Andi Pratama', age=20}
- Student{id='S002', name='andi saputra', age=22}
- Student{id='S003', name='Budi', age=21}

Search flow:
1. Choose menu `3` (Search Student by ID or Name)
2. Choose `2` (Search by Name)
3. Input keyword: `andi`

Expected result:
- Returns both `Andi Pratama` and `andi saputra`
- Matching is case-insensitive
- Partial keyword is supported (e.g. `and` also matches both)

## Notes

- Uses only Java standard library
- Data is stored in memory (no file/database persistence yet)
