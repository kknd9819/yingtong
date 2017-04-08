package top.zz.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by X-man on 2017/4/8.
 */
@Entity
@Table(name = "xx_role")
public class Role implements Serializable {


    private static final long serialVersionUID = -253625885561218068L;

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifyDate;
    private String description;
    @Column(nullable = false)
    private Boolean isSystem;
    @Column(nullable = false)
    private String name;
    private String code;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "xx_admin_role",joinColumns = {@JoinColumn(name = "roles")},inverseJoinColumns = {@JoinColumn(name = "admins")})
    private List<Admin> admins;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "xx_role_authority",joinColumns = {@JoinColumn(name = "roles")},inverseJoinColumns = {@JoinColumn(name = "authorities")})
    private List<Authority> authorities;


    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getSystem() {
        return isSystem;
    }

    public void setSystem(Boolean system) {
        isSystem = system;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(List<Admin> admins) {
        this.admins = admins;
    }
}
