package com.github.sheverov.ilya.taskplannerrest.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "persons", schema = "public")
public class Person {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "person_id_seq")
  @Column(name = "person_id", nullable = false)
  private Integer personId;
  @Column(name = "last_name", nullable = false, length = 35)
  private String lastName;
  @Column(name = "first_name", nullable = false, length = 35)
  private String firstName;
  @Column(name = "middle_name", nullable = false, length = 35)
  private String middleName;
  @Version
  @Column(name = "version", nullable = false)
  private Timestamp version;
  @ManyToMany(mappedBy = "assignees")
  private List<Task> tasks = new ArrayList<>();

  public Integer getPersonId() {
    return personId;
  }

  public void setPersonId(Integer personId) {
    this.personId = personId;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public Timestamp getVersion() {
    return version;
  }

  public void setVersion(Timestamp version) {

    this.version = version;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Person)) return false;
    Person person = (Person) o;
    return personId.equals(person.personId) &&
        Objects.equals(lastName, person.lastName) &&
        Objects.equals(firstName, person.firstName) &&
        Objects.equals(middleName, person.middleName) &&
        version.equals(person.version);
  }

  @Override
  public int hashCode() {
    return Objects.hash(personId, lastName, firstName, middleName, version);
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Person{");
    sb.append("id=").append(personId);
    sb.append(", lastName='").append(lastName).append('\'');
    sb.append(", firstName='").append(firstName).append('\'');
    sb.append(", middleName='").append(middleName).append('\'');
    sb.append(", version=").append(version);
    sb.append('}');
    return sb.toString();
  }

  public List<Task> getTasks() {
    return tasks;
  }

  public void setTasks(List<Task> tasks) {
    this.tasks = tasks;
  }
}
