package top.zz.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by X-man on 2017/4/8.
 */
@Entity
@Table(name = "xx_menu")
public class Menu implements Serializable {


    private static final long serialVersionUID = 9170505028339713567L;

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifyDate;
    private Integer orders;
    @Lob
    @Column(nullable = false)
    private String fullName;
    private Integer grade;
    @Column(length = 100,nullable = false)
    private String name;
    @Column(nullable = false)
    private String treePath;
    @OneToOne(fetch = FetchType.EAGER)
    private Menu menu;
    @OneToOne(fetch = FetchType.EAGER)
    private MenuValue menuValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTreePath() {
        return treePath;
    }

    public void setTreePath(String treePath) {
        this.treePath = treePath;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public MenuValue getMenuValue() {
        return menuValue;
    }

    public void setMenuValue(MenuValue menuValue) {
        this.menuValue = menuValue;
    }
}
