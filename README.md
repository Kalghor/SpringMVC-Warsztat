# SpringMVC-Warsztat

Application for managing a books. The app stores a collection of books in the class. 

## Description of the action

1. Method GET: http://localhost:8080/books - returns a collection of books as a JSON file.
2. Method POST: http://localhost:8080/books - adds a book to the collection.
3. Method GET: http://localhost:8080/books/id - returns the book with the given id as a JSON file
4. Method PUT: http://localhost:8080/books/id - edits the book with the given id as a JSON file
5. Method DELETE: http://localhost:8080/books/id - removes the book with the given id

### Libraries used

A library that converts a book object to a JSON file
https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind
