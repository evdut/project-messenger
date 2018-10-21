package com.project_messenger.project.domain.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import org.javamoney.moneta.Money;

public class Project implements Serializable {

    // @Id
    // @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ProjectSeqGenerator")
    // @SequenceGenerator(name = "ProjectSeqGenerator", sequenceName = "PROJECT_ID_SEQ", allocationSize = 1)
    private Long id;

    private String uuid;

    @NotNull
    private String title;

    private String description;

    private LocalDate dueDate;

    private Money budget;

    private Money revenue;

    private Status status;

    private User owner;

    private List<User> participants;

    private List<User> invited;

    private List<Task> tasks;

    public Project(String title, String description, String currency, User owner) {
        this.uuid = UUID.randomUUID().toString();
        update(title, description);
        this.owner = owner;
        this.invited = new ArrayList<User>();
        this.participants = new ArrayList<User>();
        this.tasks = new ArrayList<Task>();
        this.status = Status.CREATED;
        this.revenue = Money.of(0, currency);
        this.budget = Money.of(0, currency);
    }

    public void start() {
        this.status = Status.IN_PROGRESS;
        tasks.forEach(task -> task.start());
    }

    public void finish() {
        this.status = Status.DONE;
    }

    public void update(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public void schedule(LocalDate dueDate) {
        if (tasks.stream().anyMatch(task -> task.dueDate() != null && task.dueDate().isAfter(dueDate))) {
            throw new RuntimeException("You have task that ends after " + dueDate);
        }
        this.dueDate = dueDate;
    }

    public void scheduleImplicitly(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void addBudget(Money budget) {
        Money newRevenue = budget.subtract(this.budget).add(revenue);
        if (newRevenue.isLessThan(Money.zero(this.budget.getCurrency()))) {
            throw new RuntimeException("You will got negative revenue if accept this budget: " + budget);
        }
        this.budget = budget;
        this.revenue = newRevenue;
    }

    public void addBudgetImplicitly(Money budget) {
        this.budget = budget;
        this.revenue = budget.subtract(this.budget).add(revenue);
    }

    public void invite(User invited) {
        this.invited.add(invited);
    }

    public void confirmInvitation(User user) {
        this.invited.remove(user);
        this.participants.add(user);
    }

    public void addTask(Task task) {
        validateTask(task);
        addTaskImplicitly(task);
        if (revenue.isLessThan(Money.zero(this.budget.getCurrency()))) {
            throw new RuntimeException("You will got negative revenue if add this task: " + task.title());
        }
    }

    public void updateTask(Task task) {
        validateTask(task);
        updateTaskImplicitly(task);
        if (revenue.isLessThan(Money.zero(this.budget.getCurrency()))) {
            throw new RuntimeException("You will got negative revenue if accept new costs of this task: " + task.title());
        }
    }
    
    public void addTaskImplicitly(Task task) {
        if(!status.equals(Status.CREATED)) {
            task.start();
        }
        if (tasks.contains(task)) {
            throw new RuntimeException("Task " + task.title() + " already exists");
        }
        this.tasks.add(task);
        this.revenue = calculateRevenue(null, task.costs());
    }

    public void updateTaskImplicitly(Task task) {
        int index = tasks.indexOf(task);
        if (index < 0) {
            throw new RuntimeException("You do not have such task created '" + task.title() + "'");
        }
        Task oldTask = this.tasks.set(index, task);
        this.revenue = calculateRevenue(oldTask.costs(), task.costs());
    }

    private Money calculateRevenue(Money toAdd, Money toSubstruct) {
        Money result = null;
        if (toAdd != null) {
            result = revenue.add(toAdd);
        }
        if (toSubstruct != null) {
            result = revenue.subtract(toSubstruct);
        }
        return result;
    }

    private void validateTask(Task task) {
        if (task.dueDate() != null && task.dueDate().isAfter(dueDate)) {
            throw new RuntimeException("Task '" + task.title() + "' ends after " + dueDate);
        }
    }

    public String title() {
        return title;
    }

    public String description() {
        return description;
    }

    public String uuid() {
        return uuid;
    }

    public LocalDate dueDate() {
        return dueDate;
    }

    public Money budget() {
        return budget;
    }

    public Money revenue() {
        return revenue;
    }

    public Status status() {
        return status;
    }

    public User owner() {
        return owner;
    }

    public List<User> participants() {
        return participants;
    }

    public List<User> invited() {
        return invited;
    }

    public List<Task> tasks() {
        return Collections.unmodifiableList(tasks);
    }

    public Task task(String taskUuid) {
        return tasks().stream().filter(task -> taskUuid.equals(task.uuid())).findFirst()
                .orElseThrow(() -> new RuntimeException("Task '" + taskUuid + "' not found in project " + uuid));
    }
}
