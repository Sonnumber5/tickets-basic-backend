package com.example.ticketsbasic.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

@Table("tickets")
public class Ticket {
    @Id
    @Column("ticket_id")
    private Long ticketId;
    //private Long userId; // link to user
    @NotBlank @Size(max=200)
    @Column("title")
    private String title;
    @NotBlank @Size(max=1000)
    @Column("description")
    private String description;
    @NotBlank
    @Column("priority")
    private String priority; // LOW|MEDIUM|HIGH
    @Column("dueDate")
    private LocalDate dueDate;

    // getters/setters
    public Long getTicketId() { return ticketId; }
    public void setTicketId(Long ticketId) { this.ticketId = ticketId; }
    //public Long getUserId() { return userId; }
    //public void setUserId(Long userId) { this.userId = userId; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }
    public LocalDate getDueDate() { return dueDate; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }
}
