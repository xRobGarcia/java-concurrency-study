# Java Concurrency Study Plan

This study plan is designed to support learning from Java Concurrency in Practice by Brian Goetz, Tim Peierls, Joshua Bloch, Joseph Bowbeer, David Holmes, and Doug Lea.

This document is a personal study guide inspired by their work and is intended to help structure learning from the book in a systematic way.

---

This plan is designed for steady, deep learning. The goal is not to rush through the book, but to understand each concept well enough to explain it, implement it, and evaluate it before moving on.

---

## 1. Learning Philosophy

Each study block follows the same pattern:

1. Read the chapter or section
2. Write a minimal example from scratch
3. Explain the concept in plain English
4. Pass a short comprehension check
5. Only continue when the concept is clearly understood

Concurrency is not learned by reading alone. It is learned by seeing race conditions, reasoning about shared state, and testing how synchronization changes behavior.

---

## 2. Weekly Structure

Use three sessions per week, about 90 minutes each:

- 30 minutes: reading
- 30 minutes: hands-on coding
- 20 minutes: summary and notes
- 10 minutes: check your understanding

This pace is slower and more durable than a single long cram session.

---

## 3. Study Roadmap

### Phase 1: Foundations of Concurrency
Duration: 2 weeks

Goals:
- understand threads and execution
- recognize shared mutable state
- understand visibility and memory consistency
- understand why code can look correct but still fail under concurrency

Core topics:
- threads and execution models
- shared state
- race conditions
- visibility problems
- publication of objects
- immutability
- synchronized
- volatile

Practice:
- build a shared counter across multiple threads
- create a version that fails without synchronization
- create a version that works with synchronized
- experiment with volatile and compare behavior
- write examples of unsafe object publication

Evaluation:
- explain what a race condition is in your own words
- explain what visibility means in Java concurrency
- explain why synchronized fixes certain bugs
- write a short example showing a stale or inconsistent state

Advance criteria:
- you can explain the problem and the fix without reading the book
- you can describe the difference between safety and visibility

---

### Phase 2: Synchronization and Safe Object Design
Duration: 2 weeks

Goals:
- build thread-safe objects
- reason about encapsulation
- understand locks and reentrancy
- design safe state ownership

Core topics:
- synchronized methods and blocks
- lock granularity
- encapsulation of state
- object composition
- thread-safe design patterns
- reentrancy
- atomic variables

Practice:
- create a thread-safe counter class
- build a shared cache with controlled mutation
- compare a safe and unsafe implementation
- design a class that encapsulates mutable state properly
- practice lock usage with small examples

Evaluation:
- identify whether a class is thread-safe
- explain what state is shared and what is private
- rewrite an unsafe class into a safe version
- explain why encapsulation matters in concurrent design

Advance criteria:
- you can explain why a class is unsafe without guessing
- you can design a thread-safe class from scratch

---

### Phase 3: Executors, Tasks, and Task Coordination
Duration: 2 weeks

Goals:
- understand task-based concurrency
- stop thinking only in terms of raw threads
- manage task execution and cancellation

Core topics:
- ExecutorService
- ThreadPoolExecutor
- Callable and Future
- cancellation
- shutdown behavior
- task scheduling
- managing long-running tasks

Practice:
- use a fixed thread pool
- use a cached thread pool
- use a scheduled executor
- create a task that can be canceled
- handle task failures and exceptions properly

Evaluation:
- explain the difference between a Thread and an Executor
- choose the correct executor for a concrete use case
- explain how cancellation works in practice
- describe how a pool behaves under load

Advance criteria:
- you can choose a suitable executor and explain why
- you understand the difference between task submission and running a thread directly

---

### Phase 4: Liveness, Deadlocks, and Performance
Duration: 2 weeks

Goals:
- understand deadlocks, starvation, and livelock
- reason about contention and throughput
- understand the relationship between correctness and performance

Core topics:
- deadlocks
- livelock
- starvation
- lock contention
- lock granularity
- throughput and scalability
- benchmarking basics

Practice:
- create a deadlock example
- examine a case of lock-order inversion
- compare synchronized and lock behavior
- measure the cost of locking under contention
- analyze a performance bottleneck caused by too much locking

Evaluation:
- draw a deadlock sequence and explain where it breaks
- explain why lock ordering matters
- explain the impact of contention on scalability
- compare a simple safe solution with a more scalable one

Advance criteria:
- you can recognize and explain a deadlock path
- you understand why safe code can still be slow under concurrency

---

### Phase 5: Concurrent Collections and Practical Patterns
Duration: 2 weeks

Goals:
- select the right concurrent primitive
- understand producer-consumer scenarios
- master important concurrency patterns

Core topics:
- concurrent collections
- blocking queues
- producer-consumer patterns
- bounded queues
- task coordination patterns
- concurrent design examples
- testing concurrent code

Practice:
- implement a producer-consumer queue
- build a bounded queue
- use a blocking queue for task coordination
- test behavior under contention and repeated execution

Evaluation:
- explain when to use a concurrent queue instead of manual synchronization
- explain why a blocking queue helps in producer-consumer problems
- design a simple coordination system with two or more threads

Advance criteria:
- you can choose between synchronized, lock, queue, or executor for a real problem

---

### Phase 6: Consolidation and Review
Duration: 2 weeks

Goals:
- review all major concepts
- build a small integrated project
- verify understanding across the full topic area

Core topics:
- review the full model of concurrency in Java
- rebuild core patterns from memory
- connect theory with practice

Practice project idea:
Build a small concurrency system with:
- multiple producers
- a shared buffer
- a thread pool for workers
- cancellation support
- logging of task execution
- stress tests that run repeatedly

Evaluation:
- explain the system design in writing
- identify where state is shared
- justify which synchronization approach is used and why
- explain failure modes and how they are mitigated

Advance criteria:
- you can reason about the design clearly and defend your choices

---

## 4. Evaluation System

### A. Concept Check
After each phase, answer these four questions:

1. What problem does this concept solve?
2. What breaks if it is not used?
3. When should it be used?
4. What other option exists and why would you avoid it?

This keeps the learning grounded in understanding instead of memorization.

---

### B. Coding Check
Each phase should end with:

- one bug-detection exercise
- one solution-from-scratch exercise

Examples:
- identify a race condition
- rewrite an unsafe class as thread-safe
- implement a producer-consumer queue
- build a simple executor-based solution

---

### C. Oral Explanation Check
Every week, explain the concept out loud as if teaching someone else.

Requirements:
- no reading the notes
- use your own examples
- explain why the issue happens
- explain how the fix works

If you cannot explain it clearly, the concept is not yet solid.

---

### D. Mini Quiz Standard
Use a simple score range:

- 0-2: repeat the phase
- 3: acceptable, but weak
- 4: solid understanding
- 5: strong understanding

The goal is not speed. The goal is durable understanding.

---

## 5. Key Rule for Progression

Do not move to the next phase until you can:

- explain the concept in plain English
- implement a small working example
- identify a common mistake related to it
- describe how to fix that mistake

This is the standard that keeps the learning deep and reliable.

---

## 6. Recommended pace

If you have a lot of time, this is the best approach:

- 2 weeks for fundamentals
- 2 weeks for synchronization and safe design
- 2 weeks for executors and task coordination
- 2 weeks for liveness and performance
- 2 weeks for concurrent collections and patterns
- 2 weeks for review and integration

This keeps the process steady, safe, and strong.

---

## 7. Final Goal

By the end of the plan, you should be able to:

- tell whether a class is thread-safe
- explain why visibility problems happen
- use synchronized, volatile, locks, and atomic tools correctly
- design safe concurrent systems using executors
- recognize deadlocks and performance bottlenecks
- choose the right concurrent abstraction for a real problem

That is the real target of Java Concurrency in Practice: not just knowing the API, but understanding concurrency as a design discipline.

---

## 8. Suggested next step

Start with Phase 1 and work through it systematically. If you want, the next step can be:

- a more detailed chapter-by-chapter breakdown,
- a set of exercises for each phase,
- or a weekly checklist you can follow as you study.
