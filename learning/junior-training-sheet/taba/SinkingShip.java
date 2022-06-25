import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class SinkingShip {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      List<Person> people = new ArrayList<>();
      int n = in.nextInt();
      in.nextLine();

      for (int i = 0; i < n; i++) {
        String[] line = in.nextLine().trim().split(" ");
        people.add(new Person(line[0], getStatus(line[1]), i));
      }

      Collections.sort(people, (Person p1, Person p2) -> {
        if (p1.status == Status.RAT) {
          if (p2.status == Status.RAT) {
            return p1.pos - p2.pos;
          } else {
            return -1;
          }
        } else if (p1.status == Status.WOMAN || p1.status == Status.CHILD) {
          if (p2.status == Status.WOMAN || p2.status == Status.CHILD) {
            return p1.pos - p2.pos;
          } else if (p2.status == Status.MAN || p2.status == Status.CAPTAIN) {
            return -1;
          } else {
            return 1;
          }
        } else if (p1.status == Status.MAN) {
          if (p2.status == Status.MAN) {
            return p1.pos - p2.pos;
          } else if (p2.status == Status.RAT || p2.status == Status.CHILD || p2.status == Status.WOMAN) {
            return 1;
          } else {
            return -1;
          }
        }
          return 1;
      });

      for (var p : people) {
        System.out.printf("%s\n", p.name);
      }
    }
  }

  private static Status getStatus(String type) {
    return switch (type) {
      case "captain" -> Status.CAPTAIN;
        case "woman" -> Status.WOMAN;
        case "child" -> Status.CHILD;
        case "rat" -> Status.RAT;
        default -> Status.MAN;
    };
  }
}

class Person {
  String name;
  Status status;
  int pos;

  Person(String name, Status status, int pos) {
    this.name = name;
    this.status = status;
    this.pos = pos;
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof Person other) {
      return this.name.equals(other.name) && this.status == other.status && this.pos == other.pos;
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.name, this.status, this.pos);
  }
}

enum Status {
  CAPTAIN,
  WOMAN,
  CHILD,
  MAN,
  RAT;
}
