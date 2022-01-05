# COMP303_Winter2022


## General Information
|   |  |
| :---: | ------------- |
| Instructor    | [Jin Guo](http://jguo-web.com/index.html)|
| Live Lecture Date and Time    | MW 11:35 pm - 12:55 pm (remote through Zoom) | 
| Lecture Link and Recordings | myCourses |
| Office Hours | TBD |
| Q&A and Discussion Forum | Ed discussion (link through myCourses, will be add soon) |

## Teaching Assistant Team

| Name | Email Address |
| :---: | :---: |



## TA Office Hours
| Time | TA |
| --- |---|


## Description
This course provides an in-depth introduction to the discipline of software design for building realistic and high-quality software applications. It will focus on object-oriented programming techniques, and cover topics related to managing software complexity and verifying that they work as expected. It will use Java for all the code examples and assignments. However, the considerations during the design process apply in all languages for practical software development.

## Expected Outcome

After completing this course successful students should be able to:

- Properly explain and apply general Design Principles (separation of concerns, encapsulation, substitutability, interface segregation, etc.) and important Design patterns;
- Properly explain and apply design techniques such as UML Diagrams and Design by Contract;
- Effective use programming language mechanisms such as exception handling and reflection;
- Analyze and evaluate the quality of design solutions; correctly identify design smells and apply appropriate refactoring to eliminate them;
- Gain experience on software development tools such as modern IDEs, automatic documentation and testing tools, and version control system.

## Reference Material
- **Required Textbook**: 
  - [Introduction to Software Design with Java (referred to as SD in the schedule)](https://link.springer.com/book/10.1007/978-3-030-24094-3). The electronic version of this book is **free** for McGill users with library access. For those who optionally want a print version, the [Paragraph Bookstore](http://paragraphbooks.com/) will stock a limited number of copies;
  - [Companion Website](https://github.com/prmr/DesignBook) for source code, exercises, and solutions.
- **Other Recommended References:** 
  - [The Pragmatic Programmer (referred to as PP)](https://www.oreilly.com/library/view/the-pragmatic-programmer/9780135956977/), by David Thomas, Andrew Hunt, Addison-Wesley Professional;
  - [Effective Java (referred to as EJ)](https://www.oreilly.com/library/view/effective-java-3rd/9780134686097/), by Joshua Bloch, Addison-Wesley Professional.

- **Sample Projects:** 
  - [Inclass demos](TBD);
  - [Minesweeper](https://github.com/prmr/Minesweeper);
  - [Solitaire](https://github.com/prmr/Solitaire).

- **Diagramming Tool (and Sample Project):** 
  - [JetUML](http://cs.mcgill.ca/~martin/jetuml/)

## Prerequisites
COMP 206 and COMP 250. Please also perform the [self assessment](https://github.com/prmr/COMP303/blob/master/Assessment.md) within the first week of the class to determine if you are ready to take this course.


## Assessment and Evaluation (Tentative):
*Subject to minor adjustments*

|  Assessment Method | Weight |
| :---: | :---: |
|  Survey and Quiz | 10% |
|  Assignments | 60% -- 10(A1)+10(A2)+15(A3)+25(A4) |
|  Lab Test | 30% -- 10(L1)+10(L2)+10(L3) |


 
- Due to the remote teaching complication, I won't require you to attend the live lectures even though it is highly recommended. If you are not able to attend the live lectures, please make sure to follow the recordings afterward and complete the quizzes that constitute your `Survey and Quiz` grade. 
- Our TA will try their best to support your learning. But considering this is a big class – many of you will have similar questions or concerns and many of you have will answers to other people’s questions, we encourage you to discuss your questions about the lectures and exercises online;
- Every module of the lecture will come with [exercises provided by the textbook](https://github.com/prmr/DesignBook). Those are for your practice and will not be graded. Instead, your practical skills will be evaluated through a series of design assignments and lab tests throughout the semester. 
- We plan to have four `assignments` throughout the semester. The first three assignments will map to different modules of the textbook, and the last one will be a final integration activity covering the entire course. 
- The `lab tests` complement the assignments and will be in person. During each lab test, you will be asked to complete a series of tasks given by our TAs. You are responsible to book the slot of each lab test in advance with the TAs. 
- Any form of plagiarism, cheating is strictly banned throughout the semester. Integrity is crucial to this course and your future career. Any violation against academic integrity will be taken very seriously. For more information, please refer [here](https://www.mcgill.ca/students/srr/academicrights/integrity).

## Schedule (Tentative)
*Subject to minor adjustments*

| Lecture | Date | Content | Reading | Exercise | Assignments | Lab Tests |
| :---: |:---:| :---: | :---: | :---: | :---: | :---: |
|1	|  5 Jan  | Introduction | SD: Chapter 1| | | |
|2	|  10 Jan | Encapsulation - 1 | SD: Chapter 2 | [Exercise 0](https://gitlab.cs.mcgill.ca/jguo/COMP303_Winter2021/-/blob/main/M0-Exercise.md) <br> [Exercise 1-5 in SD: Chapter 2](https://github.com/prmr/DesignBook/blob/master/exercises/e-chapter2.md) | | |
|3	|  12 Jan | Encapsulation - 2 | EJ: Item 15-17  | [Exercise 6-9 in SD: Chapter 2 <br> (omit the exercise related to Design by Contract and Assertion which will be introduced later in the course)](https://github.com/prmr/DesignBook/blob/master/exercises/e-chapter2.md) | | |
|4	|  17 Jan | Types and Polymorphism - 1 | SD: Chapter 3 | [Exercise 1-2 in SD: Chapter 3](https://github.com/prmr/DesignBook/blob/master/exercises/e-chapter3.md) | | |
|5	|  19 Jan | Types and Polymorphism - 2 | EJ: Item 14 | [Exercise 3-6 in SD: Chapter 3](https://github.com/prmr/DesignBook/blob/master/exercises/e-chapter3.md) | | |
|6	|  24 Jan | Types and Polymorphism - 3 | | [Exercise 7-12 in SD: Chapter 3](https://github.com/prmr/DesignBook/blob/master/exercises/e-chapter3.md)| | |
|7	|  26 Jan | Object State - 1 | SD: Chapter 3, EJ: Item 10, 11 | [Exercise 1-5 in SD: Chapter 4](https://github.com/prmr/DesignBook/blob/master/exercises/e-chapter4.md) | | | |
|8	|  31 Jan | Object State - 2 | EJ: Item 1, 3 | [Exercise 6-11 in SD: Chapter 4](https://github.com/prmr/DesignBook/blob/master/exercises/e-chapter4.md) | | |
|9	|  2 Feb | Design for Robustness - 1 | PP: Topic 23, 24, 25| | | |
|10  |  7 Feb | Design for Robustness - 2 | EJ: Item 69 - 72 | | | |
|11	|  9 Feb | Unit Testing - 1 | SD: Chapter 5  | | |
|12	|  14 Feb | Unit Testing - 2| SD: Chapter 5 | [Exercise 1-11 in SD: Chapter 5](https://github.com/prmr/DesignBook/blob/master/exercises/e-chapter5.md) | | |
|13	|  26 Feb | Content Review (by TAs)| | | | |
|14	|  21 Feb | Composition - 1 | SD: Chapter 6 | | | |
|15	|  23 Feb | Composition - 2 | SD: Chapter 6 | [Exercise 1-5 in SD: Chapter 6](https://github.com/prmr/DesignBook/blob/master/exercises/e-chapter6.md)| | |
|**	|  28 Feb | READING WEEK | | | | |
|**	|  2 Mar | READING WEEK | | | | |
|16	|  7 Mar | Composition - 3 | | [Exercise 6-19 in SD: Chapter 6](https://github.com/prmr/DesignBook/blob/master/exercises/e-chapter6.md) | | |
|17	|  9 Mar | Inheritance - 1 | SD: Chapter 7, EJ:Item 19,20| [Exercise 1-5 in SD: Chapter 7](https://github.com/prmr/DesignBook/blob/master/exercises/e-chapter7.md) | | |
|18 |  14 Mar | Inheritance - 2  | SD: Chapter 7, EJ:Item 18 | [Exercise 6-10 in SD: Chapter 7](https://github.com/prmr/DesignBook/blob/master/exercises/e-chapter7.md) | | |
|19 |  16 Mar | Inversion of Control - 1 | SD: Chapter 8 | [Exercise 1-7 in SD: Chapter 8](https://github.com/prmr/DesignBook/blob/master/exercises/e-chapter8.md) | | |
|20 |  21 Mar | Inversion of Control - 2 | SD: Chapter 8 | [Exercise 9-11 in SD: Chapter 8](https://github.com/prmr/DesignBook/blob/master/exercises/e-chapter8.md)  | | |
|21 |  23 Mar | Inversion of Control - 3 |SD: Chapter 8 | [Exercise 12-13 in SD: Chapter 8](https://github.com/prmr/DesignBook/blob/master/exercises/e-chapter8.md)|  | |
|22 |  28 Mar |  Content Review (by TAs) | | | | |
|23 |  30 Mar | Concurrency - 1 | [Java Concurrency in Practice Chapter 1,2,3](https://learning.oreilly.com/library/view/java-concurrency-in/0321349601/) | | | |
|24 |  4 Apr | Concurrency - 2 | | | | | |
|25 |  6 Apr | API Usability Design | | | | |
|26 |  11 Apr | Software Engineering Ethics and Wrap-up | [ACM/IEEE-CS Software Engineering Code](https://ethics.acm.org/code-of-ethics/software-engineering-code/) <br> [Ethics Is a Software Design Concern](https://ieeexplore.ieee.org/abstract/document/8693077) | | | |

## Survey and Quiz links
[Background Survey](https://forms.gle/34v9jrXtnwkpPZA67) (Deadline Jan 20th)

