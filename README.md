## 🛠️ Kotlin MVVM Showcase App

Welcome to the Kotlin MVVM Showcase App! This project is a demonstration of my expertise in building modern Android applications using Kotlin and the MVVM architecture. It emphasizes clean and maintainable code while adhering to SOLID principles and Clean Architecture guidelines. The project also includes comprehensive unit testing to ensure code quality and reliability.

## ✨ Features

MVVM Architecture: Separation of concerns with ViewModel and LiveData/StateFlow for reactive UI updates.
Clean Code Practices: Codebase structured with Clean Architecture layers (Domain, Data, and Presentation).
SOLID Principles: Adherence to object-oriented design principles for scalability and maintainability.
Unit Testing: Thorough testing of business logic with frameworks like JUnit and Mockito.

## 🎯 Highlights

This app showcases:

Separation of Concerns: Clear distinction between business logic, data handling, and UI components.
Test-Driven Development: Focus on writing unit tests for ViewModels, Use Cases, and Repository logic.
Best Practices in Kotlin: Immutability, null safety, and idiomatic Kotlin code.

## 🛠️ Tech Stack

Language: Kotlin
Architecture: MVVM with Clean Architecture
Libraries:
Retrofit for network operations
LiveData/StateFlow for reactive programming
JUnit and Mockito for unit testing
Build Tools: Gradle

## 🔍 Unit Testing Overview

ViewModel Tests: Validates UI logic and state changes.
Example Test Snippet:

```
@Test
fun `sort by Id with 1 2 3 userId`() = with(viewModel) {
    `when`(mockStorageRepository.userModelList).thenReturn(createMockedUserListWith123UserId())
    sortUsersById()
    val result = userEntityList.getOrAwaitValue()
    MatcherAssert.assertThat(result.peekContent()[0].id, CoreMatchers.equalTo(1))
    MatcherAssert.assertThat(result.peekContent()[1].id, CoreMatchers.equalTo(2))
    MatcherAssert.assertThat(result.peekContent()[2].id, CoreMatchers.equalTo(3))
}
```
