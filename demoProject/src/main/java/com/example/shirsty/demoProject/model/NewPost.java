package com.example.shirsty.demoProject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "post")
public class NewPost {
    @Override
    public String toString() {
        return "NewPost{" +
                "postId=" + postId +
                ", postDesc='" + postDesc + '\'' +
                ", postTime='" + postTime + '\'' +
                ", postBy='" + postBy + '\'' +
                ", postLike=" + postLike +
                ", postCmnt='" + postCmnt + '\'' +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int postId;
    @Column(name = "postdesc")
    private String postDesc;
    @Column(name = "posttime")
    private String postTime;
    @Column(name = "postby")
    private String postBy;
    @Column(name = "postlike")
    private int postLike;
    @Column(name = "postcmnt")
    private String postCmnt;
}
