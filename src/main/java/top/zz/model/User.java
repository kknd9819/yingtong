package top.zz.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by X-man on 2017/3/30.
 */
@Entity
@Table(name = "t_user")
public class User implements Serializable{

    private static final long serialVersionUID = 6990792998903360845L;

    @Id
    @GeneratedValue
    private Long uid;

    @Column(unique = true)
    private String username;
    private String name;
    private String password;
    private String salt;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    private Boolean isEnabled;
    private Boolean isLocked;
    private Integer loginFailureCount;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lockedDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date loginDate;
    private String loginIp;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "t_user_role",joinColumns = {@JoinColumn(name = "uid")},inverseJoinColumns = {@JoinColumn(name = "roleId")})
    private List<Role> roleList;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Boolean getEnabled() {
        return isEnabled;
    }

    public void setEnabled(Boolean enabled) {
        isEnabled = enabled;
    }

    public Boolean getLocked() {
        return isLocked;
    }

    public void setLocked(Boolean locked) {
        isLocked = locked;
    }

    public Integer getLoginFailureCount() {
        return loginFailureCount;
    }

    public void setLoginFailureCount(Integer loginFailureCount) {
        this.loginFailureCount = loginFailureCount;
    }

    public Date getLockedDate() {
        return lockedDate;
    }

    public void setLockedDate(Date lockedDate) {
        this.lockedDate = lockedDate;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public String getCredentialsSalt(){
        return this.username+this.salt;
    }

}
