package com.linxi.po;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author linxi
 * @function
 * @project linxiblog
 * @package com.linxi.po
 * @date 2020/4/29-12:37 上午
 */
@Entity
@Table(name = "t_tag")
public class Tag {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
//被维护
    @ManyToMany(mappedBy = "tags")
    private List<Blog> blogs = new ArrayList<>();
    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Tag() {
    }

}
