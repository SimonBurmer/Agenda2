package edu.hm.cs.katz.swt2.agenda.persistence.task;

import edu.hm.cs.katz.swt2.agenda.persistence.topic.Topic;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 * Modellklasse für die Speicherung der Aufgaben. Enthält die Abbildung auf eine Datenbanktabelle in
 * Form von JPA-Annotation.
 * 
 * @author Bastian Katz (mailto: bastian.katz@hm.edu)
 */
@Entity
public class Task {

  @Id
  @NotNull
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @NotNull
  @Length(min = 8, max = 32)
  @Column(length = 32)
  private String title;

  @NotNull
  @ManyToOne
  private Topic topic;

  /**
   * JPA-kompatibler Kostruktor. Wird nur von JPA verwendet und darf private sein.
   */
  public Task() {
    // JPA benötigt einen Default-Konstruktor!
  }

  /**
   * Konstruktor zum Erstellen eines neuen Tasks.
   * 
   * @param topic Topic, darf nicht null sein.
   * @param title Titel, darf nicht null sein.
   */
  public Task(final Topic topic, final String title) {
    this.topic = topic;
    topic.addTask(this);
    this.title = title;
  }

  @Override
  public String toString() {
    return "Task \"" + title + "\"";
  }

  public Long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public Topic getTopic() {
    return topic;
  }

  /*
   * Generierte Methoden. Es ist sinnvoll, hier auf die Auswertung der Assoziationen zu verzichten,
   * da sonst unnötige Datenbankzugriffe erzeugt werden.
   */

  @Override
  public int hashCode() {
    return Objects.hash(id, title);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Task other = (Task) obj;
    return Objects.equals(id, other.id) && Objects.equals(title, other.title);
  }
}
