# Java Records

## 📌 Introduced In
- Introduced in **Java 14 (preview)**
- Became stable in **Java 16**

---

## 📌 What are Records in Java?
- A **special type of class** used to hold data.
- Designed for **immutability (final fields)**.
- Automatically provides:
    - constructor
    - accessors (getters)
    - equals(), hashCode(), toString()

👉 In short: **Concise data carrier class**

---
## 📌 Why Java Records?

I was working with the api response and I realized that the received response is never gonna change while processing, then why not to use Records?
- Eliminates boilerplate code
- Improves readability
- Immutable by default
- Ideal for DTOs / data transfer objects
- Just like in a class you can also write methods in records

---

## 📌 Real-life Analogy
Think of a **Student ID card**:
- Name, Roll No are fixed once created
- You only read data, not modify it

👉 Record = **Read-only data holder**

---

## 📌 Syntax

```java
public record RecordName(DataType fieldName) {}
```

- record - keyword just like class
- RecordName - just like class name
- DataType - is the type of data the variable holds
---


## 📌 Initialization

```java
RecordName recordVariable = new RecordName(value);
```

---

## 📌 Example


PersonDTO.java
```java
public record Person(String name, int age) {}
```

Main.java
```java
public class Main {
    public static void main(String[] args) {
        Person p = new Person("Pratiksha", 25);

        System.out.println(p.name()); 
        System.out.println(p.age());
        
//      Output
//      Pratiksha
//      25
    }
}
```

---


## 📌 Setting Data
❌ Not allowed (immutable)

```java
p.name = "Bob"; // Compile-time error
```

---

## 📌 Accessing Data

```java
p.name();
p.age();
```

---

## 📌 Access All Fields (Record Components)

```java
import java.lang.reflect.RecordComponent;

RecordComponent[] components = Person.class.getRecordComponents();

for (RecordComponent rc : components) {
    System.out.println(rc.getName() + ":" + rc.getAccessor().invoke(object));
}
```
Complete Example:

PersonDTO.java
```java
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.RecordComponent;

public record Person(String name, int age) {

    public void accessAllFields(Person p) throws InvocationTargetException, IllegalAccessException {
        RecordComponent[] components = Person.class.getRecordComponents();

        for (RecordComponent rc : components) {
            System.out.println(rc.getName() + ":" + rc.getAccessor().invoke(p));
        }
    }
}
```
Main.java
```java
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Person p = new Person("Pratiksha", 25);

        System.out.println(p.name());
        System.out.println(p.age());
        p.accessAllFields(p);
        
//        Output:
//      Pratiksha
//      25
//      name:Pratiksha
//      age:25
    }
}
```

---

## 📌 Records vs Lombok

| Feature | Records                | Lombok                     |
|--------|------------------------|----------------------------|
| Boilerplate removal | ✅ Built-in             | ✅ Annotation-based (@Data) |
| Immutability | ✅ Default              | ❌ Optional                 |
| Dependency | ❌ No                   | ✅ Required                 |
| Flexibility | ❌ Limited              | ✅ High                     |
| Use case | DTOs, unchangable data | Complex models             |

---

## ✅ Summary
- Records = **Immutable data carriers**
- Best for:
    - DTOs
    - API responses
    - Simple data models
    - Make sure all the classes are records to have full immutability
    - You can combine Records + normal dto classes like one with @Data

**Keep Learning and Growing** 🌱.