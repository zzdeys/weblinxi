package com.linxi.po;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author linxi
 * @function
 * @project linxiblog
 * @package com.linxi.po
 * @date 2020/4/29-12:33 上午
 */
@Entity
@Table(name = "t_type")
public class Type {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

//    一对多 ,表示type是通过blog的被动维护
    @OneToMany(mappedBy = "type")
    private List<Blog> blogs = new ArrayList<>();


    public Type() {
    }

    @Override
    public String toString() {
        return "Type{" +
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
}
