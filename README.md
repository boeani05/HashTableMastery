# Custom HashTable Implementation in Java

![Java Logo](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Data Structures Badge](https://img.shields.io/badge/Data_Structures-blue?style=for-the-badge)
![Algorithms Badge](https://img.shields.io/badge/Algorithms-orange?style=for-the-badge)

## Project Overview

This project is a hands-on implementation of a custom Hash Table in Java. The goal was to build a fundamental key-value data store from scratch, thoroughly understanding its core mechanics, including hashing, index calculation, and collision resolution.

Developed as part of my Computer Science learning journey on roadmap.sh, this project reinforces my knowledge of data structures, which is crucial for my apprenticeship in application development and my ultimate goal of becoming an independent game developer.

## Features

This custom Hash Table supports the following key operations:

*   **`put(key, value)`**: Inserts a new key-value pair or updates the value if the key already exists.
*   **`get(key)`**: Retrieves the value associated with a given key. Returns `-1` if the key is not found.
*   **`remove(key)`**: Deletes a key-value pair from the table. Provides feedback if the key was successfully removed or not found.
*   **`containsKey(key)`**: Checks if a specific key exists in the table. Returns `true` or `false`.
*   **`size()`**: Returns the current number of entries stored in the Hash Table.

## How It Works (Conceptual)

The Hash Table is implemented using a technique called **Separate Chaining** to handle collisions.

1.  **`Entry` Class**: A custom `Entry` class holds a `String key` and an `int value`.
2.  **`Database` Class**: This class forms the core of the Hash Table. It internally uses an array of `LinkedList<Entry>` objects. Each index in this array represents a "bucket."
3.  **Hashing**: For any given `key` (String), its `hashCode()` method is used to generate an integer hash value.
4.  **Index Calculation**: This hash value is then transformed into a valid array index by taking its absolute value and applying the modulo operator with the table's capacity (`index = Math.abs(hashCode) % capacity`).
5.  **Collision Handling**: If multiple keys hash to the same index (a collision), their `Entry` objects are stored sequentially in the `LinkedList` at that specific bucket.
6.  **Operations**:
    *   `put`: Calculates the index, then iterates through the linked list at that index. If the key exists, its value is updated. Otherwise, the new `Entry` is added to the list.
    *   `get`, `remove`, `containsKey`: Follow a similar pattern: calculate the index, go to the respective linked list, and then iterate to find or manipulate the desired `Entry`. The `remove` operation specifically uses an `Iterator` for safe modification during iteration.

## Technologies Used

*   **Java**: The primary programming language.
*   **Core Java Collections (`LinkedList`, `Iterator`)**: Utilized for implementing the separate chaining mechanism within each bucket.

## Getting Started

To run this project:

1.  **Clone the repository:**
    ```bash
    git clone https://github.com/boeani05/HashTableMastery.git
    cd HashTableMastery
    ```
2.  **Compile the Java files:**
    ```bash
    javac Main.java Logic.java Database.java Entry.java
    ```
3.  **Run the application:**
    ```bash
    java src/Main
    ```
    Follow the on-screen prompts to interact with the custom Hash Table.

## Learning Outcomes

By completing this project, I have gained a solid understanding of:

*   The internal workings of Hash Tables.
*   Concepts of hashing and hash functions.
*   Strategies for collision resolution, specifically Separate Chaining with Linked Lists.
*   Implementation details for `put`, `get`, `remove`, `containsKey` operations.
*   Managing `size` and `capacity` in a dynamic data structure.
*   Best practices for input handling and user interaction in console applications.

## Future Enhancements

*   Implement dynamic resizing (rehashing) to maintain efficiency as the table grows.
*   Explore different collision resolution strategies (e.g., Open Addressing).
*   Add more sophisticated error handling for edge cases.

---