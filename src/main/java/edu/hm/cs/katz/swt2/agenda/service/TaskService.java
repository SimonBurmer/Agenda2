package edu.hm.cs.katz.swt2.agenda.service;

import edu.hm.cs.katz.swt2.agenda.service.dto.OwnerTaskDto;
import edu.hm.cs.katz.swt2.agenda.service.dto.SubscriberTaskDto;
import java.util.List;

/**
 * Serviceklasse für Verarbeitung von Tasks.
 * 
 * @author Bastian Katz (mailto: bastian.katz@hm.edu)
 */
public interface TaskService {

  /**
   * Erstellt einen neuen Task.
   */
  Long createTask(String topicUuid, String title, String login);

  /**
   * Zugriff auf einen Task (priviligierte Sicht für Ersteller des Topics).
   */
  OwnerTaskDto getManagedTask(Long taskId, String login);

  /**
   * Zugriff auf alle Tasks eines eigenen Topics.
   */
  List<OwnerTaskDto> getManagedTasks(String topicUuid, String login);

  /**
   * Zugriff auf einen Task (Abonnentensicht).
   */
  SubscriberTaskDto getTask(Long taskId, String login);

  /**
   * Zugriff auf alle Tasks abonnierter Topics.
   */
  List<SubscriberTaskDto> getSubscribedTasks(String login);

  /**
   * Zugriff auf alle Tasks eines abonnierten Topics.
   */
  List<SubscriberTaskDto> getTasksForTopic(String topicUuid, String login);

  /**
   * Markiert einen Task für einen Abonnenten als "done".
   */
  void checkTask(Long taskId, String login);
}