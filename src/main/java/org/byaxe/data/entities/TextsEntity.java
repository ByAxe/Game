package org.byaxe.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "texts")
public class TextsEntity extends AbstractEntity {
    private String content;

    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String text) {
        this.content = text;
    }
}
