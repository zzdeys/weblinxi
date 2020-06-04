package com.linxi.vo;

/**
 * @author linxi
 * @function
 * @project linxiblog
 * @package com.linxi.vo
 * @date 2020/5/15-11:46 下午
 */
public class BlogQuery {
    private String title;
    private Long typeId;
    private boolean recommend;

    public BlogQuery() {
    }

    @Override
    public String toString() {
        return "BlogQuery{" +
                "title='" + title + '\'' +
                ", typeId=" + typeId +
                ", recommend=" + recommend +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public boolean isRecommend() {
        return recommend;
    }

    public void setRecommend(boolean recommend) {
        this.recommend = recommend;
    }
}
