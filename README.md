
#  Expense Tracker – Console-Based Java Application

A simple and beginner-friendly **console-based Java expense tracker** that allows users to manage their daily expenses using a local **SQLite database**. The app supports **CRUD operations**, **report generation**, and **arithmetic summaries**.

---

## FEATURES

- Add new expenses (category, amount, date)
- View all saved expenses
- Delete expenses by ID
- Generate reports (total, average, min, max)
- SQLite database integration via JDBC

---

## TECHNOLOGIES USED

| Tool            | Purpose                                |
|-----------------|----------------------------------------|
| Java (JDK 17+)  | Core programming language              |
| SQLite          | Embedded database                      |
| JDBC            | Java-DB interaction                    |
| VS Code         | Code editing and running               |
| sqlite-jdbc.jar | SQLite driver for Java                 |

---

## PROJECT STRUCTURE

```
ExpenseTracker/
├── src/
│   ├── Main.java                # Main CLI logic
│   ├── Expense.java             # Expense model class
│   ├── ExpenseDAO.java          # DB interaction logic
│   ├── DatabaseHelper.java      # DB initialization
│   └── ReportGenerator.java     # Report with arithmetic
│
├── lib/
│   └── sqlite-jdbc.jar          # SQLite JDBC driver
├── expenses.db                  # Auto-created database
└── README.md                    # This file
```

---

## HOW TO COMPILE AND RUN

1. COMPILE

```bash
javac -cp ".;lib/sqlite-jdbc.jar" src/*.java
```
> On Mac/Linux, use `:` instead of `;` in the classpath.

 2. RUN

```bash
java --enable-native-access=ALL-UNNAMED -cp ".;lib/sqlite-jdbc.jar;src" Main
```

---

## How to Build JAR (Optional)

To create an executable `.jar`:

```bash
jar --create --file ExpenseTracker.jar --main-class=Main -C src/ .
```

Run the jar:

```bash
java --enable-native-access=ALL-UNNAMED -cp "lib/sqlite-jdbc.jar;ExpenseTracker.jar" -jar ExpenseTracker.jar
```

---

## SAMPLE OUTPUT

```
Expense Tracker
1. Add Expense
2. View Expenses
3. Delete Expense
4. Generate Report (Includes Arithmetic Operations)
0. Exit
Enter your choice: 4

Report:
Total Expenses: $740.00
Average Expense: $185.00
Max Expense: $400.00
Min Expense: $90.00
```

Created with  using Java, JDBC, and SQLite.
