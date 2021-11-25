package com.lanaco.movies.Models;



import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.xml.soap.Text;
import java.util.Set;

@Data
@Entity
@Table(name="users",schema = "public")
@Accessors(chain = true)
@NoArgsConstructor
public class Users {
    @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    public int userId;
    public String userName;
    public String firstName;
    public   String lastName;
    public String adress;
    public String phoneNumber;
    public String email;
    public String password;

  //  @ManyToMany
  //  @JoinTable(schema = "public",name = "user_role",joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "role_id"))
   // private Set<Role> roleList;

}
