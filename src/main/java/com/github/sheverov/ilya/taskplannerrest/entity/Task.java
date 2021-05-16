package com.github.sheverov.ilya.taskplannerrest.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Table(name = "tasks", schema = "public")
@Entity
public class Task {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_id_seq")
  @Column(name = "task_id")
  private Integer id;
  @Column(name = "description", length = 120)
  private String description;
  @Column(name = "work_volume")
  private Integer workVolume;
  @Column(name = "start_date")
  private Timestamp startDate;
  @Column(name = "due_date")
  private Timestamp dueDate;
  @Column(name = "status")
  private String status;
  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "assignee_groups",
      joinColumns = @JoinColumn(name = "task_id"),
      inverseJoinColumns = @JoinColumn(name = "person_id"))
  private List<Person> assignees = new ArrayList<>();
  @Version
  private Timestamp version;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getWorkVolume() {
    return workVolume;
  }

  public void setWorkVolume(Integer workVolume) {
    this.workVolume = workVolume;
  }

  public Timestamp getStartDate() {
    return startDate;
  }

  public void setStartDate(Timestamp startDate) {
    this.startDate = startDate;
  }

  public Timestamp getDueDate() {
    return dueDate;
  }

  public void setDueDate(Timestamp dueDate) {
    this.dueDate = dueDate;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public List<Person> getAssignees() {
    return assignees;
  }

  public void setAssignees(List<Person> assignees) {
    this.assignees = assignees;
  }

  public Timestamp getVersion() {
    return version;
  }

  public void setVersion(Timestamp version) {
    this.version = version;
  }
}
